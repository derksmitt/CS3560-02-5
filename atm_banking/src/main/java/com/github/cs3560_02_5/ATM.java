package com.github.cs3560_02_5;
import com.github.cs3560_02_5.GUI.AlertBox;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
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

        // Size of scene and display
        Scene scene = new Scene(login(), width, height);
        window.setScene(scene);
        window.show();
    }

    /**
     * Login window displayed to the user
     * @return VBox
     */
    public BorderPane login() { 
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

        // Create VBox with centering
        VBox layout = new VBox();
        layout.setAlignment(Pos.CENTER);
        // Set style
        layout.setStyle("-fx-background-color: #d9d9d9");
        // Set size
        layout.setMaxWidth(600);
        layout.setMaxHeight(300);
        // Create padding and spacing for objects'
        layout.setPadding(new Insets(90));
        layout.setSpacing(20);

        // Create new text on top
        Text name = new Text("Login");
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
                    // Check if a valid account is found
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
        border.setTop(hBox);
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
