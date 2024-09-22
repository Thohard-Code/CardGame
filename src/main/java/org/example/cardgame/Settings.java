package org.example.cardgame;

public class Settings {
    private static Settings instance;
    private String resolution;

    private Settings() {
        // Default settings
        this.resolution = "Standard (1280x720)";
    }

    public static Settings getInstance() {
        if (instance == null) {
            instance = new Settings();
        }
        return instance;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }
}
