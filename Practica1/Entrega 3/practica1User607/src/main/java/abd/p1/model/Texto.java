package abd.p1.model;

import javax.persistence.Entity;

@Entity
public class Texto extends Mensaje {

	private String texto;
	
	public Texto() {}
	
	public Texto(Integer id, Usuario emisor, Usuario receptor,
			String texto) {
		super(id, emisor, receptor);
		this.setTexto(texto);
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

}