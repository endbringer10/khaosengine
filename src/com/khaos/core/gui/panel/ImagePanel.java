package com.khaos.core.gui.panel;

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

    public ImagePanel(BufferedImage image, Point location) {
        this.image = image;
        this.calcLocation(location.x, location.y);
        this.setOpaque(false);
    }

    public void init() {
        this.resize();
    }

    @Override
    public void setLocation(Point p) {
        this.calcLocation(p.x, p.y);
    }

    @Override
    public void setLocation(int x, int y) {
        this.calcLocation(x, y);
    }

    private void calcLocation(int x, int y) {
        int offX = (SCALE_SIZE - this.getWidth()) / 2;
        int offY = (SCALE_SIZE - this.getHeight()) / 2;

        super.setLocation((x * SCALE_SIZE) + offX, (y * SCALE_SIZE) + offY);
    }

    final public void resize() {
        this.setSize();
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public void setAbsoluteSize(Dimension absoluteSize) {
        this.absoluteSize = absoluteSize;
    }

    public void setSize() {
        if (absoluteSize.height == 0 || absoluteSize.width == 0) {
            super.setSize(image.getWidth(), image.getHeight());
        } else {
            super.setSize(absoluteSize);
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

        if (image != null) {
            g.drawImage(image, offset.width, offset.height, null);
        }
    }

}//End CLass
