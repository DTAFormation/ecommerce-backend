package dta.commerce.rest;


import static org.junit.Assert.assertEquals;

import java.util.List;

import org.glassfish.jersey.message.internal.MediaTypes;
import org.junit.Before;
import org.junit.Test;

import dta.commerce.persistance.User;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;



public class UserRessourceTest {
	private javax.ws.rs.client.Client client;
	private WebTarget target;
	
	@Before
	public void setUp() {
		client = ClientBuilder.newClient();
		target = client.target("http://localhost:8080/ecommerce-backend/api");
	}
	
	@Test
	public void testScenario() {
		User myUser1 = new User("UserTest1Nom", "UserTest1Prenom", "UserTest1Login", "UserTest1MotDePase");

		User myUser = testAddProduit(myUser1);
		testGetListUsers();
		testGetUserByID();
		testUpdateProduit(myUser1);
		testDeleteUser(110);
	}
	
	// Get de la liste d'User
		public void testGetListUsers() {
			Invocation.Builder builder = target.path("user").path("get").request();
			Response resp = builder.get();
			assertEquals("Test du GET sur /user/get", 200, resp.getStatus());
		}
	
	// Get d'un User par l'id
		public void testGetUserByID() {
			Invocation.Builder builder = target.path("user").path("get").path("110").request();
			Response resp = builder.get();
			assertEquals("Test du GET sur /user/get/{id}", 200, resp.getStatus());
		}
	
	// Add d'un User
		public User testAddProduit(User user) {
			Invocation.Builder builder = target.path("user").path("add").request();
			Entity<User> myUser = Entity.entity(user, MediaType.APPLICATION_JSON);
			Response resp = builder.put(myUser);
			assertEquals("Test du PUT sur /user/add", 201, resp.getStatus());
			return resp.readEntity(User.class);
		}
	
	// Update d'un User
		public void testUpdateProduit(User user) {
			Invocation.Builder builder = target.path("user").path("update").request();
			Entity<User> myUser = Entity.entity(user, MediaType.APPLICATION_JSON);
			Response resp = builder.put(myUser);
			assertEquals("Test du PUT sur /user/update/", 200, resp.getStatus());
		}
	
	// Delete d'un User
		public void testDeleteUser(int id) {
			Invocation.Builder builder = target.path("user").path("delete").path(Integer.toString(id)).request();
			Response resp = builder.delete();
			assertEquals("Test du DELETE sur /user/delete/{id}", 200, resp.getStatus());
		}
	
	
}
