package com.khaos.core.file;

import com.khaos.system.core.Files;
import java.io.File;

/**
 *
 * @author endbringer10
 * @since 20151207
 */
public class dFile extends File {

    public dFile(String pathname) {
        super(pathname);
    }

    public dFile(Files pathname) {
        super(pathname.getPath());
    }

    @Override
    public boolean mkdir() {
        return this.mk();
    }

    @Override
    public boolean mkdirs() {
        return this.mk();
    }

    private boolean mk() {
        if (this.isDirectory() == false) {
            File parent = this.getParentFile();
            if (parent != null) {
                return this.getParentFile().mkdirs();
            }

            return false;
        }

        return super.mkdirs();
    }

}//End Class
