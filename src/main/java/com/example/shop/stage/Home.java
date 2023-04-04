package com.example.shop.stage;

import com.example.shop.util.MainUtil;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Home {
    public static void show(Stage stage) {
        stage.setOnCloseRequest(e -> {
            e.consume();
            MainUtil.close(stage);
        });
        HBox topMenu = new HBox();
        Button file = new Button("File");
        Button edit = new Button("Edit");
        Button view = new Button("View");

        Button button1 = new Button("Thoát");
        button1.setOnAction(e -> MainUtil.close(stage));

        topMenu.getChildren().addAll(file, edit, view);

        VBox leftMenu = new VBox();
        Button project = new Button("Project");
        Button library = new Button("Library");
        leftMenu.getChildren().addAll(project, library);

        BorderPane borderPane = new BorderPane();
        borderPane.setTop(topMenu);
        borderPane.setLeft(leftMenu);

        Scene scene = new Scene(borderPane, 400, 200);
        stage.setScene(scene);
        stage.show();
    }
}
