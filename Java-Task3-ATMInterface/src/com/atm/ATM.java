package com.atm;

import java.util.Scanner;

public class ATM {

    private Bank bank;
    private Scanner scanner;
    private Account currentAccount;

    public ATM(Bank bank) {

        this.bank = bank;
        this.scanner = new Scanner(System.in);
    }

    public void start() {

        System.out.println("========================================");
        System.out.println("     WELCOME TO JAVA ATM Interface      ");
        System.out.println("========================================");

        if (login()) {

            boolean running = true;

            while (running) {

                displayMenu();

                System.out.print(" Enter your choice: ");

                int choice;

                try {
                    choice = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println(" Invalid input.");
                    continue;
                }

                switch (choice) {

                    case 1:
                        showTransactionHistory();
                        break;

                    case 2:
                        withdraw();
                        break;

                    case 3:
                        deposit();
                        break;

                    case 4:
                        transfer();
                        break;

                    case 5:
                        System.out.println("\n Thank you for using Java ATM!");
                        System.out.println(" Goodbye, "
                                + currentAccount.getAccountHolderName() + "!");
                        running = false;
                        break;

                    default:
                        System.out.println(" Invalid choice. Please select 1 to 5.");
                }
            }

        } else {

            System.out.println("\nACCESS DENIED!");
            System.out.println("Too many incorrect login attempts.");
        }

        scanner.close();
    }

    private boolean login() {

        int attempts = 0;

        while (attempts < 3) {

            System.out.println("\n---------------- LOGIN -----------------");

            System.out.print(" Enter User ID: ");
            String userId = scanner.nextLine();

            System.out.print(" Enter PIN: ");
            String pin = scanner.nextLine();

            Account account = bank.authenticate(userId, pin);

            if (account != null) {

                currentAccount = account;

                System.out.println("\n Login Successful!");
                System.out.println(" Welcome, "
                        + currentAccount.getAccountHolderName());

                return true;

            } else {

                attempts++;

                System.out.println(" Incorrect User ID or PIN.");

                if (attempts < 3) {
                    System.out.println(" Remaining attempts: "
                            + (3 - attempts));
                }
            }
        }

        return false;
    }

    private void displayMenu() {

        System.out.println("\n==========================================");
        System.out.println("                 ATM MENU                 ");
        System.out.println("==========================================");
        System.out.println(" 1. Transaction History.");
        System.out.println(" 2. Withdraw.");
        System.out.println(" 3. Deposit.");
        System.out.println(" 4. Transfer.");
        System.out.println(" 5. Quit.");
        System.out.println("==========================================");

        System.out.println(" Current Balance: Rs. "
                + String.format("%.2f",
                currentAccount.getBalance()));

        System.out.println("==========================================");
    }

    private void showTransactionHistory() {

        System.out.println("\n========================================");
        System.out.println("           TRANSACTION HISTORY            ");
        System.out.println("==========================================");

        if (currentAccount.getTransactionHistory().isEmpty()) {

            System.out.println(" No transactions found.");

        } else {

            for (Transaction transaction :
                    currentAccount.getTransactionHistory()) {

                System.out.println(transaction);
            }
        }
    }

    private void withdraw() {

        System.out.print("\n Enter withdrawal amount: Rs. ");

        double amount;

        try {
            amount = Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println(" Invalid amount.");
            return;
        }

        if (amount <= 0) {
            System.out.println(" Amount must be greater than 0.");
            return;
        }

        if (amount > currentAccount.getBalance()) {
            System.out.println(" Insufficient Funds.");
            return;
        }

        boolean success = currentAccount.withdraw(amount);

        if (success) {

            currentAccount.addTransaction(
                    new Transaction(
                            "WITHDRAW",
                            amount,
                            "Cash withdrawal"
                    )
            );

            System.out.println(" Withdrawal Successful!");

            System.out.println(" Remaining Balance: Rs. "
                    + String.format("%.2f",
                    currentAccount.getBalance()));
        }
    }

    private void deposit() {

        System.out.print("\n Enter deposit amount: Rs. ");

        double amount;

        try {
            amount = Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println(" Invalid amount.");
            return;
        }

        if (amount <= 0) {
            System.out.println(" Amount must be greater than 0.");
            return;
        }

        boolean success = currentAccount.deposit(amount);

        if (success) {

            currentAccount.addTransaction(
                    new Transaction(
                            "DEPOSIT",
                            amount,
                            "Cash deposit"
                    )
            );

            System.out.println(" Deposit Successful!");

            System.out.println(" Updated Balance: Rs. "
                    + String.format("%.2f",
                    currentAccount.getBalance()));
        }
    }

    private void transfer() {

        System.out.print("\n Enter recipient User ID: ");
        String recipientId = scanner.nextLine();

        if (recipientId.equals(currentAccount.getUserId())) {

            System.out.println(
                    " You cannot transfer to your own account."
            );
            return;
        }

        Account recipient = bank.findAccount(recipientId);

        if (recipient == null) {

            System.out.println(" Recipient account not found.");
            return;
        }

        System.out.println(" Recipient: "
                + recipient.getAccountHolderName());

        System.out.print(" Enter transfer amount: Rs. ");

        double amount;

        try {
            amount = Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println(" Invalid amount.");
            return;
        }

        if (amount <= 0) {
            System.out.println(" Amount must be greater than 0.");
            return;
        }

        if (amount > currentAccount.getBalance()) {

            System.out.println(" Insufficient Funds.");
            return;
        }

        currentAccount.withdraw(amount);
        recipient.deposit(amount);

        currentAccount.addTransaction(
                new Transaction(
                        "TRANSFER",
                        amount,
                        "Transferred to "
                                + recipient.getAccountHolderName()
                                + " (User ID: "
                                + recipient.getUserId() + ")"
                )
        );

        recipient.addTransaction(
                new Transaction(
                        "RECEIVED",
                        amount,
                        "Received from "
                                + currentAccount.getAccountHolderName()
                                + " (User ID: "
                                + currentAccount.getUserId() + ")"
                )
        );

        System.out.println("\n Transfer Successful!");

        System.out.println(" Your Remaining Balance: Rs. "
                + String.format("%.2f",
                currentAccount.getBalance()));
    }
}