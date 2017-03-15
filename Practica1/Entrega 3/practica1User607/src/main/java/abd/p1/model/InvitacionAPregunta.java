package abd.p1.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class InvitacionAPregunta extends Mensaje {

	@ManyToOne
	private Pregunta pregunta; 
	
	public InvitacionAPregunta() {}
	
	public InvitacionAPregunta(Integer id, Usuario emisor,
			Usuario receptor, Pregunta pregunta) {
		super(id, emisor, receptor);
		this.pregunta = pregunta;
	}

	public Pregunta getPregunta() {
		return pregunta;
	}

	public void setPregunta(Pregunta pregunta) {
		this.pregunta = pregunta;
	}

}