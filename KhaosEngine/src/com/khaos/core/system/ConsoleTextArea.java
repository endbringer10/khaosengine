package com.khaos.core.system;

import com.khaos.core.file.Defaults;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JTextArea;

/**
 *
 * @author endbringer10
 * @since 20151025
 */
public class ConsoleTextArea extends JTextArea {

    private final int DEFAULT_WIDTH = 300;
    private final int DEFAULT_HEIGHT = 100;
    private final int LENGTH_CAP = 1000;

    public ConsoleTextArea() {
        super();
        this.setLineWrap(true);
        this.setEditable(false);
        this.setWrapStyleWord(true);
        this.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        this.setPreferredSize(new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT));
        this.setFocusable(false);
        //this.setBorder(new EtchedBorder());
    }

    @Override
    public synchronized void append(String str) {
        super.append(str + Defaults.NEWLINE);

        String text = this.getText();
        if (text.length() > LENGTH_CAP) {
            int index = text.indexOf(Defaults.NEWLINE);
            this.setText(text.substring(index));
        }
    }

    /**
     * @deprecated
     */
    private void addListener() {
        this.addHierarchyBoundsListener(new java.awt.event.HierarchyBoundsListener() {
            @Override
            public void ancestorMoved(java.awt.event.HierarchyEvent evt) {

            }

            @Override
            public void ancestorResized(java.awt.event.HierarchyEvent evt) {
                //resize();
            }
        });
    }

    /**
     * @deprecated
     */
    private void resize() {
        Container container = this.getParent();
        if (container != null) {
            Dimension parent = this.getParent().getSize();
            //this.setSize(parent.width - (PanelHolder.PADDING * 2), parent.height - (PanelHolder.PADDING * 2));
        }
    }

}//End Class
