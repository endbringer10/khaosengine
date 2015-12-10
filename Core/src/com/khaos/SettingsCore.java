package com.khaos;

import com.khaos.core.Entry;
import com.khaos.core.FileReader;
import com.khaos.core.dFile;
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

    DEBUG(true),
    EXPORTALL(true),
    NIMBUS(true);

    private static final String FILE_TAG = "<Core>";
    private static final String FILE_TAG_CLOSE = "</Core>";

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
        FileReader reader = new FileReader(new dFile(Files.SETTINGS));

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
        String toExport = FILE_TAG + Files.NEWLINE;
        toExport += SettingsCore.DEBUG.formatExportCheck();
        toExport += SettingsCore.EXPORTALL.formatExportCheck();
        toExport += SettingsCore.NIMBUS.formatExportCheck();
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

}//End Class
