package dta.commerce.rest;

import static junit.framework.Assert.assertEquals;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.junit.Before;
import org.junit.Test;

import dta.commerce.persistance.CommandeClient;
import dta.commerce.persistance.Produit;
import dta.commerce.persistance.User;

public class CommandeRessourceTestIntegration {
	
	private javax.ws.rs.client.Client client;
	private WebTarget target;
	
	public CommandeClient mockCommandeCli() {
		CommandeClient cdeClie = new CommandeClient();
		return cdeClie;
	}
	
	@Before
	public void setUp() {
		client = ClientBuilder.newClient();
		target = client.target("http://localhost:8085/ecommerce-backend/api");
	}

	@Test
	public void testScenario() {
		CommandeClient cde1 = mockCommandeCli();
				
		testGetCommandbyID();
		testGetClientCommandes();
		
		
		cde1.setEtat("en cours");
		testcreateCommand(cde1);
		
		cde1.setId(1);
		testupdateCommande(cde1);
		
//		testDeleteCommandbyID(cde1.getId());
	}
	
	
	public void testGetClientCommandes() {
		Invocation.Builder builder = target.path("client").path("1").path("commandes").request();
		Response resp = builder.get();
		assertEquals("Test du GET sur /{idClient}/commandes", 200, resp.getStatus());
	}
	
	
	public void testGetCommandbyID() {
		Invocation.Builder builder = target.path("client").path("1").path("commande").path("1").request();
		Response resp = builder.get();
		assertEquals("Test du GET sur /{idClient}/commande/{idCommande}", 200, resp.getStatus());
	}
		
	public Produit testcreateCommand(CommandeClient commandeClient) {
		Invocation.Builder builder = target.path("client").path("1").path("commande").request();
		Entity e = Entity.entity(commandeClient, MediaType.APPLICATION_JSON);
		Response resp = builder.post(e);
		assertEquals("Test du POST sur /{idClient}/commande", 201, resp.getStatus());
		return resp.readEntity(Produit.class);
	}
	
	public void testupdateCommande(CommandeClient commandeClient) {
		Invocation.Builder builder = target.path("client").path("1").path("commande").request();
		Entity e = Entity.entity(commandeClient, MediaType.APPLICATION_JSON);
		Response resp = builder.put(e);
		assertEquals("Test du PUT sur /{idClient}/commande", 200, resp.getStatus());
	}
	
	public void testDeleteCommandbyID(Integer id) {
		Invocation.Builder builder = target.path("client").path("1").path("commande").path(Integer.toString(id)).request();
		Response resp = builder.delete();
		assertEquals("Test du DELETE sur /{idClient}/commande/{idCommande}", 200, resp.getStatus());
	}
	
}
