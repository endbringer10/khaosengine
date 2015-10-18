package com.khaos.core.data.entry;

import java.awt.image.BufferedImage;

/**
 *
 * @author endbr
 */
public class ImageEntry extends Meta {

    private final BufferedImage image;

    public ImageEntry(String path, BufferedImage image) {
        super(path);
        this.image = image;
        //System.out.println(super.getMeta());
    }

    /*private static String edit(String path) {
        path = path.replace(FileSystem.FOLDER_TEXTURES.getPath2(), "");
        return path;
    }*/

}//end class
