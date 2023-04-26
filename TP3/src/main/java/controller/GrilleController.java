package controller;

import Model.Case;
import Model.Grille;

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
    }
}
