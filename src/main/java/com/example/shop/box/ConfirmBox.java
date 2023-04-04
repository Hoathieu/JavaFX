package com.example.shop.box;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ConfirmBox {
    static boolean res;
    public static boolean display(String title, String message) {

        Stage confirmBox = new Stage();

        confirmBox.initModality(Modality.APPLICATION_MODAL);
        confirmBox.setTitle(title);
        confirmBox.setMinWidth(250);

        Label label = new Label();
        label.setText(message);
        Button confirm = new Button("OK");
        confirm.setOnAction(e -> {
            confirmBox.close();
            res = true;
        });

        Button cancel = new Button("Cancel");
        cancel.setOnAction(e -> {
            confirmBox.close();
            res = false;
        });

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, confirm, cancel);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);

        confirmBox.setScene(scene);
        confirmBox.showAndWait();
        return res;
    }
}
