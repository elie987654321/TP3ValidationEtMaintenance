package model;

import javafx.scene.control.Button;

public class Case {
    public enum TypeCase{
        rien,
        un,
        deux,
        trois,
        quatre,
        cinq,
        six,
        sept,
        huit,
        mine
    }

    public enum EtatCase{
        normal,
        revele,
        drapeau,
        interrogation
    }

    private Button bouton = new Button();
    private TypeCase type;
    private EtatCase etat;
    private int ligne;
    private int colonne;


    public Button getBouton() {
        return bouton;
    }
    public void setBouton(Button bouton) {
        this.bouton = bouton;
    }

    public EtatCase getEtat() {
        return etat;
    }

    public void setEtat(EtatCase etat) {
        this.etat = etat;
    }


    public TypeCase getType() {
        return type;
    }

    public void setType(TypeCase type) {
        this.type = type;
    }

    public int getLigne() {
        return ligne;
    }

    public void setLigne(int ligne) {
        this.ligne = ligne;
    }

    public int getColonne() {
        return colonne;
    }

    public void setColonne(int colonne) {
        this.colonne = colonne;
    }
}
