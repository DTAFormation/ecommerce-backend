package dta.commerce.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;

import dta.commerce.dao.IProduitDAO;
import dta.commerce.persistance.Produit;

@Stateless
@TransactionManagement(value=TransactionManagementType.CONTAINER)
public class ProduitEJB implements IProduitEJB {
	
	@Inject private IProduitDAO produitDao;

	@Override
	public Produit getProduit(int idProduit) {
		return produitDao.getProduit(idProduit);
	}

	@Override
	public void addProduit(Produit produit) {
		produitDao.addProduit(produit);
		
	}

	@Override
	public void deleteProduit(int idProduit) {
		produitDao.deleteProduit(idProduit);
		
	}

	@Override
	public void updateProduit(Produit produit) {
		produitDao.updateProduit(produit);
		
	}

	@Override
	public List<Produit> listerProduits() {
		return produitDao.listerProduits();
	}

}
