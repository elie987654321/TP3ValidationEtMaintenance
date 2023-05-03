package controller;

import javafx.fxml.FXML;
import javafx.stage.Stage;
import javafx.scene.control.MenuItem;


public class JeuIntermediaireGraphicalController {

    @FXML
    public MenuItem debutantMenuItem;

    @FXML
    public MenuItem intermediaireMenuItem;

    @FXML
    public MenuItem expertMenuItem;

    public void handleJeuDebutant() throws Exception {
        Stage stage = (Stage) debutantMenuItem.getParentPopup().getOwnerWindow();
        JeuDebutantController jeuDebutantController = new JeuDebutantController();
        jeuDebutantController.start(stage);
    }

    public void handleJeuIntermediaire() throws Exception {
        Stage stage = (Stage) intermediaireMenuItem.getParentPopup().getOwnerWindow();
        JeuIntermediaireController jeuIntermediaireController = new JeuIntermediaireController();
        jeuIntermediaireController.start(stage);
    }

    public void handleJeuExpert() throws Exception {
        Stage stage = (Stage) expertMenuItem.getParentPopup().getOwnerWindow();
        JeuExpertController expertController = new JeuExpertController();
        expertController.start(stage);
    }

}
