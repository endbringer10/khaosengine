package com.khaos.client;

import com.khaos.client.data.CharacterSelectCommand;
import com.khaos.core.KhaosEngine;
import com.khaos.core.Localized;
import com.khaos.core.Settings;
import com.khaos.core.connection.ConnectionHook;
import com.khaos.core.data.Architecture;
import com.khaos.core.data.GameData;
import com.khaos.core.data.Resources;
import com.khaos.core.gui.DisplayPane;
import com.khaos.core.gui.EngineGUI;
import javax.swing.JInternalFrame;

/**
 *
 * @author endbr
 */
public class Game extends javax.swing.JFrame implements EngineGUI {

    private final Architecture arch = new Architecture();
    private final Resources resources;
    private final GameData data;
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

        this.data = new GameData(resources, display.initGrid(), display.initPlayer());
    }

    @Override
    public synchronized void init() {
        this.setSize(Settings.SCREEN_WIDTH.parseInt(), Settings.SCREEN_HEIGHT.parseInt());
        this.setIconImage(Resources.LOGO);
        this.setTitle(Localized.KHAOS_ENGINE.getLocalized() + " v" + KhaosEngine.VERSION);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    @Override
    public synchronized void start() {
        connection.addCommand(new CharacterSelectCommand());
    }

    @Override
    public synchronized GameData getGuiData() {
        return data;
    }

    @Override
    public void openInternalFrame(JInternalFrame frame) {
        this.display.add(frame);
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
