package com.github.cs3560_02_5;

/**
* Abstract class representing a transaction
*/
abstract class Transaction {
    // Attributes
    protected Account account;
    protected double amount;
    /**
     * Constructor
     */
    public Transaction(Account account, double amount) {
        this.account = account;
        this.amount = amount;
    }
    /**
     * Executes the transaction
     * @return boolean indicating success/failure
     */
    public abstract boolean execute();
}
