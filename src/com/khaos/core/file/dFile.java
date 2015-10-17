package com.khaos.core.file;

import java.io.File;

/**
 *
 * @author endbr
 */
public class dFile extends File {

    public dFile(FileSystem pathname) {
        super(pathname.getPath());
    }

    public dFile(String pathname) {
        super(pathname);
    }

}//End Class
