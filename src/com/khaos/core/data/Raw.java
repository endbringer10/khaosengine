package com.khaos.core.data;

import com.khaos.core.file.Defaults;
import com.khaos.core.file.dFile;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author endbr
 */
public class Raw {

    private final String raw;
    private int caret = 0;

    public Raw(dFile path) throws IOException {
        raw = FileUtils.readFileToString(path);
    }

    public Entry next() {
        String entry = this.entry();
        if (entry != null) {
            String header = this.header(entry);
            String value = this.value(entry);
            if (header != null && value != null) {
                return new Entry(header, value);
            }
        }

        return null;
    }

    private String entry() {
        int start = raw.indexOf(Defaults.ENTRY_START, caret);
        int end = raw.indexOf(Defaults.ENTRY_END, caret);

        if (start != -1 && end != -1) {
            caret = end + Defaults.ENTRY_END.length();
            return raw.substring(start, end);
        }

        caret = raw.length();
        return null;
    }

    private String value(String entry) {
        int start = entry.indexOf(Defaults.VALUE_START) + Defaults.VALUE_START.length();
        int end = entry.indexOf(Defaults.VALUE_END);
        if (start != -1 && end != -1) {
            return entry.substring(start, end);
        }

        return null;
    }

    private String header(String entry) {
        int start = entry.indexOf(Defaults.META_START) + Defaults.META_START.length();
        int end = entry.indexOf(Defaults.META_END);
        if (start != -1 && end != -1) {
            return entry.substring(start, end);
        }

        return null;
    }

}//End Class
