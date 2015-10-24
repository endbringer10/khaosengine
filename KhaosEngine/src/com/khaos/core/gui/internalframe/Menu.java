package com.khaos.core.gui.internalframe;

import com.khaos.core.EngineHook;
import com.khaos.core.Localized;
import com.khaos.core.gui.interfaces.Aligned;
import com.khaos.core.system.Errors;
import java.awt.Container;
import java.awt.Dimension;

/**
 *
 * @author endbringer10
 * @since 20151024
 */
public class Menu extends javax.swing.JInternalFrame implements Aligned {

    private final EngineHook engine;

    public Menu(EngineHook engine) {
        initComponents();
        this.engine = engine;

        this.buttonSettings.setText(Localized.SETTINGS.getLocalized());
        this.buttonExit.setText(Localized.EXIT.getLocalized());
        this.setTitle(Localized.MENU.getLocalized());
        this.setLayer(this.getPreferredLayer());
        this.moveToFront();
    }

    @Override
    public void init() {
        this.align();
        this.setVisible(true);
    }

    @Override
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

        buttonSettings = new javax.swing.JButton();
        buttonExit = new javax.swing.JButton();

        addHierarchyBoundsListener(new java.awt.event.HierarchyBoundsListener() {
            public void ancestorMoved(java.awt.event.HierarchyEvent evt) {
            }
            public void ancestorResized(java.awt.event.HierarchyEvent evt) {
                formAncestorResized(evt);
            }
        });

        buttonSettings.setText("Settings");
        buttonSettings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSettingsActionPerformed(evt);
            }
        });

        buttonExit.setText("Exit");
        buttonExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonSettings, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                    .addComponent(buttonExit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buttonSettings)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonExit)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formAncestorResized(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_formAncestorResized
        this.align();
    }//GEN-LAST:event_formAncestorResized

    private void buttonExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonExitActionPerformed
        System.exit(Errors.NO_ERROR.getCode());
    }//GEN-LAST:event_buttonExitActionPerformed

    private void buttonSettingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSettingsActionPerformed
        SettingsEditor frame = new SettingsEditor(engine);
        engine.getGUI().openInternalFrame(frame);
        frame.init();
        this.dispose();
    }//GEN-LAST:event_buttonSettingsActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonExit;
    private javax.swing.JButton buttonSettings;
    // End of variables declaration//GEN-END:variables
}//End Class
