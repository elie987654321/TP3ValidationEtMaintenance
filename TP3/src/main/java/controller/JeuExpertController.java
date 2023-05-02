package controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class JeuExpertController extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("Expert");

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/JeuExpert.fxml"));

        Scene scene = new Scene(fxmlLoader.load(), 500, 308);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
