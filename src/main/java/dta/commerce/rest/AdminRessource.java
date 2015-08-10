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
	@PUT
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addAdmin(Admin admin) {
		try {
			adminEjb.addAdmin(admin);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseBuilder builder = Response.ok();
		builder.status(201);
		return builder.build(); 
	}
	
	// ****** MODIFIER ADMIN ******
	@PUT
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateAdmin(Admin admin) {
		try {
			adminEjb.updateAdmin(admin);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseBuilder builder = Response.ok();
		builder.status(200);
		return builder.build(); 
	}
	
	// ****** SUPPRIMER ADMIN ******
		@DELETE
		@Path("/delete/{id}")
		public Response deleteAdmin(@PathParam(value = "id") Integer admin) {
			try {
				adminEjb.deleteAdmin(admin);
			} catch (Exception e) {
				e.printStackTrace();
			}
			ResponseBuilder builder = Response.ok();
			builder.status(200);
			return builder.build(); 
		}
		
		// ****** GET ADMIN ******
		@GET
		@Path("/get/{id}")
		@Produces(MediaType.APPLICATION_JSON)
		public Response getAdmin(@PathParam(value = "id") Integer admin) {
			Admin myAdmin = new Admin();
			try {
				myAdmin = adminEjb.getAdmin(admin);
			} catch (Exception e) {
				e.printStackTrace();
			}
			ResponseBuilder builder = Response.ok(myAdmin);
			builder.status(200);
			return builder.build(); 
		}
		
		// ****** LISTER ADMIN ******
			@GET
			@Path("/get")
			@Produces(MediaType.APPLICATION_JSON)
			public Response getAdmin() {
					List<Admin> myAdmins= new ArrayList<Admin>();
					try {
						myAdmins = adminEjb.listerAdmin();
					} catch (Exception e) {
						e.printStackTrace();
					}
					ResponseBuilder builder = Response.ok(myAdmins);
					builder.status(200);
					return builder.build(); 
				}
}

