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
     */
    @Override
    public boolean execute() {
        if(account == null) {
            return false;
        }

        if(amount <= 0) {
            return false;
        }

        account.deposit(amount);
        return true;
    }
}