package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.Case;
import model.Grille;

import java.net.URL;
import java.util.ResourceBundle;

public class JeuDebutantGraphicalController {

    private Grille grille = new Grille(8,8);
    private GrilleController grilleController = new GrilleController();
    private Image image = new Image("images/caseDeBase.png");

    @FXML
    private Button button;

    @FXML
    private GridPane tableauDeJeu;

    @FXML
    public MenuItem debutantMenuItem;

    @FXML
    public MenuItem intermediaireMenuItem;

    @FXML
    public MenuItem expertMenuItem;

    public void handleJeuDebutant() throws Exception {
        Stage stage = (Stage) debutantMenuItem.getParentPopup().getOwnerWindow();
        JeuDebutantController jeuDebutantController = new JeuDebutantController();
        jeuDebutantController.start(stage);
    }

    public void handleJeuIntermediaire() throws Exception {
        Stage stage = (Stage) intermediaireMenuItem.getParentPopup().getOwnerWindow();
        JeuIntermediaireController jeuIntermediaireController = new JeuIntermediaireController();
        jeuIntermediaireController.start(stage);
    }

    public void handleJeuExpert() throws Exception {
        Stage stage = (Stage) expertMenuItem.getParentPopup().getOwnerWindow();
        JeuExpertController expertController = new JeuExpertController();
        expertController.start(stage);
    }

    public void initialize() {
        grilleController.PeuplerGrille(grille, 10);

        for (int ligne = 0; ligne < grille.getLargeur(); ligne++) {
            for (int colonne = 0; colonne < grille.getHauteur(); colonne++) {
                //grille.getGrille()[colonne][ligne].setMinWidth(16);
                tableauDeJeu.add(grille.getGrille()[colonne][ligne], colonne, ligne);
            }
        }
    }

    public void recommencerLaPartie(){

    }

}
