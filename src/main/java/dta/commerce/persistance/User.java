package dta.commerce.persistance;
//import org.eclipse.persistance.annotations.PrivateOwned;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.MapKey;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@NamedQuery(
		name="User.findAll",
		query="select u from User as u")
@DiscriminatorValue("U")
public class User extends Personne {
	
	/** 
	 * Attributs
	 */
	@OneToMany(mappedBy="client", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	@MapKey(name="id")
	@JsonIgnore
	private List<Adresse> adresses = new ArrayList<Adresse>();
	
	@OneToMany(mappedBy = "client", fetch=FetchType.EAGER)
	@JsonIgnore
	private List<CommandeClient> listCommandes = new ArrayList<CommandeClient>();
	
	/**
	 * Constructeurs
	 */
	public User(String nom, String prenom, String login,
			String password, List<Adresse> adresses) {
		super();
		this.setNom(nom);
		this.setPrenom(prenom);
		this.setLogin(login);
		this.setPassword(password);
		this.setAdresses(adresses);
	}
	public User(String nom, String prenom, String login,
			String password) {
		super();
		this.setNom(nom);
		this.setPrenom(prenom);
		this.setLogin(login);
		this.setPassword(password);
	}
	public User(){
		
	}
	
	
	/**
	 * Getters & setters
	 */
	public List<Adresse> getAdresses() {
		return adresses;
	}
	public void setAdresses(List<Adresse> adresses) {
		for (Adresse adresse : adresses) {
			adresse.setClient(this);
		}
		this.adresses = adresses;
	}
	public Integer getId(){
		return super.getId();
	}
	
	public List<CommandeClient> addCommandClient (CommandeClient commandeClient){
		this.listCommandes.add(commandeClient);
		return listCommandes;
	}
	
	public List<CommandeClient> removeCommandClient (CommandeClient commandeClient){
		this.listCommandes.remove(commandeClient);
		return listCommandes;
	}
	
}
