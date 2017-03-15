package abd.p1.model;

import java.io.Serializable;

public class ClaveResponde implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private Usuario usuario;
	private Opcion respuesta;
	
	public ClaveResponde() {}
	
	public ClaveResponde(Usuario usuario, Opcion respuesta) {
		super();
		this.setUsuario(usuario);
		this.setRespuesta(respuesta);
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((respuesta == null) ? 0 : respuesta.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClaveResponde other = (ClaveResponde) obj;
		if (respuesta == null) {
			if (other.respuesta != null)
				return false;
		} else if (!respuesta.equals(other.respuesta))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}
	
}
