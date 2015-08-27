/**
 * 
 */
package dta.commerce.service;

import dta.commerce.persistance.CommandeClient;

/**
 * @author ETY
 *
 */
public interface IEmailService {
	
	public void envoiEmailSmtp(CommandeClient commandeClient);
	
}
