/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abd.p1.controller;


import abd.p1.bd.DAOUsuario;
import abd.p1.model.Pregunta;
import abd.p1.model.Usuario;
import abd.p1.view.InformacionPerfil;
import abd.p1.view.ModificarPerfil;
import abd.p1.view.ResponderPregunta;
import java.util.List;
import javax.swing.DefaultListModel;

/**
 *
 * @author enriq
 */
public class VentanaPrincipalController {

    private final DAOUsuario dao;
    private final Usuario model;
    

    public VentanaPrincipalController(DAOUsuario dao, Usuario user) {
        this.dao = dao;
        this.model = user;
    }

    public void modificarPerfil() {
        ModificarPerfilController mpc = new ModificarPerfilController(dao, model, true);
	ModificarPerfil modificar = new ModificarPerfil(mpc, model);
			
	modificar.setModal(true);
        modificar.setVisible(true);
    }
    
    public List<Usuario> cargarListaUsuarios() {
        System.out.println("Correo: " + model.getCorreo());
        System.out.println("Genero interes: " + model.getGeneroInteres());
        System.out.println("Genero: " + model.getGenero());
        return dao.obtenerUsuarios(model.getCorreo(), model.getGeneroInteres(), model.getGenero());
    }
    
    public List<Usuario> cargarListaUsuariosFiltrados(String filtro){
        return dao.getUsuariosFiltradosPorNombre(filtro);
    }
    
    public List<Pregunta> cargarListaPreguntas(){
        return dao.cargarTopPreguntas();
    }
    
    public void verPerfil(Usuario seleccionado) {
        InformacionPerfil infoPerfil = new InformacionPerfil(null, true);
        infoPerfil.rellenarInfo(this.model, seleccionado);
        infoPerfil.setVisible(true);
    }
    
    public void responderPregunta(Pregunta p) {
       PreguntaController pc = new PreguntaController(dao, model);
       ResponderPregunta rp = new ResponderPregunta(new java.awt.Frame(), true, p);
       rp.setModal(true);
       rp.setVisible(true);
    }

    public List<Usuario> cargarListaUsuariosFiltradosDistancia(String filtro, boolean selected) {
        return dao.getUsuariosFiltradosDistancia(filtro, selected, this.model);
    }
}
