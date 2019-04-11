package org.snapit;

public class BankAccount {
    private String  userName;
    private double balance;
    private String balanceFormatted;
    private int customerId;

    public

    BankAccount(){
        setUserName("Existing User");
        setCustomerId(5555);
        setBalance(0);
    }

    BankAccount(String userName, int customerId, double balance){
        setUserName(userName);
        setCustomerId(customerId);
        setBalance(balance);
    }

    String getUserName() {
        return userName;
    }                                 // Refactor
    // Use Private variables
    double getBalance() {
        return balance;
    }

    String getBalanceFormatted() {
        return balanceFormatted;
    }

    int getCustomerId() {
        return customerId;
    }

    void setUserName(String userName1) {
        userName = userName1;
    }

    void setBalance(double balance1) {
        balance = balance1;
        balanceFormatted = String.format("%.2f", balance);
    }

    void setCustomerId(int customerId1){
        customerId = customerId1;
    }

    void deposit(double depositParam) {
        balance += depositParam;
        balanceFormatted = String.format("%.2f", balance);
    }

    void withdraw(double withdraw) {
        double newBalance = getBalance();
        newBalance -= withdraw;
        setBalance(newBalance);
        balanceFormatted = String.format("%.2f", newBalance);
    }

    void printAccountInfo() {
        System.out.println("Account User: " + userName);
        System.out.println("Account Id: " + customerId);
        System.out.println("Account Balance: " + balanceFormatted);
    }


}
