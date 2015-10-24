package com.khaos.core.file.builder;

import com.khaos.core.data.entry.Meta;
import com.khaos.core.file.Defaults;
import com.khaos.core.file.dFile;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author endbr
 */
public abstract class Builder {

    private final String raw;
    private int caret = 0;

    public Builder(dFile file) throws IOException {
        raw = FileUtils.readFileToString(file);

        if (raw.contains(Defaults.XML_START)) {
            caret = raw.indexOf(Defaults.XML_START) + Defaults.XML_START.length();
        }
    }

    public void setCaret(int caret) {
        this.caret = caret;
    }

    public String getRaw() {
        return raw;
    }

    public int getCaret() {
        return caret;
    }

    public abstract Meta next();

    protected String entry() {
        //String raw = super.getRaw();
        //int caret = super.getCaret();

        int start = raw.indexOf(Defaults.ENTRY_START, caret);
        int end = raw.indexOf(Defaults.ENTRY_END, caret);

        if (start != -1 && end != -1) {
            caret = end + Defaults.ENTRY_END.length();
            return raw.substring(start, end + Defaults.ENTRY_END.length());
        }

        caret = raw.length();
        return null;
    }

    protected String header(String entry) {
        int start = entry.indexOf(Defaults.META_START) + Defaults.META_START.length();
        int end = entry.indexOf(Defaults.META_END);
        if (start != -1 && end != -1) {
            return entry.substring(start, end);
        }

        return null;
    }

    protected String value(String entry) {
        int start = entry.indexOf(Defaults.VALUE_START) + Defaults.VALUE_START.length();
        int end = entry.indexOf(Defaults.VALUE_END);

        if (start != -1 && end != -1) {
            return entry.substring(start, end);
        }

        return null;
    }
}//End Class
