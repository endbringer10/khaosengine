package com.khaos.system.core;

/**
 *
 * @author endbr
 */
public enum Errors  {

    //Core
    GENERIC(-1, "An Error has occurred"),
    NO_ERROR(0, "No Errors"),
    FILE_READ(-2, "Error reading file"),
    FILE_WRITE(-3, "Error writing to file"),
    NIMBUS(-100, "An error occured loading nimbus look and feel"),
    TIMED_DISPLAY_FRAME_WAIT_INTTERUPT(-101, "TimedDisplayFrame was intterupted"),
    
    //Game
    THREAD_RUNNING(-1001, "An error occured within a running thread"),
    THREAD_STOP(-1002, "An error occured stopping a thread"),
    SERVER_CONNECTION(-1003, "An error occured while connecting to server");

    private final int code;
    private final String message;

    Errors(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public int getCode() {
        return code;
    }

}//End Class
