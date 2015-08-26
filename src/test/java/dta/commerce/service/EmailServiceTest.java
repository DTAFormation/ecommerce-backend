/**
 * 
 */
package dta.commerce.service;

import org.junit.Test;

import dta.commerce.persistance.CommandeClient;
import dta.commerce.persistance.CommandeProduits;
import dta.commerce.persistance.Produit;
import dta.commerce.persistance.User;

/**
 * @author ETY
 *
 */
public class EmailServiceTest {

	/**
	 * 
	 */
	public EmailServiceTest() {
		// TODO Auto-generated constructor stub
	}
	
	
	/*
	 * Méthode de tests
	 * 
	 */
	

	@Test
	public void testEnvoimail(){
		
		EmailService emailService = new EmailService();
		
		String courriel = "testformationdtaaout2015@gmail.com";

		
		User user = new User();
		user.setNom("Dupont");
		user.setPrenom("Michel");
		user.setLogin(courriel);
		String etat = "en cours";
		String libelle = "libelle1";
		String caracteristique = "caracteristique1";
		String categorie = "categorie1";
		String image = "";
		Float prix = (float) 2;
		Produit produit = new Produit(libelle, caracteristique, categorie, image, prix, true);
		
		CommandeClient commandeClient = new CommandeClient(user, etat);
		CommandeProduits commandeProduits = new CommandeProduits(produit, commandeClient);
		
		commandeClient.ajouterCommandeProduits(commandeProduits);
		
		emailService.envoiEmailSmtp(commandeClient);
		
	}

}
