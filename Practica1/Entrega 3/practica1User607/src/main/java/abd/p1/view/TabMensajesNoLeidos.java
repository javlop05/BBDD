/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abd.p1.view;

import abd.p1.controller.VentanaPrincipalController;

/**
 *
 * @author enriq
 */
public class TabMensajesNoLeidos extends javax.swing.JPanel {

    private VentanaPrincipalController controller;

    /**
     * Creates new form tabMensajesNoLeidos
     */
    public TabMensajesNoLeidos() {
        initComponents();
    }
    void setController(VentanaPrincipalController controller) {
        this.controller = controller;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jListMensajesNoLeidos = new javax.swing.JList<>();
        buttonMarcarLeidos = new javax.swing.JButton();

        jScrollPane1.setViewportView(jListMensajesNoLeidos);

        buttonMarcarLeidos.setText("Marcar todos como leídos");
        buttonMarcarLeidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonMarcarLeidosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonMarcarLeidos, javax.swing.GroupLayout.DEFAULT_SIZE, 501, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonMarcarLeidos)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonMarcarLeidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonMarcarLeidosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonMarcarLeidosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonMarcarLeidos;
    private javax.swing.JList<String> jListMensajesNoLeidos;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
