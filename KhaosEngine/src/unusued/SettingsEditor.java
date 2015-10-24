package unusued;

import com.khaos.core.EngineHook;
import com.khaos.core.Localized;
import com.khaos.core.Settings;
import com.khaos.core.gui.interfaces.Aligned;
import java.awt.Container;
import java.awt.Dimension;

/**
 *
 * @author endbringer10
 * @since 20151024
 */
public class SettingsEditor extends javax.swing.JInternalFrame implements Aligned {

    private final EngineHook engine;

    public SettingsEditor(EngineHook engine) {
        initComponents();
        this.engine = engine;

        this.checkBoxAutoLogin.setText(Localized.ENABLED.getLocalized());
        this.labelAutoLogin.setText(Localized.AUTO_LOGIN.getLocalized());
        this.buttonCancel.setText(Localized.DISCARD.getLocalized());
        this.buttonReset.setText(Localized.RESET.getLocalized());
        this.buttonSave.setText(Localized.SAVE.getLocalized());
        this.setTitle(Localized.SETTINGS.getLocalized());
        this.setLayer(this.getPreferredLayer());
        this.moveToFront();
    }

    @Override
    public void init() {
        this.setComponents();
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

        setClosable(true);
        addHierarchyBoundsListener(new java.awt.event.HierarchyBoundsListener() {
            public void ancestorMoved(java.awt.event.HierarchyEvent evt) {
            }
            public void ancestorResized(java.awt.event.HierarchyEvent evt) {
                formAncestorResized(evt);
            }
        });

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonCancel)
                    .addComponent(buttonReset)
                    .addComponent(buttonSave))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formAncestorResized(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_formAncestorResized
        this.align();
    }//GEN-LAST:event_formAncestorResized

    private void buttonResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonResetActionPerformed
        this.setComponents();
    }//GEN-LAST:event_buttonResetActionPerformed

    private void buttonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_buttonCancelActionPerformed

    private void buttonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSaveActionPerformed
        this.saveSettings();
    }//GEN-LAST:event_buttonSaveActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCancel;
    private javax.swing.JButton buttonReset;
    private javax.swing.JButton buttonSave;
    private javax.swing.JCheckBox checkBoxAutoLogin;
    private javax.swing.JLabel labelAutoLogin;
    // End of variables declaration//GEN-END:variables
}//End Class
