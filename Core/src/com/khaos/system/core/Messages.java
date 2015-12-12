package com.khaos.system.core;

import com.khaos.system.IMessages;

/**
 *
 * @author endbr
 * @idea localize this later
 */
public enum Messages implements IMessages {

    //Core
    DEFAULT("Null message"),
    //Game
    CONNECTED_TO_SERVER("Connected to server"),
    RUNNING_OFFLINE("Running in offline mode");

    private final String message;

    Messages(String message) {

        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

}//End Class
