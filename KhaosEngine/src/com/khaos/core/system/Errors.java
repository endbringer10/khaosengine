package com.khaos.core.system;

/**
 *
 * @author endbr
 */
public enum Errors {

    GENERIC(-1, "An Error has occurred"),
    NO_ERROR(0, "No Errors"),
    FILE_READ(-2, "Error reading file");

    //NIMBUS(-2, "An error occured loading nimbus look and feel"),
    //ENUM_DOES_NOT_EXIST(-1000, "The Enum.valueOf(String) for the value you specified does not exist"),
    //THREAD_RUNNING(-1001, "An error occured within a running thread"),
    //THREAD_STOP(-1002, "An error occured stopping a thread"),
    //SERVER_CONNECTION(-1003, "An error occured while connecting to server"),
    //FILE_WRITE(-1004, "An error occured while writing to a file"),
    //SPLASH_INTERRUPT(-1005, "Splash screen was interrupted"),
    //IMAGE_LOAD(-1006, "Error loading image"),
    //NULL_IMAGE(-1007, "Image was not found"),
    //INTERNALFRAME_SELECTED(-1008, "Error selecting internalframe");
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
