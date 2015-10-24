package com.khaos.core.gui.panel;

import com.khaos.core.gui.Layer;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

/**
 *
 * @author endbr
 * @idea zoom level: take size and multiply by zoom to increase size. has
 * multiple sets of textures for this
 * @idea resizeble boolean to lock size
 */
public class ImagePanel extends JPanel {

    public static final int SCALE_SIZE = 25;

    private BufferedImage image;
    private final Dimension offset = new Dimension(0, 0);
    private Dimension absoluteSize = new Dimension(0, 0);
    private Point grid = new Point(0,0);

    public ImagePanel() {
        this.image = null;
        this.setVisible(true);
        //this.calcLocation(location.x, location.y);
        this.setOpaque(false);
    }

    public ImagePanel(BufferedImage image) {
        this.image = image;
        this.setVisible(true);
        //this.calcLocation(location.x, location.y);
        this.setOpaque(false);
    }

    @Override
    public void setLocation(Point p) {
        grid = p;
        this.calcLocation();
    }

    @Override
    public void setLocation(int x, int y) {
        grid = new Point(x,y);
        this.calcLocation();
    }

    private void calcLocation() {
        int offX = (SCALE_SIZE - this.getWidth()) / 2;
        int offY = (SCALE_SIZE - this.getHeight()) / 2;

        super.setLocation((grid.x * SCALE_SIZE) + offX, (grid.y * SCALE_SIZE) + offY);
    }

    final public void resize() {
        this.setSize();
    }

    public void setImage(BufferedImage update) {
        if (update != null) {
            this.image = update;
            this.setSize();
            this.calcLocation();
        }
    }

    public void setAbsoluteSize(Dimension absoluteSize) {
        this.absoluteSize = absoluteSize;
    }

    public void setSize() {
        if (absoluteSize.height > 0 || absoluteSize.width > 0) {
            super.setSize(absoluteSize);
        } else if (image != null && (absoluteSize.height == 0 || absoluteSize.width == 0)) {
            super.setSize(image.getWidth(), image.getHeight());
        } else {
            super.setSize(0, 0);
        }
    }

    public void increaseOffsetWidth(int offset) {
        this.offset.width += Math.abs(offset);
    }

    public void decreaseOffsetWidth(int offset) {
        this.offset.width -= Math.abs(offset);
    }

    public void increaseOffsetHeight(int offset) {
        this.offset.height += Math.abs(offset);
    }

    public void decreaseOffsetHeight(int offset) {
        this.offset.height -= Math.abs(offset);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        if (this.image != null) {
            g.drawImage(image, offset.width, offset.height, null);
        }
    }
    
    public int getPreferredLayer(){
        return Layer.BOTTOM.getLayer();
    }

}//End CLass
