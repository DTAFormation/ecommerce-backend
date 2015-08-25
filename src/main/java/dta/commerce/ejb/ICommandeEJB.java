package dta.commerce.ejb;

import java.util.List;

import dta.commerce.persistance.CommandeClient;
import dta.commerce.persistance.CommandeProduits;


public interface ICommandeEJB {

	
	/**
	 * Méthods pour les commandes clients
	 */
	
	public List<CommandeClient> listerAllCommandeClient();
	
	public List<CommandeClient> listerCommandeClient(Integer idClient);
	
	public void deleteCommandeClient(Integer idCommande);

	public void updateCommandeClient(CommandeClient commandeClient);
	
	public CommandeClient editCommandClient (Integer idCommandeClient);
	
	public  void createCommandeClient(CommandeClient commandeClient);
	
	/**
	 * Méthodes pour les commandes produits
	 */

	public void createCommandeProduit(CommandeProduits commandeProduits);
	
	public void deleteCommandeProduit(CommandeProduits commandeProduits);

	public void updateCommandeProduit(CommandeProduits commandeProduits);

	public List<CommandeProduits> listerCommandeProduit();

	public CommandeProduits editCommandProduit (Integer idCommandeProduit);
}
