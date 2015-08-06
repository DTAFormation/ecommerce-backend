package dta.commerce.persistance;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("A")
public class Admin extends Personne {
	
	/** 
	 * Constructeurs
	 */ 
	public Admin(String nom, String prenom, String login,
			String password) {
		super();
		this.setNom(nom);
		this.setPrenom(prenom);
		this.setLogin(login);
		this.setPassword(password);
	}
	public Admin(){
		
	}
}
