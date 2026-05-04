package com.github.cs3560_02_5;
import com.github.cs3560_02_5.GUI.AlertBox;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
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

        // Size of scene and display
        Scene scene = new Scene(login(), width, height);
        window.setScene(scene);
        window.show();
    }

    /**  
     * Banner on scenes
    */
    public HBox banner() {
        // Create HBox
        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);
        hBox.setPadding(new Insets(15,12,15,12));
        hBox.setStyle("-fx-background-color: #48525d");
        // Create Text in hBox
        Text bankNameText = new Text("Outlaw Banking");
        // Set the style
        bankNameText.setFont(Font.font("Arial Narrow", FontWeight.THIN, 60));
        bankNameText.setFill(Color.WHITE);
        hBox.getChildren().add(bankNameText);
        return hBox;
    }
    /**
     * Login window displayed to user
     * @return VBox
     */
    public BorderPane login() { 
        // Create VBox with centering
        VBox layout = new VBox();
        layout.setAlignment(Pos.CENTER);
        // Set style
        layout.setStyle("-fx-background-color: #d9d9d9");
        // Set size
        layout.setMaxWidth(600);
        layout.setMaxHeight(300);
        // Create padding and spacing for objects
        layout.setPadding(new Insets(90));
        layout.setSpacing(20);

        // Create new text on top
        Text name = new Text("LOGIN");
        // Set style
        name.setFont(Font.font("Arial Narrow", FontWeight.THIN, 30));
        name.setFill(Color.rgb(42, 60, 77));

        // Create GridPane
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setVgap(50);
        grid.setHgap(20);

        // Allow columns to expand
        grid.getColumnConstraints().addAll(new ColumnConstraints(100), new ColumnConstraints(300));

        // Create text 
        Text cardNumberText = new Text("Card Number");
        // Defining the card number field
        final TextField cardNum = new TextField();
        cardNum.setPromptText("Enter your Card Number");
        grid.add(cardNumberText, 0, 0);
        grid.add(cardNum, 1, 0);

        // Create text
        Text pinText = new Text("PIN");
        // Defining the pin text field
        final TextField pin = new TextField();
        pin.setPromptText("Enter your PIN");
        grid.add(pinText, 0, 1);
        grid.add(pin, 1, 1);

        // Defining the Submit button
        Button submit = new Button("Login");
        submit.setMaxWidth(100);
        submit.setStyle("-fx-background-color: #2a3c4d; -fx-text-fill: white");
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
        layout.getChildren().addAll(name, grid, submit);

        // Creating a BorderPane container
        BorderPane border = new BorderPane();
        border.setTop(banner());
        border.setCenter(layout);
        return border;
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
        // Create VBox with centering
        VBox pane = new VBox(); 
        pane.setAlignment(Pos.CENTER);

        // Set style
        pane.setStyle("-fx-background-color: #d9d9d9");
        // Set size
        pane.setMaxWidth(800);
        pane.setMaxHeight(500);
        pane.setSpacing(20);

        // Create new text on top
        Text name = new Text("PLEASE SELECT A SERVICE");
        // Set style
        name.setFont(Font.font("Arial Narrow", FontWeight.THIN, 30));
        name.setFill(Color.rgb(42, 60, 77));
        
        // Create GridPane
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setVgap(50);
        grid.setHgap(50);

        //display the balance of the account
        Text balanceText = new Text("Balance: $" + String.format("%.2f", account.getBalance()));
        balanceText.setFont(Font.font("Arial Narrow", FontWeight.THIN, 24));
        balanceText.setFill(Color.rgb(42, 60, 77));
        HBox balanceBox = new HBox(balanceText);
        balanceBox.setAlignment(Pos.CENTER);
        balanceBox.setPadding(new Insets(15));
        balanceBox.setStyle("-fx-background-color: white; -fx-border-color: #2a3c4d; -fx-border-width: 2; -fx-background-radius: 10; -fx-border-radius: 10;");

        // Defining the withdraw button
        Button withdrawButton = new Button("WITHDRAW");
        withdrawButton.setMaxWidth(100);
        withdrawButton.setStyle("-fx-background-color: white; -fx-text-fill: #2a3c4d");
        grid.add(withdrawButton, 0, 0);

        // Defining the deposit button
        Button depositButton = new Button("DEPOSIT");
        depositButton.setMaxWidth(100);
        depositButton.setStyle("-fx-background-color: white; -fx-text-fill: #2a3c4d");
        grid.add(depositButton, 1, 0);

        // Defining the balance button
        Button transferButton = new Button("TRANSFER");
        transferButton.setMaxWidth(100);
        transferButton.setStyle("-fx-background-color: white; -fx-text-fill: #2a3c4d");
        grid.add(transferButton, 0, 1);

        // Defining the exit button
        Button exitButton = new Button("EXIT");
        exitButton.setMaxWidth(100);
        exitButton.setStyle("-fx-background-color: #2a3c4d; -fx-text-fill: white");
        grid.add(exitButton, 1, 1);
        exitButton.setOnAction(event -> {
            AlertBox.display("Signing Out", "Goodbye!", 2);
            logout();
        });


        pane.getChildren().addAll(name, balanceBox, grid);

        // Creating a BorderPane container
        BorderPane border = new BorderPane();
        border.setTop(banner());
        border.setCenter(pane);

        Scene menuScene = new Scene(border, width, height);
        window.setScene(menuScene);
    }
    /**
     * Logs out the current user
     */
    public void logout() {
        // TODO: Reset session
        Scene scene = new Scene(login(), width, height);
        window.setScene(scene);
    }
}
