package com.github.cs3560_02_5;

/**
* Represents a debit/ATM card
*/
public class Card {
  // Attributes
  private String cardNumber;
  private int pin;
  private int accountNumber;

  public Card(String cardNum, int pin, int accNum) {
    this.cardNumber = cardNum;
    this.pin = pin;
    this.accountNumber = accNum;
  }
  /**
  * Validates entered PIN
  * @param enteredPin PIN entered by user
  * @return boolean indicating match
  */
  public boolean validatePin(int enteredPin) {
    if (enteredPin == pin) {
      return true;
    }
    return false;
  }
  /**
  * Gets linked account number
  * @return account number
  */
  public int getAccountNumber() {
    return accountNumber;
  }

  /**
   * Gets objects card number
   * @return card number
   */
  public String getCardNumber() {
    return cardNumber;
  }

  /**
   * Gets objects pin number
   * @return pin number
   */
  public int getPIN() {
    return pin;
  }
}
