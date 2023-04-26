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
        primaryStage.setTitle("Jeu debutant");

        FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("/view/JeuDebutant.fxml"));

        Scene scene = new Scene(fxmlLoader1.load());
        primaryStage.setScene(scene);
        GrilleController controllerTest = new GrilleController();
        grille = new Grille(4,4);
        controllerTest.PeuplerGrille(grille, 10);
        int i = 0;
        primaryStage.show();


    }




    public static void main(String args[]) {
        launch(args);
    }

}
