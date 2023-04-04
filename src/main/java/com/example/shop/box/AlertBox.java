package com.example.shop.box;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AlertBox {

    public static void display(String title, String message){
        Stage messageBox = new Stage();

        messageBox.initModality(Modality.APPLICATION_MODAL);
        messageBox.setTitle(title);
        messageBox.setMinWidth(250);

        Label label = new Label();
        label.setText(message);
        Button closeButton = new Button("OK");
        closeButton.setOnAction(e -> messageBox.close());

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, closeButton);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);

        messageBox.setScene(scene);
        messageBox.showAndWait();
    }
}
