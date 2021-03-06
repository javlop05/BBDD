package p1admin.adminview;

import javax.swing.ListModel;

import p1admin.admincontroller.QuestionController;
import p1admin.model.Opcion;

/**
 * Cuadro de diálogo del editor de una pregunta.
 *
 * @author Manuel Montenegro (mmontene@ucm.es)
 */
public class QuestionEditor extends javax.swing.JDialog {
	private static final long serialVersionUID = 1L;
	private QuestionController controller;
    
    /**
     * Creates new form QuestionEditor
     */
    public QuestionEditor(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
    public QuestionEditor(QuestionController controller, ListModel<Opcion> answersModel) {
        this(null, true);
        this.controller = controller;
        labelTexto.setText(controller.getQuestionStatement());
        listItems.setCellRenderer(new AnswerCellRenderer());
        listItems.setModel(answersModel);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelTexto = new javax.swing.JLabel();
        buttonCambiarTexto = new javax.swing.JButton();
        labelRespuestas = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listItems = new javax.swing.JList<>();
        panelButtons = new javax.swing.JPanel();
        buttonNueva = new javax.swing.JButton();
        buttonEditar = new javax.swing.JButton();
        buttonEliminar = new javax.swing.JButton();
        buttonMoverArriba = new javax.swing.JButton();
        buttonMoverAbajo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Editar pregunta");

        labelTexto.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        labelTexto.setText("Texto de pregunta");

        buttonCambiarTexto.setMnemonic('C');
        buttonCambiarTexto.setText("Cambiar...");
        buttonCambiarTexto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCambiarTextoActionPerformed(evt);
            }
        });

        labelRespuestas.setText("Respuestas:");

        jScrollPane1.setViewportView(listItems);

        buttonNueva.setMnemonic('N');
        buttonNueva.setText("Nueva...");
        buttonNueva.setToolTipText("");
        buttonNueva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNuevaActionPerformed(evt);
            }
        });
        panelButtons.add(buttonNueva);

        buttonEditar.setMnemonic('E');
        buttonEditar.setText("Editar...");
        buttonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEditarActionPerformed(evt);
            }
        });
        panelButtons.add(buttonEditar);

        buttonEliminar.setMnemonic('l');
        buttonEliminar.setText("Eliminar");
        buttonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEliminarActionPerformed(evt);
            }
        });
        panelButtons.add(buttonEliminar);

        buttonMoverArriba.setMnemonic('M');
        buttonMoverArriba.setText("Mover arriba");
        buttonMoverArriba.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonMoverArribaActionPerformed(evt);
            }
        });
        panelButtons.add(buttonMoverArriba);

        buttonMoverAbajo.setMnemonic('o');
        buttonMoverAbajo.setText("Mover abajo");
        buttonMoverAbajo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonMoverAbajoActionPerformed(evt);
            }
        });
        panelButtons.add(buttonMoverAbajo);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addComponent(panelButtons, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(labelRespuestas)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(labelTexto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonCambiarTexto)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTexto)
                    .addComponent(buttonCambiarTexto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelRespuestas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelButtons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonNuevaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNuevaActionPerformed
        controller.addAnswer();
    }//GEN-LAST:event_buttonNuevaActionPerformed

    private void buttonCambiarTextoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCambiarTextoActionPerformed
        String newStatement = controller.setQuestionStatement();
        if (newStatement != null) {
            labelTexto.setText(newStatement);
        }
    }//GEN-LAST:event_buttonCambiarTextoActionPerformed

    private void buttonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEditarActionPerformed
        Opcion answer = listItems.getSelectedValue();
        if (answer != null) {
            controller.editAnswer(answer);
            listItems.repaint();
        }
    }//GEN-LAST:event_buttonEditarActionPerformed

    private void buttonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEliminarActionPerformed
        Opcion answer = listItems.getSelectedValue();
        if (answer != null) {
            controller.removeAnswer(answer);
        }        
    }//GEN-LAST:event_buttonEliminarActionPerformed

    private void buttonMoverArribaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonMoverArribaActionPerformed
        Opcion answer = listItems.getSelectedValue();
        if (answer != null) {
            controller.moveAnswerUp(answer);
            listItems.setSelectedValue(answer, true);
        }
    }//GEN-LAST:event_buttonMoverArribaActionPerformed

    private void buttonMoverAbajoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonMoverAbajoActionPerformed
        Opcion answer = listItems.getSelectedValue();
        if (answer != null) {
            controller.moveAnswerDown(answer);
            listItems.setSelectedValue(answer, true);
        }
    }//GEN-LAST:event_buttonMoverAbajoActionPerformed

    
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
            java.util.logging.Logger.getLogger(QuestionEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuestionEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuestionEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuestionEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                QuestionEditor dialog = new QuestionEditor(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton buttonCambiarTexto;
    private javax.swing.JButton buttonEditar;
    private javax.swing.JButton buttonEliminar;
    private javax.swing.JButton buttonMoverAbajo;
    private javax.swing.JButton buttonMoverArriba;
    private javax.swing.JButton buttonNueva;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelRespuestas;
    private javax.swing.JLabel labelTexto;
    private javax.swing.JList<Opcion> listItems;
    private javax.swing.JPanel panelButtons;
    // End of variables declaration//GEN-END:variables
}
