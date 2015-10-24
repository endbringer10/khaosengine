package com.khaos.core.gui.gamevisuals;

import com.khaos.core.gui.Layer;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.image.BufferedImage;

/**
 *
 * @author endbr
 */
public class TilePanel extends ImagePanel {

    public TilePanel(Point location) {
        this.setAbsoluteSize(new Dimension(ImagePanel.SCALE_SIZE, ImagePanel.SCALE_SIZE));
        this.resize();
        this.setLocation(location);
    }

    public void update(BufferedImage image) {
        this.setImage(image);
        //this.repaint();
    }
    
    @Override
    public int getPreferredLayer(){
        return Layer.TILE.getLayer();
    }

}//End Class
