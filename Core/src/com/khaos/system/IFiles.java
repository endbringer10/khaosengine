package com.khaos.system;

/**
 *
 * @author endbringer10
 * @since 20151209
 */
public interface IFiles {
    
    public static final String XML_HEADER = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
    public static final String NEWLINE = System.getProperty("line.separator");
    public static final String FILE_TAG_SETTINGS = "<settings>";
    public static final String FILE_TAG_SETTINGS_CLOSE = "</settings>";

    public String getPath();

}//End Class
