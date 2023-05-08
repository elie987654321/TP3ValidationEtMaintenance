package controller;

import model.Grille;


public class GrilleGraphicalDecorator {

    private Grille grille;

    private BouttonCase[][] grilleBouton;

    public GrilleGraphicalDecorator(Grille grille)
    {
        this.grille = grille;
        this.grilleBouton = new BouttonCase[grille.getLargeur()][grille.getHauteur()];

        for(int i = 0; i < grille.getLargeur(); i++)
        {
            for(int j = 0; j < grille.getHauteur(); j++)
            {
                grilleBouton[i][j] = new BouttonCase();
                grilleBouton[i][j].setLigne(i);
                grilleBouton[i][j].setRange(j);
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

    public Grille getGrille()
    {
        return grille;
    }

    public void setGrille(Grille grille)
    {

        this.grille = grille;
    }

    public BouttonCase[][] getGrilleBoutton()
    {
        return this.grilleBouton;
    }

    public void setGrilleBoutton(BouttonCase[][] grilleBoutton)
    {
        this.grilleBouton = grilleBoutton;
    }
}

