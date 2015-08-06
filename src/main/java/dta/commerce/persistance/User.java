package dta.commerce.persistance;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("U")
public class User extends Personne {
	
	/** 
	 * Attributs
	 */
	//@OneToMany(mappedBy="user", cascade=CascadeType.ALL)
	//private List<Adresse> listAdresse = new ArrayList<Adresse>();

	
	/**
	 * Constructeurs
	 */
	public User(String nom, String prenom, String login,
			String password, List<Adresse> listeAdresse) {
		super();
		this.setNom(nom);
		this.setPrenom(prenom);
		this.setLogin(login);
		this.setPassword(password);
		//this.listAdresse = listeAdresse;
	}
	public User(){
		
	}
	
	
	/**
	 * Getters & setters
	 */
//	public List<Adresse> getListAdresse() {
//		return listAdresse;
//	}
//	public void setListAdresse(List<Adresse> listeAdresse) {
//		this.listAdresse = listAdresse;
//	}
	
		
	
}
