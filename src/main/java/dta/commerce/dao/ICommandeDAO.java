package dta.commerce.dao;

import java.util.List;

import dta.commerce.persistance.CommandeClient;
import dta.commerce.persistance.CommandeProduits;

public interface ICommandeDAO {

	/**
	 * Méthodes pour les commandes client
	 * 
	 */
	public void createCommandeClient(CommandeClient commandeClient);

	public void deleteCommandeClient(CommandeClient commandeClient);

	public void updateCommandeClient(CommandeClient commandeClient);
	
	public List<CommandeClient> listerAllCommandeClient();

	public List<CommandeClient> listerCommandeClient(Integer idClient);

	public CommandeClient editCommandClient (Integer idCommandeClient);
	
	/**
	 * Méthodes pour les commandes Produits 
	 */
	
	public void createCommandeProduit(CommandeProduits commandeProduits);
	
	public void deleteCommandeProduit(CommandeProduits commandeProduits);

	public void updateCommandeProduit(CommandeProduits commandeProduits);

	public List<CommandeProduits> listerCommandeProduit();

	public CommandeProduits editCommandProduit (Integer idCommandeProduit);
}
