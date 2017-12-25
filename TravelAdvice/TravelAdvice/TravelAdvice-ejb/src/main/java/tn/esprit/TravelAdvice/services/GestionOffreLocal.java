package tn.esprit.TravelAdvice.services;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.TravelAdvice.entities.Offre;

@Local
public interface GestionOffreLocal {
    Boolean OrgenizeOffre(Offre offre,int idUser);
    Boolean updateOffre(Offre offre);
    Boolean removeOffre(Offre offre);
    List<Offre> findAll();
    Offre FindById(int id);
    Boolean ReserverOffre(Offre offre);
}
