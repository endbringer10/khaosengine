package com.khaos.core.data;

import com.khaos.core.file.Defaults;
import com.khaos.core.file.dFile;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author endbr
 */
public abstract class Raw<E extends Meta> {

    private final String raw;
    private int caret = 0;

    public Raw(dFile path) throws IOException {
        raw = FileUtils.readFileToString(path);

        if (raw.contains(Defaults.XML_START)) {
            caret = raw.indexOf(Defaults.XML_START) + Defaults.XML_START.length();
        }
    }

    public void setCaret(int caret) {
        this.caret = caret;
    }

    public int getCaret() {
        return caret;
    }

    public String getRaw() {
        return raw;
    }

    public abstract <E extends Meta> E next();

}//End Class
