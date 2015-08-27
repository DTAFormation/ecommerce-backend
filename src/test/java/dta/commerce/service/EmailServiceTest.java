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

        CommandeClient commandeClient = new CommandeClient(user, etat);
        
        String libelle = "libelle1";
        String caracteristique = "caracteristique1";
        String categorie = "categorie1";
        String image = "";
        Float prix = Float.valueOf(2.0f);
        Produit produit = new Produit(libelle, caracteristique, categorie, image, prix, true);
        CommandeProduits commandeProduits = new CommandeProduits(produit, commandeClient);
        commandeClient.ajouterCommandeProduits(commandeProduits);
        
        Produit produit2 = new Produit(libelle, caracteristique, categorie, image, prix, true);
        CommandeProduits commandeProduits2 = new CommandeProduits(produit2, commandeClient);
        commandeClient.ajouterCommandeProduits(commandeProduits2);
        
        emailService.envoiEmailSmtp(commandeClient);
		
	}

}
