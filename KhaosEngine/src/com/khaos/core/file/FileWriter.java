package com.khaos.core.file;

import com.khaos.core.Settings;
import com.khaos.core.system.Errors;
import com.khaos.core.system.SysLog;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author endbr
 */
public class FileWriter {

    private final File file;
    private final String type;
    private String toPrint;

    public FileWriter(FileSystem file, FileTypes type) {
        this.file = new dFile(file.getPath());
        this.type = type.getType();

        toPrint = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + Defaults.NEWLINE;
        toPrint += "<" + this.type + ">" + Defaults.NEWLINE;
    }

    public void cache(Settings setting) {
        toPrint += Defaults.TAB + Defaults.ENTRY_START + Defaults.NEWLINE;
        toPrint += Defaults.TAB + Defaults.TAB + Defaults.META_START + setting.toString() + Defaults.META_END + Defaults.NEWLINE;
        toPrint += Defaults.TAB + Defaults.TAB + Defaults.VALUE_START + setting.parseString() + Defaults.VALUE_END + Defaults.NEWLINE;
        toPrint += Defaults.TAB + Defaults.ENTRY_END + Defaults.NEWLINE;
    }

    public void print() {
        toPrint += "</" + type + ">";
        try {
            FileUtils.writeStringToFile(file, toPrint);
        } catch (IOException ex) {
            SysLog.err(Errors.FILE_WRITE, ex);
        }
    }

}//End Class
