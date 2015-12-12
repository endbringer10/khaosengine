package com.khaos.system.core;

/**
 *
 * @author endbr
 * @idea localize this later
 */
public enum Messages {

    //Core
    DEFAULT("Null message"),
    //Game
    CONNECTED_TO_SERVER("Connected to server"),
    RUNNING_OFFLINE("Running in offline mode");

    private final String message;

    Messages(String message) {

        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}//End Class
