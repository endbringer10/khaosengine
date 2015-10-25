package com.khaos.core.gui.gamevisuals;

import com.khaos.core.enums.gui.Layer;
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
    
    public void update(BufferedImage image, Point location) {
        this.setImage(image);
        this.setLocation(location);
    }
    
    @Override
    public int getPreferredLayer() {
        return Layer.PLAYER.getLayer();
    }
    
}//End CLass
