package com.khaos.core.gui.internalframe;

import com.khaos.core.gui.Layer;
import com.khaos.core.system.Errors;
import com.khaos.core.system.SysLog;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;
import java.beans.PropertyVetoException;
import javax.swing.JPanel;
import javax.swing.plaf.basic.BasicInternalFrameUI;

/**
 *
 * @author endbringer10
 * @since 20151024
 */
public abstract class PanelHolder extends javax.swing.JInternalFrame {

    private static final int PADDING = 10;

    public PanelHolder(String title) {
        initComponents();
        this.setTitle(title);

        this.setLayer(Layer.INTERNALFRAME.getLayer());
        this.moveToFront();
        this.setVisible(true);
    }

    public void addPanel(JPanel panel) {
        this.add(panel);
        panel.setLocation(PADDING, PADDING);

        Insets insets = this.getInsets();
        int titleBarHeight = ((BasicInternalFrameUI) this.getUI()).getNorthPane().getHeight();

        this.setSize(panel.getWidth() + insets.left + insets.right + (PADDING * 2), panel.getHeight() + insets.top + insets.bottom + titleBarHeight + (PADDING * 2));

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
        Container container = this.getParent();
        if (container != null) {
            Dimension parent = this.getParent().getSize();
            int x = (parent.width - this.getWidth()) / 2;
            int y = (parent.height - this.getHeight()) / 2;

            this.setLocation(x, y);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addHierarchyBoundsListener(new java.awt.event.HierarchyBoundsListener() {
            public void ancestorMoved(java.awt.event.HierarchyEvent evt) {
            }
            public void ancestorResized(java.awt.event.HierarchyEvent evt) {
                formAncestorResized(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 233, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 189, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formAncestorResized(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_formAncestorResized
        this.align();
    }//GEN-LAST:event_formAncestorResized

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}//End Class
