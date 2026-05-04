package com.github.cs3560_02_5;

public class TransferTransaction extends Transaction {

    private Account toAccount;
    private double amount;

    public TransferTransaction(Account fromAccount, Account toAccount, double amount) {
        super(fromAccount, amount);
        this.toAccount = toAccount;
        this.amount = amount;
    }

    @Override
    public boolean execute() {

        // check valid accounts
        if (account == null || toAccount == null) {
            return false;
        }

        // check valid amount
        if (amount <= 0) {
            return false;
        }

        // check sufficient funds
        if (account.getBalance() < amount) {
            return false;
        }

        // withdraw from sender
        boolean withdrawn = account.withdraw(amount);

        // deposit into receiver
        if (withdrawn) {
            toAccount.deposit(amount);
            return true;
        }

        return false;
    }
}