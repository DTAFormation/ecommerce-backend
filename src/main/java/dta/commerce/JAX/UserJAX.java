package dta.commerce.JAX;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;


import dta.commerce.ejb.PersonneEJB;
import dta.commerce.persistance.User;

@Path("/personne")
public class UserJAX {
	@EJB PersonneEJB myEJB;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response get(){

		User myUser = myEJB.createUser();	

		ResponseBuilder builder = Response.ok(myUser);
		builder.status(200);
		//builder.header("Access-Control-Allow-Origin", "*");
		
		return builder.build(); 
	}
}
