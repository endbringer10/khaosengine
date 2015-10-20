package com.khaos.core.gui.panel;

import java.awt.Point;
import java.awt.image.BufferedImage;

/**
 *
 * @author endbr
 */
public class CharacterPanel extends ImagePanel {

    public CharacterPanel(Point location) {
        this.resize();
        this.setLocation(location);
    }
    
    public void update(BufferedImage image) {
        this.setImage(image);
        //this.repaint();
    }

}//End CLass
