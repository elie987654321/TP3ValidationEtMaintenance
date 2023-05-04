package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.Grille;

public class JeuExpertGraphicalController {

    // La grille
    private Grille grille = new Grille(30,16);
    private GrilleController grilleController = new GrilleController();
    @FXML
    private GridPane tableauDeJeu;
    @FXML
    private BorderPane contour;

    // Images des cases
    private ImageView imageViewCase;
    private Image imageCaseDeBase = new Image("images/caseDeBase.png");
    private Image imageCase0 = new Image("images/case0.png");
    private Image imageCase1 = new Image("images/case1.png");
    private Image imageCase2 = new Image("images/case2.png");
    private Image imageCase3 = new Image("images/case3.png");
    private Image imageCase4 = new Image("images/case4.png");
    private Image imageCase5 = new Image("images/case5.png");
    private Image imageCase6 = new Image("images/case6.png");
    private Image imageCase7 = new Image("images/case7.png");
    private Image imageCase8 = new Image("images/case8.png");
    private Image imageCaseDrapeau = new Image("images/caseDrapeau.png");
    private Image imageCaseInterrogation = new Image("images/caseInterrogation.png");
    private Image imageCaseMine = new Image("images/caseMine.png");
    private Image imageCaseMineExplose = new Image("images/caseMineExplose.png");
    private Image imageCaseMineMalIdentifie = new Image("images/caseMineMalIdentifie.png");


    // Images du bonhomme
    @FXML
    private Button bonhomme;
    private ImageView imageViewBonhomme;
    private Image imageBonhommeSourire = new Image("images/boutonInteractifSourire.png");
    private Image imageBonhommeGagne = new Image("images/boutonInteractifGagne.png");
    private Image imageBonhommeMort = new Image("images/boutonInteractifMort.png");

    // Les difficultés
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

    public void recommencerLaPartie() throws Exception {
        Stage stage = (Stage) bonhomme.getScene().getWindow();
        JeuExpertController expertController = new JeuExpertController();
        expertController.start(stage);
    }

    public void initialize() {
        grilleController.PeuplerGrille(grille, 10);

        for (int ligne = 0; ligne < grille.getLargeur(); ligne++) {
            for (int colonne = 0; colonne < grille.getHauteur(); colonne++) {

                // Les cases
      /*          imageViewCase = new ImageView(imageCaseDeBase);
                grille.getGrille()[ligne][colonne].setGraphic(imageViewCase);*/
/*                grille.getGrille()[ligne][colonne].setDisable(true);
                grille.getGrille()[ligne][colonne].setStyle("-fx-opacity: 1");*/
                // Le bonhomme
      /*          imageViewBonhomme = new ImageView(imageBonhommeSourire);
                bonhomme.setGraphic(imageViewBonhomme);

                tableauDeJeu.add(grille.getGrille()[ligne][colonne], ligne, colonne);*/
            }
        }
    }
}
