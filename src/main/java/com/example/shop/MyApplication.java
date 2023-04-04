package com.example.shop;

import com.example.shop.box.ConfirmBox;
import com.example.shop.stage.Login;
import com.example.shop.util.MainUtil;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class MyApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {


        stage.setOnCloseRequest(e -> {
            e.consume();
            MainUtil.close(stage);
        });

        GridPane login = Login.display(stage);
        Scene scene = new Scene(login, 400, 200);
        stage.setScene(scene);
        stage.setTitle("title");
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }

    //        FXMLLoader fxmlLoader = new FXMLLoader(MyApplication.class.getResource("hello-view.fxml"));
    //        Scene scene = new Scene(fxmlLoader.load(), 1080, 720);
    //        stage.setTitle("Hello!");
    //        stage.setScene(scene);
    //        stage.show();
}