import model.Case;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Assertions.*;

import controller.GrilleController;
import model.Grille;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class GrilleControllerTest
{
    public GrilleController grilleController;
    public Grille grille;

    @BeforeAll
    public void InitGrilleController()
    {
        grilleController = new GrilleController();
    }

    @BeforeEach
    public void InitGrille()
    {
        grille = new Grille(20,20);
    }

    @Test
    public void TestPeuplerGrille()
    {
        //Todo copier les autre tests
    }

    @Test
    public void TestAjouterEtatInitialCasesGrilles()
    {
        grilleController.AjouterEtatInitialCasesGrille(grille);

        for(int i = 0 ; i < grille.getLargeur(); i++)
        {
            for(int j = 0; j < grille.getHauteur(); j++)
            {
                Assertions.assertEquals( Case.EtatCase.normal, grille.getGrille()[i][j].getEtat());
            }
        }
    }

    public void TestAjouterMinesGrille()
    {

    }

    public void TestAjouterChiffresGrille()
    {

    }
}

