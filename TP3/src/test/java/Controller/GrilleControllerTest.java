package Controller;

import model.Case;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Assertions.*;

import controller.GrilleController;
import model.Grille;

public class GrilleControllerTest
{
    @Test
    public void TestPeuplerGrille()
    {
        //Todo copier les autre tests
    }

    @Test
    public void TestAjouterEtatInitialCasesGrilles()
    {
        //GIVEN
        GrilleController grilleController = new GrilleController();
        Grille grille = new Grille(20,20);

        //WHEN
        grilleController.AjouterEtatInitialCasesGrille(grille);

        //THEN
        for(int i = 0 ; i < grille.getLargeur(); i++)
        {
            for(int j = 0; j < grille.getHauteur(); j++)
            {
                Assertions.assertEquals( Case.EtatCase.normal, grille.getGrille()[i][j].getEtat());
            }
        }
    }

    @Test
    public void TestAjouterMinesGrille()
    {
        //GIVEN
        GrilleController grilleController = new GrilleController();
        Grille grille = new Grille(20,20);

        //WHEN
        grilleController.AjouterMinesGrille(grille, 10);

        //THEN
        //Test manuel pour plus de fiabilite
        int nbBombeCalcul = 0;
        for(int i = 0; i < grille.getLargeur(); i++)
        {
            for(int j = 0; j < grille.getHauteur(); j++)
            {
                if(grille.getGrille()[i][j].getType() == Case.TypeCase.mine)
                    nbBombeCalcul++;
            }
        }

        Assertions.assertEquals(10, nbBombeCalcul);
    }

    @Test
    public void TestAjouterChiffresGrille()
    {
        //Position des mines a ajouter et des chiffres a tester
        //0123456
        //mxmmxxx  0
        //1x2xxxx  1
        //mmmxmmm  2
        //x3xxx4x  3
        //xxxxmxx  4
        //xxxxxxx  5
        //mmmxmmm  6
        //m5mxm6m  7
        //xxxxmxx  8
        //mmmxmmm  9
        //m7mxm8m  10
        //mmxxmmm  11
        //0123456

        //GIVEN
        GrilleController grilleController = new GrilleController();
        Grille grille = new Grille(6,11);
/*
        //WHEN
        grille.getGrille()[0][0].setType(Case.TypeCase.mine);
        grille.getGrille()[2][0].setType(Case.TypeCase.mine);
        grille.getGrille()[3][0].setType(Case.TypeCase.mine);
        grille.getGrille()[0][2].setType(Case.TypeCase.mine);
        grille.getGrille()[1][2].setType(Case.TypeCase.mine);
        grille.getGrille()[2][2].setType(Case.TypeCase.mine);
        grille.getGrille()[4][2].setType(Case.TypeCase.mine);
        grille.getGrille()[5][2].setType(Case.TypeCase.mine);
        grille.getGrille()[0][0].setType(Case.TypeCase.mine);
        grille.getGrille()[0][0].setType(Case.TypeCase.mine);
        grille.getGrille()[0][0].setType(Case.TypeCase.mine);
        grille.getGrille()[0][0].setType(Case.TypeCase.mine);
        grille.getGrille()[0][0].setType(Case.TypeCase.mine);
        grille.getGrille()[0][0].setType(Case.TypeCase.mine);
        grille.getGrille()[0][0].setType(Case.TypeCase.mine);
        grille.getGrille()[0][0].setType(Case.TypeCase.mine);
        grille.getGrille()[0][0].setType(Case.TypeCase.mine);
        grille.getGrille()[0][0].setType(Case.TypeCase.mine);
        grille.getGrille()[0][0].setType(Case.TypeCase.mine);
*/

        //

    }
}

