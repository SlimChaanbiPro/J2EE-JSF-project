package tn.esprit.TravelAdvice.entities;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.List;

import javax.jms.JMSSessionMode;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Entity implementation class for Entity: User
 *
 */

@Entity

@XmlRootElement
@JsonIgnoreProperties(value={"reservations","getMessagesFromTo","getMessagesFor","role"}) 
public class User implements Serializable {
@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nom;
	private String prenom;
	private String email;
	private String login;
	private String password;
	private String adress;
	private String type ;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@OneToMany(mappedBy="user")
	private List<Reservation> reservations ;
	@ManyToOne
	private Role role;
	private static final long serialVersionUID = 1L;
    @OneToMany(mappedBy="sender")
	private List<Message> getMessagesFromTo;
	@OneToMany(mappedBy="receiver")
	private List<Message> getMessagesFor;
	
	public User() {
		
	}   
	
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}   
	
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}   
	
	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}   
	
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}   
	
	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}  
	
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}  
	
	public String getAdress() {
		return this.adress;
	}
	
	public List<Message> getGetMessagesFromTo() {
		return getMessagesFromTo;
	}
	
	public void setGetMessagesFromTo(List<Message> getMessagesFromTo) {
		this.getMessagesFromTo = getMessagesFromTo;
	}
	
	public List<Message> getGetMessagesFor() {
		return getMessagesFor;
	}
	public void setGetMessagesFor(List<Message> getMessagesFor) {
		this.getMessagesFor = getMessagesFor;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	
	public List<Reservation> getReservations() {
		return reservations;
	}
	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}
	
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public User(Integer id, String nom, String prenom, String email, String login, String password, String adress,
			String type) {
	
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.login = login;
		this.password = password;
		this.adress = adress;
		this.type = type;
		
	}

	
	
   
	
}
