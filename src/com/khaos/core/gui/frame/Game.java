package com.khaos.core.gui.frame;

import com.khaos.client.KhaosEngine;
import com.khaos.core.Localized;
import com.khaos.core.Settings;
import com.khaos.core.connection.ConnectionHook;
import com.khaos.core.data.Architecture;
import com.khaos.core.data.GameData;
import com.khaos.core.data.Resources;
import com.khaos.core.data.commands.CharacterSelectCommand;
import com.khaos.core.gui.DisplayPane;
import com.khaos.core.gui.internalframe.CharacterSelect;

/**
 *
 * @author endbr
 */
public class Game extends javax.swing.JFrame {

    private final Architecture arch = new Architecture();
    private final Resources resources;
    private final GameData game;
    private final ConnectionHook connection;
    private final DisplayPane display = new DisplayPane();

    public Game(ConnectionHook connection, Resources resources) {
        initComponents();
        this.add(display);
        display.init();

        this.connection = connection;
        this.resources = resources;

        resources.load();
        arch.load();

        this.game = new GameData(resources, display.initGrid(), display.initPlayer());
    }

    public synchronized void init() {
        this.setSize(Settings.SCREEN_WIDTH.parseInt(), Settings.SCREEN_HEIGHT.parseInt());
        this.setIconImage(Resources.LOGO);
        this.setTitle(Localized.KHAOS_ENGINE.getLocalized() + " v" + KhaosEngine.VERSION);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public synchronized void start() {
        connection.addCommand(new CharacterSelectCommand());
    }

    public synchronized void openCharacterSelect() {
        CharacterSelect select = new CharacterSelect(connection);
        this.display.add(select);
        select.init();
    }

    public synchronized GameData getGame() {
        return game;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 579, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables
}//End Class
