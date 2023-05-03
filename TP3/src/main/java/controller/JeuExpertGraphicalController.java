package controller;

import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.Grille;

public class JeuExpertGraphicalController {

    private Grille grille = new Grille(30,16);
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
        grilleController.PeuplerGrille(grille, 99);

        for (int ligne = 0; ligne < grille.getLargeur(); ligne++) {
            for (int colonne = 0; colonne < grille.getHauteur(); colonne++) {
                grille.getGrille()[ligne][colonne].setMinWidth(29);
                tableauDeJeu.add(grille.getGrille()[ligne][colonne], ligne, colonne);
            }
        }
    }
}
