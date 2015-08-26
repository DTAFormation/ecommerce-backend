package dta.commerce.persistance;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="facture") 
public class Facture {

	/** 
	 * Attributs
	 */
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private Date date;
	
	private String modepaiement;
	
	@ManyToOne
	@JsonBackReference
	private Adresse adresselivraison;
	
	@ManyToOne
	@JsonBackReference
	private Adresse adressefacturation;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JsonBackReference
	private CommandeClient commandeClient;

	
	
	/**
	 * Constructeurs
	 */
	public Facture(Date date, String modepaiement,
			Adresse adresseLivraison, Adresse adresseFacturation,
			CommandeClient commandeClient) {
		super();
		this.date = date;
		this.modepaiement = modepaiement;
		this.adresselivraison = adresseLivraison;
		this.adressefacturation = adresseFacturation;
		this.commandeClient = commandeClient;
	}
	public Facture(){
		
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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getModePaiement() {
		return modepaiement;
	}
	public void setModePaiement(String modePaiement) {
		this.modepaiement = modePaiement;
	}
	public Adresse getAdresseLivraison() {
		return adresselivraison;
	}
	public void setAdresseLivraison(Adresse adresseLivraison) {
		this.adresselivraison = adresseLivraison;
	}
	public Adresse getAdresseFacturation() {
		return adressefacturation;
	}
	public void setAdresseFacturation(Adresse adresseFacturation) {
		this.adressefacturation = adresseFacturation;
	}
	public CommandeClient getCommande() {
		return commandeClient;
	}
	public void setCommande(CommandeClient commandeClient) {
		this.commandeClient = commandeClient;
	}

}





