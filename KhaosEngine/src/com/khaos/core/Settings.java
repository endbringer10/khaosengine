package com.khaos.core;

import com.khaos.core.data.UniqueArray;
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
import unusued.SettingValue;

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

    private static UniqueArray<SettingValue> list = new UniqueArray<>();

    private final String def;

    Settings(String def) {
        this.def = def;
    }

    Settings(boolean def) {
        this.def = Boolean.toString(def);
    }

    Settings(int def) {
        this.def = Integer.toString(def);
    }

    public static void load() {
        dFile file = FileSystem.FILE_USER_SETTINGS.getFile();
        try {
            SettingBuilder builder = new SettingBuilder(file);

            SettingEntry next;
            while ((next = builder.next()) != null) {
                try {
                    Settings.valueOf(next.getMeta());
                    list.add(new SettingValue(Settings.valueOf(next.getMeta()), next.getValue()));
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
        int index = list.indexOf(this.toString());
        if (index != -1) {
            list.get(index).setValue(value);
        }
    }

    public void setValue(boolean value) {
        int index = list.indexOf(this.toString());
        if (index != -1) {
            list.get(index).setValue(value);
        }
    }

    public void setValue(int value) {
        int index = list.indexOf(this.toString());
        if (index != -1) {
            list.get(index).setValue(value);
        }
    }

    public String parseString() {
        int index = list.indexOf(this.toString());
        if (index != -1) {
            return list.get(index).parseString();
        }

        return def;
    }

    public boolean parseBoolean() {
        int index = list.indexOf(this.toString());
        if (index != -1) {
            return list.get(index).parseBoolean();
        }

        return Boolean.parseBoolean(def);
    }

    public int parseInteger() {
        int index = list.indexOf(this.toString());
        if (index != -1) {
            return list.get(index).parseInteger();
        }

        return Integer.parseInt(def);
    }

    public void clear() {
        int index = list.indexOf(this.toString());
        if (index != -1) {
            list.get(index).clear();
        }
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
