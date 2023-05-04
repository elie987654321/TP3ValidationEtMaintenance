package controller;

import model.Case;
import model.Grille;

public class GrilleGraphique {
    Grille grille;

    CaseGraphique[][] grilleGraphique;


    public GrilleGraphique(int largeur, int hauteur)
    {
        grille = new Grille(largeur, hauteur);
        grilleGraphique = new CaseGraphique[largeur][hauteur];

        for(int i = 0; i < largeur; i++)
        {
            for(int j = 0; j < hauteur; j++)
            {
                grilleGraphique[i][j] = new CaseGraphique();
            }
        }
    }


    public int getNbCaseRestante()
    {
        return grille.getNbCaseRestante();
    }


    public int getNbBombes()
    {
        return grille.getNbBombes();
    }

    public int getLargeur() {
        return grille.getLargeur();
    }

    public int getHauteur() {
        return grille.getHauteur();
    }

    public Case[][] getGrilleModel() {
        return grille.getGrille();
    }

    public CaseGraphique[][] getGrilleGraphique()
    {
        return grilleGraphique;
    }
}
