package com.github.cs3560_02_5;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
* Main class representing the ATM machine
* Handles user interaction and coordinates system operations
*/
public class ATM extends Application{
    // Attributes
    private Bank bank;
    private Card currentCard;
    private Account currentAccount;
    private boolean isAuthenticated;
    public static void main(String[] args) {
        // Initialize database - TODO

        // Bank safeBank = new Bank();

        launch(args);
    }
    /**
     * Starts the ATM machine
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Outlaw Banking");

        //Creating a GridPane container
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(5);
        grid.setHgap(5);

        //Defining the card number field
        final TextField cardNum = new TextField();
        cardNum.setPromptText("Enter your Card Number");
        GridPane.setConstraints(cardNum, 0, 0);
        grid.getChildren().add(cardNum);

        //Defining the Last Name text field
        final TextField pin = new TextField();
        pin.setPromptText("Enter your PIN");
        GridPane.setConstraints(pin, 0, 1);
        grid.getChildren().add(pin);

        //Defining the Submit button
        Button submit = new Button("Login-in");
        GridPane.setConstraints(submit, 0, 3);
        grid.getChildren().add(submit);
        //button.setOnAction(e->System.out.println(cardNum.getText()));
        submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(event.getSource()==submit) {
                    authenticateUser(cardNum.getText(), Integer.parseInt(pin.getText()));
                    System.out.print("Button pressed");
                }
            }
        });

        // Size of scene
        Scene scene = new Scene(grid, 300, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Authenticates user using card and PIN
     * @param card Card inserted by user
     * @param pin Entered PIN
     * @return boolean indicating success/failure
     */
    public boolean authenticateUser(String cardNum, int pin) {
        if (cardNum == String.valueOf(currentCard.getAccountNumber())) {

            return true;
        }
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