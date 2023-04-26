package controller;

import model.Case;
import model.Grille;

import java.util.Random;

public class GrilleController {
    public void PeuplerGrille(Grille grille, int nbBombe)
    {
        Random rand = new Random();
        for(int i = 0; i < nbBombe; i++)
        {
            int positionX;
            int positionY;

            boolean dejaMineSurCase = false;
            do{
                dejaMineSurCase = false;
                positionX = rand.nextInt(grille.getLargeur());
                positionY = rand.nextInt(grille.getHauteur());
                if(grille.getGrille()[positionX][positionY].getType() == Case.TypeCase.mine)
                {
                    dejaMineSurCase = true;
                }
            }while(dejaMineSurCase);

            grille.getGrille()[positionX][positionY].setType(Case.TypeCase.mine);
        }

        for(int i = 0; i < grille.getLargeur(); i++)
        {
            for(int j = 0; j < grille.getHauteur(); j++)
            {
                if(grille.getGrille()[i][j].getType() != Case.TypeCase.mine)
                {
                    int nombreMines = 0;

                    if(i-1 >=0 && j-1 >=0 &&)
                }

            }
        }
    }
}
