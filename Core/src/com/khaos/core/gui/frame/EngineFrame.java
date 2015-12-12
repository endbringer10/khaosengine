package com.khaos.core.gui.frame;

import com.khaos.core.interfaces.EngineHook;

/**
 *
 * @author endbringer10
 * @since 20151211
 */
public class EngineFrame extends javax.swing.JFrame {

    public EngineFrame(EngineHook engine) {
        initComponents();
    }

    public void init() {
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public static void invokeLater(EngineHook engine) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new EngineFrame(engine).init();
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
