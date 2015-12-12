package com.khaos.engine;

import com.khaos.core.SettingsCore;
import com.khaos.core.file.dFile;
import com.khaos.core.interfaces.EngineHook;
import com.khaos.core.interfaces.ConnectionHook;
import com.khaos.system.SysLog;
import com.khaos.system.core.Errors;
import com.khaos.system.core.Files;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author endbringer10
 * @since 20151208
 */
public abstract class Manager {

    public static ConnectionHook open(EngineHook engine) {
        try {
            return new OnlineConnection(engine);
        } catch (IOException ex) {
            return new OfflineConnection(engine);
        }
    }

    public static void load() {
        try {
            SettingsCore.load();
        } catch (IOException ex) {
            Manager.generate();
        }
    }

    private static void generate() {
        String toExport = Files.XML_HEADER + Files.NEWLINE;
        toExport += SettingsCore.formatForExport();

        try {
            FileUtils.writeStringToFile(new dFile(Files.SETTINGS.getPath()), toExport);
        } catch (IOException ex) {
            SysLog.err(Errors.FILE_WRITE, ex);
        }
    }

    public static void save() {
        Manager.generate();
    }

}//End Class
