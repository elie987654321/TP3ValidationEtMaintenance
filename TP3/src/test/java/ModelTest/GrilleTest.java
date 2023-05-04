package ModelTest;

import controller.GrilleController;
import model.Case;
import model.Grille;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GrilleTest {

    @Test
    void getNbCaseRestante()
    {
        //GIVEN
        GrilleController grilleController = new GrilleController();
        Grille grille = new Grille(3,3);

        //WHEN
        grilleController.AjouterEtatEtTypeInitialCasesGrille(grille);
        grille.getGrille()[0][0].setEtat(Case.EtatCase.normal);

        //THEN
        Assertions.assertEquals(8,grille.getNbCaseRestante());
    }

    @Test
    void getNbBombes()
    {

    }

    @Test
    void getLargeur()
    {

    }

    @Test
    void setLargeur()
    {

    }

    @Test
    void getHauteur()
    {

    }

    @Test
    void setHauteur()
    {

    }

    @Test
    void getGrille()
    {

    }

    @Test
    void setGrille()
    {

    }
}