/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abd.p1.view;

import abd.p1.model.Usuario;

/**
 *
 * @author enriq
 */
public class InformacionPerfil extends javax.swing.JDialog {

    private int distancia;

    /**
     * Creates new form dialogoInformacionPerfil
     */
    public InformacionPerfil(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        panelPerfil.setEditable(false);
    }
    
    public void rellenarInfo(Usuario modelo, Usuario user) {
        panelPerfil.rellenarDatos(user);
        // Calcular distancia entre usuarios
        int d = (int) distancia(Math.PI*modelo.getLatitud()/180, Math.PI*modelo.getLongitud()/180, Math.PI*user.getLatitud()/180, Math.PI*user.getLongitud()/180);
        this.labelMetros.setText(d + " metros");
    }
    
    private double expresionSeno(double incremento) {
	return Math.sin(incremento / 2) * Math.sin(incremento / 2);
    }

    private double distancia(double lat1, double long1, double lat2, double long2) {
        //Suponer que recibe los parámetros en radianes
	double a;
	int R = 6371000;
	double c;
	a = expresionSeno(Math.abs(lat1 - lat2)) + Math.cos(lat1) * Math.cos(lat2) * expresionSeno(Math.abs(long1 - long2));
	c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
	return R * c;
    }
    
    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonPeticionAmistad = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        panelPerfil = new abd.p1.view.PanelPerfil();
        tabCompatibilidad = new abd.p1.view.TabCompatibilidad();
        tabChat = new abd.p1.view.TabChat();
        labelDistancia = new javax.swing.JLabel();
        labelMetros = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        buttonPeticionAmistad.setText("Enviar petición de amistad");

        jTabbedPane1.addTab("Perfil", panelPerfil);
        jTabbedPane1.addTab("Compatibilidad", tabCompatibilidad);
        jTabbedPane1.addTab("Chat", tabChat);

        labelDistancia.setText("Distancia:");

        labelMetros.setText("200 m");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(labelDistancia, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelMetros)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonPeticionAmistad, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonPeticionAmistad)
                    .addComponent(labelDistancia)
                    .addComponent(labelMetros))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(InformacionPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InformacionPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InformacionPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InformacionPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                InformacionPerfil dialog = new InformacionPerfil(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonPeticionAmistad;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel labelDistancia;
    private javax.swing.JLabel labelMetros;
    private abd.p1.view.PanelPerfil panelPerfil;
    private abd.p1.view.TabChat tabChat;
    private abd.p1.view.TabCompatibilidad tabCompatibilidad;
    // End of variables declaration//GEN-END:variables
}
