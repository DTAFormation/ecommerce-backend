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

@Path("/client")
public class CommandeRessource {
@EJB ICommandeEJB commmandeEjb;
@EJB IUserEJB	userEJB;
	
	@GET
	@Path("/commandes")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllCommands() {
		
		List<CommandeClient> listCde;
		try {
			listCde = commmandeEjb.listerCommandeClient();
		} catch (Exception e) {
			e.printStackTrace();
			listCde = null;
		}
		ResponseBuilder builder= Response.ok(listCde);
		return builder.build(); 
	}
	
	@GET
	@Path("/{idClient}/commandes")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCommandbyID(@PathParam("idClient") Integer id) {
		
		ResponseBuilder builder= Response.ok("");
		CommandeClient commandeCli;
		
		try {
			System.out.println("récupération de la commande de l'user :" + id);
			commandeCli = commmandeEjb.editCommandClient(id);
			builder.status(200);
		} catch (Exception e) {
			e.printStackTrace();
			commandeCli = null;
			builder.status(406);
		}
		builder = Response.ok(commandeCli);
		return builder.build();
	}
	
	@POST
	@Path("/{idClient}/commande")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createCommand(@PathParam("idClient") Integer idClient, CommandeClient commandeClient) {
				
		try {
			System.out.println("création de la commande");
			commandeClient.setClient(userEJB.getUser(idClient));
			commmandeEjb.updateCommandeClient(commandeClient);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return Response.status(Response.Status.CREATED).entity(commandeClient).build();
	}
	
	@PUT
	@Path("/{idClient}/commande")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateCommand(@PathParam("idClient") Integer idClient, CommandeClient commandeClient) {
		
		try {
			System.out.println("mise à jour de la commande du client " + idClient);
			commmandeEjb.updateCommandeClient(commandeClient);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Response.status(Response.Status.CREATED).entity(commandeClient).build();
	}
	
	@DELETE
	@Path("/{idClient}/commande/{idCommande}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response createCommandbyID(@PathParam("idClient") Integer idClient, @PathParam("idCommande") Integer idCommande ) {
		
		ResponseBuilder builder= Response.ok("");
		
		try {
			System.out.println("suppression de la commande du client " + idClient);
			commmandeEjb.deleteCommandeClient(idCommande);
			builder.status(200);
		} catch (Exception e) {
			e.printStackTrace();
			builder.status(404);
		}
		return builder.build();
	}
}
