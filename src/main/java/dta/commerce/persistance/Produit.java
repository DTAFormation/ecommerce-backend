package dta.commerce.persistance;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="produit")
@NamedQuery(
		name="Produit.findAll",
		query="select p from Produit as p")
public class Produit {

	/** 
	 * Attributs
	 */
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String libelle;
	private String caracteristique;
	private String categorie;
	private String image;
	private Float prix;
	
	/**
	 * Constructeurs
	 */
	public Produit(String libelle, String caracteristique, String categorie,
			String image, Float prix) {
		super();
		this.libelle = libelle;
		this.caracteristique = caracteristique;
		this.categorie = categorie;
		this.image = image;
		this.prix = prix;
	}
	public Produit(){
		
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
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public String getCaracteristique() {
		return caracteristique;
	}
	public void setCaracteristique(String caracteristique) {
		this.caracteristique = caracteristique;
	}
	public String getCategorie() {
		return categorie;
	}
	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Float getPrix() {
		return prix;
	}
	public void setPrix(Float prix) {
		this.prix = prix;
	}
}
