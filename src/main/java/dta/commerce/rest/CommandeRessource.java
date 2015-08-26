package dta.commerce.rest;

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

import dta.commerce.ejb.ICommandeEJB;
import dta.commerce.ejb.IUserEJB;
import dta.commerce.persistance.CommandeClient;
import dta.commerce.service.EmailService;

@Path("/commande")
public class CommandeRessource {
@EJB ICommandeEJB commmandeEjb;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllCommandes(){
		List<CommandeClient> listCde;
		listCde = commmandeEjb.listerAllCommandeClient();
		ResponseBuilder builder = Response.ok(listCde);
		return builder.build();
	}
	
	@GET
	@Path("/{idCommande}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCommandeById(@PathParam("idCommande") Integer idCommande){
		
		ResponseBuilder builder= Response.ok("");
		CommandeClient commandeCli;
		commandeCli = commmandeEjb.editCommandClient(idCommande);
		if (commandeCli == null) {
			builder.status(404);
			return builder.build();
		}
		builder.status(200);
		builder = Response.ok(commandeCli);
		return builder.build();
	}	
}
