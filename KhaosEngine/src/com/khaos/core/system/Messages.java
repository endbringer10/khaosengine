package com.khaos.core.system;

/**
 *
 * @author endbr
 * @idea localize this later
 */
public enum Messages {

    DEFAULT("Null message"),
    NO_SETTINGS_FILE("Settings file generated"),
    CONNECTED_TO_SERVER("Connected to server"),
    UNSUPPORTED_PACKET("Unsupported packet found"),
    TEXTURES_LOADED("Textures loaded");

    private final String message;

    Messages(String message) {

        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}//End Class
