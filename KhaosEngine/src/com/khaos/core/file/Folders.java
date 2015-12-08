package com.khaos.core.file;

import java.io.File;

/**
 *
 * @author endbringer10
 * @since 20151207
 */
public enum Folders {

    USERDATA("userdata");

    private final String name;
    private final String parent;

    Folders(String name) {
        this.name = name + File.separator;
        this.parent = ""; //File.separator;
    }

    Folders(String name, String parent) {
        this.name = name + File.separator;
        this.parent = parent;
    }

    public String getPath() {
        return parent + name;
    }

}//End Class
