package com.khaos.core.gui.panel;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import javax.swing.border.EtchedBorder;

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

}//End Class
