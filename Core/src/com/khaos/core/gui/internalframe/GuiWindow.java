package com.khaos.core.gui.internalframe;

import com.khaos.core.gui.enums.Alignment;
import com.khaos.core.gui.enums.Resizeable;
import com.khaos.core.interfaces.EngineHook;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;
import javax.swing.JPanel;
import javax.swing.plaf.basic.BasicInternalFrameUI;

/**
 *
 * @author endbr
 * @since 20151213
 */
public class GuiWindow extends javax.swing.JInternalFrame {

    private static final int MARGIN = 5;

    private final Alignment align;
    private final JPanel panel;

    public GuiWindow(JPanel panel, String title, Resizeable resize, Alignment align) {
        this.panel = panel;
        initComponents();
        this.align = align;

        this.setTitle(title);
        this.setResizable(resize.isResizeable());
    }

    private void init() {
        this.panelHolder.add(panel);
        panel.setLocation(0, 0);

        Insets iFrame = this.getInsets();
        int titleBarHeight = ((BasicInternalFrameUI) this.getUI()).getNorthPane().getHeight();
        panel.setSize(panel.getPreferredSize());
        this.panelHolder.setSize(panel.getSize());
        this.setSize(this.panelHolder.getWidth() + iFrame.left + iFrame.right + 1, this.panelHolder.getHeight() + iFrame.top + iFrame.bottom + titleBarHeight + 1);

        this.setMinimumSize(this.getSize());
        this.align();

        panel.setVisible(true);
        this.setVisible(true);
    }

    public void align() {
        if (align == Alignment.BOTTOM_LEFT) {
            this.alignBottomLeft();
        }
    }

    private void alignBottomLeft() {
        Container container = this.getParent();
        if (container != null) {
            Dimension parent = this.getParent().getSize();
            this.setLocation(MARGIN, parent.height - this.getHeight() - MARGIN);
        }
    }

    public static void newInstance(EngineHook engine, JPanel panel, String title, Resizeable resize, Alignment align) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                GuiWindow window = new GuiWindow(panel, title, resize, align);
                engine.getGUI().addWindow(window);
                window.init();
            }
        });
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

        javax.swing.GroupLayout panelHolderLayout = new javax.swing.GroupLayout(panelHolder);
        panelHolder.setLayout(panelHolderLayout);
        panelHolderLayout.setHorizontalGroup(
            panelHolderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 394, Short.MAX_VALUE)
        );
        panelHolderLayout.setVerticalGroup(
            panelHolderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 282, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelHolder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelHolder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
