package com.khaos;

import com.khaos.core.Entry;
import com.khaos.core.FileReader;
import com.khaos.core.dFile;
import com.khaos.system.core.Files;
import java.io.IOException;

/**
 *
 * @author endbringer10
 * @since 20151207
 * @idea make this to implement SystemSettings interface stub
 */
public enum SettingsGame {

    //AUTO_LOGIN(false),
    //USERNAME("username"),
    //PASSWORD("password"),
    HOST_IP("localhost"),
    HOST_PORT(10101);
    //SCREEN_WIDTH(800),
    //SCREEN_HEIGHT(600);

    private static final String FILE_TAG = "<Game>";
    private static final String FILE_TAG_CLOSE = "</Game>";

    private final String defaults;
    private String value;

    SettingsGame(String value) {
        this.defaults = value;
        this.value = value;
    }

    SettingsGame(boolean value) {
        this.defaults = Boolean.toString(value);
        this.value = Boolean.toString(value);
    }

    SettingsGame(int value) {
        this.defaults = Integer.toString(value);
        this.value = Integer.toString(value);
    }

    public static void load() throws IOException {
        FileReader reader = new FileReader(new dFile(Files.SETTINGS));

        Entry next;
        while ((next = reader.next()) != null) {
            try {
                SettingsGame.valueOf(next.getHeader()).setValue(next.getValue());
            } catch (IllegalArgumentException ex) {

            }
        }
    }

    public static String formatForExport() {
        String toExport = FILE_TAG + Files.NEWLINE;
        //toExport += SettingsGame.AUTO_LOGIN.formatExportCheck();
        toExport += SettingsGame.HOST_IP.formatExportCheck();
        toExport += SettingsGame.HOST_PORT.formatExportCheck();
        //toExport += SettingsGame.PASSWORD.formatExportCheck();
        //toExport += SettingsGame.USERNAME.formatExportCheck();
        //toExport += SettingsGame.SCREEN_HEIGHT.formatExportCheck();
        //toExport += SettingsGame.SCREEN_WIDTH.formatExportCheck();
        toExport += FILE_TAG_CLOSE;
        
        return toExport;
    }

    private String formatExportCheck() {
        if (SettingsCore.EXPORTALL.parseBoolean() == true
                || this.value.equalsIgnoreCase(this.defaults) == false) {
            return this.formatExport();
        }

        return "";
    }

    private String formatExport() {
        String toReturn = "\t" + Files.ENTRY_START + Files.NEWLINE;
        toReturn += "\t\t" + Files.HEADER_START + this.toString() + Files.HEADER_END + Files.NEWLINE;
        toReturn += "\t\t" + Files.VALUE_START + this.value + Files.VALUE_END + Files.NEWLINE;
        toReturn += "\t" + Files.ENTRY_END + Files.NEWLINE;
        return toReturn;
    }

    public String parseString() {
        return value;
    }

    public boolean parseBoolean() {
        return Boolean.parseBoolean(value);
    }

    public int parseInteger() {
        return Integer.parseInt(value);
    }

    public void setValue(String value) {
        this.value = value;
    }

}//End Class
