package dta.commerce.persistance;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="commandeProduits") 
@JsonIgnoreProperties(ignoreUnknown=true)
public class CommandeProduits {

	@Id @GeneratedValue
	private Integer id;
	
	@ManyToOne(targetEntity=Produit.class)
	
	private Produit Produit;
	
	@ManyToOne
	@JsonIgnore
	private CommandeClient commandeClient;
	
	// quantité lié à chaque item de la liste 
	private Integer quantite;


	/**
	 * Constructeurs
	 */
	
	public CommandeProduits() {
	}
	
	public CommandeProduits(dta.commerce.persistance.Produit produit,
			CommandeClient commandeClient) {
		Produit = produit;
		this.commandeClient = commandeClient;
	}
	
	

	/**
	 * getters & setters
	 */

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public CommandeClient getCommandeClient() {
		return commandeClient;
	}

	public void setCommandeClient(CommandeClient commandeClient) {
		this.commandeClient = commandeClient;
	}

	public Produit getProduit() {
		return Produit;
	}

	public void setProduit(Produit produit) {
		Produit = produit;
	}

	public Integer getQuantite() {
		return quantite;
	}

	public void setQuantite(Integer quantite) {
		this.quantite = quantite;
	} 



}
