package abd.p1.controller;

import java.util.Date;

import javax.swing.JOptionPane;

import com.toedter.calendar.JDateChooser;

import abd.p1.bd.DAOUsuario;
import abd.p1.model.Genero;
import abd.p1.model.Usuario;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ModificarPerfilController {
	private DAOUsuario dao;
	private Usuario model;
        /*  Este booleano nos indica si se esta editando un usuario ya creado o
            se esta creando uno nuevo */
        boolean edit;
	
	public ModificarPerfilController (DAOUsuario dao, Usuario model, boolean edit) {
		this.dao = dao;
		this.model = model;
                this.edit = edit;
	}
	
	public boolean guardarCambios(String descripcion) {
		//Comprobamos que ha rellenado los campos obligatorios
                //Al crear un nuevo usuario por defecto tiene estos valores
		if (model.getNombre().isEmpty()) {
                    JOptionPane.showMessageDialog(null, 
                                            "Debe introducir un nombre", "Error", JOptionPane.ERROR_MESSAGE);
		} else if (model.getContrasena().isEmpty()) {
                    JOptionPane.showMessageDialog(null, 
                                            "Debe tener una contraseña", "Error", JOptionPane.ERROR_MESSAGE);
		} else if (model.getGenero() == null) {
                    JOptionPane.showMessageDialog(null, 
                                            "Debe especificar su género", "Error", JOptionPane.ERROR_MESSAGE);			
		/* } else if (model.getLatitud() != -1) {
                    JOptionPane.showMessageDialog(null, 
                                            "Debe introducir un nombre", "Error", JOptionPane.ERROR_MESSAGE);			
		} else if (model.getLongitud() != -1) {
                    JOptionPane.showMessageDialog(null, 
                                            "Debe introducir un nombre", "Error", JOptionPane.ERROR_MESSAGE);*/
		} else if (model.getGeneroInteres() == null) {
                    JOptionPane.showMessageDialog(null, 
                                            "Debe especificar sus gustos", "Error", JOptionPane.ERROR_MESSAGE);			
		} else {
                        model.setDescripcion(descripcion);
                        if (edit) {
                            dao.actualizarUsuario(model);
                        } else {
                            dao.insertarUsuario(model);
                        }
                        return true;
		}
                return false;
	}
	
	public String cambiarNombre() {
		String nombre = JOptionPane.showInputDialog("Introduce tu nombre:", model.getNombre());
		if (nombre != null && !nombre.isEmpty()) {
                    model.setNombre(nombre);
                    return nombre;
                } 
                return null;
        }
            
	public void cambiarContraseña() {
		String contraseña = JOptionPane.showInputDialog("Introduce tu contraseña:", model.getContrasena());
		if (contraseña != null && !contraseña.isEmpty()) {
                    model.setContrasena(contraseña);
                }
	}
	
	public String cambiarFechaNacimiento() {
		int edad;
		
		JDateChooser jdc = new JDateChooser();
                JOptionPane.showMessageDialog(null, jdc, "Fecha de nacimiento", JOptionPane.QUESTION_MESSAGE);
                
		Date fechaNac = jdc.getDate();
                if (fechaNac != null) {
                    edad = Usuario.calcularEdad(fechaNac);
                    if (edad > 18) {
                            model.setFechaNac(fechaNac);
                            return edad + "";
                    } else {
                            JOptionPane.showMessageDialog(null, 
                                            "Debe ser mayor de edad", "Vete a ligar al colegio", JOptionPane.ERROR_MESSAGE);
                    }
                }
                return null;
	}
	
	public ImageIcon cambiarAvatar () {
            JFileChooser jfc = new JFileChooser();
            FileNameExtensionFilter extension = new FileNameExtensionFilter("JPG, PNG & GIF", "JPG", "PNG", "GIF");
            jfc.setFileFilter(extension);
            int result = jfc.showOpenDialog(null);
            
            if (result == JFileChooser.APPROVE_OPTION) {
                File archivo = jfc.getSelectedFile();
                ImageIcon icon = new ImageIcon(archivo.getPath());
                byte[] array = toByteArray(icon);
                if (array.length == 0) {
                     JOptionPane.showMessageDialog(null, 
					"Avatar seleccionado no válido", "Error", JOptionPane.ERROR_MESSAGE);
			return null;
                }
                model.setImagen(array);
                return new ImageIcon(array);
            } else {
                return null;
            }   
	}
        
        private byte[] toByteArray(ImageIcon icon) {
            BufferedImage bi = new BufferedImage(
                          icon.getIconWidth(), icon.getIconHeight(),
                          BufferedImage.TYPE_INT_RGB
                       );
            Graphics g = bi.getGraphics();
            icon.paintIcon(null, g, 0, 0);
            g.dispose();
            
            ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
            try {
                ImageIO.write(bi, "png", byteStream);
            } catch (IOException ex) {
                Logger.getLogger(ModificarPerfilController.class.getName()).log(Level.SEVERE, null, ex);
                byte[] vacio = {};
                return vacio;
            }
            byte[] array = byteStream.toByteArray();
            
            return array;
        }
	
	public String añadirAficion () {
            String aficion = JOptionPane.showInputDialog("Introduce la aficion:");
            if (aficion != null && !aficion.isEmpty()) {
                model.addAficion(aficion);
                return aficion;
            }
            return null;
	}
	
	public void eliminarAficion(String aficion) {
            model.deleteAficion(aficion);
	}
	
	public String editarAfición (String aficion) {
            String nuevaAficion = JOptionPane.showInputDialog("Introduce la aficion:", aficion);
            if (nuevaAficion != null && !nuevaAficion.isEmpty()) {
                model.deleteAficion(aficion);
                model.addAficion(nuevaAficion);
                return nuevaAficion;
            }
            return aficion;
	}
        
         public Genero cambiarSexo() {
            JComboBox cb = new JComboBox();
            cb.addItem(Genero.Masculino);
            cb.addItem(Genero.Femenino);
            JOptionPane.showMessageDialog(null, cb, "Introduzca su género", JOptionPane.QUESTION_MESSAGE);
            Genero g = (Genero) cb.getSelectedItem();
            model.setGenero(g);
            return g;
        }
        
        public Genero cambiarPreferencia() {
            JComboBox cb = new JComboBox();
            for (Genero g: Genero.values()) {
                cb.addItem(g);
            }
            JOptionPane.showMessageDialog(null, cb, "Que busca?", JOptionPane.QUESTION_MESSAGE);
            Genero g = (Genero) cb.getSelectedItem();
            model.setGeneroInteres(g);
            return g;
        }
    
}
