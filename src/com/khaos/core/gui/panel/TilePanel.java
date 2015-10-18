package com.khaos.core.gui.panel;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;

/**
 *
 * @author endbr
 */
public class TilePanel extends ImagePanel {

    //private int coordX = 0;
    //private int coordY = 0;

    public TilePanel(BufferedImage image, Point location /*,int coordX, int coordY*/) {
        super(image, location);
        //this.coordX = coordX;
        //this.coordY = coordY;
        this.setAbsoluteSize(new Dimension(ImagePanel.SCALE_SIZE, ImagePanel.SCALE_SIZE));
    }

    @Override
    public void init() {
        this.resize();
    }

    public void update(BufferedImage image, int coordX, int coordY) {
        super.setImage(image);
        //this.coordX = coordX;
        //this.coordY = coordY;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        /*String out = "(" + coordX + "," + coordY + ")";
        int x = (this.getWidth() - g.getFontMetrics().stringWidth(out)) / 2;
        int y = (this.getHeight() - g.getFontMetrics().getHeight());

        g.drawString(out, x, y);*/
    }

}//End Class
