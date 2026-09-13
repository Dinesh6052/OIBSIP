package com.atm;

public class Main {

    public static void main(String[] args) {

        // Create Bank object
        Bank bank = new Bank();

        // Create demo accounts
        Account account1 = new Account(
                "1001",
                "1234",
                "Dinesh Patil",
                50000.00
        );

        Account account2 = new Account(
                "1002",
                "5678",
                "Lokesh Patil",
                30000.00
        );

        Account account3 = new Account(
                "1003",
                "9999",
                "Piyush Patil",
                20000.00
        );

        // Add accounts to bank
        bank.addAccount(account1);
        bank.addAccount(account2);
        bank.addAccount(account3);

        // Create ATM
        ATM atm = new ATM(bank);

        // Start ATM
        atm.start();
    }
}