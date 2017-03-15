package abd.p1.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;

@Entity
@IdClass(ClaveResponde.class)
public class Responde {
	
	//Respuesta tiene el usuario y la opción respondida
	@Id
	@ManyToOne
	private Usuario usuario;
	
	@Id
	@ManyToOne
	private Opcion respuesta;
	
	private Integer relevancia;

	public Responde() {}
	
	public Responde(Usuario usuario, Opcion respuesta, Integer relevancia) {
		super();
		this.usuario = usuario;
		this.respuesta = respuesta;
		this.relevancia = relevancia;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Opcion getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(Opcion respuesta) {
		this.respuesta = respuesta;
	}

	public Integer getRelevancia() {
		return relevancia;
	}

	public void setRelevancia(Integer relevancia) {
		this.relevancia = relevancia;
	}
	
}