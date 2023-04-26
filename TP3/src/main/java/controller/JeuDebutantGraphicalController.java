package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.ResourceBundle;

public class JeuDebutantGraphicalController implements Initializable {
    private static final int NBR_LIGNES = 8;
    private static final int NBR_COLONNES = 8;
    private static final int NBR_MINES = 10;

    private final Case[][] cases = new Case[NBR_LIGNES][NBR_COLONNES];

    @FXML
    private GridPane tableauDeJeu;
    @FXML private MenuBar barreDeMenu;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initializeCases();
    }

    private void initializeCases() {
        for (int ligne = 0; ligne < NBR_LIGNES; ligne++) {
            for (int colonne = 0; colonne < NBR_COLONNES; colonne++) {
                Case uneCase = new Case(ligne, colonne, NBR_MINES);
                cases[ligne][colonne] = uneCase;
                tableauDeJeu.add(uneCase, colonne, ligne);
            }
        }
    }

    @FXML
    private void recommencerLaPartie() {
        for (int ligne = 0; ligne < NBR_LIGNES; ligne++) {
            for (int colonne = 0; colonne < NBR_COLONNES; colonne++) {
                cases[ligne][colonne].resetCase(); 
            }
        }
    }
}
