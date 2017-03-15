package es.ucm.abd.practica2.dao;

import es.ucm.abd.practica2.model.Abedemon;
import java.util.List;
import javax.xml.xquery.XQDataSource;

/**
 * Implementación concreta del DAO que hace llamadas a eXist.
 * 
 * @author Manuel Montenegro (mmontene@ucm.es)
 */
public class AbedemonDAOImpl implements AbedemonDAO {

    private final XQDataSource ds;

    public AbedemonDAOImpl(XQDataSource ds) {
        this.ds = ds;
    }

    
    /**
     * Obtiene los tipos de especies disponibles en la BD.
     * 
     * @return Lista de tipos de especies (sin duplicados)
     */
    @Override
    public List<String> getTypes() {
        // TODO: Implementar
        System.err.println("getTypes() not implemented yet");
        return null;
    }

    /**
     * Obtiene las especies de abedemon de un determinado.
     * 
     * @param type Tipo a buscar
     * @return Especies encontradas del tipo pasado como parámetro.
     */
    @Override
    public List<Abedemon> getAbedemonsOf(String type) {
        // TODO: Implementar
        System.err.println("getAbedemonsOf() not implemented yet");
        return null;
    }

    /**
     * Obtiene la descripción de una especie de abedemon.
     * 
     * @param id ID de la especie a describir
     * @return Código XHTML con la descripción de la especie
     */
    @Override
    public String getAbedemonDescription(String id) {
        // TODO: Implementar
        System.err.println("getAbedemonDescription() not implemented yet");
        return null;
    }

    /**
     * Obtiene el daño máximo recibido por un abedemon de una especie dada al
     * ser atacado por otro.
     * 
     * @param idAttacker ID de la especie del atacante.
     * @param idReceiver ID de la especie que recibe el daño.
     * @return Máximo daño que puede infligir el atacante.
     */
    @Override
    public Integer getDamage(String idAttacker, String idReceiver) {
        // TODO: Implementar (parte opcional)
        System.err.println("getDamage() not implemented yet");
        return null;
    }
}
