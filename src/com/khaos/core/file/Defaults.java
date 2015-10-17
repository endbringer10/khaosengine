package com.khaos.core.file;

/**
 *
 * @author endbr
 */
public interface Defaults {

    public static final String SEPARATOR = System.getProperty("file.separator");
    public static final String NEWLINE = System.getProperty("line.separator");
    public static final String TAB = "\t";

    public static final String ENTRY_START = "<entry>";
    public static final String ENTRY_END = "</entry>";
    public static final String META_START = "<meta>";
    public static final String META_END = "</meta>";
    public static final String VALUE_START = "<value>";
    public static final String VALUE_END = "</value>";

    public static final String FOLDER_USERDATA = "userdata" + SEPARATOR;
    public static final String FOLDER_CONFIG = "config" + SEPARATOR;
    public static final String FOLDER_DATA = "data" + SEPARATOR;
    public static final String FOLDER_DOWNLOADS = "downloads" + SEPARATOR;
    public static final String FOLDER_TEXTURES = "textures" + SEPARATOR;
    public static final String FOLDER_MODS = "mods" + SEPARATOR;

    public static final String FILE_CONFIG = "settings.xml";
    public static final String FILE_LOGO = "logo.png";

}
