package com.khaos;

/**
 *
 * @author endbringer10
 * @since 20151209
 */
public class AboutGame extends javax.swing.JFrame {
    
    private static final String CONNECTION_TYPE = "Online/Offline";
    public static final String VERSION = "1.0";
    
    public AboutGame() {
        initComponents();
    }
    
    public void init() {
        this.setTitle("Game Module");
        this.labelVersion.setText("Version: " + VERSION);
        this.labelConnectionType.setText("Connection Type: " + CONNECTION_TYPE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelConnectionType = new javax.swing.JLabel();
        labelVersion = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        labelConnectionType.setText("jLabel1");

        labelVersion.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelVersion)
                    .addComponent(labelConnectionType))
                .addContainerGap(256, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelVersion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelConnectionType)
                .addContainerGap(155, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AboutGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }//</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AboutGame().init();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel labelConnectionType;
    private javax.swing.JLabel labelVersion;
    // End of variables declaration//GEN-END:variables
}//End Class
