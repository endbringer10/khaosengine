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
    FOLDER_TEXTURES(Defaults.FOLDER_DATA + Defaults.FOLDER_TEXTURES),
    FOLDER_MODS(Defaults.FOLDER_MODS),
    FILE_USER_SETTINGS(Defaults.FOLDER_USERDATA + Defaults.FOLDER_CONFIG + Defaults.FILE_CONFIG),
    FILE_LOGO(Defaults.FOLDER_DATA + Defaults.FILE_LOGO);

    private final String path;

    FileSystem(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public dFile getFile() {
        return new dFile(path);
    }

    public static dFile[] listAll(dFile folder) {
        //return new File(folder).listFiles();
        File[] files = folder.listFiles();

        dFile[] dFiles = new dFile[files.length];
        for (int i = 0; i < files.length; i++) {
            dFiles[i] = new dFile(files[i]);
        }

        return dFiles;
    }

    public static dFile[] listFiles(dFile folder) {
        File[] files = folder.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                File temp = new File(dir, name);
                return temp.isFile();
            }
        });

        dFile[] dFiles = new dFile[files.length];
        for (int i = 0; i < files.length; i++) {
            dFiles[i] = new dFile(files[i]);
        }

        return dFiles;
    }

    public static dFile[] listFiles(dFile folder, String filter) {
        File[] files = folder.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(filter);
            }
        });

        dFile[] dFiles = new dFile[files.length];
        for (int i = 0; i < files.length; i++) {
            dFiles[i] = new dFile(files[i]);
        }

        return dFiles;
    }

    public static dFile[] listFolders(dFile folder) {
        File[] files = folder.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                File temp = new File(dir, name);
                return temp.isDirectory();
            }
        });

        dFile[] dFiles = new dFile[files.length];
        for (int i = 0; i < files.length; i++) {
            dFiles[i] = new dFile(files[i]);
        }

        return dFiles;
    }

}//End Class
