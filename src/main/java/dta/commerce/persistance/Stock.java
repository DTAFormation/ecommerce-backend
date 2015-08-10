package dta.commerce.persistance;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="stock") 
public class Stock {
	
	/** 
	 * Attributs
	 */
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id; 
	@ManyToOne
	private Produit prod;
	private Integer qte;
	

	

	/**
	 * Constructeurs
	 */
	public Stock(){
		
	}
	public Stock(Produit prod, Integer qte) {
		super();
		this.prod = prod;
		this.qte = qte;
	}



	/**
	 * Getters & setters
	 */
	public Produit getProd() {
		return prod;
	}

	public void setProd(Produit prod) {
		this.prod = prod;
	}

	public Integer getQte() {
		return qte;
	}

	public void setQte(Integer qte) {
		this.qte = qte;
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
