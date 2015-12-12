package com.khaos.core;

import com.khaos.system.core.Files;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author endbringer10
 * @since 20151211
 */
public class Resources {

    public static final Image LOGO = (new ImageIcon(Resources.class.getClassLoader().getResource(Files.LOGO.getPath()))).getImage();

}//End Class
