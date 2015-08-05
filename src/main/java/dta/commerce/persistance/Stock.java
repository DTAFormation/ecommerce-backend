package dta.commerce.persistance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Stock {
	
	/** 
	 * Attributs
	 */
	private Integer id;
	private List<Produit> listProduit = new ArrayList<Produit>();
	private Map<Produit, Integer> quantiteProduit = new HashMap<Produit, Integer>();

	

	/**
	 * Constructeurs
	 */
	public Stock(Integer id, List<Produit> listProduit,
			Map<Produit, Integer> quantiteProduit) {
		super();
		this.id = id;
		this.listProduit = listProduit;
		this.quantiteProduit = quantiteProduit;
	}
	public Stock(){
		
	}
	
	
	/**
	 * Getters & setters
	 */
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public List<Produit> getListProduit() {
		return listProduit;
	}
	public void setListProduit(List<Produit> listProduit) {
		this.listProduit = listProduit;
	}
	public Map<Produit, Integer> getQuantiteProduit() {
		return quantiteProduit;
	}
	public void setQuantiteProduit(Map<Produit, Integer> quantiteProduit) {
		this.quantiteProduit = quantiteProduit;
	}
}
