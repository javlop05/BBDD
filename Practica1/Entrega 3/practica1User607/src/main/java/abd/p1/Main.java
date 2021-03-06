package abd.p1;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import abd.p1.bd.DAOUsuario;
import abd.p1.controller.LoginController;
import abd.p1.view.VentanaAcceso;

/**
 * Ésta es la clase que arranca la aplicación. La ejecución del método main()
 * no reconstruirá la base de datos. La base de datos se supone ya construida
 * por el método CreateDB.main()
 *
 */
public class Main {
    
    private static SessionFactory buildSessionFactory() {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure().build();
        try {
            return new MetadataSources(registry).buildMetadata().buildSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
            StandardServiceRegistryBuilder.destroy(registry);
            return null;
        } 
    }
   
    
    public static void main(String[] args) {

        SessionFactory sf = null;
        
        try {
            sf = buildSessionFactory();
            
            DAOUsuario userDAO = new DAOUsuario(sf);
            LoginController loginController = new LoginController(userDAO);
            VentanaAcceso login = new VentanaAcceso(loginController);
            
            login.setModal(true);
            login.setVisible(true);

        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            if (sf != null) sf.close();
        }
    }

}
