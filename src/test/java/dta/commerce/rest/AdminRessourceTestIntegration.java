package dta.commerce.rest;


import static org.junit.Assert.assertEquals;

import java.util.List;

import org.glassfish.jersey.message.internal.MediaTypes;
import org.junit.Before;
import org.junit.Test;

import dta.commerce.persistance.Admin;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;



public class AdminRessourceTestIntegration {
	private javax.ws.rs.client.Client client;
	private WebTarget target;
	
	@Before
	public void setUp() {
		client = ClientBuilder.newClient();
		target = client.target("http://localhost:8080/ecommerce-backend/api");
	}
	
	@Test
	public void testScenario() {
		Admin myAdmin1 = new Admin("AdminTest1Nom", "AdminTest1Prenom", "AdminTest1Login", "AdminTest1MotDePase");

		Admin myAdmin = testAddProduit(myAdmin1);
		testGetListAdmins();
		testGetAdminByID();
		testUpdateProduit(myAdmin1);
		testDeleteAdmin(110);
	}
	
	// Get de la liste d'admin
		public void testGetListAdmins() {
			Invocation.Builder builder = target.path("admin").path("get").request();
			Response resp = builder.get();
			assertEquals("Test du GET sur /admin/get", 200, resp.getStatus());
		}
	
	// Get d'un admin par l'id
		public void testGetAdminByID() {
			Invocation.Builder builder = target.path("admin").path("get").path("110").request();
			Response resp = builder.get();
			assertEquals("Test du GET sur /admin/get/{id}", 200, resp.getStatus());
		}
	
	// Add d'un admin
		public Admin testAddProduit(Admin admin) {
			Invocation.Builder builder = target.path("admin").path("add").request();
			Entity<Admin> myAdmin = Entity.entity(admin, MediaType.APPLICATION_JSON);
			Response resp = builder.put(myAdmin);
			assertEquals("Test du PUT sur /admin/add", 201, resp.getStatus());
			return resp.readEntity(Admin.class);
		}
	
	// Update d'un admin
		public void testUpdateProduit(Admin admin) {
			Invocation.Builder builder = target.path("admin").path("update").request();
			Entity<Admin> myAdmin = Entity.entity(admin, MediaType.APPLICATION_JSON);
			Response resp = builder.put(myAdmin);
			assertEquals("Test du PUT sur /admin/update/", 200, resp.getStatus());
		}
	
	// Delete d'un admin
		public void testDeleteAdmin(int id) {
			Invocation.Builder builder = target.path("admin").path("delete").path(Integer.toString(id)).request();
			Response resp = builder.delete();
			assertEquals("Test du DELETE sur /admin/delete/{id}", 200, resp.getStatus());
		}
	
	
}
