package com.khaos.core.gui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.HierarchyBoundsListener;
import javax.swing.JDesktopPane;

/**
 *
 * @author endbr
 * @since 20151213
 */
public class DisplayPane extends JDesktopPane {

    private final static int PADDING = 10;

    public void init() {
        this.addHierarchyBoundsListener();
        this.setLocation(PADDING, PADDING);
        this.resize();
        this.setVisible(true);
    }

    private void addHierarchyBoundsListener() {
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

    private void resize() {
        Container container = this.getParent();
        if (container != null) {
            Dimension parent = container.getSize();
            Dimension size = new Dimension(parent.width - (PADDING * 2), parent.height - (PADDING * 2));

            this.setSize(size);
            //this.resizeGrid();
        }
    }

}//End Class
