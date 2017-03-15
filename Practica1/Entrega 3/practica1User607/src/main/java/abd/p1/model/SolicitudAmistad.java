package abd.p1.model;

import javax.persistence.Entity;

@Entity
public class SolicitudAmistad extends Mensaje {

	public SolicitudAmistad() {}
	
	public SolicitudAmistad(Integer id, Usuario emisor,
			Usuario receptor) {
		super(id, emisor, receptor);
	}

}