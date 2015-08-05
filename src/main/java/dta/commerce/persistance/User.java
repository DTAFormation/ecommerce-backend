package dta.commerce.persistance;

import java.util.ArrayList;
import java.util.List;

public class User extends Personne {
	
	/**
	 * Attributs
	 */
	private List<Adresse> listAdresse = new ArrayList<Adresse>();

	
	/**
	 * Constructeurs
	 */
	public User(Integer id, String nom, String prenom, String login,
			String password, List<Adresse> listeComptes) {
		super(id, nom, prenom, login, password);
		this.listAdresse = listeComptes;
	}
	public User(){
		
	}
	
	
	/**
	 * Getters & setters
	 */
	public List<Adresse> getListAdresse() {
		return listAdresse;
	}
	public void setListAdresse(List<Adresse> listeAdresse) {
		this.listAdresse = listAdresse;
	}
	
		
	
}
