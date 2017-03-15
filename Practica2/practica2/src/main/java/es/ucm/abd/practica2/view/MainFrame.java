package es.ucm.abd.practica2.view;

import es.ucm.abd.practica2.controller.FightController;
import es.ucm.abd.practica2.controller.FightResult;
import es.ucm.abd.practica2.controller.SearchPanelController;
import es.ucm.abd.practica2.model.Abedemon;
import javax.swing.JOptionPane;

/**
 * Ventana principal.
 *
 * @author Manuel Montenegro (mmontene@ucm.es)
 */
public class MainFrame extends javax.swing.JFrame {

    private FightController fightController;
    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
    }
    
    public MainFrame(SearchPanelController controller1,
            SearchPanelController controller2,
            FightController fightController) {
        initComponents();
        searchPanel1.setController(controller1);
        searchPanel2.setController(controller2);
        this.fightController = fightController;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        searchPanel1 = new es.ucm.abd.practica2.view.SearchPanel();
        searchPanel2 = new es.ucm.abd.practica2.view.SearchPanel();
        jPanel1 = new javax.swing.JPanel();
        botonLucha = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Abedemon");
        getContentPane().setLayout(new java.awt.GridBagLayout());

        searchPanel1.setBackground(new java.awt.Color(255, 204, 255));
        searchPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 2);
        getContentPane().add(searchPanel1, gridBagConstraints);

        searchPanel2.setBackground(new java.awt.Color(204, 255, 204));
        searchPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 3, 5, 5);
        getContentPane().add(searchPanel2, gridBagConstraints);

        botonLucha.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        botonLucha.setText("Lucha");
        botonLucha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonLuchaActionPerformed(evt);
            }
        });
        jPanel1.add(botonLucha);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 10, 0);
        getContentPane().add(jPanel1, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonLuchaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonLuchaActionPerformed
        Abedemon abedemon1 = searchPanel1.getSelectedAbedemon();
        Abedemon abedemon2 = searchPanel2.getSelectedAbedemon();
        if (abedemon1 == null) {
            JOptionPane.showMessageDialog(this, "Abedemon izquierdo no seleccionado", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (abedemon2 == null) {
            JOptionPane.showMessageDialog(this, "Abedemon derecho no seleccionado", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            FightResult res = fightController.fight(abedemon1, abedemon2);
            String winnerMsg = null;
            switch(res.getWinner()) {
                case ONE: winnerMsg = "Gana " + res.getAbedemon1().getNombre(); break;
                case TWO: winnerMsg = "Gana " + res.getAbedemon2().getNombre(); break;
                case TIE: winnerMsg = "Empate";
            }
            
            JOptionPane.showMessageDialog(this, 
                    res.getAbedemon1().getNombre() + " recibe daño " + res.getDamage1() + "\n" +
                            res.getAbedemon2().getNombre() + " recibe daño " + res.getDamage2() + "\n" +
                            winnerMsg
                    );
        }
    }//GEN-LAST:event_botonLuchaActionPerformed

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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonLucha;
    private javax.swing.JPanel jPanel1;
    private es.ucm.abd.practica2.view.SearchPanel searchPanel1;
    private es.ucm.abd.practica2.view.SearchPanel searchPanel2;
    // End of variables declaration//GEN-END:variables
}
