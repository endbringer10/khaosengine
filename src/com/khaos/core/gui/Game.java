package com.khaos.core.gui;

import com.khaos.client.KhaosEngine;
import com.khaos.core.Localized;
import com.khaos.core.Settings;
import com.khaos.core.connection.ConnectionHook;
import com.khaos.core.data.Architecture;
import com.khaos.core.data.GameData;
import com.khaos.core.data.Resources;
import com.khaos.core.data.commands.CharacterSelectCommand;
import com.khaos.core.gui.internalframe.CharacterSelect;

/**
 *
 * @author endbr
 */
public class Game extends javax.swing.JFrame {

    private final Architecture arch = new Architecture();
    private final GameData data = new GameData();
    private final Resources resources;
    private final ConnectionHook connection;

    public Game(ConnectionHook connection, Resources resources) {
        initComponents();
        this.connection = connection;
        this.resources = resources;
    }

    public void init() {
        this.setSize(Settings.SCREEN_WIDTH.parseInt(), Settings.SCREEN_HEIGHT.parseInt());
        this.setIconImage(Resources.LOGO);
        this.setTitle(Localized.KHAOS_ENGINE.getLocalized() + " v" + KhaosEngine.VERSION);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public void start() {
        resources.load();
        arch.load();
        connection.addCommand(new CharacterSelectCommand());
    }

    public void openCharacterSelect() {
        CharacterSelect select = new CharacterSelect(connection);
        this.desktopPane.add(select);
        select.init();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout desktopPaneLayout = new javax.swing.GroupLayout(desktopPane);
        desktopPane.setLayout(desktopPaneLayout);
        desktopPaneLayout.setHorizontalGroup(
            desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 780, Short.MAX_VALUE)
        );
        desktopPaneLayout.setVerticalGroup(
            desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 557, Short.MAX_VALUE)
        );

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(desktopPane)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(desktopPane)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables
}//End Class
