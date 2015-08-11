package dta.commerce.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import dta.commerce.persistance.CommandeClient;
import dta.commerce.persistance.CommandeProduits;

public class CommandeDAO implements ICommandeDAO{

	@PersistenceContext(unitName="my_pu") private EntityManager em;
	
	@Override
	public void createCommandeClient(CommandeClient commandeClient) {
		em.persist(commandeClient);
	}

	@Override
	public void deleteCommandeClient(CommandeClient commandeClient) {
		em.remove(commandeClient);
	}

	@Override
	public void updateCommandeClient(CommandeClient commandeClient) {
		em.merge(commandeClient);
	}

	@Override 
	public CommandeClient editCommandClient (Integer idCommandeClient) {
		return em.find(CommandeClient.class, idCommandeClient);
	}
	
	@Override
	public List<CommandeClient> listerCommandeClient(Integer idClient) {
		
		TypedQuery<CommandeClient> selectQuery = em.createQuery("select cde FROM CommandeClient as cde where cde.client.id = :x",CommandeClient.class);
		selectQuery.setParameter("x", idClient);
		
		return (List<CommandeClient>)selectQuery.getResultList();
	}

	@Override
	public void createCommandeProduit(CommandeProduits commandeProduits) {
		em.persist(commandeProduits);		
	}

	@Override
	public void deleteCommandeProduit(CommandeProduits commandeProduits) {
		em.remove(commandeProduits);		
	}

	@Override
	public void updateCommandeProduit(CommandeProduits commandeProduits) {
		em.merge(commandeProduits);		
	}

	@Override
	public List<CommandeProduits> listerCommandeProduit() {
		TypedQuery<CommandeProduits> selectQuery = em.createQuery("select cde FROM CommandeProduits as cde",CommandeProduits.class);
		
		return (List<CommandeProduits>)selectQuery.getResultList();
	}

	@Override
	public CommandeProduits editCommandProduit(Integer idCommandeProduit) {
		return em.find(CommandeProduits.class, idCommandeProduit);
	}

	
	
}
