package com.khaos.core.gui.panel;

import com.khaos.core.gui.Layer;
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
    }

    @Override
    public int getLayer() {
        return Layer.PLAYER.getLayer();
    }

}//End CLass
