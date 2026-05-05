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
        if (account == null || amount <= 0) {
            return false;
        }

        if (account.getBalance() < amount) {
            return false;
        }
        return account.withdraw(amount);
    }
}
