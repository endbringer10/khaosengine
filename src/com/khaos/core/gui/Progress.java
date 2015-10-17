package com.khaos.core.gui;

import com.khaos.core.Localized;
import com.khaos.core.data.Resources;
import com.khaos.core.gui.progress.SplashPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import unused.NewJFrame;

/**
 *
 * @author endbr
 */
public class Progress extends javax.swing.JFrame {

    private static final int PADDING = 10;

    public Progress(String title) {
        this.initComponents();
        this.setTitle(title);
        Insets iFrame = this.getInsets();

        JProgressBar progress = new JProgressBar();
        progress.setIndeterminate(true);
        progress.setSize(300, 25);
        this.panelHolder.add(progress);
        progress.setLocation(PADDING, PADDING);

        this.panelHolder.setSize(progress.getWidth() + (PADDING * 2), progress.getHeight() + (PADDING * 2));
        this.setSize(panelHolder.getWidth() + iFrame.left + iFrame.right, panelHolder.getHeight() + iFrame.top + iFrame.bottom);
    }

    public Progress(JPanel panel, String title) {
        this.initComponents();
        this.setTitle(title);

        if (panel == null) {
            panel = new JPanel();
            panel.setSize(300, 1);
        } else {
            panel.setSize(panel.getPreferredSize());
        }

        Insets iFrame = this.getInsets();

        JProgressBar progress = new JProgressBar();
        progress.setIndeterminate(true);
        progress.setSize(panel.getWidth(), 25);

        this.panelHolder.add(panel);
        this.panelHolder.add(progress);

        panel.setLocation(PADDING, PADDING);
        progress.setLocation(PADDING, panel.getHeight() + (PADDING * 2));

        this.panelHolder.setSize(panel.getWidth() + (PADDING * 2), panel.getHeight() + progress.getHeight() + (PADDING * 3));
        this.setSize(panelHolder.getWidth() + iFrame.left + iFrame.right, panelHolder.getHeight() + iFrame.top + iFrame.bottom);
    }

    public void init() {
        this.setIconImage(Resources.LOGO);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelHolder = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout panelHolderLayout = new javax.swing.GroupLayout(panelHolder);
        panelHolder.setLayout(panelHolderLayout);
        panelHolderLayout.setHorizontalGroup(
            panelHolderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );
        panelHolderLayout.setVerticalGroup(
            panelHolderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelHolder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelHolder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel panelHolder;
    // End of variables declaration//GEN-END:variables
}//End Class
