package com.github.cs3560_02_5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* Represents a bank system
* Manages accounts and validates users
*/
public class Bank {
    // Attributes
    List<Account> acc = new ArrayList<>();

    public Bank() {
        Connection conn = null;
        // Initialize database
        try {
            // Connect to database
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            /*
            Update connection string with your credentials
            */
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/YOURDATABASE?user=root&password=YOURPASSWORD");
            // Call function to create cards
            acc = createCards(conn);
        } catch (Exception ex) {
            // Error in connecting
            System.err.println("Failure to connect!\n" + ex);
        }
    }
    /**
     * Define customer cards
     * @param c database connection
     * @return list of cards
     */
    private List<Account> createCards(Connection c) {
        Map<String, Account> accountMap = new HashMap<>();
        // Query to execute that displays card info and it's type joined by accNum
        String query = "SELECT d.accNum, d.cardNum, d.pin, c.fname, c.lname, d.balance, DATE_FORMAT(d.expDate, '%m/%y') AS expDate, 'DEBIT' AS type\n" + //
                        "FROM DebitCard d\n" + //
                        "JOIN Customer c ON d.accNum = c.accNum\n" + //
                        "\n" + //
                        "UNION\n" + //
                        "\n" + //
                        "SELECT cr.accNum, cr.cardNum, NULL AS pin, c.fname, c.lname, cr.balance, DATE_FORMAT(cr.expDate, '%m/%y') AS expDate, 'CREDIT' AS type\n" + //
                        "FROM CreditCard cr\n" + //
                        "JOIN Customer c ON cr.accNum = c.accNum;";
        // Attempt to execute query and make result set
        try (PreparedStatement stmt = c.prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();

            // While row in result set get data of each column
            while (rs.next()) {
                // Assign columns to variables
                String cardNum = rs.getString("cardNum");
                int pin = rs.getInt("pin");
                String firstName = rs.getString("fname");
                String lastName = rs.getString("lname");
                String type = rs.getString("type");
                String expDate = rs.getString("expDate");
                double bal = rs.getDouble("balance");
                String accNum = rs.getString("accNum");
                
                Account acc = accountMap.get(accNum);
                // Check if account in map
                if (acc == null) {
                    acc = new Account(accNum, bal, firstName + " " + lastName);
                    accountMap.put(accNum, acc);
                }
                // Create cards
                Card card = new Card(accNum, cardNum, pin, firstName, lastName, expDate, type);
                acc.addCard(card);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Return Accounts
        return new ArrayList<>(accountMap.values());
    }

    /**
     * Retrieves Accounts
     * @return Account object list
     */
    public List<Account> getAccount() {
        return acc;
    }

    /**
     * Find Account
     * @param cardNum card number
     * @param pin PIN number
     * @return Account
     */
    public Account findAccount(String cardNum, int pin) {
        for (Account a : acc) {
            Card c = a.validateCard(cardNum, pin);

            if (c != null) {
                return a;
            }
        }
        return null;
    }
}