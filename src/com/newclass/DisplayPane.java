package com.newclass;

import com.khaos.core.data.game.DisplayGrid;
import com.khaos.core.gui.panel.ImagePanel;
import com.khaos.core.gui.panel.TilePanel;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.HierarchyBoundsListener;
import java.awt.event.HierarchyEvent;
import javax.swing.JDesktopPane;

/**
 *
 * @author endbr
 */
public class DisplayPane extends JDesktopPane {

    private static final int PADDING = 10;

    public DisplayGrid init() {
        this.setLocation(PADDING, PADDING);
        this.resize();
        this.addHierarchyBoundsListener();

        DisplayGrid grid = new DisplayGrid();
        int columns = (this.getWidth() / ImagePanel.SCALE_SIZE) + 1;
        int rows = (this.getHeight() / ImagePanel.SCALE_SIZE) + 1;

        for (int x = 0; x < columns; x++) {
            for (int y = 0; y < rows; y++) {
                TilePanel panel = new TilePanel(new Point(x, y));
                grid.add(x, y, panel);
                this.add(panel);
                this.setLayer(panel, panel.getLayer());

                this.setPosition(panel, (columns - x - 1) + ((rows - y - 1) * (columns)));
            }
        }

        return grid;
    }

    public void addHierarchyBoundsListener() {
        super.addHierarchyBoundsListener(new HierarchyBoundsListener() {
            @Override
            public void ancestorMoved(HierarchyEvent evt) {

            }

            @Override
            public void ancestorResized(HierarchyEvent evt) {
                resize();
            }
        });
    }

    private void resize() {
        Dimension parent = this.getParent().getSize();
        if (parent != null) {
            this.setSize(parent);
        }
    }

}//end class
