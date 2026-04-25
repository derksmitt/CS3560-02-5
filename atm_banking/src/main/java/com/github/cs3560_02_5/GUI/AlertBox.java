package com.github.cs3560_02_5.GUI;

import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.control.*;
import javafx.stage.*;
import javafx.geometry.*;
import javafx.scene.*;

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
}
