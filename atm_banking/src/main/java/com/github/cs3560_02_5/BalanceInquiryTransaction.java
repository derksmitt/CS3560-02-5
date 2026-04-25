package com.github.cs3560_02_5;

/**
* Handles balance inquiry transactions
*/
class BalanceInquiryTransaction extends Transaction {
    /**
     * Constructor
     */
    public BalanceInquiryTransaction(Account account) {
        super(account, 0);
    }
    /**
     * Executes balance check
     * @Override
     */
    public boolean execute() {
        return false;
    }
    /**
     * Returns account balance
     * @return balance
     */
    public double getBalance() {
        return 0.0;
    }
}
