package com.khaos.core.data;

import com.khaos.core.data.entry.ImageEntry;
import com.khaos.core.file.FileSystem;
import com.khaos.core.file.dFile;
import com.khaos.core.system.Errors;
import com.khaos.core.system.Messages;
import com.khaos.core.system.SysLog;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author endbr
 */
public class Resources {

    public static final Image LOGO = (new ImageIcon(FileSystem.FILE_LOGO.getPath())).getImage();

    private final UniqueArray<ImageEntry> textures = new UniqueArray<>();
    //private final UniqueArray<ImageEntry> background = new UniqueArray<>();

    public void load() {
        this.loadTextures(FileSystem.FOLDER_TEXTURES.getFile());
        this.loadMods();

        SysLog.log(Messages.TEXTURES_LOADED.getMessage() + ": " + textures.size());
    }

    private void loadTextures(dFile folder) {
        dFile[] files = FileSystem.listAll(folder);

        if (files != null) {
            for (dFile file : files) {
                //dFile file = new dFile(index);
                if (file.isFile()) {
                    try {
                        BufferedImage image = ImageIO.read(file);
                        textures.add(new ImageEntry(file.getRelativePath(), image));
                    } catch (IOException ex) {
                        SysLog.err(Errors.IMAGE_LOAD, ex);
                    }
                } else {
                    this.loadTextures(file);
                }
            }
        }
    }

    private void loadMods() {
        dFile[] files = FileSystem.listFolders(FileSystem.FOLDER_MODS.getFile());

        for (dFile file : files) {
            if (file.isDirectory()) {
                this.loadTextures(file);
            }
        }
    }

    public BufferedImage getTexture(String texture) {
        int index = textures.indexOf(texture);
        if (index != -1) {
            return textures.get(index).getImage();
        }

        return null;
    }

}//End Class
