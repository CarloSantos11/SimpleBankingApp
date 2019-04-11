package org.snapit;

import java.util.Scanner;

public class Atm {
    static Scanner inputField = new Scanner(System.in);

    /*
     *  returns a numeral that is representative of yes or no. 1 and 2 respectively.
     *  1: Yes I have an account
     *  2: No I do not have an account
     * */
    public static BankAccount areYouUser() {
        String input;
        BankAccount member;

        System.out.println("Do you have an account?");
        System.out.println("1. For yes.");
        System.out.println("2. For no.\n");

        input = inputField.next();
        inputField.nextLine();

        if(input.equals("1")) {
            System.out.println("You have an account");
            member = new BankAccount();
            return  member;
        }
        else if (input.equals("2")){
            member = createMemberAccount();
            return  member;
        }
        else {
            member = new BankAccount();         // should be removed
            return  member;                     // what do we do when neither 1 or 2 is chosen
        }                                       // we should create a bank account in that instance


    }

    //    public static BankAccount createMemberAccount(){
    public static BankAccount createMemberAccount(){
        String input;
        String name;
        int pin;

        System.out.println("What is your name?");
        input = inputField.nextLine();
        name = input;

        System.out.println("Hello " + name + " create a 4 digit user id for yourself");

        pin = inputField.nextInt();

        BankAccount member = new BankAccount(name, pin, 100);

        System.out.println("\nCongratulations! Here's $100.00 to get you started");

        return  member;
    }

    public static void showMenu(BankAccount givenAccount) {
        String choice;
        choice = "";

        while (!choice.equals("Q") && !choice.equals("q")){

            System.out.println("Hello " + givenAccount.getUserName());
            System.out.println("ATM:");
            System.out.println("    1. Deposit");
            System.out.println("    2. Withdraw");
            System.out.println("    3. Check Balance");

            choice = inputField.nextLine();

            switch (choice) {
                case "1":
                    givenAccount.deposit(promptDeposit());
                    System.out.println(givenAccount.getBalanceFormatted());
                    break;
                case "2":
                    givenAccount.withdraw(promptWithdraw());
                    break;
                case "3":
                    givenAccount.printAccountInfo();
                    break;
                case "Q":
                case "q":
                    System.out.println("Quitting Time");
                    break;
            }
        }
    }

    public static double promptDeposit() {
        double depositAmount;

        System.out.println("How much would you like to deposit?");
        depositAmount = inputField.nextDouble();

        return depositAmount;
    }

    public static double promptWithdraw() {
        double withdrawAmount;

        System.out.println("How much would you like to withdraw");
        withdrawAmount = inputField.nextDouble();

        return withdrawAmount;
    }

}
