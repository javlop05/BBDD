package abd.p1.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Mensaje {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@ManyToOne
	private Usuario emisor;
	
	@ManyToOne
	private Usuario receptor;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha;
	
	private boolean leido;
	
	
	public Mensaje() {
	}
	
	public Mensaje(Integer id, Usuario emisor, Usuario receptor) {
		this.id = id;
		this.emisor = emisor;
		this.receptor = receptor;
		this.fecha = new Date();
		this.leido = false;
	}

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Usuario getEmisor() {
		return emisor;
	}
	
	public void setCorreoEmisor(Usuario emisor) {
		this.emisor = emisor;
	}
	
	public Usuario getReceptor() {
		return receptor;
	}
	
	public void setReceptor(Usuario receptor) {
		this.receptor = receptor;
	}
	
	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public boolean isLeido() {
		return leido;
	}

	public void setLeido(boolean leido) {
		this.leido = leido;
	}
	
}