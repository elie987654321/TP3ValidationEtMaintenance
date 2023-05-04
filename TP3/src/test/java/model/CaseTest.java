package model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class CaseTest {

    @Test
    void getEtat()
    {
        //GIVEN
        Case caseTest = new Case();

        //WHEN
        caseTest.setEtat(Case.EtatCase.normal);

        //THEN
        Assertions.assertEquals(Case.EtatCase.normal,caseTest.getEtat());
    }

    @Test
    void setEtat()
    {
        //GIVEN
        Case caseTest = new Case();

        //WHEN
        caseTest.setEtat(Case.EtatCase.normal);

        //THEN
        Assertions.assertEquals(Case.EtatCase.normal,caseTest.getEtat());
    }

    @Test
    void getType()
    {
        //GIVEN
        Case caseTest = new Case();

        //WHEN
        caseTest.setType(Case.TypeCase.mine);

        //THEN
        Assertions.assertEquals(Case.TypeCase.mine,caseTest.getType());

    }

    @Test
    void setType()
    {
        //GIVEN
        Case caseTest = new Case();

        //WHEN
        caseTest.setType(Case.TypeCase.mine);

        //THEN
        Assertions.assertEquals(Case.TypeCase.mine, caseTest.getType());
    }
}