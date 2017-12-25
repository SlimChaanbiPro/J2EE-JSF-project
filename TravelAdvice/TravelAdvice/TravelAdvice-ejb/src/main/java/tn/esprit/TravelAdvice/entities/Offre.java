package tn.esprit.TravelAdvice.entities;

import java.io.Serializable;
import java.lang.Boolean;
import java.lang.Float;
import java.lang.Integer;
import java.lang.String;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * Entity implementation class for Entity: Offre
 *
 */
@Entity
@XmlRootElement
public class Offre implements Serializable {

	   
	
	private Integer id;
	private String description;
	private String nomOffre;
	private Date dateLancement;
	private Date dateFin;
	private Integer nombrePlace;
	private Boolean Disponibilite;
	private Float prix;
	private List<Reservation> reservations;
	private Destination destination ;
	private static final long serialVersionUID = 1L;

	public Offre() {
		
	}  
	@Id 
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}   
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}   
	public Date getDateLancement() {
		return this.dateLancement;
	}

	public void setDateLancement(Date dateLancement) {
		this.dateLancement = dateLancement;
	}   
	public Date getDateFin() {
		return this.dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}   
	public Integer getNombrePlace() {
		return this.nombrePlace;
	}

	public void setNombrePlace(Integer nombrePlace) {
		this.nombrePlace = nombrePlace;
	}   
	public Boolean getDisponibilite() {
		return this.Disponibilite;
	}

	public void setDisponibilite(Boolean Disponibilite) {
		this.Disponibilite = Disponibilite;
	}   
	public Float getPrix() {
		return this.prix;
	}

	public void setPrix(Float prix) {
		this.prix = prix;
	}
	public String getNomOffre() {
		return nomOffre;
	}
	public void setNomOffre(String nomOffre) {
		this.nomOffre = nomOffre;
	}
	@OneToMany(mappedBy="offreReserve")
	public List<Reservation> getReservations() {
		return reservations;
	}
	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}
	@ManyToOne
	public Destination getDestination() {
		return destination;
	}
	public void setDestination(Destination destination) {
		this.destination = destination;
	}
   
}
