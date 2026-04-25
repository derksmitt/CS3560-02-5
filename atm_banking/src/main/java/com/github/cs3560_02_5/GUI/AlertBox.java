package com.github.cs3560_02_5.GUI;

import javafx.animation.PauseTransition;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
* Creates a pop up window to handle alerts
*/
public class AlertBox {
    public static void display(String title, String message) {
        // Create new stage
        Stage window = new Stage();

        // Block events to other windows
        window.initModality(Modality.APPLICATION_MODAL);
        // Set the window title and size
        window.setTitle(title);
        window.setMinWidth(500);

        // Display message in window
        Text info = new Text(message);
        info.setFont(Font.font("Arial", FontWeight.BOLD, 36)); 
        // Close window on button press
        Button close = new Button("Close");
        close.setOnAction(e->window.close());

        // Define spacing and alignment
        VBox layout = new VBox(10);
        layout.getChildren().addAll(info, close);
        layout.setAlignment(Pos.CENTER);

        // Display window
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
    }

    public static void display(String title, String message, int seconds) {
                // Create new stage
        Stage window = new Stage();

        // Block events to other windows
        window.initModality(Modality.APPLICATION_MODAL);
        // Set the window title and size
        window.setTitle(title);
        window.setMinWidth(500);

        // Display message in window
        Text info = new Text(message);
        info.setFont(Font.font("Arial", FontWeight.BOLD, 36)); 
        // Close window on button press
        Button close = new Button("Close");
        close.setOnAction(e->window.close());

        // Define spacing and alignment
        VBox layout = new VBox(10);
        layout.getChildren().addAll(info, close);
        layout.setAlignment(Pos.CENTER);

        // Display window
        Scene scene = new Scene(layout);
        window.setScene(scene);

        PauseTransition delay = new PauseTransition(Duration.seconds(seconds));
        delay.setOnFinished(event -> window.close());
        delay.play();

        window.showAndWait();
    }
        

    
}
