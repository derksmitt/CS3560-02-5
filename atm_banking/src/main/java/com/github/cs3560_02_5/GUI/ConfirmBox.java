package com.github.cs3560_02_5.GUI;

import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.stage.*;
import javafx.geometry.*;
import javafx.scene.*;

public class ConfirmBox {
    static boolean answer;
    public static void display(String title, String message) {
        Stage window = new Stage();

        // Block events to other windows
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(200);

        Label label = new Label();
        label.setText(message);

        Button yesButton = new Button("Yes");
        Button noButton = new Button("No");

        yesButton.setOnAction(e -> {
            answer = true;
            window.close();
        });
        noButton.setOnAction(e -> {
            answer = false;
            window.close();
        });

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, yesButton, noButton);
        layout.setAlignment(Pos.CENTER);

        // Display window
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
    }
}