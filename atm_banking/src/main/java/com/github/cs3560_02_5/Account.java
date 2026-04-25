package com.github.cs3560_02_5;

import java.util.ArrayList;
import java.util.List;

/**
* Represents a user's bank account
*/
public class Account {
    // Attributes
    private String accountNumber;
    private double balance;
    private String accountHolderName;
    List<Card> cardList = new ArrayList<>();
    /**
     * Constructor
     */
    public Account(String accNum, double balance, String accName) {
        this.accountNumber = accNum;
        this.balance = balance;
        this.accountHolderName = accName;
        this.cardList = new ArrayList<>();
    }
    /**
     * Assigns card to Account
     */
    public void addCard(Card card) {
        cardList.add(card);
    }
    /**
     * Gets list of cards belonging to an Account
     * @return cardList
     */
    public List<Card> getCards() {
        return cardList;
    }
    /**
     * Authenicate cards belonging to an Account
     * @param cardNum card number
     * @param pin PIN number
     * @return Card
     */
    public Card validateCard(String cardNum, int pin) {
        for (Card c : cardList) {
            if (c.getCardNumber().equals(cardNum) && c.getPIN() == pin) {
                return c;
            }
        }
        return null;
    }
    /**
     * Gets name assigned to Account
     * @return accountHolderName
     */
    public String getName() {
        return accountHolderName;
    }
    /**
     * Gets account number
     * @return accountNumber
     */
    public String getAccNum() {
        return accountNumber;
    }
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