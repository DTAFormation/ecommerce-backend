package dta.commerce.persistance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyColumn;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

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
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
		      name="commande_produit",
		      joinColumns={@JoinColumn(name="commande", referencedColumnName="id")},
		      inverseJoinColumns={@JoinColumn(name="produit", referencedColumnName="id")})
	private List<Produit> produits = new ArrayList<Produit>();
//	@ElementCollection
//    @MapKeyColumn(name="produit")
//    @Column(name="quantite")
//    @CollectionTable(name="commande_quantite", joinColumns=@JoinColumn(name="id"))
//	private Map<Produit,Integer> quantites = new HashMap<Produit, Integer>();
	
	
	 
	    
	  
	  

	/**
	 * Constructeurs
	 */
	public Commande(User client, String etat) {
		super();
		this.client = client;
		this.etat = etat;
	}
	public Commande(){
		
	}
	
	/**
	 * Methods
	 */
//	public void ajouterProduit(Produit produit, Integer quantite){
//		quantites.put(produit,quantite);
//		produits.add(produit);
//	}
//	public void retirerProduit(Produit produit){
//		quantites.remove(produit);
//		produits.remove(produit);
//	}
//	public void changerQuantiteProduit(Produit produit, Integer quantite){
//		quantites.replace(produit, quantite);
//	}
	
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
	public List<Produit> getproduits() {
		return produits;
	}
	public void setproduits(List<Produit> produits) {
		this.produits = produits;
	}
	public List<Produit> getProduits() {
		return produits;
	}
//	public Map<Produit, Integer> getQuantites() {
//		return quantites;
//	}
//	public void setQuantites(Map<Produit, Integer> quantites) {
//		this.quantites = quantites;
//	}

}
