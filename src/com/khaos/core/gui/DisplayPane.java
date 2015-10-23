package com.khaos.core.gui;

import com.khaos.core.data.game.DisplayGrid;
import com.khaos.core.gui.panel.CharacterPanel;
import com.khaos.core.gui.panel.ImagePanel;
import com.khaos.core.gui.panel.TilePanel;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.HierarchyBoundsListener;
import javax.swing.JDesktopPane;

/**
 *
 * @author endbr
 */
public class DisplayPane extends JDesktopPane {

    private final static int PADDING = 10;
    private final DisplayGrid grid = new DisplayGrid();

    public void init() {
        this.addHierarchyBoundsListener();
        this.setLocation(PADDING, PADDING);
        this.resize();
        this.setVisible(true);
    }

    public CharacterPanel initPlayer() {
        CharacterPanel character = new CharacterPanel(new Point(9, 9));
        this.add(character);
        this.setLayer(character, character.getLayer());
        this.setPosition(character, 0);

        return character;
    }

    public DisplayGrid initGrid() {
        //DisplayGrid grid = new DisplayGrid();
        int columns = (this.getWidth() / ImagePanel.SCALE_SIZE) + 1;
        int rows = (this.getHeight() / ImagePanel.SCALE_SIZE) + 1;

        for (int x = 0; x < columns; x++) {
            for (int y = 0; y < rows; y++) {
                TilePanel panel = new TilePanel(new Point(x, y));
                grid.add(x, y, panel);
                this.add(panel);
                this.setLayer(panel, panel.getLayer());
                this.setPosition(panel, (columns - x - 1) + ((rows - y - 1) * columns));
            }
        }

        return grid;
    }

    private void resize() {
        Container container = this.getParent();
        if (container != null) {
            Dimension parent = container.getSize();
            Dimension size = new Dimension(parent.width - (PADDING * 2), parent.height - (PADDING * 2));

            this.setSize(size);
            //this.resizeGrid();
        }
    }

    /*private void resizeGrid() {
     int columns = (this.getWidth() / ImagePanel.SCALE_SIZE) + 1;
     int rows = (this.getHeight() / ImagePanel.SCALE_SIZE) + 1;

     for (int x = grid.getColumns(); x < columns; x++) {
     for (int y = grid.getRows(); y < rows; y--) {
     TilePanel panel = new TilePanel(new Point(x, y));
     grid.add(x, y, panel);
     this.add(panel);
     this.setLayer(panel, panel.getLayer());
     this.setPosition(panel, (columns - x - 1) + ((rows - y - 1) * columns));
     }
     }
     }*/
    public void addHierarchyBoundsListener() {
        super.addHierarchyBoundsListener(new HierarchyBoundsListener() {
            @Override
            public void ancestorMoved(java.awt.event.HierarchyEvent evt) {
            }

            @Override
            public void ancestorResized(java.awt.event.HierarchyEvent evt) {
                resize();
            }
        });
    }
}//End CLass
