package com.khaos.core;

import com.khaos.core.data.entry.SettingEntry;
import com.khaos.core.file.FileSystem;
import com.khaos.core.file.FileTypes;
import com.khaos.core.file.FileWriter;
import com.khaos.core.file.builder.SettingBuilder;
import com.khaos.core.file.dFile;
import com.khaos.core.system.Errors;
import com.khaos.core.system.Messages;
import com.khaos.core.system.SysLog;
import java.io.IOException;

/**
 *
 * @author endbringer10
 * @since 20151024
 */
public enum Settings {

    AUTO_LOGIN(false),
    DEBUG(true),
    USERNAME("null"),
    PASSWORD("null"),
    HOST_IP("localhost"),
    HOST_PORT(10101),
    NIMBUS(true),
    SCREEN_WIDTH(800),
    SCREEN_HEIGHT(600);

    private String value;

    Settings(String value) {
        this.value = value;
    }

    Settings(boolean value) {
        this.value = Boolean.toString(value);
    }

    Settings(int value) {
        this.value = Integer.toString(value);
    }

    public static void load() {
        dFile file = FileSystem.FILE_USER_SETTINGS.getFile();
        try {
            SettingBuilder builder = new SettingBuilder(file);

            SettingEntry next;
            while ((next = builder.next()) != null) {
                try {
                    Settings.valueOf(next.getMeta()).setValue(next.getValue());
                } catch (IllegalArgumentException ex) {
                    SysLog.err(Errors.ENUM_DOES_NOT_EXIST, ex);
                }
            }
        } catch (IOException ex) {
            SysLog.log(Messages.NO_SETTINGS_FILE);
            Settings.generate();
        }

        Settings.lookAndFeel();
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

    public String parseString() {
        return value;
    }

    public boolean parseBoolean() {
        return Boolean.parseBoolean(value);
    }

    public int parseInteger() {
        return Integer.parseInt(value);
    }

    public void clear() {
        this.value = "null";
    }

    public static void save() {
        Settings.generate();
    }

    private static void generate() {
        FileWriter writer = new FileWriter(FileSystem.FILE_USER_SETTINGS, FileTypes.SETTINGS);
        writer.cache(DEBUG);
        writer.cache(HOST_IP);
        writer.cache(HOST_PORT);
        writer.cache(AUTO_LOGIN);
        writer.cache(NIMBUS);
        writer.print();
    }

    private static void lookAndFeel() {
        /* Set the Nimbus look and feel 
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        if (NIMBUS.parseBoolean()) {
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

}//End Class
