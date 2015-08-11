package dta.commerce.ejb;

import java.util.List;

import dta.commerce.persistance.CommandeClient;
import dta.commerce.persistance.CommandeProduits;


public interface ICommandeEJB {

	
	/**
	 * Méthods pour les commandes clients
	 */
	
	public List<CommandeClient> listerCommandeClient(Integer idClient);
	
	public void deleteCommandeClient(Integer idCommande);

	public void updateCommandeClient(CommandeClient commandeClient);
	
	public CommandeClient editCommandClient (Integer idCommandeClient);
	
	public  void createCommandeClient(CommandeClient commandeClient);

}
