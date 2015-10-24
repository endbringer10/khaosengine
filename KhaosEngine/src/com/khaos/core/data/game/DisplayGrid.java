package com.khaos.core.data.game;

import com.khaos.core.data.Array2D;
import com.khaos.core.gui.gamevisuals.TilePanel;
import java.awt.image.BufferedImage;

/**
 *
 * @author endbr
 */
public class DisplayGrid extends Array2D<TilePanel> {

    public void update(int x, int y, BufferedImage image) {
        this.get(x, y).update(image);
    }

    public void repaint() {
        for (int x = 0; x < this.getColumns(); x++) {
            for (int y = 0; y < this.getRows(); y++) {
                this.get(x, y).repaint();
            }
        }
    }

    public void setVisible(boolean visible) {
        for (int x = 0; x < this.getColumns(); x++) {
            for (int y = 0; y < this.getRows(); y++) {
                this.get(x, y).setVisible(visible);
            }
        }
    }

}//End Class
