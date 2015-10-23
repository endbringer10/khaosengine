package unused;

import java.awt.Color;
import javax.swing.JPanel;

/**
 *
 * @author endbr
 */
public class NewJFrame extends javax.swing.JFrame {

    public NewJFrame() {
        initComponents();
    }

    public void init() {
        //JLayeredPane pane = JLayeredPane.getLayeredPaneAbove(this.jDesktopPane1);
        //JLayeredPane pane = this.jDesktopPane1;
        //System.out.println(pane);
        //pane.setSize(new Dimension(500, 500));
        //pane.setLocation(10, 10);
        //pane.setBorder(new EtchedBorder());
        //this.add(pane);

        JPanel red = new JPanel();
        red.setSize(50, 50);
        red.setLocation(10, 10);
        red.setBackground(Color.red);

        JPanel blue = new JPanel();
        blue.setSize(50, 50);
        blue.setLocation(20, 20);
        blue.setBackground(Color.blue);

        JPanel green = new JPanel();
        green.setSize(50, 50);
        green.setLocation(30, 30);
        green.setBackground(Color.green);

        //Items added first are on top
        this.jDesktopPane1.add(red);
        this.jDesktopPane1.add(blue);
        this.jDesktopPane1.add(green);

        //lower number is on the bottom
        this.jDesktopPane1.setLayer(red, 0);
        this.jDesktopPane1.setLayer(blue, 0);
        this.jDesktopPane1.setLayer(green, 0);

        //lower number is on the top
        //1000-coordY = position
        this.jDesktopPane1.setPosition(red, 1);
        this.jDesktopPane1.setPosition(blue, 0);
        this.jDesktopPane1.setPosition(green, 2);

        System.out.println(this.jDesktopPane1.getLayer(red));
        System.out.println(this.jDesktopPane1.getLayer(blue));
        System.out.println(this.jDesktopPane1.getLayer(green));

        System.out.println(this.jDesktopPane1.getPosition(red));
        System.out.println(this.jDesktopPane1.getPosition(blue));
        System.out.println(this.jDesktopPane1.getPosition(green));

        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addHierarchyBoundsListener(new java.awt.event.HierarchyBoundsListener() {
            public void ancestorMoved(java.awt.event.HierarchyEvent evt) {
            }
            public void ancestorResized(java.awt.event.HierarchyEvent evt) {
                formAncestorResized(evt);
            }
        });

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 377, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jDesktopPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jDesktopPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formAncestorResized(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_formAncestorResized
        // TODO add your handling code here:
    }//GEN-LAST:event_formAncestorResized

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame().init();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPane1;
    // End of variables declaration//GEN-END:variables
}
