package model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class GrilleTest {

    @Test
    void TestGetNbCaseRestante() {
        //GIVEN
        Grille grille = new Grille(2,2);

        //WHEN
        grille.getGrille()[0][0].setEtat(Case.EtatCase.revele);
        grille.getGrille()[0][1].setEtat(Case.EtatCase.drapeau);
        grille.getGrille()[1][0].setEtat(Case.EtatCase.normal);
        grille.getGrille()[1][1].setEtat(Case.EtatCase.interrogation);

        //THEN
        Assertions.assertEquals(3, grille.getNbCaseRestante());
    }

    @Test
    void TestGetNbBombes() {
        //GIVEN
        Grille grille = new Grille(2,2);

        //WHEN
        grille.getGrille()[0][0].setType(Case.TypeCase.mine);
        grille.getGrille()[0][1].setType(Case.TypeCase.mine);
        grille.getGrille()[1][0].setType(Case.TypeCase.rien);
        grille.getGrille()[1][1].setType(Case.TypeCase.rien);

        //THEN
        Assertions.assertEquals(2, grille.getNbBombes());
    }

    @Test
    void TestGetLargeur() {
        //GIVEN
        Grille grille = new Grille(2,3);

        //WHEN

        //THEN
        Assertions.assertEquals(2,grille.getLargeur());

    }


    @Test
    void TestGetHauteur() {
        //GIVEN
        Grille grille = new Grille(2,3);

        //WHEN

        //THEN
        Assertions.assertEquals(3,grille.getHauteur());

    }

    @Test
    void TestGetGrille() {
        //GIVEN
        Grille grille = new Grille(3,3);
        Case caseTest;

        //WHEN

        //THEN
        //Fait echouer le test si l'indice n'existe pas
        try{
            caseTest = grille.getGrille()[2][2];
        }
        catch(Exception e)
        {
            Assertions.fail();
        }
    }
}