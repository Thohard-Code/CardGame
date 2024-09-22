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

        // Set the selected item based on the current global resolution
        String currentResolution = Settings.getInstance().getResolution();
        menuSizeChoiceBox.getSelectionModel().select(currentResolution);

        // Apply the resolution when the user selects a new one
        menuSizeChoiceBox.getSelectionModel().selectedItemProperty().addListener((obs, oldValue, newValue) -> {
            Settings.getInstance().setResolution(newValue);
            applyResolution(newValue);
        });
    }

    private void applyResolution(String resolution) {
        Stage stage = (Stage) soundSlider.getScene().getWindow();
        switch (resolution) {
            case "Fullscreen (1920x1080)":
                stage.setWidth(1920);
                stage.setHeight(1080);
                stage.setFullScreen(false);  // This stays as per your previous setup
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

    @FXML
    protected void onMainMenuButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Menu.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = getStage();
        // Apply the globally selected resolution
        applyResolution(Settings.getInstance().getResolution());
        stage.setScene(scene);
        stage.setTitle("CardGame");
    }

    private Stage getStage() {
        return (Stage) soundSlider.getScene().getWindow();
    }
}
