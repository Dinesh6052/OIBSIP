package com.atm;

import java.util.ArrayList;

public class Account {

    private String userId;
    private String pin;
    private String accountHolderName;
    private double balance;

    private ArrayList<Transaction> transactionHistory;

    public Account(String userId, String pin,
                   String accountHolderName, double balance) {

        this.userId = userId;
        this.pin = pin;
        this.accountHolderName = accountHolderName;
        this.balance = balance;

        this.transactionHistory = new ArrayList<>();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void addTransaction(Transaction transaction) {
        transactionHistory.add(transaction);
    }

    public ArrayList<Transaction> getTransactionHistory() {
        return transactionHistory;
    }

    public boolean withdraw(double amount) {

        if (amount <= 0 || amount > balance) {
            return false;
        }

        balance = balance - amount;
        return true;
    }

    public boolean deposit(double amount) {

        if (amount <= 0) {
            return false;
        }

        balance = balance + amount;
        return true;
    }
}