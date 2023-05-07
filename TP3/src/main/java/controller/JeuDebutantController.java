package controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class JeuDebutantController extends Application implements JeuControllerInterface{

    @Override
    public void start(Stage primaryStage) throws IOException {

        primaryStage.setTitle("Débutant");

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/JeuDebutant.fxml"));

        Scene scene = new Scene(fxmlLoader.load(), 153, 214);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
