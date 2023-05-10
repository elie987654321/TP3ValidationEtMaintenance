package model;

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

        for(int i = 0; i < largeur; i++)
        {
            for(int j = 0; j < hauteur; j++)
            {
                grille[i][j] = new Case();
            }
        }
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


    public int getNbBombes()
    {
        int nbBombes = 0;

        for(int i = 0; i < getLargeur(); i++)
        {
            for(int j = 0; j < getHauteur(); j++)
            {
                if(grille[i][j].getType() == Case.TypeCase.mine)
                {
                    nbBombes++;
                }
            }
        }

        return nbBombes;
    }

    public int getLargeur() {
        return largeur;
    }

    public int getHauteur() {
        return hauteur;
    }

    public Case[][] getGrille() {
        return grille;
    }
}
