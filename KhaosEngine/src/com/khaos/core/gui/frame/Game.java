package com.khaos.core.gui.frame;

import com.khaos.core.EngineHook;
import com.khaos.core.KhaosEngine;
import com.khaos.core.data.Architecture;
import com.khaos.core.data.Resources;
import com.khaos.core.data.commands.CharacterSelectCommand;
import com.khaos.core.data.commands.MoveCommand;
import com.khaos.core.data.game.GameData;
import com.khaos.core.data.game.HardCap;
import com.khaos.core.enums.Direction;
import com.khaos.core.enums.KeyBinds;
import com.khaos.core.enums.Localized;
import com.khaos.core.enums.Settings;
import com.khaos.core.enums.gui.Alignment;
import com.khaos.core.enums.gui.Closeable;
import com.khaos.core.enums.gui.Iconifiable;
import com.khaos.core.enums.gui.Maximizable;
import com.khaos.core.enums.gui.Resizeable;
import com.khaos.core.gui.DisplayPane;
import com.khaos.core.gui.EngineGUI;
import com.khaos.core.gui.internalframe.KeyBoundFrame;
import com.khaos.core.gui.internalframe.PanelHolder;
import com.khaos.core.gui.panel.MenuPanel;
import com.khaos.core.system.SysLog;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JInternalFrame;
import org.joda.time.DateTime;

/**
 *
 * @author endbr
 */
public class Game extends javax.swing.JFrame implements EngineGUI {

    private final int MOVE_DELAY_MILLIS = 300;

    private final Architecture arch = new Architecture();
    private final GameData data;
    private final EngineHook engine;
    private final DisplayPane display;

    private DateTime nextMove = DateTime.now();

    public Game(EngineHook engine) {
        initComponents();

        this.engine = engine;
        display = new DisplayPane();
        this.add(display);
        display.init();

        engine.getResources().load();
        arch.load();

        this.data = new GameData(engine.getResources(), display.initGrid(), display.initPlayer());
        this.openConsole();        
    }

    @Override
    public synchronized void init() {
        this.setSize(Settings.SCREEN_WIDTH.parseInteger(), Settings.SCREEN_HEIGHT.parseInteger());
        this.setIconImage(Resources.LOGO);
        this.setTitle(Localized.KHAOS_ENGINE.getLocalized() + " v" + KhaosEngine.VERSION);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    @Override
    public synchronized void start() {
        engine.getConnection().addCommand(new CharacterSelectCommand());
    }

    @Override
    public synchronized GameData getData() {
        return data;
    }

    @Override
    public void openInternalFrame(JInternalFrame frame) {
        this.display.add(frame);
    }

    private void openConsole() {
        PanelHolder frame = new PanelHolder(Localized.CONSOLE.getLocalized(), Alignment.BOTTOM_LEFT, Iconifiable.TRUE, Resizeable.TRUE, Maximizable.TRUE);
        this.display.add(frame);
        frame.addCustom(SysLog.getConsole());
    }

    @Override
    public void addKeyBinds() {
        int focus = JComponent.WHEN_FOCUSED;
        int window = JComponent.WHEN_IN_FOCUSED_WINDOW;
        int ancestor = JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT;

        display.getInputMap(window).put(KeyBinds.UP.getKey(), KeyBinds.UP.getAction());
        display.getActionMap().put(KeyBinds.UP.getAction(), new MoveAction(Direction.UP));

        display.getInputMap(window).put(KeyBinds.DOWN.getKey(), KeyBinds.DOWN.getAction());
        display.getActionMap().put(KeyBinds.DOWN.getAction(), new MoveAction(Direction.DOWN));

        display.getInputMap(window).put(KeyBinds.LEFT.getKey(), KeyBinds.LEFT.getAction());
        display.getActionMap().put(KeyBinds.LEFT.getAction(), new MoveAction(Direction.LEFT));

        display.getInputMap(window).put(KeyBinds.RIGHT.getKey(), KeyBinds.RIGHT.getAction());
        display.getActionMap().put(KeyBinds.RIGHT.getAction(), new MoveAction(Direction.RIGHT));

        display.getInputMap(window).put(KeyBinds.CLOSE.getKey(), KeyBinds.CLOSE.getAction());
        display.getActionMap().put(KeyBinds.CLOSE.getAction(), new EscAction());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

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

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        System.out.println("Checking when Game.formWindowClosing(evt) is called");
        Settings.save();
        KeyBinds.save();
    }//GEN-LAST:event_formWindowClosing

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables

    private class MoveAction extends AbstractAction {

        private final Direction direction;

        public MoveAction(Direction direction) {
            this.direction = direction;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            DateTime now = DateTime.now();
            if (now.isAfter(nextMove)) {
                engine.getConnection().addCommand(new MoveCommand(this.direction));

                int delay = MOVE_DELAY_MILLIS - data.getCharacterSpeed();
                if (delay < HardCap.MOVE_SPEED) {
                    delay = HardCap.MOVE_SPEED;
                }

                nextMove = now.plusMillis(delay);
            }
        }

    }//End Class

    private class EscAction extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {
            PanelHolder menu = new KeyBoundFrame(Localized.MENU.getLocalized(), Closeable.TRUE);
            display.add(menu);
            menu.addCustom(new MenuPanel(engine, menu));
            //display.setLayer(menu, menu.getPreferredLayer());
            //display.setPosition(menu, 0);
        }

    }//End Class

}//End Class
