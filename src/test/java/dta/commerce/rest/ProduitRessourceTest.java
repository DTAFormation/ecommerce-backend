package dta.commerce.rest;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static junit.framework.Assert.*;

import org.junit.Before;
import org.junit.Test;

import dta.commerce.persistance.Produit;

public class ProduitRessourceTest {
	
	private javax.ws.rs.client.Client client;
	private WebTarget target;
	
	public Produit mockProduit() {
		Produit p = new Produit("mockProduit", "mockCaracteristique", "mockCategorie", "mockImage", 0.0F);
		return p;
	}
	
	@Before
	public void setUp() {
		client = ClientBuilder.newClient();
		target = client.target("http://localhost:6070/ecommerce-backend/api");
	}
	
	@Test
	public void testScenario() {
		Produit p = mockProduit();
		Produit p2 = testAddProduit(p);
		testGetListProduits();
		testGetProduitByID();
		testUpdateProduit(p);
		testDeleteProduit(p2.getId());
	}
	
	public void testGetListProduits() {
		Invocation.Builder builder = target.path("produit").request();
		Response resp = builder.get();
		assertEquals("Test du GET sur /produit", 200, resp.getStatus());
	}
	
	public void testGetProduitByID() {
		Invocation.Builder builder = target.path("produit").path("1").request();
		Response resp = builder.get();
		assertEquals("Test du GET sur /produit/{id}", 200, resp.getStatus());
	}
	
	public Produit testAddProduit(Produit produit) {
		Invocation.Builder builder = target.path("produit").request();
		Entity e = Entity.entity(produit, MediaType.APPLICATION_JSON);
		Response resp = builder.post(e);
		assertEquals("Test du POST sur /produit", 201, resp.getStatus());
		return resp.readEntity(Produit.class);
	}
	
	public void testUpdateProduit(Produit produit) {
		Invocation.Builder builder = target.path("produit").request();
		Entity e = Entity.entity(produit, MediaType.APPLICATION_JSON);
		Response resp = builder.put(e);
		assertEquals("Test du PUT sur /produit", 200, resp.getStatus());
	}
	
	public void testDeleteProduit(int id) {
		Invocation.Builder builder = target.path("produit").path(Integer.toString(id)).request();
		Response resp = builder.delete();
		assertEquals("Test du DELETE sur /produit/{id}", 200, resp.getStatus());
	}
	
}
