package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.MenuItem;
import model.Grille;


public class JeuIntermediaireGraphicalController
{

    // La grille
    private Grille grille = new Grille(16,16);
    private GrilleController grilleController = new GrilleController();
    @FXML
    private GridPane tableauDeJeu;
    @FXML
    private BorderPane contour;

    // Images des cases
    private ImageView imageViewCase;
    private Image imageCaseDeBase = new Image("images/caseDeBase.png");
    private Image imageCase0 = new Image("images/rien.png");
    private Image imageCase1 = new Image("images/un.png");
    private Image imageCase2 = new Image("images/deux.png");
    private Image imageCase3 = new Image("images/trois.png");
    private Image imageCase4 = new Image("images/quatre.png");
    private Image imageCase5 = new Image("images/cinq.png");
    private Image imageCase6 = new Image("images/six.png");
    private Image imageCase7 = new Image("images/sept.png");
    private Image imageCase8 = new Image("images/huit.png");
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
        JeuControllerFactory factory = new JeuControllerFactory();
        JeuControllerInterface jeuDebutantController = factory.CreateGraphicalController(1);
        jeuDebutantController.start(stage);
    }

    public void handleJeuIntermediaire() throws Exception {
        Stage stage = (Stage) intermediaireMenuItem.getParentPopup().getOwnerWindow();
        JeuControllerFactory factory = new JeuControllerFactory();
        JeuControllerInterface jeuIntermediaireController = factory.CreateGraphicalController(2);
        jeuIntermediaireController.start(stage);
    }

    public void handleJeuExpert() throws Exception {
        Stage stage = (Stage) expertMenuItem.getParentPopup().getOwnerWindow();
        JeuControllerFactory factory = new JeuControllerFactory();
        JeuControllerInterface expertController = factory.CreateGraphicalController(3);
        expertController.start(stage);
    }

    public void recommencerLaPartie() throws Exception {
        Stage stage = (Stage) bonhomme.getScene().getWindow();
        JeuIntermediaireController jeuIntermediaireController = new JeuIntermediaireController();
        jeuIntermediaireController.start(stage);
    }

    public void initialize() {
        grilleController.PeuplerGrille(grille, 40);

        for (int ligne = 0; ligne < grille.getLargeur(); ligne++) {
            for (int colonne = 0; colonne < grille.getHauteur(); colonne++) {

                // Les cases
                imageViewCase = new ImageView(imageCaseDeBase);
                grille.getGrille()[ligne][colonne].setGraphic(imageViewCase);

                // Le bonhomme
                imageViewBonhomme = new ImageView(imageBonhommeSourire);
                bonhomme.setGraphic(imageViewBonhomme);

                tableauDeJeu.add(grille.getGrille()[ligne][colonne], ligne, colonne);
            }
        }
    }
}
