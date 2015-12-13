package com.khaos.engine;

import com.khaos.core.file.dFile;
import com.khaos.core.interfaces.Connection;
import com.khaos.core.interfaces.ConnectionHook;
import com.khaos.system.Errors;
import com.khaos.system.Files;
import com.khaos.system.SysLog;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import zom.core.KeyBinds;
import zom.core.Settings;

/**
 *
 * @author endbringer10
 * @since 20151208
 */
public abstract class Manager {

    public static Connection open(ConnectionHook engine) {
        try {
            return new OnlineConnection(engine);
        } catch (IOException ex) {
            return new OfflineConnection(engine);
        }
    }

    public static void loadSettings() {
        try {
            Settings.load();

        } catch (IOException ex) {
            Manager.generate();
        }
        KeyBinds.load();
    }

    private static void generate() {
        String toExport = Files.XML_HEADER + Files.NEWLINE;
        toExport += Settings.formatForExport();

        try {
            FileUtils.writeStringToFile(new dFile(Files.SETTINGS.getPath()), toExport);
        } catch (IOException ex) {
            SysLog.err(Errors.FILE_WRITE, ex);
        }
    }

    public static void saveSettings() {
        Manager.generate();
        KeyBinds.save();
    }

}//End Class
