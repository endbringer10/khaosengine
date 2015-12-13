package zom.core;

import com.khaos.core.gui.DisplayPane;
import com.khaos.core.gui.enums.Alignment;
import com.khaos.core.gui.enums.Resizeable;
import com.khaos.core.gui.internalframe.GuiWindow;
import com.khaos.core.gui.panel.ConsolePanel;
import com.khaos.core.interfaces.EngineHook;

public class EngineFrame extends javax.swing.JFrame {

    private final EngineHook engine;
    private final DisplayPane pane;

    private EngineFrame(EngineHook engine) {
        initComponents();
        this.engine = engine;
        pane = new DisplayPane();
    }

    private void init() {
        this.add(pane);
        pane.init();

        this.setIconImage(Resources.LOGO);
        this.setTitle(Localized.KHAOS_ENGINE.getLocalized());
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public void start() {
        GuiWindow.newInstance(engine, new ConsolePanel(), Localized.CONSOLE.getLocalized(), Resizeable.TRUE, Alignment.BOTTOM_LEFT);
    }

    public void addWindow(GuiWindow window) {
        this.pane.add(window);
    }

    public static EngineFrame newInstance(EngineHook engine) {
        final EngineFrame frame = new EngineFrame(engine);

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                //EngineFrame frame = new EngineFrame(engine);
                frame.init();
            }
        });

        return frame;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}//End Class
