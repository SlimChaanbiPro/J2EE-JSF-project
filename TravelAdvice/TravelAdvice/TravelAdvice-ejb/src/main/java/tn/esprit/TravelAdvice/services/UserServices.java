package tn.esprit.TravelAdvice.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.TravelAdvice.entities.Role;
import tn.esprit.TravelAdvice.entities.User;


@Stateless
@LocalBean
public class UserServices  implements UserLocal , UserRemote{


	@PersistenceContext
	private EntityManager em;
	public  User user = new User();
	 
	 
	
    public UserServices() {
    }

    @Override
	public void create(User user) {
    String type ="simple_user";
    Role r = new Role();
    r.setId(1);
    r.setType(type);
   
		em.persist(user);
		user.setRole(r);
		
	user.setType(type);
		em.merge(user);
		em.flush();
	}

	@Override
	public User authentificate(String login, String password) {
		
		User u=null;
		Query q=em.createQuery("select u from User u where u.login=:p1 and u.password=:p2");
		q.setParameter("p1", login);
		q.setParameter("p2",password);
		try {
			u = (User) q.getSingleResult();

		} catch (Exception e) {

			System.out.println("error " + e.getMessage());
		}
		user =u ;
		return u;
	}



	@Override
	public void delete(int id) {
		em.remove(em.find(User.class, id));
		
	}

	@Override
	public List<User> findAll() {
		
			return em.createQuery("select u from User u", User.class).getResultList();
	}

	@Override
	public User find(int id) {
		Query q= em.createQuery("select u from User u where u.id=:x");
		q.setParameter("x", id);
	    return (User) q.getResultList().get(0);
	}

	@Override
	public User findByLogin(String login) {
		Query q= em.createQuery("select u from User u where u.login=:x");
		q.setParameter("x", login);
	    return (User) q.getResultList().get(0);
	}

	@Override
	public Boolean deleteUser(User u) {
		
			try{
				em.remove(em.merge(u));
				}catch(Exception e){
					return false;
				}
				return true;
			
	}

	@Override
	public Boolean updateUser(User u) {
		try{
			em.merge(u);
			}catch(Exception e){
				return false;
			}
			return true;
	}

	@Override
	public User findByAdress(String adress) {
		Query q= em.createQuery("select u from User u where u.adress=:x");
		q.setParameter("x", adress);
	    return (User) q.getResultList().get(0);
	}

	
	
	
	

}
