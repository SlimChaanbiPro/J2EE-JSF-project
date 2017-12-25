package tn.esprit.TravelAdvice.entities;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.List;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Entity implementation class for Entity: Destination
 *
 */
@Entity
@XmlRootElement
public class Destination implements Serializable {

	
	private Integer id;
	private String pays;
	private String ville;
	private List<Offre> offres;
	private static final long serialVersionUID = 1L;

	public Destination() {
		
	}   
	@Id    
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}   
	public String getPays() {
		return this.pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}   
	public String getVille() {
		return this.ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}
	@OneToMany(mappedBy="destination")
	public List<Offre> getOffres() {
		return offres;
	}
	public void setOffres(List<Offre> offres) {
		this.offres = offres;
	}
   
}
