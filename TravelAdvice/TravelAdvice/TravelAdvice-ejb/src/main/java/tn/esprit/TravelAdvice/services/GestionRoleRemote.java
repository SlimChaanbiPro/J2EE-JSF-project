package tn.esprit.TravelAdvice.services;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.TravelAdvice.entities.Role;
import tn.esprit.TravelAdvice.entities.User;
@Remote
public interface GestionRoleRemote {
	void create(Role role);
	public void delete(int id);
	public List<Role> findAll();
	public Role find(int id);
}
