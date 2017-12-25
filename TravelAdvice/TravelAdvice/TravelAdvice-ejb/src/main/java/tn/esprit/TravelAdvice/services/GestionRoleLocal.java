package tn.esprit.TravelAdvice.services;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.TravelAdvice.entities.Role;
import tn.esprit.TravelAdvice.entities.User;



@Local
public interface GestionRoleLocal {
	
	void create(Role role);
	public void delete(int id);
	public List<Role> findAll();
	public Role find(int id);
}
