/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abd.p1.controller;

import abd.p1.bd.DAOUsuario;
import abd.p1.model.Usuario;

/**
 *
 * @author enriq
 */
class PreguntaController {

    private DAOUsuario dao;
    private Usuario model;

    public PreguntaController(DAOUsuario dao, Usuario model) {
        this.dao = dao;
        this.model = model;
    }
    
    
    
}
