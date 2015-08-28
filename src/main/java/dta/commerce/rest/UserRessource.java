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

import dta.commerce.ejb.ICommandeEJB;
import dta.commerce.ejb.IProduitEJB;
import dta.commerce.ejb.IUserEJB;
import dta.commerce.persistance.Adresse;
import dta.commerce.persistance.CommandeClient;
import dta.commerce.persistance.User;
import dta.commerce.service.IEmailService;

@Path("/user")
public class UserRessource {
	@EJB IUserEJB myEJB;
	@EJB ICommandeEJB commmandeEjb;
	@EJB IEmailService email;
	@EJB IProduitEJB produitEjb;
	
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

		// ****** AJOUTER NOUVELLES ADRESSES DANS UN USER ******
		@POST
		@Path("/{id}/adresses/")
		@Produces(MediaType.APPLICATION_JSON)
		@Consumes(MediaType.APPLICATION_JSON)
		public Response addAdresses(List<Adresse> adresses){
			myEJB.addAdressesUser(adresses);
			ResponseBuilder builder = Response.ok();
			builder.status(201);
			return builder.build(); 
		}
		
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
				
			commandeClient.setClient(myEJB.getUser(idClient));
			// Commande en cours à la création
			commandeClient.setEtat("EC");
			
			commandeClient.getCommandeProduits().stream().forEach(commandeProduit -> {
				commandeProduit.setCommandeClient(commandeClient);
				commandeProduit.setProduit(produitEjb.getProduit(commandeProduit.getProduit().getId()));
			});
			
			commmandeEjb.createCommandeClient(commandeClient);
			//envoi d'un email à l'adresse enregistré dans login
			email.envoiEmailSmtp(commandeClient);
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
