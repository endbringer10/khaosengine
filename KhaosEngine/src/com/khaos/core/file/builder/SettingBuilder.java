package com.khaos.core.file.builder;

import com.khaos.core.data.entry.SettingEntry;
import com.khaos.core.file.dFile;
import java.io.IOException;

/**
 *
 * @author endbr
 */
public class SettingBuilder extends Builder {

    public SettingBuilder(dFile file) throws IOException {
        super(file);
    }

    @Override
    public SettingEntry next() {
        String entry = this.entry();
        if (entry != null) {
            String header = this.header(entry);
            String value = this.value(entry);
            if (header != null && value != null) {
                return new SettingEntry(header, value);
            }
        }

        return null;
    }

    /*private String entry() {
     String raw = super.getRaw();
     int caret = super.getCaret();

     int start = raw.indexOf(Defaults.ENTRY_START, caret);
     int end = raw.indexOf(Defaults.ENTRY_END, caret);

     if (start != -1 && end != -1) {
     super.setCaret(end + Defaults.ENTRY_END.length());
     return raw.substring(start, end + Defaults.ENTRY_END.length());
     }

     super.setCaret(raw.length());
     return null;
     }*/
    /*private String value(String entry) {
        int start = entry.indexOf(Defaults.VALUE_START) + Defaults.VALUE_START.length();
        int end = entry.indexOf(Defaults.VALUE_END);

        if (start != -1 && end != -1) {
            return entry.substring(start, end);
        }

        return null;
    }*/

    /*private String header(String entry) {
        int start = entry.indexOf(Defaults.META_START) + Defaults.META_START.length();
        int end = entry.indexOf(Defaults.META_END);
        if (start != -1 && end != -1) {
            return entry.substring(start, end);
        }

        return null;
    }*/

}//End Class
