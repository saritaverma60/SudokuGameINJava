package io.github.dvyadav.sudokufx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root   = FXMLLoader.load(getClass().getResource("GameGridUI.fxml"));

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("SudokuFX");
        primaryStage.setMaximized(true);
        primaryStage.setMinWidth(700);

        primaryStage.show();
    }
}
