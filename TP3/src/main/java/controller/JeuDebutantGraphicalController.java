package controller;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.Case;
import model.Grille;

import java.util.ArrayList;

public class JeuDebutantGraphicalController {

    // La grille
    private Grille grille = new Grille(8,8);
    private GrilleController grilleController = new GrilleController();
    @FXML
    private GridPane tableauDeJeu;

    // Images des cases
    private ImageView imageViewCase;
    private Image imageCaseDeBase = new Image("images/caseDeBase.png");
    private Image imageCase;
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

    // Le compteur
    @FXML
    private Label timerLabel = new Label("000");
    private Timeline compteur;
    private int temps = 0;

    // Les mines
    @FXML
    private Label labelMine = new Label("000");
    private int nbrDeMines = 10;


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
        JeuDebutantController jeuDebutantController = new JeuDebutantController();
        jeuDebutantController.start(stage);
    }

    private void updateTimer() {
        timerLabel.setText(String.format("%03d", temps));

        temps++;
    }

    private  void initialiserLeCompteur(){
        compteur = new Timeline(new KeyFrame(Duration.seconds(1), event -> updateTimer()));
        compteur.setCycleCount(Animation.INDEFINITE);
        compteur.play();
    }

    private void handleClick(javafx.scene.input.MouseButton bouton, Case caseSelectionne) {
        System.out.println(caseSelectionne.getEtat() + " " + caseSelectionne.getType());

        if (!partieGagne(caseSelectionne)){
            // Validation d'un clique sur mine
            if (caseSelectionne.getEtat() != Case.EtatCase.revele){

                // Commencer le compteur au premier clique d'une case
                if(compteur== null){
                    initialiserLeCompteur();
                }

                // Validation d'un clique gauche sur une case
                if (caseSelectionne.getEtat() !=  Case.EtatCase.drapeau) {
                    if (bouton == javafx.scene.input.MouseButton.PRIMARY) {
                        // Validation d'un clic sur une mine
                        if (caseSelectionne.getType() ==  Case.TypeCase.mine){
                            finirLaPartie(caseSelectionne);
                        }else {
                            revelerLaCase(caseSelectionne);
                        }

                    }
                }

                // Validation d'un clique droit sur une case
                if (bouton == javafx.scene.input.MouseButton.SECONDARY) {
                    if (caseSelectionne.getEtat() ==  Case.EtatCase.normal){

                        mettreUnDrapeau(caseSelectionne);
                    }else if(caseSelectionne.getEtat() ==  Case.EtatCase.drapeau){
                        mettreUnInterrogation(caseSelectionne);
                    }else {
                        remettreNormal(caseSelectionne);
                    }
                }
            }
        }
    }

    private void mettreAJourNbrDeMines(boolean mine){
        if (mine){
            nbrDeMines = nbrDeMines - 1;
        }else {
            nbrDeMines = nbrDeMines + 1;
        }

        if(nbrDeMines > 99){
            labelMine.setText(""+nbrDeMines);
        }else if (nbrDeMines < 10){
            labelMine.setText("00"+nbrDeMines);
        }
        else{
            labelMine.setText("0"+nbrDeMines);
        }
    }

    private void mettreUnDrapeau(Case caseSelectionne){
        caseSelectionne.setEtat(Case.EtatCase.drapeau);
        imageViewCase = new ImageView(imageCaseDrapeau);
        caseSelectionne.setGraphic(imageViewCase);

        mettreAJourNbrDeMines(true);
    }

    private void mettreUnDrapeauErrone(Case caseSelectionne){
        imageViewCase = new ImageView(imageCaseMineMalIdentifie);
        caseSelectionne.setGraphic(imageViewCase);
    }

    private void mettreUnInterrogation(Case caseSelectionne){
        caseSelectionne.setEtat(Case.EtatCase.interrogation);
        imageViewCase = new ImageView(imageCaseInterrogation);
        caseSelectionne.setGraphic(imageViewCase);

        mettreAJourNbrDeMines(false);

    }

    private void remettreNormal(Case caseSelectionne){
        caseSelectionne.setEtat(Case.EtatCase.normal);
        imageViewCase = new ImageView(imageCaseDeBase);
        caseSelectionne.setGraphic(imageViewCase);
    }

    private void revelerLaCase(Case caseSelectionne){
        String type = caseSelectionne.getType() + ".png";
        caseSelectionne.setEtat(Case.EtatCase.revele);
        imageCase = new Image("images/" + type);
        imageViewCase = new ImageView(imageCase);
        caseSelectionne.setGraphic(imageViewCase);
        caseSelectionne.setDisable(true);
    }

    private void revelerLaMine(Case caseSelectionne){
        imageViewCase = new ImageView(imageCaseMine);
        caseSelectionne.setGraphic(imageViewCase);
    }

    private void revelerLaMineExplose(Case caseSelectionne){
        imageViewCase = new ImageView(imageCaseMineExplose);
        caseSelectionne.setGraphic(imageViewCase);
    }

    private void changerBonhommeMort(){
        imageViewCase = new ImageView(imageBonhommeMort);
        bonhomme.setGraphic(imageViewCase);
    }

    private void changerBonhommeGagne(){
        imageViewCase = new ImageView(imageBonhommeGagne);
        bonhomme.setGraphic(imageViewCase);
    }

    private void finirLaPartie(Case caseSelectionne){
        for (int ligne = 0; ligne < grille.getLargeur(); ligne++) {
            for (int colonne = 0; colonne < grille.getHauteur(); colonne++) {

                if (grille.getGrille()[ligne][colonne].getType() == Case.TypeCase.mine && grille.getGrille()[ligne][colonne].getEtat() != Case.EtatCase.drapeau){
                    revelerLaMine(grille.getGrille()[ligne][colonne]);

                }
                else if (grille.getGrille()[ligne][colonne].getEtat() == Case.EtatCase.drapeau && grille.getGrille()[ligne][colonne].getType() != Case.TypeCase.mine){
                    mettreUnDrapeauErrone(grille.getGrille()[ligne][colonne]);
                }
                grille.getGrille()[ligne][colonne].setDisable(true);
            }
        }

        changerBonhommeMort();
        revelerLaMineExplose(caseSelectionne);
        compteur.stop();
    }

    private boolean partieGagne(Case caseSelectionne){
        int indice = 0;

        for (int ligne = 0; ligne < grille.getLargeur(); ligne++) {
            for (int colonne = 0; colonne < grille.getHauteur(); colonne++) {

                if (grille.getGrille()[ligne][colonne].getType() == Case.TypeCase.mine || grille.getGrille()[ligne][colonne].getEtat() == Case.EtatCase.revele){
                    indice++;
                }
            }
        }

        if (indice == grille.getLargeur() * grille.getHauteur() - 1){
            for (int ligne = 0; ligne < grille.getLargeur(); ligne++) {
                for (int colonne = 0; colonne < grille.getHauteur(); colonne++) {
                    if (grille.getGrille()[ligne][colonne].getEtat() != Case.EtatCase.drapeau && grille.getGrille()[ligne][colonne].getType() == Case.TypeCase.mine){
                        mettreUnDrapeau(grille.getGrille()[ligne][colonne]);
                    }

                    grille.getGrille()[ligne][colonne].setDisable(true);

                }
            }
            revelerLaCase(caseSelectionne);
            changerBonhommeGagne();
            compteur.stop();

            return true;
        }

        return false;
    }

    public void initialize() {
        grilleController.PeuplerGrille(grille, 1);

        for (int ligne = 0; ligne < grille.getLargeur(); ligne++) {
            for (int colonne = 0; colonne < grille.getHauteur(); colonne++) {

                // Les cases
                imageViewCase = new ImageView(imageCaseDeBase);
                grille.getGrille()[ligne][colonne].setGraphic(imageViewCase);
                Case cases = grille.getGrille()[ligne][colonne];
                grille.getGrille()[ligne][colonne].setOnMouseClicked(event -> handleClick(event.getButton(), cases));

                // Le bonhomme
                imageViewBonhomme = new ImageView(imageBonhommeSourire);
                bonhomme.setGraphic(imageViewBonhomme);

                // Le label mine
                if(nbrDeMines > 99){
                    labelMine.setText(""+nbrDeMines);
                }else if (nbrDeMines < 10){
                    labelMine.setText("00"+nbrDeMines);
                }
                else{
                    labelMine.setText("0"+nbrDeMines);
                }

                tableauDeJeu.add(grille.getGrille()[ligne][colonne], ligne, colonne);
            }
        }
    }
}
