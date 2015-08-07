package dta.commerce.persistance;
//import org.eclipse.persistance.annotations.PrivateOwned;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("U")
public class User extends Personne {
	
	/** 
	 * Attributs
	 */
	@OneToMany(mappedBy="client", cascade = CascadeType.ALL)
	@MapKey(name="id")
	private List<Adresse> adresses = new ArrayList<Adresse>();

	
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
	
		
	
}
