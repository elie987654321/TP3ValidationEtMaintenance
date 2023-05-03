package controller;

import model.Grille;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class JeuDebutantController extends Application {

    private Grille grille;

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("Débutant");

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/JeuDebutant.fxml"));

        Scene scene = new Scene(fxmlLoader.load(), 263, 288);
        primaryStage.setScene(scene);

        /*GrilleController controllerTest = new GrilleController();
        grille = new Grille(4,4);
        controllerTest.PeuplerGrille(grille, 10);
        int i = 0;*/

        primaryStage.setResizable(false);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
