package controller;

public class JeuControllerFactory
{

    public JeuControllerInterface CreateGraphicalController(int difficulte)
    {
        switch(difficulte)
        {
            case 1:
                return new JeuDebutantController();
            case 2:
                return new JeuIntermediaireController();
            case 3:
            default:
                return new JeuExpertController();
        }
    }
}
