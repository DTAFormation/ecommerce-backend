package dta.commerce.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;

import dta.commerce.dao.ICommandeDAO;
import dta.commerce.persistance.CommandeClient;
import dta.commerce.persistance.CommandeProduits;

@Stateless
@TransactionManagement(value=TransactionManagementType.CONTAINER)
public class CommandeEJB implements ICommandeEJB{

	
	@Inject private ICommandeDAO commandeDao;
	
	public  void createCommandeClient(CommandeClient commandeClient) {
		commandeDao.createCommandeClient(commandeClient);
		commandeClient.getClient().addCommandClient(commandeClient); 
	}

	public void deleteCommandeClient(Integer idCommandeClient) {
		CommandeClient deletableCdeCli = editCommandClient(idCommandeClient);
		deletableCdeCli.getClient().removeCommandClient(deletableCdeCli);
		commandeDao.deleteCommandeClient(deletableCdeCli);
	}

	public void updateCommandeClient(CommandeClient commandeClient) {
		commandeDao.updateCommandeClient(commandeClient);
	}

	public List<CommandeClient> listerCommandeClient() {
		return commandeDao.listerCommandeClient();
	}

	public CommandeClient editCommandClient (Integer idCommandeClient) {
		return commandeDao.editCommandClient(idCommandeClient);
	}

	@Override
	public void createCommandeProduit(CommandeProduits commandeProduits) {
		commandeDao.createCommandeProduit(commandeProduits);
		commandeProduits.getCommandeClient().ajouterCommandeProduits(commandeProduits);
	}

	@Override
	public void deleteCommandeProduit(CommandeProduits commandeProduits) {
		commandeProduits.getCommandeClient().retirerCommandeProduits(commandeProduits);
		commandeDao.deleteCommandeProduit(commandeProduits);
	}

	@Override
	public void updateCommandeProduit(CommandeProduits commandeProduits) {
		commandeDao.updateCommandeProduit(commandeProduits);
	}

	@Override
	public List<CommandeProduits> listerCommandeProduit() {
		commandeDao.listerCommandeProduit();
		return null;
	}

	@Override
	public CommandeProduits editCommandProduit(Integer idCommandeProduit) {
		return commandeDao.editCommandProduit(idCommandeProduit);
	}
	
}
