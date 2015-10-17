package com.khaos.core.data.raw;

import com.khaos.core.data.Raw;
import com.khaos.core.data.entry.MaterialEntry;
import com.khaos.core.file.dFile;
import java.io.IOException;

/**
 *
 * @author endbr
 */
public class RawMaterial extends Raw<MaterialEntry> {

    public RawMaterial(dFile path) throws IOException {
        super(path);
    }

    @Override
    public MaterialEntry next() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}//End Class
