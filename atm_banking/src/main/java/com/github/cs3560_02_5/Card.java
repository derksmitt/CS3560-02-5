package com.github.cs3560_02_5;

/**
* Represents a debit/ATM card
*/
public class Card {
  // Attributes
  private String cardNumber;
  private int pin;
  //private String accountNumber;
  private String fname;
  private String lname;
  //private String expDate;
  //private String type;

  public Card(String accNum, String cardNum, int pin, String fname, String lname, String expDate, String type) {
    this.cardNumber = cardNum;
    this.pin = pin;
    //this.accountNumber = accNum;
    this.fname = fname;
    this.lname = lname;
    //this.expDate = expDate;
    //this.type = type;
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
   * Gets Card card number
   * @return card number
   */
  public String getCardNumber() {
    return cardNumber;
  }

  /**
   * Gets Card pin number
   * @return pin number
   */
  public int getPIN() {
    return pin;
  }

  /**
   * Gets name assigned to Card
   * @return name
   */
  public String getName() {
    return fname + " " + lname;
  }
}
