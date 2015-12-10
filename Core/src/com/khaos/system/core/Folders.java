package com.khaos.system.core;

import com.khaos.system.IFolders;
import java.io.File;

/**
 *
 * @author endbringer10
 * @since 20151207
 */
public enum Folders implements IFolders {

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

    @Override
    public String getPath() {
        return parent + name;
    }

}//End Class
