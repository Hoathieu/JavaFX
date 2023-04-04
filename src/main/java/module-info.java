module com.example.shop {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires lombok;

    opens com.example.shop to javafx.fxml;
    exports com.example.shop;
}