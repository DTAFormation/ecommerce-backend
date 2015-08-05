package dta.commerce.persistance;

import java.util.List;

public class Admin extends Personne {
	
	/**
	 * Constructeurs
	 */
	public Admin(Integer id, String nom, String prenom, String login,
			String password, List<Adresse> listeComptes) {
		super(id, nom, prenom, login, password);
	}
	public Admin(){
		
	}
}
