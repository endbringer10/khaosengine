package com.khaos.core.gui.frame;

import com.khaos.core.Localized;
import com.khaos.core.data.packets.GameInitPacket;
import com.khaos.core.interfaces.EngineHook;

/**
 *
 * @author endbringer10
 * @since 20151211
 */
public class UpdateFrame extends javax.swing.JFrame {

    private final EngineHook engine;

    public UpdateFrame(EngineHook engine) {
        initComponents();
        this.progressBar.setIndeterminate(true);
        this.setTitle(Localized.UPDATING.getLocalized());

        this.engine = engine;
    }

    public void start() {
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        new Thread() {

            @Override
            public synchronized void run() {
                new GameInitPacket().process(engine);
                close();
            }
        }.start();
    }

    private void close() {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                dispose();
            }
        });
    }

    public static void invokeLater(EngineHook engine) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new UpdateFrame(engine).start();
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        progressBar = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(progressBar, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar progressBar;
    // End of variables declaration//GEN-END:variables
}//End Class
