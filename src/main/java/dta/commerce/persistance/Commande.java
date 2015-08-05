package dta.commerce.persistance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Commande {
	/**
	 * Attributs
	 */
	private Integer id;
	private User client;
	private String etat;
	private List<Produit> listProduit = new ArrayList<Produit>();
	private Map<Produit, Integer> quantiteProduit = new HashMap<Produit, Integer>();

	
	/**
	 * Constructeurs
	 */
	public Commande(Integer id, User client, String etat,
			List<Produit> listProduit, Map<Produit, Integer> quantiteProduit) {
		super();
		this.id = id;
		this.client = client;
		this.etat = etat;
		this.listProduit = listProduit;
		this.quantiteProduit = quantiteProduit;
	}
	public Commande(){
		
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
	public User getClient() {
		return client;
	}
	public void setClient(User client) {
		this.client = client;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
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
