package controller;

import model.Grille;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class JeuDebutantController extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("Débutant");

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/JeuDebutant.fxml"));

        Scene scene = new Scene(fxmlLoader.load(), 279, 297);
        primaryStage.setScene(scene);

        primaryStage.setResizable(false);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
