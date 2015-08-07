package dta.commerce.persistance;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
	private Adresse adresselivraison;
	@ManyToOne
	private Adresse adressefacturation;
	@ManyToOne(cascade = CascadeType.ALL)
	private Commande commande;

	
	
	/**
	 * Constructeurs
	 */
	public Facture(Date date, String modepaiement,
			Adresse adresseLivraison, Adresse adresseFacturation,
			Commande commande) {
		super();
		this.date = date;
		this.modepaiement = modepaiement;
		this.adresselivraison = adresseLivraison;
		this.adressefacturation = adresseFacturation;
		this.commande = commande;
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
	public Commande getCommande() {
		return commande;
	}
	public void setCommande(Commande commande) {
		this.commande = commande;
	}

}





