package com.khaos.core.gui.frame;

import com.khaos.core.Localized;
import com.khaos.core.Resources;
import com.khaos.core.SettingsCore;
import com.khaos.core.data.commands.LoginCommand;
import com.khaos.core.interfaces.EngineHook;
import com.khaos.system.core.Errors;

/**
 *
 * @author endbr
 */
public class LoginFrame extends javax.swing.JFrame {

    private final EngineHook engine;

    public LoginFrame(EngineHook engine) {
        initComponents();
        this.engine = engine;

        this.setIconImage(Resources.LOGO);
        this.setTitle(Localized.LOGIN.getLocalized());
        this.labelUsername.setText(Localized.USERNAME.getLocalized());
        this.labelPassword.setText(Localized.PASSWORD.getLocalized());
        this.buttonCancel.setText(Localized.EXIT.getLocalized());
        this.buttonLogin.setText(Localized.LOGIN.getLocalized());
        this.checkBoxAuto.setText(Localized.AUTO_LOGIN.getLocalized());
    }

    public void init() {
        this.setComponents();

        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private void setComponents() {
        this.checkBoxAuto.setSelected(SettingsCore.AUTO_LOGIN.parseBoolean());
        this.textFieldPassword.setText(SettingsCore.PASSWORD.parseString());
        this.textFieldUsername.setText(SettingsCore.USERNAME.parseString());
    }

    private void login() {
        engine.getManager().addCommand(new LoginCommand(this.textFieldUsername.getText(), this.textFieldPassword.getText()));
        if (this.checkBoxAuto.isSelected()) {
            SettingsCore.AUTO_LOGIN.setValue(true);
            SettingsCore.USERNAME.setValue(this.textFieldUsername.getText());
            SettingsCore.PASSWORD.setValue(this.textFieldPassword.getText());
        } else {
            SettingsCore.AUTO_LOGIN.setValue(false);
            SettingsCore.USERNAME.clear();
            SettingsCore.PASSWORD.clear();
        }
        this.dispose();
    }

    public static void invokeLater(EngineHook engine) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LoginFrame(engine).init();
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelUsername = new javax.swing.JLabel();
        labelPassword = new javax.swing.JLabel();
        textFieldUsername = new javax.swing.JTextField();
        textFieldPassword = new javax.swing.JTextField();
        checkBoxAuto = new javax.swing.JCheckBox();
        buttonCancel = new javax.swing.JButton();
        buttonLogin = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        labelUsername.setText("Username:");

        labelPassword.setText("Password:");

        checkBoxAuto.setText("Auto Login");

        buttonCancel.setText("Cancel");
        buttonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancelActionPerformed(evt);
            }
        });

        buttonLogin.setText("Login");
        buttonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLoginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelUsername, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                    .addComponent(labelPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(checkBoxAuto)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(buttonCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(64, 64, 64)
                                .addComponent(buttonLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(textFieldUsername, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(textFieldPassword, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelUsername)
                    .addComponent(textFieldUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelPassword)
                    .addComponent(textFieldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(checkBoxAuto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonCancel)
                    .addComponent(buttonLogin))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelActionPerformed
        System.exit(Errors.NO_ERROR.getCode());
    }//GEN-LAST:event_buttonCancelActionPerformed

    private void buttonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLoginActionPerformed
        this.login();
    }//GEN-LAST:event_buttonLoginActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCancel;
    private javax.swing.JButton buttonLogin;
    private javax.swing.JCheckBox checkBoxAuto;
    private javax.swing.JLabel labelPassword;
    private javax.swing.JLabel labelUsername;
    private javax.swing.JTextField textFieldPassword;
    private javax.swing.JTextField textFieldUsername;
    // End of variables declaration//GEN-END:variables

}//End Class
