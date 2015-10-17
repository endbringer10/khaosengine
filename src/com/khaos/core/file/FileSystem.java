package com.khaos.core.file;

import java.io.File;
import java.io.FilenameFilter;

/**
 *
 * @author endbr
 */
public enum FileSystem {

    FOLDER_USER_SETTINGS(Defaults.FOLDER_USERDATA + Defaults.FOLDER_CONFIG),
    FOLDER_DOWNLOADS(Defaults.FOLDER_USERDATA + Defaults.FOLDER_DOWNLOADS),
    FILE_USER_SETTINGS(Defaults.FOLDER_USERDATA + Defaults.FOLDER_CONFIG + Defaults.FILE_CONFIG),
    FILE_LOGO(Defaults.FOLDER_DATA + Defaults.FILE_LOGO);

    private final String path;

    FileSystem(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    @Override
    public String toString() {
        return path;
    }

    public static File[] listFiles(String folder) {
        return new File(folder).listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                File temp = new File(dir, name);
                return temp.isFile();
            }
        });
    }

    public static File[] listFiles(String folder, String filter) {
        return new File(folder).listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(filter);
            }
        });
    }

    public static File[] listFolders(String folder) {
        return new File(folder).listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                File temp = new File(dir, name);
                return temp.isDirectory();
            }
        });
    }

}//End Class
