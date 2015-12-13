package com.khaos.system;

import java.io.File;

/**
 *
 * @author endbringer10
 * @since 20151207
 */
public enum Folders {

    USERDATA("userdata"),
    CONFIG(USERDATA.getPath() + "config"),
    RESOURCE_CLASSPATH("resources/");

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
