package model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GrilleTest {

    @Test
    void getNbCaseRestante() {
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
    void getNbBombes() {
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
    void getLargeur() {
        //GIVEN
        Grille grille = new Grille(2,3);

        //WHEN

        //THEN
        Assertions.assertEquals(2,grille.getLargeur());

    }


    @Test
    void getHauteur() {
        //GIVEN
        Grille grille = new Grille(2,3);

        //WHEN

        //THEN
        Assertions.assertEquals(3,grille.getHauteur());

    }

    @Test
    void getGrille() {
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