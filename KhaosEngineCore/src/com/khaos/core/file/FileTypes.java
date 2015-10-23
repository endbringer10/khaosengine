package com.khaos.core.file;

/**
 *
 * @author endbr
 */
public enum FileTypes {

    SETTINGS("settings"),
    MATERIAL("material");

    private final String type;

    FileTypes(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

}//End Class
