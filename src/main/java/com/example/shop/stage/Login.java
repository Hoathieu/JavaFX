package com.example.shop.stage;

import com.example.shop.box.AlertBox;
import com.example.shop.entity.User;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Login {

    public static GridPane display(Stage stage) {

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(8);
        gridPane.setHgap(10);
        Label nameLabel = new Label("Username: ");
        gridPane.setConstraints(nameLabel, 0, 0);

        TextField inputName = new TextField("...");
        gridPane.setConstraints(inputName, 1, 0);

        Label passLabel = new Label("Password: ");
        gridPane.setConstraints(passLabel, 0, 1);

        TextField inputPass = new TextField("...");
        inputPass.setPromptText("password");
        gridPane.setConstraints(inputPass, 1, 1);

        Button buttonLogin = new Button("Login");
        buttonLogin.setOnAction(e -> {
            User user = new User();
            user.setUsername(inputName.getText());
            user.setPassword(inputPass.getText());
            System.out.println(user);
            if (user.getUsername().equals("admin") && user.getPassword().equals("123")) {
                Home.show(new Stage());
                stage.close();
            }else {
                AlertBox.display("Đăng nhập", "Tài khoản hoặc mật khẩu không chính xác");
            }
        });
        gridPane.setConstraints(buttonLogin, 1, 2);
        gridPane.getChildren().addAll(nameLabel, inputName, passLabel, inputPass, buttonLogin);
        return gridPane;
    }
}
