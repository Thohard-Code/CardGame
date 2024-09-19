package org.example.cardgame;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.stage.Stage;

import java.io.IOException;

public class OptionsController {

    @FXML
    private Label welcomeText;

    private Stage getStage() {
        return (Stage) welcomeText.getScene().getWindow();
    }

    @FXML
    private Slider soundSlider;

    @FXML
    private Slider musicSlider;

    @FXML
    private Label soundVolumeLabel;

    @FXML
    private Label musicVolumeLabel;

    @FXML
    private ChoiceBox<String> graphicsChoiceBox;

    @FXML
    private ChoiceBox<String> menuSizeChoiceBox;

    @FXML
    public void initialize() {
        soundVolumeLabel.textProperty().bind(soundSlider.valueProperty().asString("%.0f%%"));
        musicVolumeLabel.textProperty().bind(musicSlider.valueProperty().asString("%.0f%%"));


        graphicsChoiceBox.getSelectionModel().selectFirst();
        menuSizeChoiceBox.getSelectionModel().select(1); // Default to Standard (1280x720)


        menuSizeChoiceBox.getSelectionModel().selectedItemProperty().addListener((obs, oldValue, newValue) -> {
            applyResolution(newValue);
        });
    }

    private void applyResolution(String resolution) {
        Stage stage = (Stage) soundSlider.getScene().getWindow();
        switch (resolution) {
            case "Fullscreen (1920x1080)":
                stage.setWidth(1920);
                stage.setHeight(1080);
                stage.setFullScreen(true);
                stage.centerOnScreen();
                break;
            case "Standard (1280x720)":
                stage.setWidth(1280);
                stage.setHeight(720);
                stage.setFullScreen(false);
                stage.centerOnScreen();
                break;
            case "Small (960x540)":
                stage.setWidth(960);
                stage.setHeight(540);
                stage.setFullScreen(false);
                stage.centerOnScreen();
                break;
            default:
                // Default case
                break;
        }
    }

    @FXML
    protected void onMainMenuButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Menu.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
        Stage stage = getStage();
        stage.setScene(scene);
        stage.setTitle("CardGame");
    }
}
