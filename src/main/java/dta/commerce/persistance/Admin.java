package dta.commerce.persistance;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(
		name="Admin.findAll",
		query="select a from Admin as a")
@DiscriminatorValue("A")
public class Admin extends Personne {
	
	/** 
	 * Constructeurs
	 */ 
	public Admin(){
		
	}
	public Admin(boolean actif, String nom, String prenom, String login,
			String password) {
		super();
		this.setActif(actif);
		this.setNom(nom);
		this.setPrenom(prenom);
		this.setLogin(login);
		this.setPassword(password);
	}

}
