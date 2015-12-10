package com.khaos.system.core;

import com.khaos.system.IMessages;

/**
 *
 * @author endbr
 * @idea localize this later
 */
public enum Messages implements IMessages {

    DEFAULT("Null message");
    //NO_SETTINGS_FILE("Settings file generated"),
    //NO_KEYBINDS_FILE("Keybinds file generated"),
    //CONNECTED_TO_SERVER("Connected to server");
    //UNSUPPORTED_PACKET("Unsupported packet found"),
    //TEXTURES_LOADED("Textures loaded");

    private final String message;

    Messages(String message) {

        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

}//End Class
