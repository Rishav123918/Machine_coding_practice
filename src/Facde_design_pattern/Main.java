package Facde_design_pattern;

import static java.lang.Thread.sleep;

class AccountService{
    public boolean checkaccount(String account){
        System.out.println("Accoutn number :"+account);
        return true;
    }
}

class SecurityService{
 public boolean pincheck(String pin){
     if(pin.equals("Qwert@123"))return true;
     return false;
 }
}
class BalanceService{

   private double balance=10000;
   public boolean checkbalance(double amount){
       if(amount<=balance){
           return true;
       }
       return false;
   }
   public double update_balance(double amount1){
       balance=balance-amount1;
       return balance;
   }
}
class TransactionService{
  public void service(String accountNumber,double amount){
      System.out.println("User trasaction amount of : "+amount+" from account number : "+accountNumber);
  }
}

class Bankfacade{
    private String accountNumber;
    private String pin;

    private AccountService accountService;
    private SecurityService securityService;
    private BalanceService balanceService;
    private TransactionService transactionService;

    public Bankfacade(String accountNumber, String pin) {
        this.accountNumber = accountNumber;
        this.pin = pin;

        accountService=new AccountService();
        securityService=new SecurityService();
        balanceService=new BalanceService();
        transactionService=new TransactionService();
    }

    public void withdraw(Double amount){
        System.out.println("\n=== Withdrawal Request: " + amount + " ===");
        if (!accountService.checkaccount(accountNumber)) {
            System.out.println("Invalid account.");
            return;
        }
        if(!securityService.pincheck(pin)){
            System.out.println("Invalid pin : ");
            return;
        }
        if(!balanceService.checkbalance(amount)){
            System.out.println("Insufficient amount");
            return;
        }
        transactionService.service(accountNumber,amount);
        System.out.println("Your amount available after transaction : "+balanceService.update_balance(amount));

        System.out.println("✅ Withdrawal successful!");
    }




}
public class Main {
    public static void main(String[] args) {
        Bankfacade bankfacade=new Bankfacade("ACC123","Qwert@123");
        bankfacade.withdraw(200.0);
        try{
            sleep(1000);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        bankfacade.withdraw(200.0);


    }
}

/*
3. Banking System
When you do withdrawMoney() from your bank account, internally:
The system validates your account.
Checks the balance.
Validates ATM PIN.
Processes transaction.
Updates account.
👉 For you (the client), it’s one method call: bankFacade.withdraw(amount).
 */

/*
1. Definition
The Facade Design Pattern is a structural design pattern that provides a simplified, unified interface to a larger body of code, such as a complex subsystem.
👉 Think of it as a “front desk at a hotel” – instead of you directly talking to housekeeping, restaurant, and maintenance, you just call the front desk (the facade), and it delegates the tasks behind the scenes.
 */
