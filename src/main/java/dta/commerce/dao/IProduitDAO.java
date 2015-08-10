package dta.commerce.dao;

import java.util.List;

import dta.commerce.persistance.Produit;

public interface IProduitDAO {
	
	public abstract Produit getProduit(int idProduit);
	
	public abstract void addProduit(Produit produit);

	public abstract void deleteProduit(int idProduit);

	public abstract void updateProduit(Produit produit);

	public abstract List<Produit> listerProduits();
	
}
