package org.example.cardgame;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuController {

    @FXML
    private Label welcomeText;

    private Stage getStage() {
        return (Stage) welcomeText.getScene().getWindow();
    }

    // Called when the "Start Game" button is clicked
    @FXML
    protected void onStartButtonClick() {
        welcomeText.setText("Start Game button clicked!");
    }

    // Called when the "Options" button is clicked
    @FXML
    protected void onOptionsButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Options.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
        Stage stage = getStage();
        stage.setScene(scene);
        stage.setTitle("Options");
    }

    // Called when the "Exit" button is clicked
    @FXML
    protected void onExitButtonClick() {
        System.exit(0);
    }
}