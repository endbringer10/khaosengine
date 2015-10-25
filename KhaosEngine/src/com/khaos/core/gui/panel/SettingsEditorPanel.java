package com.khaos.core.gui.panel;

import com.khaos.core.EngineHook;
import com.khaos.core.enums.Localized;
import com.khaos.core.enums.Settings;
import javax.swing.JInternalFrame;

/**
 *
 * @author endbringer10
 * @since 20151024
 */
public class SettingsEditorPanel extends javax.swing.JPanel {

    private final EngineHook engine;
    private final JInternalFrame parent;

    public SettingsEditorPanel(EngineHook engine, JInternalFrame parent) {
        initComponents();
        this.engine = engine;
        this.parent = parent;

        this.checkBoxAutoLogin.setText(Localized.ENABLED.getLocalized());
        this.labelAutoLogin.setText(Localized.AUTO_LOGIN.getLocalized());
        this.buttonCancel.setText(Localized.DISCARD.getLocalized());
        this.buttonReset.setText(Localized.RESET.getLocalized());
        this.buttonSave.setText(Localized.SAVE.getLocalized());

        this.setComponents();
        //this.setSize(this.getPreferredSize());
    }

    private void setComponents() {
        this.checkBoxAutoLogin.setSelected(Settings.AUTO_LOGIN.parseBoolean());
    }

    private void saveSettings() {
        Settings.AUTO_LOGIN.setValue(this.checkBoxAutoLogin.isSelected());
        Settings.save();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelAutoLogin = new javax.swing.JLabel();
        checkBoxAutoLogin = new javax.swing.JCheckBox();
        buttonCancel = new javax.swing.JButton();
        buttonReset = new javax.swing.JButton();
        buttonSave = new javax.swing.JButton();

        labelAutoLogin.setText("Auto Login:");

        checkBoxAutoLogin.setText("Yes");

        buttonCancel.setText("Cancel");
        buttonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancelActionPerformed(evt);
            }
        });

        buttonReset.setText("Reset");
        buttonReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonResetActionPerformed(evt);
            }
        });

        buttonSave.setText("Save");
        buttonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelAutoLogin)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(checkBoxAutoLogin))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonReset, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonSave, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelAutoLogin)
                    .addComponent(checkBoxAutoLogin))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonCancel)
                    .addComponent(buttonReset)
                    .addComponent(buttonSave))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelActionPerformed
        parent.dispose();
    }//GEN-LAST:event_buttonCancelActionPerformed

    private void buttonResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonResetActionPerformed
        this.setComponents();
    }//GEN-LAST:event_buttonResetActionPerformed

    private void buttonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSaveActionPerformed
        this.saveSettings();
        parent.dispose();
    }//GEN-LAST:event_buttonSaveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCancel;
    private javax.swing.JButton buttonReset;
    private javax.swing.JButton buttonSave;
    private javax.swing.JCheckBox checkBoxAutoLogin;
    private javax.swing.JLabel labelAutoLogin;
    // End of variables declaration//GEN-END:variables

}//End Class
