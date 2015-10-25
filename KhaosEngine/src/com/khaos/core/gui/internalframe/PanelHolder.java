package com.khaos.core.gui.internalframe;

import com.khaos.core.gui.enums.Alignment;
import com.khaos.core.gui.enums.Closeable;
import com.khaos.core.gui.enums.Iconifiable;
import com.khaos.core.gui.enums.Layer;
import com.khaos.core.gui.enums.Maximizable;
import com.khaos.core.gui.enums.Resizeable;
import com.khaos.core.system.Errors;
import com.khaos.core.system.SysLog;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;
import java.beans.PropertyVetoException;
import javax.swing.plaf.basic.BasicInternalFrameUI;

/**
 *
 * @author endbringer10
 * @since 20151024
 * @idea this.setDesktopIcon(desktopIcon);
 */
public class PanelHolder extends javax.swing.JInternalFrame {

    private static final int PADDING = 10;
    private static final int MARGIN = 2;
    private Alignment align;

    public PanelHolder(String title) {
        this.construct(title, Alignment.CENTER, Closeable.FALSE, Iconifiable.FALSE, Resizeable.FALSE, Maximizable.FALSE);
    }

    public PanelHolder(String title, Closeable close) {
        this.construct(title, Alignment.CENTER, close, Iconifiable.FALSE, Resizeable.FALSE, Maximizable.FALSE);
    }

    public PanelHolder(String title, Alignment align, Iconifiable icon, Resizeable resize, Maximizable max) {
        this.construct(title, align, Closeable.FALSE, icon, resize, max);
    }

    private void construct(String title, Alignment align, Closeable close, Iconifiable icon, Resizeable resize, Maximizable max) {
        this.align = align;
        this.initComponents();
        this.setTitle(title);
        this.setClosable(close.isCloseable());
        this.setIconifiable(icon.isIconifiable());
        this.setResizable(resize.isResizeable());
        this.setMaximizable(max.isMaximizable());

        //Move off screen to prevent stutter when temperarilly visible but empty
        //most be visible for getNorthPane() below to get proper height
        this.setLocation(-1000, -1000);

        this.setLayer(Layer.INTERNALFRAME.getLayer());
        this.moveToFront();
        this.setVisible(true);
    }

    /*public void addCustom(JPanel text) {
     text.setSize(text.getPreferredSize());
     this.add(text);
     text.setLocation(PADDING, PADDING);

     Insets insets = this.getInsets();
     int titleBarHeight = ((BasicInternalFrameUI) this.getUI()).getNorthPane().getHeight();
     this.setSize(text.getWidth() + insets.left + insets.right + (PADDING * 2), text.getHeight() + insets.top + insets.bottom + titleBarHeight + (PADDING * 2));

     this.align();
     this.setFocus();
     }*/
    public void addCustom(Component comp) {
        int NOTSUREWHY4 = 4;
        int NOTSUREWHY1 = 1;
        comp.setSize(comp.getPreferredSize());
        this.panelHolder.setLocation(PADDING, PADDING);

        int titleBarHeight = ((BasicInternalFrameUI) this.getUI()).getNorthPane().getHeight();
        Insets insets = this.panelHolder.getInsets();

        this.panelHolder.add(comp);
        comp.setLocation(insets.left, insets.top);

        this.panelHolder.setSize(comp.getWidth() + insets.left + insets.right + NOTSUREWHY4, comp.getHeight() + insets.top + insets.bottom - NOTSUREWHY1);
        this.setSize(this.panelHolder.getWidth() + (PADDING * 2), this.panelHolder.getHeight() + titleBarHeight + (PADDING * 2));

        System.out.println(this.getInsets());

        this.align();
        this.setFocus();
    }

    public void setFocus() {
        try {
            this.setSelected(true);
        } catch (PropertyVetoException ex) {
            SysLog.err(Errors.INTERNALFRAME_SELECTED, ex);
        }
    }

    public void align() {
        if (align == Alignment.BOTTOM_LEFT) {
            this.alignBottomLeft();
        } else { //center
            this.alignCenter();
        }
    }

    private void alignCenter() {
        Container container = this.getParent();
        if (container != null) {
            Dimension parent = this.getParent().getSize();
            int x = (parent.width - this.getWidth()) / 2;
            int y = (parent.height - this.getHeight()) / 2;

            this.setLocation(x, y);
        }
    }

    public void alignBottomLeft() {
        Container container = this.getParent();
        if (container != null) {
            Dimension parent = this.getParent().getSize();
            this.setLocation(MARGIN, parent.height - this.getHeight() - MARGIN);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelHolder = new javax.swing.JPanel();

        addHierarchyBoundsListener(new java.awt.event.HierarchyBoundsListener() {
            public void ancestorMoved(java.awt.event.HierarchyEvent evt) {
            }
            public void ancestorResized(java.awt.event.HierarchyEvent evt) {
                formAncestorResized(evt);
            }
        });

        panelHolder.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout panelHolderLayout = new javax.swing.GroupLayout(panelHolder);
        panelHolder.setLayout(panelHolderLayout);
        panelHolderLayout.setHorizontalGroup(
            panelHolderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 67, Short.MAX_VALUE)
        );
        panelHolderLayout.setVerticalGroup(
            panelHolderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 48, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelHolder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelHolder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formAncestorResized(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_formAncestorResized
        this.align();
    }//GEN-LAST:event_formAncestorResized

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel panelHolder;
    // End of variables declaration//GEN-END:variables
}//End Class
