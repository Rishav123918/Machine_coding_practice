package asynchronous_order_fulfillment_pipeline;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class Main {

    private static final ExecutorService executor=new ThreadPoolExecutor(4,4,0, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<Runnable>());



    public static void main(String[] args) {
        new Main().startOrderProcess();
        executor.shutdown();
    }

    void startOrderProcess() {

        CompletableFuture<List<String>> cartFuture =
                CompletableFuture.supplyAsync(() -> {
                    simulateDelay("Fetching cart items from DB", 500);
                    return Arrays.asList("Laptop", "Mouse", "Keyboard");
                }, executor);


        CompletableFuture<Double> priceFuture =
                cartFuture
                        .thenApply(cartItems -> {
                            simulateDelay("Converting cart to Order object", 200);
                            return new Order(cartItems);
                        })
                        .thenApplyAsync(order -> {
                            simulateDelay("Calculating total price", 1000);
                            return order.getItems().size() * 100.0; // simple calc
                        }, executor);


        priceFuture
                .thenAccept(total -> {
                    simulateDelay("Logging total price", 100);
                    System.out.println("Total price: " + total);
                })
                .thenAcceptAsync(v -> {
                    simulateDelay("Saving log to remote service", 300);
                    System.out.println("Log saved remotely");
                }, executor);


        CompletableFuture<Double> discountFuture =
                priceFuture.thenCompose(total -> CompletableFuture.supplyAsync(() -> {
                    simulateDelay("Fetching discount details", 400);
                    return total * 0.1; // 10% discount
                }, executor));


        CompletableFuture<String> inventoryFuture =
                discountFuture.thenComposeAsync(discount -> CompletableFuture.supplyAsync(() -> {
                    simulateDelay("Reserving inventory", 500);
                    return "Inventory reserved";
                }, executor));


        CompletableFuture<Double> shippingFuture =
                CompletableFuture.supplyAsync(() -> {
                    simulateDelay("Fetching shipping cost", 300);
                    return 20.0;
                }, executor);

        CompletableFuture<Double> totalWithShipping =
                priceFuture.thenCombine(shippingFuture, (total, shipping) -> {
                    simulateDelay("Combining price and shipping", 200);
                    return total + shipping;
                });

        CompletableFuture<Double> loyaltyFuture =
                CompletableFuture.supplyAsync(() -> {
                    simulateDelay("Fetching loyalty bonus", 400);
                    return 5.0;
                }, executor);

        CompletableFuture<Double> finalAmountFuture =
                totalWithShipping.thenCombineAsync(loyaltyFuture, (amount, bonus) -> {
                    simulateDelay("Applying loyalty bonus", 300);
                    return amount - bonus;
                }, executor);


        finalAmountFuture.thenAccept(finalAmount -> {
            System.out.println("===== Final Order Summary =====");
            System.out.println("Customer ID: CUST123");
            System.out.println("Items: Laptop, Mouse, Keyboard");
            System.out.println("Final Payable Amount: $" + finalAmount);
        }).join();
    }

    static class Order {
        private final List<String> items;
        Order(List<String> items) { this.items = items; }
        List<String> getItems() { return items; }
    }

    private static void simulateDelay(String task, long ms) {
        System.out.println(task + "...");
        try { Thread.sleep(ms); } catch (InterruptedException e) { e.printStackTrace(); }
    }
}


/*


 */