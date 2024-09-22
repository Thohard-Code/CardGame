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
        Scene scene = new Scene(fxmlLoader.load());
        applyResolution(Settings.getInstance().getResolution());
        Stage stage = getStage();
        stage.setScene(scene);
        stage.setTitle("Options");
    }

    // Called when the "Exit" button is clicked
    @FXML
    protected void onExitButtonClick() {
        System.exit(0);
    }

    private void applyResolution(String resolution) {
        Stage stage = (Stage) welcomeText.getScene().getWindow();
        switch (resolution) {
            case "Fullscreen (1920x1080)":
                stage.setWidth(1920);
                stage.setHeight(1080);
                stage.setFullScreen(false);
                break;
            case "Standard (1280x720)":
                stage.setWidth(1280);
                stage.setHeight(720);
                stage.setFullScreen(false);
                break;
            case "Small (960x540)":
                stage.setWidth(960);
                stage.setHeight(540);
                stage.setFullScreen(false);
                break;
        }
        stage.centerOnScreen();
    }
}