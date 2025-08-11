package ATMMenu;


import java.util.Scanner;

interface ATMOperation {
    void execute(Account account, Scanner scanner);
}


class Account {
    private double balance;

    public Account(double initialBalance) {
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public double getBalance() {
        return balance;
    }
}


class DepositService implements ATMOperation {
    @Override
    public void execute(Account account, Scanner scanner) {
        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();
        account.deposit(amount);
        System.out.println("Deposit successful. Current balance: ₹" + account.getBalance());
    }
}


class WithdrawService implements ATMOperation {
    @Override
    public void execute(Account account, Scanner scanner) {
        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();
        if (account.withdraw(amount)) {
            System.out.println("Withdrawal successful. Current balance: ₹" + account.getBalance());
        } else {
            System.out.println("Insufficient balance! Current balance: ₹" + account.getBalance());
        }
    }
}


class BalanceInquiryService implements ATMOperation {
    @Override
    public void execute(Account account, Scanner scanner) {
        System.out.println("Your current balance is: ₹" + account.getBalance());
    }
}
public class ATMMenu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Account account = new Account(0.0); // Starting with 0 balance

        ATMOperation depositOp = new DepositService();
        ATMOperation withdrawOp = new WithdrawService();
        ATMOperation balanceOp = new BalanceInquiryService();

        boolean exit = false;

        while (!exit) {
            System.out.println("\n===== Welcome to ATM =====");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Balance Inquiry");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> depositOp.execute(account, scanner);
                case 2 -> withdrawOp.execute(account, scanner);
                case 3 -> balanceOp.execute(account, scanner);
                case 4 -> {
                    exit = true;
                    System.out.println("Thank you for using the ATM!");
                }
                default -> System.out.println("Invalid choice! Please try again.");
            }
        }

        scanner.close();
    }
}
