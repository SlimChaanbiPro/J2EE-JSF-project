package tn.esprit.TravelAdvice.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.TravelAdvice.entities.Offre;

/**
 * Session Bean implementation class GestionOffre
 */
@Stateless
public class GestionOffre implements GestionOffreRemote, GestionOffreLocal {
    @PersistenceContext(unitName="TravelAdvice-ejb")
    EntityManager em;
    public GestionOffre() {
        
    }

	@Override
	public Boolean OrgenizeOffre(Offre offre) {
		try{
		em.persist(offre);
		}catch(Exception e){
		return false ;
	} 
		return true;
	}
	@Override
	public Boolean updateOffre(Offre offre) {
		try{
			em.merge(offre);
			}catch(Exception e){
				return false;
			}
			
			return true;
		}
	
	@Override
	public Boolean removeOffre(Offre offre) {
		/*try{
			em.remove(em.merge(offre));
		}catch(Exception e){
			return false;
		}
		
		return true;
			
		}*/ return null;
	}

	@Override
	public List<Offre> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Offre FindById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean ReserverOffre(Offre offre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean OrgenizeOffre(Offre offre, int idUser) {
		// TODO Auto-generated method stub
		return null;
	}

}
