
package tn.ListAmis.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.TravelAdvice.entities.Friendship;
import tn.esprit.TravelAdvice.services.UserLocal;



@Stateless
public class FriendshipService implements FriendshipRemote, FriendshipLocal {

	@PersistenceContext
	EntityManager em;
	@Inject
	UserLocal userEJB;

	public FriendshipService() {
	}

	@Override
	public boolean sendFriendRequest(int idSrc, int idDest) {
		try {
			if(this.exist(idSrc, idDest) == true){
				return false;
			}
			Friendship request = new Friendship();
			request.setAccepted(false);
			request.setUser1(userEJB.find(idSrc));
			request.setUser2(userEJB.find(idDest));
			em.persist(request);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	public UserLocal getUserEJB() {
		return userEJB;
	}

	public void setUserEJB(UserLocal userEJB) {
		this.userEJB = userEJB;
	}

	@Override
	public boolean acceptFriendRequest(int idRequest) {
		try {
			Friendship request = em.find(Friendship.class, idRequest);
			request.setAccepted(true);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<tn.esprit.TravelAdvice.entities.Friendship> getRequestFor(int idUser) {
		Query q = em.createQuery("select f from Friendship f where f.user2 = :user and f.accepted = 0")
				.setParameter("user", userEJB.find(idUser));
		return q.getResultList();
	}

	@Override
	public List<tn.esprit.TravelAdvice.entities.Friendship> getFriendsList(int idUser) {
		Query q = em.createQuery("select f from Friendship f where f.user1 = :user and f.accepted = 1")
				.setParameter("user", userEJB.find(idUser));
		return q.getResultList();
	}

	@Override
	public boolean deleteFriend(int id) {
		try {
			em.remove(em.find(Friendship.class, id));
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	@Override
	public boolean exist(int idSrc, int idDest){
		try {
			Query q = em.createQuery("select count(f.id) from Friendship f where (f.user1.id = :idSrc and f.user2.id = :idDest) or (f.user1.id = :idDest and f.user2.id = :idSrc)")
					.setParameter("idSrc",idSrc)
					.setParameter("idDest",idDest);
			Long result = (Long) q.getSingleResult();
			if (result == 0) {
				return false;
			}
			return true;
		} catch (Exception e) {
			return true;
		}
	}

	@Override
	public Friendship findbyiduser(int idu1, int idu2) {
		
		return null;
	}

}
