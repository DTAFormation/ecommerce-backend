package dta.commerce.persistance;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	
	private Double montant = 0.0d;
	
	@OneToOne
	@JsonIgnore
	private Adresse adresselivraison;
	
	@OneToOne
	@JsonIgnore
	private Adresse adressefacturation;
	
	/**
	 * Constructeurs
	 */
	public Facture(Date date, String modepaiement, Double montant,
			Adresse adresseLivraison, Adresse adresseFacturation,
			CommandeClient commandeClient) {
		super();
		this.date = date;
		this.modepaiement = modepaiement;
		this.adresselivraison = adresseLivraison;
		this.adressefacturation = adresseFacturation;
		this.montant = montant;
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
	public Double getMontant() {
		return montant;
	}
	public void setMontant(Double montant) {
		if (montant >=0)
		this.montant = montant;
	}

}





