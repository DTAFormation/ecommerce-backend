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
	
	@Override
	public  void createCommandeClient(CommandeClient commandeClient) {
		commandeDao.createCommandeClient(commandeClient);
	}

	@Override
	public void deleteCommandeClient(Integer idCommandeClient) {
		CommandeClient deletableCdeCli = editCommandClient(idCommandeClient);
		deletableCdeCli.getClient().removeCommandClient(deletableCdeCli);
		commandeDao.deleteCommandeClient(deletableCdeCli);
	}

	@Override
	public void updateCommandeClient(CommandeClient commandeClient) {
		commandeDao.updateCommandeClient(commandeClient);
	}
	
	public List<CommandeClient> listerAllCommandeClient(){
		return commandeDao.listerAllCommandeClient();
	}

	@Override
	public List<CommandeClient> listerCommandeClient(Integer idClient) {
		return commandeDao.listerCommandeClient(idClient);
	}

	@Override
	public CommandeClient editCommandClient (Integer idCommandeClient) {
		return commandeDao.editCommandClient(idCommandeClient);
	}	
}
