package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;

public class JeuIntermediaireGraphicalController {

    private Stage stage;

    @FXML
    private Parent root;

    @FXML
    private JeuExpertController jeuExpertController;
    @FXML
    private MenuItem debutant;

    @FXML
    private MenuItem intermediaire;

    @FXML
    private MenuItem expert;

    @FXML
    private void handleMenuItemDebutant(ActionEvent actionEvent) throws IOException {
        stage.setTitle("Jeu du 21");

        FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("/view/JeuDebutant.fxml"));
        Scene scene = new Scene(fxmlLoader1.load());


    }

    @FXML
    public void handleMenuItemIntermediaire(ActionEvent actionEvent) {

    }

    @FXML
    public void handleMenuItemExpert(ActionEvent actionEvent) throws IOException {
            root = FXMLLoader.load(
                    getClass().getResource("/view/JeuExpert.fxml"));
            stage.getScene().setRoot(root);

    }
}
