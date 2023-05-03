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

    }

    public void TestAjouterChiffresGrille()
    {

    }
}

