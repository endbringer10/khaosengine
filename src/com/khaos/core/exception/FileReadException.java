package com.khaos.core.exception;

/**
 *
 * @author endbr
 */
public class FileReadException extends Exception {

    public FileReadException(String file) {
        super("Could not read file: " + file);
    }
    
}//End Class
