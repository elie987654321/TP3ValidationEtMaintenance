package controller;

import javafx.scene.control.Button;
import model.Case;
import model.Grille;

import javafx.scene.image.Image;


public class GrilleGraphicalDecorator {

    private Grille grille;

    private BouttonCase[][] grilleBouton;

    public GrilleGraphicalDecorator(Grille grille)
    {
        this.grille = grille;

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

    public Button[][] getGrilleBoutton()
    {
        return this.grilleBouton;
    }

    public void setGrilleBoutton(Button[][] grilleBoutton)
    {
        this.grilleBouton = grilleBoutton;
    }
}

