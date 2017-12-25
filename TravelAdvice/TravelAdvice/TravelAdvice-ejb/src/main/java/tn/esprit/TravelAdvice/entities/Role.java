package tn.esprit.TravelAdvice.entities;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.List;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Entity implementation class for Entity: Role
 *
 */
@Entity
@XmlRootElement
public class Role implements Serializable {

	
	private Integer id;
	private String type;
	private List<User> user;
	private static final long serialVersionUID = 1L;

	public Role() {
		
	}   
	@Id    
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}   
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}
	@OneToMany(mappedBy="role")
	public List<User> getUser() {
		return user;
	}
	public void setUser(List<User> user) {
		this.user = user;
	}
	public Role(Integer id, String type) {
		super();
		this.id = id;
		this.type = type;
	}
	

   
}
