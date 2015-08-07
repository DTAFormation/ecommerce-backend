package dta.commerce.persistance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="commande") 
public class Commande {
	
	/** 
	 * Attributs
	 */
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne(cascade = CascadeType.ALL)
	private Personne client;
	private String etat;
	//@ManyToMany
	//private List<Produit> listProduit = new ArrayList<Produit>();
	
	
	/**
	 * Constructeurs
	 */
	public Commande(User client, String etat/*,
			List<Produit> listProduitMap<Produit, Integer> quantiteProduit*/) {
		super();
		this.client = client;
		this.etat = etat;
		//this.listProduit = listProduit;
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
	public Personne getClient() {
		return client;
	}
	public void setClient(Personne client) {
		this.client = client;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
//	public List<Produit> getListProduit() {
//		return listProduit;
//	}
//	public void setListProduit(List<Produit> listProduit) {
//		this.listProduit = listProduit;
//	}


}
