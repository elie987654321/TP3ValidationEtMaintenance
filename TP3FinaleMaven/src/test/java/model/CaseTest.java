package model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CaseTest {

    //Il n'est pas pertinent de faire des test separer pour les get et les set car ils ne
    // peuvent pas etre tester l'un sans l'autre
    @Test
    public void TestGetSetEtat() {
        //GIVEN
        Case caseTest = new Case();

        //WHEN
        caseTest.setEtat(Case.EtatCase.normal);

        //THEN
        Assertions.assertEquals(Case.EtatCase.normal, caseTest.getEtat());
    }

    @Test
    public void TestGetSetType() {
        //GIVEN
        Case caseTest = new Case();

        //WHEN
        caseTest.setType(Case.TypeCase.un);

        //THEN
        Assertions.assertEquals(Case.TypeCase.un, caseTest.getType());

    }
}