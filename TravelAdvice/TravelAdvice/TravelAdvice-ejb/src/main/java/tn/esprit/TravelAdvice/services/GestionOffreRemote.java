package tn.esprit.TravelAdvice.services;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.TravelAdvice.entities.Offre;

@Remote
public interface GestionOffreRemote {
	 Boolean OrgenizeOffre(Offre offre);
	    Boolean updateOffre(Offre offre);
	    Boolean removeOffre(Offre offre);
	    List<Offre> findAll();
	    Offre FindById(int id);
	    Boolean ReserverOffre(Offre offre);
}
