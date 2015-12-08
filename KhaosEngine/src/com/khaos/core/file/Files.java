package com.khaos.core.file;

/**
 *
 * @author endbringer10
 * @since 20151207
 */
public enum Files {

    SETTINGS("settings.xml", Folders.USERDATA.getPath());

    private final String name;
    private final String directory;

    Files(String name, String directory) {
        this.name = name;
        this.directory = directory;
    }

    public String getPath() {
        return directory + name;
    }

}//End Class
