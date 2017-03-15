package abd.p1.controller;

import javax.swing.JOptionPane;
import abd.p1.bd.DAOUsuario;
import abd.p1.model.Usuario;
import abd.p1.view.ModificarPerfil;
import abd.p1.view.VentanaPrincipal;

public class LoginController {
	private DAOUsuario dao;
	
	public LoginController(DAOUsuario dao) {
		this.dao = dao;
	}
	
	public boolean iniciarSesion(String correo, String contraseña) {
		if (correo == null || correo.trim().isEmpty() ||
				contraseña == null || contraseña.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, 
					"Rellene los campos por favor.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    Usuario user = dao.obtenerUsuarioExistente(correo, contraseña);
                    if (user != null) {
			
                        VentanaPrincipalController vpc = new VentanaPrincipalController(dao, user);
			VentanaPrincipal vp = new VentanaPrincipal(vpc);
                        vp.setVisible(true);
                      
                        return true;
                    } else {
			JOptionPane.showMessageDialog(null, 
					"Datos introducidos incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
                    }
		}
            return false;
	}
	
	public void nuevoUsuario(String correo) {
		if (correo != null && !correo.trim().isEmpty() &&
				!dao.comprobarCorreoExiste(correo)) {
			Usuario user = new Usuario(correo);
			
                        //False indica que no estamos editando usuario
			ModificarPerfilController mpc = new ModificarPerfilController(dao, user, false);
			ModificarPerfil modificar = new ModificarPerfil(mpc);
			
			modificar.setModal(true);
                        modificar.setVisible(true);
			
		} else {
			JOptionPane.showMessageDialog(null, 
					"El correo introducido ya está en uso", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
}
