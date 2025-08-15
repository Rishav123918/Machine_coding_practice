package Strategy_Pattern_LLD;
interface PaymentStrategy {
    public void pay(Double amount);
}

class creditcardpayment implements  PaymentStrategy{
    @Override
    public void pay(Double amount)
    {
        System.out.println("Amount pay "+amount+"in credit card");
    }
}
class upipayment implements  PaymentStrategy{
    @Override
    public void pay(Double amount)
    {
        System.out.println("Amount pay "+amount+"in upi payment");
    }
}

class combine{
    private PaymentStrategy paymentStrategy;
    public void setcombine(PaymentStrategy paymentStrategy)
    {
        this.paymentStrategy=paymentStrategy;
    }
    public void paybill(Double amount){
        paymentStrategy.pay(amount);
    }
}
public class Main {
    public static void main(String[] args) {
        combine c=new combine();
        c.setcombine(new creditcardpayment());
        c.paybill((double)200);

        c.setcombine(new upipayment());
        c.paybill((double)400);

    }
}

/*
Advantages:
Follows Open/Closed Principle → You can add new strategies without touching existing code.
Cleaner and more maintainable.
Each strategy is testable in isolation.

When to Use:
When you have multiple ways to do the same operation.
When you want to avoid a big if-else / switch.
When the algorithm might change at runtime.
 */
