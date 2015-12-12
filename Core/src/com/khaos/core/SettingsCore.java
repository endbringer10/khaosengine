package com.khaos.core;

import com.khaos.core.data.Entry;
import com.khaos.core.file.FileReader;
import com.khaos.system.SysLog;
import com.khaos.system.core.Errors;
import com.khaos.system.core.Files;
import java.io.IOException;

/**
 *
 * @author endbringer10
 * @since 20151207
 * @idea make this to implement SystemSettings interface stub
 */
public enum SettingsCore {

    //Core
    DEBUG(true),
    EXPORTALL(true),
    NIMBUS(true),
    //Game
    AUTO_LOGIN(false),
    USERNAME("username"),
    PASSWORD("password"),
    HOST_IP("localhost"),
    HOST_PORT(10101);
    //SCREEN_WIDTH(800),
    //SCREEN_HEIGHT(600);

    private static final String FILE_TAG = "<Settings>";
    private static final String FILE_TAG_CLOSE = "</Settings>";

    private final String defaults;
    private String value;

    SettingsCore(String value) {
        this.defaults = value;
        this.value = value;
    }

    SettingsCore(boolean value) {
        this.defaults = Boolean.toString(value);
        this.value = Boolean.toString(value);
    }

    SettingsCore(int value) {
        this.defaults = Integer.toString(value);
        this.value = Integer.toString(value);
    }

    public static void load() throws IOException {
        FileReader reader = new FileReader(Files.SETTINGS);

        Entry next;
        while ((next = reader.next()) != null) {
            try {
                SettingsCore.valueOf(next.getHeader()).setValue(next.getValue());
            } catch (IllegalArgumentException ex) {

            }
        }

        SettingsCore.lookAndFeel();
    }

    public static String formatForExport() {
        //Core
        String toExport = FILE_TAG + Files.NEWLINE;
        toExport += SettingsCore.DEBUG.formatExportCheck();
        toExport += SettingsCore.EXPORTALL.formatExportCheck();
        toExport += SettingsCore.NIMBUS.formatExportCheck();

        //Game
        toExport += SettingsCore.HOST_IP.formatExportCheck();
        toExport += SettingsCore.HOST_PORT.formatExportCheck();
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

    private static void lookAndFeel() {
        if (SettingsCore.NIMBUS.parseBoolean() == true) {
            try {
                for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                    if ("Nimbus".equals(info.getName())) {
                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
                        break;
                    }
                }
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
                SysLog.err(Errors.NIMBUS, ex);
            }
        }
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

    public void setValue(boolean value) {
        this.value = Boolean.toString(value);
    }

    public void setValue(int value) {
        this.value = Integer.toString(value);
    }

    public void clear() {
        this.value = "";
    }

}//End Class
