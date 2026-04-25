package com.github.cs3560_02_5;

/**
* Handles deposit transactions
*/
class DepositTransaction extends Transaction {
    /**
     * Constructor
     */
    public DepositTransaction(Account account, double amount) {
        super(account, amount);
    }
    /**
     * Executes deposit
     * @Override
     */
    public boolean execute() {
        return false;
    }
}