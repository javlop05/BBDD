/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abd.p1.view;

import abd.p1.controller.ModificarPerfilController;
import abd.p1.model.Usuario;
import java.awt.Color;
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class UsuarioCellRenderer extends UserPanel implements ListCellRenderer<Usuario>{

    @Override
    public Component getListCellRendererComponent(JList<? extends Usuario> list, Usuario value, int index, boolean isSelected, boolean cellHasFocus) {
        this.rellenarInfo(value.getNombre(), value.getImagen(), value.getFechaNac());
        this.setOpaque(true);
        this.setEditable(false);
        if (value.getAvatar() != null){
            this.setIcon(new ImageIcon(value.getAvatar()));
        } else {
            this.setIcon(null);
        }
        if(isSelected){
            this.setBackground(Color.YELLOW);
        }
        else{
            this.setBackground(Color.WHITE);
        }
        return this;
    }
    
}
