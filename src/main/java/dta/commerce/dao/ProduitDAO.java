package dta.commerce.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import dta.commerce.persistance.Produit;

public class ProduitDAO implements IProduitDAO {
	
	@PersistenceContext(unitName="my_pu") private EntityManager em;

	@Override
	public Produit getProduit(int idProduit) {
		Produit produit = em.find(Produit.class, idProduit);
		return produit;
	}

	@Override
	public void addProduit(Produit produit) {
		try{
			em.persist(produit);
		} catch(Exception e) {
			e.printStackTrace();			
		}
	}

	@Override
	public void deleteProduit(int idProduit) {
		em.remove(em.find(Produit.class, idProduit));
		
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
