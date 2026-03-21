/**
* Main class representing the ATM machine
* Handles user interaction and coordinates system operations
*/
public class ATM {
  // Attributes
  private Bank bank;
  private Card currentCard;
  private Account currentAccount;
  private boolean isAuthenticated;

  /**
  * Starts the ATM machine
  */
  public void start() {
  // TODO: Initialize ATM interface
  }
  /**
  * Authenticates user using card and PIN
  * @param card Card inserted by user
  * @param pin Entered PIN
  * @return boolean indicating success/failure
  */
  public boolean authenticateUser(Card card, int pin) {
    return false;
  }
  /**
  * Displays available options to the user
  */
  public void showMenu() {
    // TODO: Display options (withdraw, deposit, balance, etc.)
  }
  /**
  * Logs out the current user
  */
  public void logout() {
    // TODO: Reset session
  }
}

/**
* Represents a bank system
* Manages accounts and validates users
*/
class Bank {
  // Attributes
  private String bankName;
  /**
  * Validates card and PIN
  * @param card Card object
  * @param pin PIN number
  * @return Account if valid, otherwise null
  */
  public Account authenticate(Card card, int pin) {
    return null;
  }
  /**
  * Retrieves account by account number
  * @param accountNumber Account number
  * @return Account object
  */
  public Account getAccount(int accountNumber) {
    return null;
  }
}
    
/**
* Represents a user's bank account
*/
class Account {
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

/**
* Represents a debit/ATM card
*/
class Card {
  // Attributes
  private String cardNumber;
  private int pin;
  private int accountNumber;
  /**
  * Validates entered PIN
  * @param enteredPin PIN entered by user
  * @return boolean indicating match
  */
  public boolean validatePin(int enteredPin) {
    return false;
  }
  /**
  * Gets linked account number
  * @return account number
  */
  public int getAccountNumber() {
    return accountNumber;
  }
}

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

/**
* Represents the ATM's cash dispenser
*/
class CashDispenser {
  // Attributes
  private int cashAvailable;
  /**
  * Dispenses cash
  * @param amount Amount to dispense
  * @return boolean indicating success/failure
  */
  public boolean dispenseCash(double amount) {
    return false;
  }
  /**
  * Checks if enough cash is available
  * @param amount requested amount
  * @return boolean
  */
  public boolean hasSufficientCash(double amount) {
    return false;
  }
}

/**
* Represents the ATM's deposit slot
*/
class DepositSlot {
  /**
  * Accepts deposit
  * @return boolean indicating if the deposit was successful
  */
  public boolean acceptDeposit() {
    return false;
  }
}
