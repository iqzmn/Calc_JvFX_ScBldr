package com.thorus;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.getIcons().add(new Image("images/if_MB__calculator_81184.png"));
        Parent root = FXMLLoader.load(getClass().getResource("View.fxml"));
        primaryStage.setTitle("Calculator");
        primaryStage.setScene(new Scene(root, 332, 442));
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
