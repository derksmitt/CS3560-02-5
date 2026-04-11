package com.github.cs3560_02_5;

/**
* Handles withdrawal transactions
*/
class WithdrawTransaction extends Transaction {
    /**
     * Constructor
     */
    public WithdrawTransaction(Account account, double amount) {
        super(account, amount);
    }
    /**
     * Executes withdrawal
     * @Override
     */
    public boolean execute() {
        return false;
    }
}
