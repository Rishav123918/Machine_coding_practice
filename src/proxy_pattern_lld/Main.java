
/*
🔹 Proxy Design Pattern in Java
The Proxy Design Pattern provides a surrogate (substitute) for another object to control access to it.
It is part of Structural Design Patterns.

Structure in this Example
Subject (BankAccount): Interface for accessing account.
RealSubject (RealBankAccount): The actual bank account on the server.
Proxy (ATMProxy): Acts as ATM machine → checks authentication (PIN), then forwards requests to the real bank account.
Client (User): Interacts only with ATM, never directly with the bank server.
 */
package proxy_pattern_lld;
interface bankaccount{
    void withdraw(String user, String pin, double amount);
    void deposit(String user, String pin, double amount);
    void getBalance(String user, String pin);
}
class realbankaccount implements bankaccount{
    private double balance;
    private String owner;

    public realbankaccount(double balance, String owner) {
        this.balance = balance;
        this.owner = owner;
    }

    @Override
    public void withdraw(String user, String pin, double amount) {
         if(amount<=balance){
             balance=balance-amount;
             System.out.println("user name : "+user+" transaction of "+amount);
         }
         else{
             System.out.println("insufficient balance");
         }
    }

    @Override
    public void deposit(String user, String pin, double amount) {
       balance=balance+amount;
        System.out.println("User deposite : "+amount+" amount");
    }

    @Override
    public void getBalance(String user, String pin) {
        System.out.println(user + "'s account balance: $" + balance);
    }
}
class proxyaccount implements bankaccount{
    private realbankaccount realbankaccount;
    private String validUser = "John";
    private String validPin = "1234";

    public proxyaccount(double balance,String owner) {
       this.realbankaccount=new realbankaccount(balance, owner);
    }

    private Boolean getValidUser(String user,String pin) {
        if(validUser.equals(user) && validPin.equals(pin)){
            System.out.println("User Authenticate successfully");
            return true;
        }
        return false;
    }

    @Override
    public void deposit(String user, String pin, double amount) {
        if(getValidUser(user,pin)){
            realbankaccount.deposit(user, pin, amount);
        }
        else{
            System.out.println("Invalid user name and invalid pin");
        }
    }

    @Override
    public void withdraw(String user, String pin, double amount) {
       if(getValidUser(user, pin)){
           realbankaccount.withdraw(user, pin, amount);
       }else{
           System.out.println("Invalid user name and invalid pin");
       }
    }

    @Override
    public void getBalance(String user, String pin) {
        if(getValidUser(user, pin)){
            realbankaccount.getBalance(user, pin);
        }
        else{
            System.out.println("Invalid user name and invalid pin");
        }
    }
}
public class Main {
    public static void main(String[] args) {
        bankaccount account=new proxyaccount(2000.0,"John");
        account.deposit("Alice","1234",1000.0);
        account.deposit("John","1234",3000.0);
        account.getBalance("John","1234");
        account.withdraw("John","1234",500.0);
        account.getBalance("Alex","1234");
    }
}

/*



How Proxy Works Here:
Client (User) → Talks to ATM (Proxy).
ATM (Proxy) → Authenticates user (PIN check).
RealBankAccount (Server) → Only executes if authentication is successful.
This protects the Real Bank Server and adds security + logging + access control.
 */
