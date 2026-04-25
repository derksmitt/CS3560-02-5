package com.github.cs3560_02_5;
import com.github.cs3560_02_5.GUI.AlertBox;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.stage.Stage;

/**
* Main class representing the ATM machine
* Handles user interaction and coordinates system operations
*/
public class ATM extends Application{
    // Global variables
    static private Bank bank = new Bank();
    Stage window;
    Stage login, accountMenu;
    static int width = 1000;
    static int height = 700;
    public static void main(String[] args) {
        // Start application
        launch(args);
    }
    /**
     * Starts the ATM machine
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        // Assigns primaryStage to window
        window = primaryStage;
        // Set title of window
        window.setTitle("Outlaw Banking");

        // Creating a BorderPane container
        BorderPane border = new BorderPane();
        border.setCenter(login());

        // Size of scene and display
        Scene scene = new Scene(border, width, height);
        window.setScene(scene);
        window.show();
    }

    /**
     * Login window displayed to user
     * @return VBox
     */
    public VBox login() { 
        // Create VBox with centering
        VBox layout = new VBox();
        layout.setAlignment(Pos.CENTER);
        // Create padding and spacing for objects
        layout.setPadding(new Insets(90));
        layout.setSpacing(20);

        // Make title name on scene
        Text bankName = new Text("Outlaw Banking");
        bankName.setFont(Font.font("Arial", FontWeight.BOLD, 100));

        // Defining the card number field
        final TextField cardNum = new TextField();
        cardNum.setPromptText("Enter your Card Number");
        cardNum.setMaxWidth(500);

        // Defining the pin text field
        final TextField pin = new TextField();
        pin.setPromptText("Enter your PIN");
        pin.setMaxWidth(500);

        // Defining the Submit button
        Button submit = new Button("Login-in");
        // Determine action after button press
        submit.setOnAction(event -> {
                    // Find account linked to cardNumber and pin
                    Account account = authenticateUser(cardNum.getText(), Integer.parseInt(pin.getText()));
                    // Check if valid account is found
                    if (account != null) {
                        // Switch scenes and display alert
                        AlertBox.display("Login Successful", "Welcome " + account.getName());
                        showMenu(account);
                    } else {
                        // Display alert
                        AlertBox.display("Error!", "No Account exists.");
                    }
                });
        // Add objects to scene
        layout.getChildren().addAll(bankName, cardNum, pin, submit);
        return layout;
    }

    /**
     * Authenticates user using card and PIN
     * @param card Card inserted by user
     * @param pin Entered PIN
     * @return boolean indicating success/failure
     */
    public Account authenticateUser(String cardNum, int pin) {
        return bank.findAccount(cardNum, pin);
    }
    /**
     * Displays available options to the user
     * @param account Account belonging to user
     */
    public void showMenu(Account account) {
        // TODO: Display options (withdraw, deposit, balance, etc.)
        VBox layout = new VBox(10);
        layout.setAlignment(Pos.CENTER);

        Label welcome = new Label(account.getName());

        layout.getChildren().add(welcome);

        Scene dashboardScene = new Scene(layout, width, height);
        window.setScene(dashboardScene);
    }
    /**
     * Logs out the current user
     */
    public void logout() {
        // TODO: Reset session
    }
}