package com.khaos.core.gui.panel;

import com.khaos.core.EngineHook;
import com.khaos.core.Localized;
import com.khaos.core.gui.internalframe.KeyBoundFrame;
import com.khaos.core.gui.internalframe.PanelHolder;
import com.khaos.core.system.Errors;
import javax.swing.JInternalFrame;

/**
 *
 * @author endbringer10
 * @since 20151024
 */
public class MenuPanel extends javax.swing.JPanel {

    private final EngineHook engine;
    private final JInternalFrame parent;

    public MenuPanel(EngineHook engine, JInternalFrame parent) {
        initComponents();
        this.engine = engine;
        this.parent = parent;

        this.buttonSettings.setText(Localized.SETTINGS.getLocalized());
        this.buttonExit.setText(Localized.EXIT.getLocalized());
        this.setSize(this.getPreferredSize());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonSettings = new javax.swing.JButton();
        buttonExit = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createEtchedBorder());

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonSettings, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
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
    }// </editor-fold>//GEN-END:initComponents

    private void buttonSettingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSettingsActionPerformed
        PanelHolder settings = new KeyBoundFrame(Localized.SETTINGS.getLocalized());
        engine.getGUI().openInternalFrame(settings);
        settings.addPanel(new SettingsEditorPanel(engine, settings));

        //SettingsEditor frame = new SettingsEditor(engine);
        //engine.getGUI().openInternalFrame(frame);
        //frame.init();
        parent.dispose();
    }//GEN-LAST:event_buttonSettingsActionPerformed

    private void buttonExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonExitActionPerformed
        System.exit(Errors.NO_ERROR.getCode());
    }//GEN-LAST:event_buttonExitActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonExit;
    private javax.swing.JButton buttonSettings;
    // End of variables declaration//GEN-END:variables

}//End Class
