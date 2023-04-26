package Model;

import java.util.ArrayList;

public class Grille
{
    private int largeur;
    private int hauteur;
    private Case[][] grille;

    public Grille(int largeur, int hauteur)
    {
        this.largeur = largeur;
        this.hauteur = hauteur;
        this.grille = new Case[largeur][hauteur];
    }


    public int getNbCaseRestante()
    {
        int nbCaseRestante = 0;

        for(int i = 0; i < this.largeur; i++)
        {
            for(int j = 0; j < this.hauteur; j++)
            {
                if(
                    grille[i][j].getEtat() == Case.EtatCase.normal ||
                    grille[i][j].getEtat() == Case.EtatCase.drapeau ||
                    grille[i][j].getEtat() == Case.EtatCase.interrogation
                )
                {
                    nbCaseRestante++;
                }
            }
        }

        return nbCaseRestante;
    }
}
