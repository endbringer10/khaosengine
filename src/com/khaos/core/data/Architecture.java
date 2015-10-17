package com.khaos.core.data;

import com.khaos.core.data.entry.MaterialEntry;
import com.khaos.core.data.raw.RawMaterial;
import com.khaos.core.file.FileSystem;
import com.khaos.core.file.dFile;
import com.khaos.core.system.Errors;
import com.khaos.core.system.SysLog;
import java.io.IOException;

/**
 *
 * @author endbr
 */
public class Architecture {

    private final UniqueArray<MaterialEntry> materials = new UniqueArray<>();

    public void load() {
        this.loadMaterials(FileSystem.FOLDER_MATERIALS.getFile());
    }

    private void loadMaterials(dFile folder) {
        dFile[] files = FileSystem.listAll(folder);

        if (files != null) {
            for (dFile file : files) {
                //dFile file = new dFile(index);
                if (file.isFile()) {
                    try {
                        RawMaterial raw = new RawMaterial(file);
                        MaterialEntry next = raw.next();
                        materials.add(next);
                    } catch (IOException ex) {
                        SysLog.err(Errors.IMAGE_LOAD, ex);
                    }
                } else {
                    this.loadMaterials(file);
                }
            }
        }
    }

}//End Class
