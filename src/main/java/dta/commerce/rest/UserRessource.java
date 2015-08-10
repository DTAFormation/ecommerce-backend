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
	@PUT
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addUser(User user) {
		try {
			myEJB.addUser(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseBuilder builder = Response.ok();
		builder.status(201);
		return builder.build(); 
	}
	
	// ****** MODIFIER USER ******
	@PUT
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateUser(User user) {
		try {
			myEJB.updateUser(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseBuilder builder = Response.ok();
		builder.status(200);
		return builder.build(); 
	}
	
	// ****** SUPPRIMER USER ******
		@DELETE
		@Path("/delete/{id}")
		public Response deleteUser(@PathParam(value = "id") Integer user) {
			try {
				myEJB.deleteUser(user);
			} catch (Exception e) {
				e.printStackTrace();
			}
			ResponseBuilder builder = Response.ok();
			builder.status(200);
			return builder.build(); 
		}
		
		// ****** ADD USER ******
		@GET
		@Path("/get/{id}")
		@Produces(MediaType.APPLICATION_JSON)
		public Response getUser(@PathParam(value = "id") Integer user) {
			User myUser = new User();
			try {
				myUser = myEJB.getUser(user);
			} catch (Exception e) {
				e.printStackTrace();
			}
			ResponseBuilder builder = Response.ok(myUser);
			builder.status(200);
			return builder.build(); 
		}
		
		// ****** LISTER USER ******
			@GET
			@Path("/get")
			@Produces(MediaType.APPLICATION_JSON)
			public Response getAdmin() {
					List<User> myUsers= new ArrayList<User>();
					try {
						myUsers = myEJB.listerUser();
					} catch (Exception e) {
						e.printStackTrace();
					}
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
				user.setId(null);
				ResponseBuilder builder = Response.ok(user);
				return builder.build(); 
			}
	
		

}
