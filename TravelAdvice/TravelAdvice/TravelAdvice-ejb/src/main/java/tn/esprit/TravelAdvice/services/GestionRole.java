package tn.esprit.TravelAdvice.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.TravelAdvice.entities.Role;

@Stateless
@LocalBean
public class GestionRole implements GestionRoleLocal ,GestionRoleRemote {
	@PersistenceContext
	private EntityManager em;
	
	
	public GestionRole() {
		super();
	}

	@Override
	public void create(Role role) {
		em.persist(role);
		
	}

	@Override
	public void delete(int id) {
		em.remove(em.find(Role.class, id));
		
	}

	@Override
	public List<Role> findAll() {
		return em.createQuery("select u from Role u",Role.class).getResultList();
	}

	@Override
	public Role find(int id) {
		return em.find(Role.class, id);
	}

}
