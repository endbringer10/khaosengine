package com.khaos.core;

import com.khaos.client.KhaosEngine;

/**
 *
 * @author endbr
 */
public enum Localized {

    KHAOS_ENGINE("Khaos Engine"),
    LOGIN("Login"),
    USERNAME("Username"),
    PASSWORD("Password"),
    CANCEL("Quit"),
    AUTO_LOGIN("Auto Login"),
    LOADING("Loading"),
    UPDATING("Updating");

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
