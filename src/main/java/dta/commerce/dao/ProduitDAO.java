package dta.commerce.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import dta.commerce.persistance.Produit;
import dta.commerce.persistance.User;

public class ProduitDAO implements IProduitDAO {
	
	@PersistenceContext(unitName="my_pu") private EntityManager em;

	@Override
	public Produit getProduit(int idProduit) {
		Produit produit = em.find(Produit.class, idProduit);
		return produit;
	}

	@Override
	public void addProduit(Produit produit) {
		em.persist(produit);
	}

	@Override
	public void deleteProduit(int idProduit) {
		//em.remove(em.find(Produit.class, idProduit));
		Produit p = getProduit(idProduit);
		p.setActif(false);
		em.merge(p);
		
	}

	@Override
	public void updateProduit(Produit produit) {
		em.merge(produit);		
	}

	@Override
	public List<Produit> listerProduits() {
		return em.createNamedQuery("Produit.findAll").getResultList();
	}

}
