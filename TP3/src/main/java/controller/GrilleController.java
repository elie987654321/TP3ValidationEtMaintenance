package controller;

import model.Case;
import model.Grille;

import java.util.Random;

public class GrilleController {

    public void PeuplerGrille(Grille grille, int nbBombe)
    {
        AjouterEtatEtTypeInitialCasesGrille(grille);
        AjouterMinesGrille(grille, nbBombe);
        AjouterChiffresGrille(grille);
    }

    public void AjouterEtatEtTypeInitialCasesGrille(Grille grille)
    {
        for(int i = 0 ; i < grille.getLargeur(); i++)
        {
            for(int j = 0; j < grille.getHauteur(); j++)
            {
                grille.getGrille()[i][j].setEtat(Case.EtatCase.normal);
                grille.getGrille()[i][j].setType(Case.TypeCase.rien);
                grille.getGrille()[i][j].setLigne(i);
                grille.getGrille()[i][j].setColonne(j);
            }
        }
    }

    public void AjouterMinesGrille(Grille grille, int nbBombe)
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

    //!!  On descend dans la grille en augmentant la valeur de j.
    //    On se dirige a droite de la grille en augmentant la valeur de i
    public void AjouterChiffresGrille(Grille grille)
    {

        for(int i = 0; i < grille.getLargeur(); i++)
        {
            for(int j = 0; j < grille.getHauteur(); j++)
            {
                int nombreMines = 0;

                if(grille.getGrille()[i][j].getType() != Case.TypeCase.mine)
                {
                    if(i-1 >= 0 && j-1 >= 0)
                    {
                        if(grille.getGrille()[i-1][j-1].getType() == Case.TypeCase.mine)
                        {
                            nombreMines++;
                        }
                    }
                    if(j-1 >= 0)
                    {
                        if(grille.getGrille()[i][j-1].getType() == Case.TypeCase.mine)
                        {
                            nombreMines++;
                        }
                    }
                    if(i+1 < grille.getGrille().length && j-1 >= 0)
                    {
                        if(grille.getGrille()[i+1][j-1].getType() == Case.TypeCase.mine)
                        {
                            nombreMines++;
                        }
                    }
                    if(i+1 < grille.getGrille().length)
                    {
                        if(grille.getGrille()[i+1][j].getType() == Case.TypeCase.mine)
                        {
                            nombreMines++;
                        }
                    }
                    if(i + 1 < grille.getGrille().length && j + 1 < grille.getGrille()[0].length)
                    {
                        if(grille.getGrille()[i+1][j+1].getType() == Case.TypeCase.mine)
                        {
                             nombreMines++;
                        }
                    }
                    if( j + 1 < grille.getGrille()[0].length )
                    {
                        if(grille.getGrille()[i][j+1].getType() == Case.TypeCase.mine)
                        {
                            nombreMines++;
                        }
                    }
                    if(i-1 >= 0 && j+1 < grille.getGrille()[0].length)
                    {
                        if(grille.getGrille()[i-1][j+1].getType() == Case.TypeCase.mine)
                        {
                            nombreMines++;
                        }
                    }
                    if(i - 1 >= 0)
                    {
                        if(grille.getGrille()[i-1][j].getType() == Case.TypeCase.mine)
                        {
                            nombreMines++;
                        }
                    }


                    switch(nombreMines)
                    {
                        case 0 :
                            grille.getGrille()[i][j].setType(Case.TypeCase.rien);
                            break;
                        case 1 :
                            grille.getGrille()[i][j].setType(Case.TypeCase.un);
                            break;
                        case 2 :
                            grille.getGrille()[i][j].setType(Case.TypeCase.deux);
                            break;
                        case 3 :
                            grille.getGrille()[i][j].setType(Case.TypeCase.trois);
                            break;
                        case 4 :
                            grille.getGrille()[i][j].setType(Case.TypeCase.quatre);
                            break;
                        case 5 :
                            grille.getGrille()[i][j].setType(Case.TypeCase.cinq);
                            break;
                        case 6:
                            grille.getGrille()[i][j].setType(Case.TypeCase.six);
                            break;
                        case 7:
                            grille.getGrille()[i][j].setType(Case.TypeCase.sept);
                            break;
                        case 8:
                            grille.getGrille()[i][j].setType(Case.TypeCase.huit);
                            break;
                        default:
                            break;
                    }
                }
            }
        }
    }

}
