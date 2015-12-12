package com.khaos.system;

/**
 *
 * @author endbringer10
 * @since 20151207
 */
public enum Files {

    SETTINGS("settings.xml", Folders.CONFIG.getPath()),
    KEYBINDS("keybinds.xml", Folders.CONFIG.getPath()),
    LOGO("logo.png", Folders.RESOURCE_CLASSPATH.getPath());

    public static final String XML_HEADER = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
    public static final String NEWLINE = System.getProperty("line.separator");
    public static final String ENTRY_START = "<entry>";
    public static final String ENTRY_END = "</entry>";
    public static final String HEADER_START = "<meta>";
    public static final String HEADER_END = "</meta>";
    public static final String VALUE_START = "<value>";
    public static final String VALUE_END = "</value>";

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
