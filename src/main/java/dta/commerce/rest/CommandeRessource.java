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
	@Path("/{idClient}/commandes")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getClientCommandes(@PathParam("idClient") Integer idClient) {
		
		List<CommandeClient> listCde;
		listCde = commmandeEjb.listerCommandeClient(idClient);
		ResponseBuilder builder= Response.ok(listCde);
		return builder.build(); 
	}
	
	@GET
	@Path("/{idClient}/commande/{idCommande}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCommandbyID(@PathParam("idClient") Integer idClient, @PathParam("idCommande") Integer idCommande) {
		
		ResponseBuilder builder= Response.ok("");
		CommandeClient commandeCli;
		commandeCli = commmandeEjb.editCommandClient(idCommande);
		builder.status(200);
		builder = Response.ok(commandeCli);
		return builder.build();
	}
	
	@POST
	@Path("/{idClient}/commande")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createCommand(@PathParam("idClient") Integer idClient, CommandeClient commandeClient) {
				
		System.out.println("création de la commande");
		commandeClient.setClient(userEJB.getUser(idClient));
		commmandeEjb.updateCommandeClient(commandeClient);

		return Response.status(Response.Status.CREATED).entity(commandeClient).build();
	}
	
	@PUT
	@Path("/{idClient}/commande")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateCommande(@PathParam("idClient") Integer idClient, CommandeClient commandeClient) {
		
		System.out.println("mise à jour de la commande du client " + idClient);
		commmandeEjb.updateCommandeClient(commandeClient);

		return Response.status(Response.Status.CREATED).entity(commandeClient).build();
	}
	
	@DELETE
	@Path("/{idClient}/commande/{idCommande}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteCommandbyID(@PathParam("idClient") Integer idClient, @PathParam("idCommande") Integer idCommande ) {
		
		ResponseBuilder builder= Response.ok("");
		
		System.out.println("suppression de la commande du client " + idClient);
		commmandeEjb.deleteCommandeClient(idCommande);
		builder.status(200);

		return builder.build();
	}
}
