package com.atm;

import java.util.ArrayList;

public class Bank {

    private ArrayList<Account> accounts;

    public Bank() {
        accounts = new ArrayList<>();
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public Account findAccount(String userId) {

        for (Account account : accounts) {

            if (account.getUserId().equals(userId)) {
                return account;
            }
        }

        return null;
    }

    public Account authenticate(String userId, String pin) {

        Account account = findAccount(userId);

        if (account != null && account.getPin().equals(pin)) {
            return account;
        }

        return null;
    }
}