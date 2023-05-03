package controller;

import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.MenuItem;
import model.Grille;


public class JeuIntermediaireGraphicalController {

    private Grille grille = new Grille(16, 16);
    private GrilleController grilleController = new GrilleController();

    @FXML
    public MenuItem debutantMenuItem;

    @FXML
    public MenuItem intermediaireMenuItem;

    @FXML
    public MenuItem expertMenuItem;

    @FXML
    private GridPane tableauDeJeu;

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

    public void recommencerLaPartie() throws Exception {

    }

    public void initialize() {
        grilleController.PeuplerGrille(grille, 40);

        for (int ligne = 0; ligne < grille.getLargeur(); ligne++) {
            for (int colonne = 0; colonne < grille.getHauteur(); colonne++) {
                tableauDeJeu.add(grille.getGrille()[ligne][colonne], ligne, colonne);
            }
        }
    }
}
