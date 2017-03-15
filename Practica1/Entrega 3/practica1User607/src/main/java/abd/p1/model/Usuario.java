package abd.p1.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import org.hibernate.annotations.Fetch;

@Entity
public class Usuario {

	@Id
	private String correo;
	
	@Column(nullable = false)
	private String contrasena;
	
	@Column(nullable = false)
	private String nombre;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Genero genero;
	
	@Column(nullable = false)
	private double latitud;
	
	@Column(nullable = false)
	private double longitud;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Genero generoInteres;
	
	@Lob
	private byte[] imagen;
	
	@Temporal(TemporalType.DATE)
	private Date fechaNac;
	
	private String descripcion;
	
	@ElementCollection(fetch = FetchType.EAGER)
	private Set<String> aficiones;
	
	//Set para evitar amigos duplicados
	@ManyToMany
	private Set<Usuario> amigos;
	
	@OneToMany(mappedBy = "receptor")
	private List<Mensaje> mensajes;

        public Usuario(){
            this.contrasena = "";
            this.nombre = "";
            this.genero = null;
            this.generoInteres = null;
            Random r = new Random();
            double lat = 40 + (41.2 - 40) * r.nextDouble();
            this.latitud = lat;
            Random r2 = new Random();
            double longit = 3 + (1.5) * r2.nextDouble();
            this.longitud = longit;
            this.aficiones = new HashSet<String>();
            this.amigos = new HashSet<Usuario>();
            this.mensajes = new ArrayList<Mensaje>();
            this.fechaNac = null;
        }
        
        public Usuario (String correo) {
            this();
            this.correo = correo;
        }
        
	public Usuario(String correo, String contrasena, String nombre,
			Genero genero, double latitud, double longitud, 
			Genero generoInteres) {
                this();
		this.correo = correo;
		this.contrasena = contrasena;
		this.nombre = nombre;
		this.genero = genero;
		this.latitud = latitud;
		this.longitud = longitud;
		this.generoInteres = generoInteres;
		this.aficiones = new HashSet<String>();
		this.amigos = new HashSet<Usuario>();
		this.mensajes = new ArrayList<Mensaje>();
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public double getLatitud() {
		return latitud;
	}

	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}

	public double getLongitud() {
		return longitud;
	}

	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}

	public byte[] getImagen() {
		return imagen;
	}

	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}

	public Date getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Set<String> getAficiones() {
		return aficiones;
	}

	public void setAficiones(Set<String> aficiones) {
		this.aficiones = aficiones;
	}
        
        public void addAficion(String aficion) {
                this.aficiones.add(aficion);
        }
        
        public void deleteAficion(String aficion) {
                this.aficiones.remove(aficion);
        }

	public Set<Usuario> getAmigos() {
		return amigos;
	}

	public void setAmigos(Set<Usuario> amigos) {
		this.amigos = amigos;
	}

	public Genero getGeneroInteres() {
		return generoInteres;
	}

	public void setGeneroInteres(Genero generoInteres) {
		this.generoInteres = generoInteres;
	}
		
        public static int calcularEdad(Date fechaNac) {
            Date fechaActual = new Date();
            long milisegundosVividos = (fechaActual.getTime() - fechaNac.getTime());
            
            //Hemos tenido que fragmentar la operación ya que no cabía el valor
            long segundosEnUnAño = 365*24*60*60;
            long aux = milisegundosVividos / segundosEnUnAño;
            long años = aux / 1000;
            
            int edad = (int)años;
            return edad;
        }

    public byte[] getAvatar() {
        return this.imagen;
    }

    private double rand() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        
}