package com.khaos.core.data;

import com.khaos.core.file.FileSystem;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author endbr
 */
public class Resources {

    public static final Image LOGO = (new ImageIcon(FileSystem.FILE_LOGO.getPath())).getImage();
    
    private final UniqueArray<ImageEntry> textures = new UniqueArray<>();
    private final UniqueArray<ImageEntry> background = new UniqueArray<>();

}//End Class
