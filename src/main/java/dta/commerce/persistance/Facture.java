package dta.commerce.persistance;

import java.util.Date;

public class Facture {

	/**
	 * Attributs
	 */
	private Integer id;
	private Date date;
	private String modePaiement;
	private Adresse adresseLivraison;
	private Adresse adresseFacturation;
	private Commande commande;

	
	
	/**
	 * Constructeurs
	 */
	public Facture(Integer id, Date date, String modePaiement,
			Adresse adresseLivraison, Adresse adresseFacturation,
			Commande commande) {
		super();
		this.id = id;
		this.date = date;
		this.modePaiement = modePaiement;
		this.adresseLivraison = adresseLivraison;
		this.adresseFacturation = adresseFacturation;
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
		return modePaiement;
	}
	public void setModePaiement(String modePaiement) {
		this.modePaiement = modePaiement;
	}
	public Adresse getAdresseLivraison() {
		return adresseLivraison;
	}
	public void setAdresseLivraison(Adresse adresseLivraison) {
		this.adresseLivraison = adresseLivraison;
	}
	public Adresse getAdresseFacturation() {
		return adresseFacturation;
	}
	public void setAdresseFacturation(Adresse adresseFacturation) {
		this.adresseFacturation = adresseFacturation;
	}
	public Commande getCommande() {
		return commande;
	}
	public void setCommande(Commande commande) {
		this.commande = commande;
	}

}





