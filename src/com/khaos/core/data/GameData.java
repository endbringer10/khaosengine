package com.khaos.core.data;

import com.khaos.core.gui.panel.ImagePanel;
import com.khaos.core.gui.panel.TilePanel;
import java.awt.Dimension;
import java.util.ArrayList;

/**
 *
 * @author endbr
 */
public class GameData {

    private final ArrayList<TilePanel> grid = new ArrayList<>();

    public void loadTiles(Dimension parentSize) {
        int rows = parentSize.width / ImagePanel.SCALE_SIZE;
        int columns = parentSize.height / ImagePanel.SCALE_SIZE;

        for (int x = 0; x < columns; x++) {
            for (int y = 0; y < rows; y++) {

            }
        }
    }

}//End Class
