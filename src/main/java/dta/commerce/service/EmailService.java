/**
 * 
 */
package dta.commerce.service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import dta.commerce.persistance.CommandeClient;
import dta.commerce.persistance.CommandeProduits;

/**
 * @author ETY
 *
 */
@Stateless
@TransactionManagement(value=TransactionManagementType.CONTAINER)
public class EmailService implements IEmailService {

	/**
	 * 
	 */
	public EmailService() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * @param filename
	 * @return
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	private Properties load(String filename) throws IOException,
			FileNotFoundException {
		
		Properties properties = new Properties();

		FileInputStream input = new FileInputStream(filename);
		try {

			properties.load(input);
			return properties;

		}

		finally {

			input.close();

		}

	}

	/**
	 * 
	 * @param commandeClient
	 */
	public void envoiEmailSmtp(CommandeClient commandeClient) {

		String format = "dd/MM/yy HH:mm:ss";
		java.text.SimpleDateFormat formater = new java.text.SimpleDateFormat(
				format);
		java.util.Date date = new java.util.Date();

		String courriel = commandeClient.getClient().getLogin();
		
		System.out.println(courriel);
		
		String emailcp = "";
		for (CommandeProduits cp : commandeClient.getCommandeProduits()) {
			emailcp += "\n Libelle du produit : " + cp.getProduit().getLibelle()
					+ "\n" + " appartenant à la catégorie :"
					+ cp.getProduit().getCategorie() + "\n"
					+ " avec les caractéristiques : "
					+ cp.getProduit().getCaracteristique() + "\n"
					+ " coûtant :" + cp.getProduit().getPrix() + "\n";
		}

		String content = "Bonjour m./mme "
				+ commandeClient.getClient().getNom() + " "
				+ commandeClient.getClient().getPrenom() + ", \n\n"
				+ "Votre commande faite le " + formater.format(date)
				+ " contenant le(s) produit(s) : \n" + emailcp 
				+ "\n a bien été prise en compte. \n\n"
				+ "L'équipe DTAformation2 vous remercie.";

		System.out.println(content);

		try {
			// chargement des propriétés
			String homeDir = System.getProperty("user.home");
			Properties prop = load(homeDir
					+ "/dtaformation/smtp-conf.properties");

			// Affichage des propriétés
			// Récupère la propriété login/mdp

			String login = prop.getProperty("login");
			String pwd = prop.getProperty("password");

			// instanciation des email
			Email email = new SimpleEmail();
			// host name googlemail.com
			email.setHostName("smtp.googlemail.com");
			// port gmail
			email.setSmtpPort(465);
			// login mdp du mail d'envoi
			email.setAuthenticator(new DefaultAuthenticator(login, pwd));
			email.setSSLOnConnect(true);
			// email de destination
			email.setFrom("test@yopmail.com");
			// titre du mail
			email.setSubject("Nouvelle commande sur le site DTAformationAout2015.");
			email.setMsg(content);
			email.addTo(courriel);
			// email.setBounceAddress("bounce@yopmail.com");
			email.send();
		} catch (EmailException | IOException e) {
			System.err.println("erreur sur l'email");
			e.printStackTrace();
		}

	}

}
