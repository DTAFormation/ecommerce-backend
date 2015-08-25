package dta.commerce.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import dta.commerce.persistance.Adresse;

public class AdresseDAO implements IAdressesDAO {

	@PersistenceContext(unitName="my_pu") private EntityManager em;
	
	@Override
	public void addAdresse(Adresse adresse) {
		em.persist(adresse);
	}

}
