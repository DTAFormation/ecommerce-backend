package dta.commerce.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import dta.commerce.ejb.IUserEJB;
import dta.commerce.persistance.Admin;
import dta.commerce.persistance.User;

@Path("/user")
public class UserRessource {
	@EJB IUserEJB myEJB;
	
	// ****** AJOUTER USER ******
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addUser(User user) {
		myEJB.addUser(user);
		ResponseBuilder builder = Response.ok();
		builder.status(201);
		return builder.build(); 
	}
	
	// ****** MODIFIER USER ******
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateUser(User user) {
		myEJB.updateUser(user);
		ResponseBuilder builder = Response.ok();
		builder.status(200);
		return builder.build(); 
	}
	
	// ****** SUPPRIMER USER ******
		@DELETE
		@Path("/{id}")
		public Response deleteUser(@PathParam(value = "id") Integer user) {
			myEJB.deleteUser(user);
			ResponseBuilder builder = Response.ok();
			builder.status(200);
			return builder.build(); 
		}
		
		// ****** ADD USER ******
		@GET
		@Path("/{id}")
		@Produces(MediaType.APPLICATION_JSON)
		public Response getUser(@PathParam(value = "id") Integer user) {
			User myUser = new User();
			myUser = myEJB.getUser(user);
			ResponseBuilder builder = Response.ok(myUser);
			builder.status(200);
			return builder.build(); 
		}
		
		// ****** LISTER USER ******
		@GET
		@Produces(MediaType.APPLICATION_JSON)
		public Response getUser() {
				List<User> myUsers= new ArrayList<User>();
				myUsers = myEJB.listerUser();
				ResponseBuilder builder = Response.ok(myUsers);
				builder.status(200);
				return builder.build(); 
			}
			
		// ****** CONNECTER USER ******
		@POST
		@Path("/connect")
		@Produces(MediaType.APPLICATION_JSON)
		@Consumes(MediaType.APPLICATION_JSON)
		public Response connectUser(User data){
			System.out.println(data.getLogin());
			User user=myEJB.getInfosUser(data.getLogin(), data.getPassword());
			user.setPassword("");
			//user.setId(null);
			ResponseBuilder builder = Response.ok(user);
			return builder.build(); 
		}
	
		// ****** TROUVER LOGIN USER ******
		@GET
		@Path("/chercher/{login}/")
		public Response connectUser(@PathParam(value = "login") String login){
			
			for (User user : myEJB.listerUser()) {
				if (login.equals(user.getLogin())){
						ResponseBuilder builderOK = Response.status(200);
						return builderOK.build();
				}
			}
			ResponseBuilder builderOK = Response.status(405);
			return builderOK.build();
			
		}
	
		

}
