package com.khaos.core.data.raw;

import com.khaos.core.data.Raw;
import com.khaos.core.data.entry.SettingsEntry;
import com.khaos.core.file.Defaults;
import com.khaos.core.file.dFile;
import java.io.IOException;

/**
 *
 * @author endbr
 */
public class RawSettings extends Raw<SettingsEntry> {

    public RawSettings(dFile path) throws IOException {
        super(path);
    }

    @Override
    public SettingsEntry next() {
        String entry = this.entry();
        if (entry != null) {
            String header = this.header(entry);
            String value = this.value(entry);
            if (header != null && value != null) {
                return new SettingsEntry(header, value);
            }
        }

        return null;
    }

    private String entry() {
        String raw = super.getRaw();
        int caret = super.getCaret();

        int start = raw.indexOf(Defaults.ENTRY_START, caret);
        int end = raw.indexOf(Defaults.ENTRY_END, caret);

        if (start != -1 && end != -1) {
            super.setCaret(end + Defaults.ENTRY_END.length());
            return raw.substring(start, end);
        }

        super.setCaret(raw.length());
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
