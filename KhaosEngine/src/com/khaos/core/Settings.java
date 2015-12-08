package com.khaos.core;

import com.khaos.core.data.Entry;
import com.khaos.core.file.FileReader;
import com.khaos.core.file.Files;
import com.khaos.core.file.dFile;
import com.khaos.core.system.Errors;
import com.khaos.core.system.SysLog;
import java.io.IOException;

/**
 *
 * @author endbringer10
 * @since 20151207
 */
public enum Settings {

    AUTO_LOGIN(false),
    DEBUG(true),
    EXPORTALL(false),
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

                }
            } else {
                save();//remove if there are no settings that get saved even if export all is false
            }
        } catch (IOException ex) {
            SysLog.err(Errors.FILE_READ, ex);
        }
    }

    public static void save() {
        //check for export all
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

}//End Class
