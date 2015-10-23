package com.khaos.core.file;

import java.io.File;

/**
 *
 * @author endbr
 */
public class dFile extends File {

    public dFile(String pathname) {
        super(pathname);
    }

    public dFile(File path) {
        super(path.getPath());
    }

    public String getRelativePath() {
        String path = super.getPath();

        if (path.contains(Defaults.FOLDER_TEXTURES)) {
            path = path.substring(path.indexOf(Defaults.FOLDER_TEXTURES) + Defaults.FOLDER_TEXTURES.length());
        }

        //repeat for all default folders
        return path;
    }

}//End Class
