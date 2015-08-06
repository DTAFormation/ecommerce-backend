package dta.commerce.persistance;

public class Produit {

	/** 
	 * Attributs
	 */
	private Integer id;
	private String libelle;
	private String caracteritique;
	private String categorie;
	private String image;
	private Float prix;

	
	/**
	 * Constructeurs
	 */
	public Produit(Integer id, String libelle, String caracteritique, String categorie,
			String image, Float prix) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.caracteritique = caracteritique;
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
	public String getCaracteritique() {
		return caracteritique;
	}
	public void setCaracteritique(String caracteritique) {
		this.caracteritique = caracteritique;
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
