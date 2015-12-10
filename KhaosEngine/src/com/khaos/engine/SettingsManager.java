package com.khaos.engine;

import com.khaos.SettingsCore;
import com.khaos.SettingsGame;
import com.khaos.core.dFile;
import com.khaos.system.SysLog;
import com.khaos.system.core.Errors;
import com.khaos.system.core.Files;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author endbringer10
 * @since 20151209
 */
public abstract class SettingsManager {

    public static void load() {
        try {
            SettingsCore.load();
            SettingsGame.load();
        } catch (IOException ex) {
            SettingsManager.generate();
        }
    }

    private static void generate() {
        String toExport = Files.XML_HEADER + Files.NEWLINE;
        toExport += SettingsCore.formatForExport();
        toExport += SettingsGame.formatForExport();

        try {
            FileUtils.writeStringToFile(new dFile(Files.SETTINGS.getPath()), toExport);
        } catch (IOException ex) {
            SysLog.err(Errors.FILE_WRITE, ex);
        }
    }

    public static void save() {
        SettingsManager.generate();
    }

}//End Class
