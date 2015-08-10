package dta.commerce.rest;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import dta.commerce.ejb.AdminEJB;
import dta.commerce.ejb.IAdminEJB;
import dta.commerce.persistance.Admin;
import dta.commerce.persistance.User;

@Path("/admin")
public class AdminJAX {
	@EJB AdminEJB adminEjb;

	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response get() {

		Admin myAdmin = new Admin("Admin test", "Test", "loginAdmin", "PwdAdmin");
		try {
			
			System.out.println("BOU !!");
			adminEjb.addAdmin(myAdmin);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResponseBuilder builder = Response.ok(myAdmin);
		builder.status(200);
		return builder.build(); 
	}
	
	
}

