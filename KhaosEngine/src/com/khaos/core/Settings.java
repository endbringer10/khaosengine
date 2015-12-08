package com.khaos.core;

import com.khaos.App;
import com.khaos.core.data.Entry;
import com.khaos.core.file.FileReader;
import com.khaos.core.file.Files;
import com.khaos.core.file.dFile;
import com.khaos.core.system.Errors;
import com.khaos.core.system.SysLog;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author endbringer10
 * @since 20151207
 */
public enum Settings {

    AUTO_LOGIN(false),
    DEBUG(true),
    EXPORTALL(true),
    USERNAME("username"),
    PASSWORD("password"),
    HOST_IP("localhost"),
    HOST_PORT(10101),
    NIMBUS(true),
    SCREEN_WIDTH(800),
    SCREEN_HEIGHT(600);

    private final String defaults;
    private String value;

    Settings(String value) {
        this.defaults = value;
        this.value = value;
    }

    Settings(boolean value) {
        this.defaults = Boolean.toString(value);
        this.value = Boolean.toString(value);
    }

    Settings(int value) {
        this.defaults = Integer.toString(value);
        this.value = Integer.toString(value);
    }

    public static void load() {
        try {
            dFile settings = new dFile(Files.SETTINGS);
            if (settings.exists()) {
                FileReader reader = new FileReader(settings);

                Entry next;
                while ((next = reader.next()) != null) {
                    Settings.valueOf(next.getHeader()).setValue(next.getValue());
                }
            } else {
                save();//remove if there are no settings that get saved even if export all is false
            }
        } catch (IOException ex) {
            SysLog.err(Errors.FILE_READ, ex);
        }

        lookAndFeel();
    }

    public static void save() {
        String toExport = Files.XML_HEADER + Files.NEWLINE;
        toExport += Files.FILE_TAG_SETTINGS + Files.NEWLINE;
        toExport += Settings.AUTO_LOGIN.formatExportCheck();
        toExport += Settings.DEBUG.formatExportCheck();
        toExport += Settings.EXPORTALL.formatExportCheck();
        toExport += Settings.HOST_IP.formatExportCheck();
        toExport += Settings.HOST_PORT.formatExportCheck();
        toExport += Settings.NIMBUS.formatExportCheck();
        toExport += Settings.PASSWORD.formatExportCheck();
        toExport += Settings.USERNAME.formatExportCheck();
        toExport += Settings.SCREEN_HEIGHT.formatExportCheck();
        toExport += Settings.SCREEN_WIDTH.formatExportCheck();
        toExport += Files.FILE_TAG_SETTINGS_CLOSE;

        try {
            dFile settings = new dFile(Files.SETTINGS.getPath());
            FileUtils.writeStringToFile(settings, toExport);
        } catch (IOException ex) {
            SysLog.err(Errors.FILE_WRITE, ex);
        }
    }

    private String formatExportCheck() {
        if (Settings.EXPORTALL.parseBoolean() == true
                || this.value.equalsIgnoreCase(this.defaults) == false) {
            //String toReturn = "\t" + Files.ENTRY_START + Files.NEWLINE;
            //toReturn += "\t\t" + Files.HEADER_START + this.toString() + Files.HEADER_END + Files.NEWLINE;
            //toReturn += "\t\t" + Files.VALUE_START + this.value + Files.VALUE_END + Files.NEWLINE;
            //toReturn += "\t" + Files.ENTRY_END + Files.NEWLINE;
            //return toReturn;
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
        if (Settings.NIMBUS.parseBoolean() == true) {
            try {
                for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                    if ("Nimbus".equals(info.getName())) {
                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
                        break;
                    }
                }
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
                java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

}//End Class
