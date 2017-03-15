package abd.p1.bd;

import abd.p1.model.Genero;
import abd.p1.model.Pregunta;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import abd.p1.model.Usuario;
import java.util.ArrayList;
import java.util.List;

public class DAOUsuario {
	
    private SessionFactory sf;

    public DAOUsuario (SessionFactory sf) {
            this.sf = sf;
    }

    public boolean comprobarCorreoExiste (String correo) {
            boolean encontrado = false;

            Session session = sf.openSession();
            Query query = session.createQuery("FROM Usuario u WHERE u.correo = :correo");
            query.setString("correo", correo);
            encontrado = query.uniqueResult() != null;
            session.close();

            return encontrado;
    }

    public Usuario obtenerUsuarioExistente (String correo, String contraseña) {
            Usuario encontrado;

            Session session = sf.openSession();
            Query query = session.createQuery("FROM Usuario u WHERE u.correo = :correo "
                                                    + "AND u.contrasena = :contrasena");
            query.setString("correo", correo);
            query.setString("contrasena", contraseña);

            encontrado = (Usuario) query.uniqueResult();
            session.close();

            return encontrado;
    }
    
    public List<Usuario> getUsuariosFiltradosPorNombre(String filtro){
        Session session = sf.openSession();
        List<Usuario> usuarios = new ArrayList<Usuario>();
        String consulta = "FROM Usuario u WHERE str(u.nombre) LIKE :filtro ";
        Query query = session.createQuery(consulta);
         query.setString("filtro", "%" + filtro + "%");
        usuarios = (List<Usuario>)query.list();
        session.close();
        return usuarios;
    }
    
    public List<Usuario> getUsuariosFiltradosDistancia(String filtro, boolean activo, Usuario user){
        Session session = sf.openSession();
        List<Usuario> usuarios = new ArrayList<Usuario>();
        String consulta = "FROM Usuario u";
        
        if(activo){
            consulta += " WHERE str(u.nombre) LIKE :filtro";
        }
        consulta += " ORDER BY (u.latitud - :latitud1)*(u.latitud - :latitud2) "
                + "+ (u.longitud - :longitud1)*(u.longitud - :longitud2) asc";
        
        Query query = session.createQuery(consulta);
        if(activo){
            query.setString("filtro", "%" + filtro + "%");
        }
        query.setDouble("latitud1", user.getLatitud());
        query.setDouble("longitud1", user.getLongitud());
        query.setDouble("latitud2", user.getLatitud());
        query.setDouble("longitud2", user.getLongitud());
        query.setMaxResults(20);
        usuarios = (List<Usuario>)query.list();
        session.close();
        return usuarios;
    }
//    
//    public List<String> getAficionesComunes(Usuario user){
//        Session session = sf.openSession();
//        List<String> aficiones = new ArrayList<String>();
//        String consulta = "SELECT distinct ";
//    }

    public void insertarUsuario (Usuario user) {
        Session session = sf.openSession();
        Transaction tr = session.beginTransaction();
        session.save(user);
        tr.commit();
        session.close();
    } 

    public void actualizarUsuario (Usuario user) {
        Session session = sf.openSession();
        Transaction tr = session.beginTransaction();
        session.update(user);
        tr.commit();
        session.close();
    } 

    //Recibe el correo del usuario que esta logueado para no devolverlo en la lista
    public List<Usuario> obtenerUsuarios(String correo, Genero generoInteres, Genero genero) {
        Session session = sf.openSession();
        List<Usuario> usuarios = new ArrayList<Usuario>();

        String consulta = "FROM Usuario u WHERE u.correo <> :correo "
                            + " AND u.genero = :generoInteres"
                            + " AND (u.generoInteres = :genero OR u.generoInteres = 'Ambos')";
        Query query = session.createQuery(consulta);
        query.setString("correo", correo);
        query.setString("generoInteres", generoInteres.toString());
        query.setString("genero", genero.toString());
        usuarios = (List<Usuario>)query.list();
        session.close();
        return usuarios;
    }
    

    public List<Pregunta> cargarTopPreguntas(){
        Session session = sf.openSession();
        List<Pregunta> l = new ArrayList<Pregunta>();
        Query query = session.createQuery("SELECT p "
                + "FROM Responde as r "
                + "RIGHT JOIN r.respuesta AS o "
                + "JOIN o.preguntaMadre AS p "
                + "GROUP BY p.id "
                + "ORDER BY AVG(r.relevancia) desc");
        query.setMaxResults(20);
        l = (List<Pregunta>)query.list();
        session.close();
        return l;
    }

    public Pregunta getAleatoria(){
        Pregunta p;
        Session session = sf.openSession();
        Query query = session.createQuery("FROM Pregunta p ORDER BY RAND()");
        p = (Pregunta)query.uniqueResult();
        session.close();
        return p;
    }
    
    
	
}
