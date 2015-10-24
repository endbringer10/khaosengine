package com.khaos.core.file.builder;

import com.khaos.core.data.entry.MaterialEntry;
import com.khaos.core.file.dFile;
import java.io.IOException;

/**
 *
 * @author endbr
 */
public class MaterialBuilder extends Builder {

    public MaterialBuilder(dFile file) throws IOException {
        super(file);
    }

    @Override
    public MaterialEntry next() {
        return null;
    }

}//End Class
