package dta.commerce.persistance;

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
@Table(name="adresse")
public class Adresse {

	/** 
	 * Attributs
	 */
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private Integer numero;
	
	private String rue;
	
	private String ville;
	
	
	@ManyToOne
	@JsonBackReference
	private User client;
	


	/**
	 * Constructeurs
	 */
	public Adresse() {
	}

	public Adresse(Integer numero, String rue, String ville) {
		this.numero = numero;
		this.rue = rue;
		this.ville = ville;
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
	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}
	public User getClient() {
		return client;
	}

	public void setClient(User client) {
		this.client = client;
	}
}

