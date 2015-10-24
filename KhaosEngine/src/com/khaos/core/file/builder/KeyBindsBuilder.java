package com.khaos.core.file.builder;

import com.khaos.core.data.entry.KeyBindsEntry;
import com.khaos.core.file.dFile;
import java.io.IOException;

/**
 *
 * @author endbr
 */
public class KeyBindsBuilder extends Builder {

    public KeyBindsBuilder(dFile file) throws IOException {
        super(file);
    }

    @Override
    public KeyBindsEntry next() {
        String entry = this.entry();
        if (entry != null) {
            String header = this.header(entry);
            String value = this.value(entry);
            if (header != null && value != null) {
                return new KeyBindsEntry(header, value);
            }
        }

        return null;
    }

}//End Class
