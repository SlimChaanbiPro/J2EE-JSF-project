package tn.esprit.TravelAdvice.entities;

import java.io.Serializable;
import java.lang.Integer;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Entity implementation class for Entity: Reservation
 *
 */
@Entity
@XmlRootElement
public class Reservation implements Serializable {

	   
	
	private Integer id;
	private Integer nombre;
	private Offre offreReserve ; 
	private static final long serialVersionUID = 1L;
	private User user;

	public Reservation() {
		
	}   
	@Id
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}   
	public Integer getNombre() {
		return this.nombre;
	}

	public void setNombre(Integer nombre) {
		this.nombre = nombre;
	}
	@ManyToOne
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@ManyToOne
	public Offre getOffreReserve() {
		return offreReserve;
	}
	public void setOffreReserve(Offre offreReserve) {
		this.offreReserve = offreReserve;
	}
   
}
