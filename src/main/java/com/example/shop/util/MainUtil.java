package com.example.shop.util;

import com.example.shop.box.ConfirmBox;
import javafx.stage.Stage;

public class MainUtil {

    public static void close(Stage stage) {
        boolean exit = ConfirmBox.display("Exit", "Bạn có chắc muốn thoát app");
        if (exit) stage.close();
    }
}
