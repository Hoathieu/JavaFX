package com.example.shop;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Random;

public class MyApplication extends Application {
    private VBox root;

    @Override
    public void start(Stage stage) throws Exception {
        stage.setScene(new Scene(createContent()));
        stage.show();
    }

    private Parent createContent() {
        root = new VBox();
        root.setPrefSize(1280, 720 + 100);



        Button button = new Button("Start");
        button.setOnAction(e -> startGame());

        root.getChildren().addAll(new Pane(), button);
        return root;
    }

    private void startGame() {
        root.getChildren().set(0, populateGrid());
    }

    private Pane populateGrid(){
        Pane tilePane = new Pane();
        Random random = new Random();

        for (int i = 1; i <= 9; i++) {
            TileView tile = new TileView(Integer.toString(i));
            tile.setTranslateX(random.nextInt(1280 / 80) * 80);
            tile.setTranslateY(random.nextInt(720 / 80) * 80);
            tile.setOnMouseClicked(e -> tile.hide());
            tilePane.getChildren().add(tile);
        }
        return tilePane;
    }

    private static class TileView extends StackPane {
        Text text;

        TileView(String content) {
            Rectangle border = new Rectangle(80, 80, null);
            border.setStroke(Color.BLACK);
            border.setStrokeWidth(4);
            border.setStrokeType(StrokeType.INSIDE);

            text = new Text(content);
            text.setFont(Font.font(64));

            getChildren().addAll(border, text);

            setPickOnBounds(true);

        }

        void hide() {
            text.setVisible(false);
        }

    }
}