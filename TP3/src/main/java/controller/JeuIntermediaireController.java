package controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class JeuIntermediaireController extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {

        primaryStage.setTitle("Intermédiaire");

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/JeuIntermediaire.fxml"));

        Scene scene = new Scene(fxmlLoader.load(), 311, 350);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
