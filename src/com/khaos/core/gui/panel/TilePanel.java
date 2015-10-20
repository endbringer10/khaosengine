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

    //private int coordX = 0;
    //private int coordY = 0;
    public TilePanel(Point location) {
        super(null, location);
        this.setAbsoluteSize(new Dimension(ImagePanel.SCALE_SIZE, ImagePanel.SCALE_SIZE));
        this.resize();
        this.setLocation(location);
        //this.setBorder(new EtchedBorder());
    }

    public void update(BufferedImage image) {
        this.setImage(image);
        this.repaint();
    }

    /*@Override
    public void paint(Graphics g) {
        super.paint(g);

        String out = "(" + coordX + "," + coordY + ")";
         int x = (this.getWidth() - g.getFontMetrics().stringWidth(out)) / 2;
         int y = (this.getHeight() - g.getFontMetrics().getHeight());

         g.drawString(out, x, y);
    }*/

}//End Class
