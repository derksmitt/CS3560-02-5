package com.github.cs3560_02_5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
        Connection conn = null;
        try { 
        conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/cs3560?user=root&password=Ag0raPHOb13^");
        } catch (Exception ex) {
            // Error in connecting
            System.err.println("Failure to connect!\n" + ex);
        }

        // Cannot withdraw if already in negative balance
        if (balance < 0) {
            return false;
        }
        balance -= amount;
        String query = "UPDATE debitcard SET balance =" + balance + " WHERE accNum = " + accountNumber;
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            int rows = stmt.executeUpdate();
            return rows > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }

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