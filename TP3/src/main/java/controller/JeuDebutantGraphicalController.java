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

    @FXML
    private GridPane tableauDeJeu;
    @FXML private MenuBar barreDeMenu;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
}
