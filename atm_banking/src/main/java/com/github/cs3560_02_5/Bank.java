package com.github.cs3560_02_5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
* Represents a bank system
* Manages accounts and validates users
*/
public class Bank {
    // Attributes
    private String bankName;
    List<Card> cardList;

    public Bank() {
        final String COMMA_DELIMITER = ",";
        try {
            // File to read from
            File inputFile = new File("customer.csv");
            // Create scanner to read from the input file
            Scanner reader = new Scanner(inputFile);
            String line;

            // Read each line of the input file and create card

            // Close scanner
            reader.close();
        } catch (FileNotFoundException e) {
            // Handle the case where the input file is not found
            System.out.println("An error has occurred. FILE NOT FOUND!");
        }
    }
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