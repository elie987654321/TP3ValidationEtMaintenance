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
        grilleController.AjouterEtatEtTypeInitialCasesGrille(grille);

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
        //m2mm1xx  0
        //xxxxxxx  1
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
        Grille grille = new Grille(7,12);

        //WHEN
        grille.getGrille()[0][0].setType(Case.TypeCase.mine);
        grille.getGrille()[2][0].setType(Case.TypeCase.mine);
        grille.getGrille()[3][0].setType(Case.TypeCase.mine);
        grille.getGrille()[0][2].setType(Case.TypeCase.mine);
        grille.getGrille()[1][2].setType(Case.TypeCase.mine);
        grille.getGrille()[2][2].setType(Case.TypeCase.mine);
        grille.getGrille()[4][2].setType(Case.TypeCase.mine);
        grille.getGrille()[4][4].setType(Case.TypeCase.mine);
        grille.getGrille()[5][2].setType(Case.TypeCase.mine);
        grille.getGrille()[6][2].setType(Case.TypeCase.mine);
        grille.getGrille()[0][6].setType(Case.TypeCase.mine);
        grille.getGrille()[1][6].setType(Case.TypeCase.mine);
        grille.getGrille()[2][6].setType(Case.TypeCase.mine);
        grille.getGrille()[4][6].setType(Case.TypeCase.mine);
        grille.getGrille()[5][6].setType(Case.TypeCase.mine);
        grille.getGrille()[5][6].setType(Case.TypeCase.mine);
        grille.getGrille()[6][6].setType(Case.TypeCase.mine);
        grille.getGrille()[0][7].setType(Case.TypeCase.mine);
        grille.getGrille()[2][7].setType(Case.TypeCase.mine);
        grille.getGrille()[4][7].setType(Case.TypeCase.mine);
        grille.getGrille()[6][7].setType(Case.TypeCase.mine);
        grille.getGrille()[4][8].setType(Case.TypeCase.mine);
        grille.getGrille()[0][9].setType(Case.TypeCase.mine);
        grille.getGrille()[1][9].setType(Case.TypeCase.mine);
        grille.getGrille()[2][9].setType(Case.TypeCase.mine);
        grille.getGrille()[4][9].setType(Case.TypeCase.mine);
        grille.getGrille()[5][9].setType(Case.TypeCase.mine);
        grille.getGrille()[6][9].setType(Case.TypeCase.mine);
        grille.getGrille()[0][10].setType(Case.TypeCase.mine);
        grille.getGrille()[2][10].setType(Case.TypeCase.mine);
        grille.getGrille()[4][10].setType(Case.TypeCase.mine);
        grille.getGrille()[6][10].setType(Case.TypeCase.mine);
        grille.getGrille()[0][11].setType(Case.TypeCase.mine);
        grille.getGrille()[1][11].setType(Case.TypeCase.mine);
        grille.getGrille()[4][11].setType(Case.TypeCase.mine);
        grille.getGrille()[5][11].setType(Case.TypeCase.mine);
        grille.getGrille()[6][11].setType(Case.TypeCase.mine);

        grilleController.AjouterChiffresGrille(grille);

        //THEN
        Assertions.assertEquals(Case.TypeCase.un ,grille.getGrille()[4][0].getType());
        Assertions.assertEquals(Case.TypeCase.deux ,grille.getGrille()[1][0].getType());
        Assertions.assertEquals(Case.TypeCase.trois ,grille.getGrille()[1][3].getType());
        Assertions.assertEquals(Case.TypeCase.quatre ,grille.getGrille()[5][3].getType());
        Assertions.assertEquals(Case.TypeCase.cinq ,grille.getGrille()[1][7].getType());
        Assertions.assertEquals(Case.TypeCase.six ,grille.getGrille()[5][7].getType());
        Assertions.assertEquals(Case.TypeCase.sept ,grille.getGrille()[1][10].getType());
        Assertions.assertEquals(Case.TypeCase.huit ,grille.getGrille()[5][10].getType());


    }
}

