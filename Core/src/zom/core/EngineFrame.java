package zom.core;

import com.khaos.core.interfaces.GuiHook;

/**
 *
 * @author endbringer10
 * @since 20151211
 */
public class EngineFrame extends javax.swing.JFrame {

    private final GuiHook engine;

    private EngineFrame(GuiHook engine) {
        initComponents();
        this.engine = engine;
    }

    public void init() {
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public static void invokeLater(GuiHook engine) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                EngineFrame frame = new EngineFrame(engine);
                frame.init();

                engine.openGUI(frame);
            }
        });
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
