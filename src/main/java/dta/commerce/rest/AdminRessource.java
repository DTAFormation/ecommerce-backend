package dta.commerce.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.ws.rs.BeanParam;
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

import dta.commerce.ejb.AdminEJB;
import dta.commerce.ejb.IAdminEJB;
import dta.commerce.persistance.Admin;
import dta.commerce.persistance.User;

@Path("/admin")
public class AdminRessource {
	@EJB AdminEJB adminEjb;

	
	// ****** AJOUTER ADMIN ******
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addAdmin(Admin admin) {
		adminEjb.addAdmin(admin);
		ResponseBuilder builder = Response.ok();
		builder.status(201);
		return builder.build(); 
	}
	
	// ****** MODIFIER ADMIN ******
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateAdmin(Admin admin) {
		adminEjb.updateAdmin(admin);
		ResponseBuilder builder = Response.ok();
		builder.status(200);
		return builder.build(); 
	}
	
	// ****** SUPPRIMER ADMIN ******
		@DELETE
		@Path("/{id}")
		public Response deleteAdmin(@PathParam(value = "id") Integer admin) {
			adminEjb.deleteAdmin(admin);
			ResponseBuilder builder = Response.ok();
			builder.status(200);
			return builder.build(); 
		}
		
		// ****** GET ADMIN ******
		@GET
		@Path("/{id}")
		@Produces(MediaType.APPLICATION_JSON)
		public Response getAdmin(@PathParam(value = "id") Integer admin) {
			Admin myAdmin = new Admin();
			myAdmin = adminEjb.getAdmin(admin);
			ResponseBuilder builder = Response.ok(myAdmin);
			builder.status(200);
			return builder.build(); 
		}
		
		// ****** LISTER ADMIN ******
		@GET
		@Produces(MediaType.APPLICATION_JSON)
		public Response getAdmin() {
				List<Admin> myAdmins= new ArrayList<Admin>();
				myAdmins = adminEjb.listerAdmin();
				ResponseBuilder builder = Response.ok(myAdmins);
				builder.status(200);
				return builder.build(); 
			}
			
		// ****** CONNECTER ADMIN ******
		@POST
		@Produces(MediaType.APPLICATION_JSON)
		@Consumes(MediaType.APPLICATION_JSON)
		@Path("/connect/")
		public Response connectUser(Admin data){
			
			for (Admin admin : adminEjb.listerAdmin()) {
				if (data.getLogin().equals(admin.getLogin())){
					if (data.getPassword().equals(admin.getPassword())){
						ResponseBuilder builderOK = Response.status(200);
						return builderOK.build();
					} 
				}
			}
			ResponseBuilder builderOK = Response.status(405);
			return builderOK.build();
			
		}
		
		// ****** TROUVER LOGIN ADMIN ******
			@POST
			@Path("/chercher/{login}/")
			public Response connectUser(@PathParam(value = "login") String login){
				
				for (Admin admin : adminEjb.listerAdmin()) {
					if (login.equals(admin.getLogin())){
							ResponseBuilder builderOK = Response.status(200);
							return builderOK.build();
					}
				}
				ResponseBuilder builderOK = Response.status(405);
				return builderOK.build();
				
			}
		
			
			
}

