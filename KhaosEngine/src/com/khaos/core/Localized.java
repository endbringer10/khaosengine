package com.khaos.core;

/**
 *
 * @author endbr
 */
public enum Localized {

    KHAOS_ENGINE("Khaos Engine"),
    LOGIN("Login"),
    USERNAME("Username"),
    PASSWORD("Password"),
    EXIT("Exit"),
    DISCARD("Discard"),
    AUTO_LOGIN("Auto Login"),
    LOADING("Loading"),
    UPDATING("Updating"),
    MENU("Menu"),
    SETTINGS("Settings"),
    RESET("Reset"),
    SAVE("Save"),
    ENABLED("Enabled"),
    SELECT("Select"),
    CONSOLE("Console"),
    CHARACTER_SELECT("Character Select");

    private final String english;
    private String localized;

    Localized(String english) {
        this.english = english;
        this.localized = english;
    }

    public String getLocalized() {
        if (Settings.DEBUG.parseBoolean()) {
            return "_" + localized;
        }
        return localized;
    }

    public String getEnglish() {
        return english;
    }

    public void setLocalized(String localized) {
        this.localized = localized;
    }

}//End Class
