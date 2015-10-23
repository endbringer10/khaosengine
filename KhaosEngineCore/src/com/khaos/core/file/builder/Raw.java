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
public abstract class Raw {

    private final String raw;
    private int caret = 0;

    public Raw(dFile file) throws IOException {
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

    public abstract <E extends Meta> Meta next();

}//End Class
