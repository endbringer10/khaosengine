package com.khaos.core.gui.frame;

import com.khaos.system.Errors;
import com.khaos.system.SysLog;
import java.awt.Insets;
import javax.swing.JPanel;
import zom.core.Localized;
import zom.core.Resources;

/**
 *
 * @author endbringer10
 * @since 20151209
 * @note handle negative numbers with Math.abs
 */
public class SplashFrame extends javax.swing.JFrame {

    private static final int PADDING = 10;
    private static final int DEFAULT_WAIT = 5000; //0 for infinite timeout
    private final int wait;
    private final JPanel display;

    private SplashFrame(JPanel display) {
        initComponents();
        this.setIconImage(Resources.LOGO);
        this.setTitle(Localized.LOADING.getLocalized());
        this.display = display;
        this.wait = DEFAULT_WAIT;
    }

    public void start() {
        Insets iFrame = this.getInsets();

        this.add(display);
        display.setSize(display.getPreferredSize());
        display.setLocation(PADDING, PADDING);
        this.setSize(display.getWidth() + (PADDING * 2) + iFrame.left + iFrame.right, display.getHeight() + (PADDING * 2) + iFrame.top + iFrame.bottom);

        display.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        new Thread() {

            @Override
            public synchronized void run() {
                if (wait != 0) { //wait of 0 means infinite time
                    try {
                        this.wait(wait);
                        close();
                    } catch (InterruptedException ex) {
                        SysLog.err(Errors.TIMED_DISPLAY_FRAME_WAIT_INTTERUPT, ex);
                    }
                }
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

    public static void newInstance(JPanel panel) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SplashFrame(panel).start();
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
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}//End Class
