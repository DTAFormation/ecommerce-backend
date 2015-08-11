package dta.commerce.persistance;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="commandeClient") 
@NamedQuery(name="Commande.findAll",query="select c from CommandeClient as c")
@JsonIgnoreProperties(ignoreUnknown=true)
public class CommandeClient {
	
	/** 
	 * Attributs
	 */
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JsonIgnore
	private User client;
	
	@OneToMany(mappedBy="commandeClient", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JsonIgnore
	private List<CommandeProduits> commandeProduits = new ArrayList<CommandeProduits>();

	@OneToOne
	@JsonIgnore
	private Facture facture;
	
	private String etat;

	/**
	 * Constructeurs
	 */
	public CommandeClient(User client, String etat) {
		super();
		this.client = client;
		this.etat = etat;
	}
	
	public CommandeClient(){
		
	}
	
	/**
	 * Methods
	 */
	public void ajouterCommandeProduits(CommandeProduits commandeProduits){
		this.commandeProduits.add(commandeProduits);
	}
	
	public void retirerCommandeProduits(CommandeProduits commandeProduits){
		this.commandeProduits.remove(commandeProduits);
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
	public User getClient() {
		return client;
	}
	public void setClient(User client) {
		this.client = client;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}

	public List<CommandeProduits> getCommandeProduits() {
		return commandeProduits;
	}

	public void setCommandeProduits(List<CommandeProduits> commandeProduits) {
		this.commandeProduits = commandeProduits;
	}

	public Facture getFacture() {
		return facture;
	}

	public void setFacture(Facture facture) {
		this.facture = facture;
	}


}
