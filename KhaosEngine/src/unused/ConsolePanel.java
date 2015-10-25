package unused;

/**
 *
 * @author endbringer10
 * @since 20151025
 */
public class ConsolePanel extends javax.swing.JPanel {

    public ConsolePanel() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        consoleTextArea1 = new com.khaos.core.system.ConsoleTextArea();

        setBorder(javax.swing.BorderFactory.createEtchedBorder());

        consoleTextArea1.setColumns(20);
        consoleTextArea1.setRows(5);
        consoleTextArea1.addHierarchyBoundsListener(new java.awt.event.HierarchyBoundsListener() {
            public void ancestorMoved(java.awt.event.HierarchyEvent evt) {
            }
            public void ancestorResized(java.awt.event.HierarchyEvent evt) {
                consoleTextArea1AncestorResized(evt);
            }
        });
        jScrollPane1.setViewportView(consoleTextArea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void consoleTextArea1AncestorResized(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_consoleTextArea1AncestorResized
        // TODO add your handling code here:
    }//GEN-LAST:event_consoleTextArea1AncestorResized

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.khaos.core.system.ConsoleTextArea consoleTextArea1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}//End Class
