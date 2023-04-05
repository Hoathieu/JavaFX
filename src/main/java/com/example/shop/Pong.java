package com.example.shop;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.Random;

public class Pong extends Application {
    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;
    public static final int PLAYER_WIDTH = 100;
    public static final int PLAYER_HEIGHT = 15;
    public static final int BALL_R = 15;
    public int BALL_Y_SPEED = 1;
    public int BALL_X_SPEED = 1;
    public double PLAYER_ONE_Y_POS = HEIGHT / 2;
    public double PLAYER_TWO_Y_POS = HEIGHT / 2;
    public double BALL_X_POS = WIDTH / 2;
    public double BALL_Y_POS = WIDTH / 2;
    public int SCORE_P1 = 0;
    public int SCORE_P2 = 0;
    public boolean GAME_STARTED;
    public int PLAYER_ONE_X_POS = 0;
    public double PLAYER_TWO_X_POS = WIDTH - PLAYER_WIDTH;

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("P O N G");
        Canvas c = new Canvas(WIDTH, HEIGHT);
        GraphicsContext gc = c.getGraphicsContext2D();
        Timeline tl = new Timeline(new KeyFrame(Duration.millis(100), e -> run(gc)));
        tl.setCycleCount(Timeline.INDEFINITE);

        c.setOnMouseMoved(e -> PLAYER_ONE_Y_POS = e.getY());
        c.setOnMouseClicked(e -> GAME_STARTED = true);
        stage.setScene(new Scene(new StackPane(c)));
        stage.show();
        tl.play();
    }

    private void run(GraphicsContext gc) {
        gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, WIDTH, HEIGHT);

        gc.setFill(Color.WHITE);
        gc.setFont(Font.font(25));

        if (GAME_STARTED) {
            System.out.println("START");
            BALL_X_POS += BALL_X_SPEED;
            BALL_Y_POS += BALL_Y_SPEED;

            if (BALL_X_POS < WIDTH - WIDTH / 4)
                PLAYER_TWO_Y_POS = BALL_Y_POS - PLAYER_HEIGHT / 2;
            else
                PLAYER_TWO_Y_POS = BALL_Y_POS > PLAYER_HEIGHT / 2 ? PLAYER_TWO_Y_POS + 1 : PLAYER_TWO_Y_POS - 1;


            gc.fillOval(BALL_X_POS, BALL_Y_POS, BALL_R, BALL_R);
        } else {
            System.out.println("PAUSE");
            gc.setStroke(Color.WHITE);
            gc.setTextAlign(TextAlignment.CENTER);
            gc.strokeText("START GAME", WIDTH / 2, HEIGHT / 2);

            BALL_X_POS = WIDTH / 2;
            BALL_Y_POS = HEIGHT / 2;

            BALL_X_SPEED = new Random().nextInt(2) == 0 ? 1 : -1;
            BALL_Y_SPEED = new Random().nextInt(2) == 0 ? 1 : -1;
        }

        if (BALL_Y_POS > HEIGHT || BALL_Y_POS == 0)
            BALL_Y_SPEED *= -1;

        if (BALL_X_POS < PLAYER_ONE_X_POS - PLAYER_WIDTH) {
            SCORE_P2++;
            GAME_STARTED = false;
        }

        if (BALL_X_POS > PLAYER_TWO_X_POS + PLAYER_WIDTH) {
            SCORE_P1++;
            GAME_STARTED = false;
        }
        gc.fillRect(PLAYER_TWO_X_POS, PLAYER_TWO_Y_POS, PLAYER_HEIGHT, PLAYER_WIDTH);
        gc.fillRect(PLAYER_ONE_X_POS, PLAYER_ONE_Y_POS, PLAYER_WIDTH, PLAYER_HEIGHT);
    }

    public static void main(String[] args) {
        launch();
    }
}
