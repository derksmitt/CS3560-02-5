package com.github.cs3560_02_5;

/**
* Represents a user's bank account
*/
public class Account {
    // Attributes
    private int accountNumber;
    private double balance;
    private String accountHolderName;
    /**
     * Deposits money into account
     * @param amount Amount to deposit
     * @return updated balance
     */
    public double deposit(double amount) {
        return 0.0;
    }
    /**
     * Withdraws money from account
     * @param amount Amount to withdraw
     * @return boolean indicating success/failure
     */
    public boolean withdraw(double amount) {
        return false;
    }
    /**
     * Gets current account balance
     * @return balance
     */
    public double getBalance() {
        return balance;
    }
}