package dta.commerce.rest;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;

import dta.commerce.ejb.IProduitEJB;
import dta.commerce.ejb.ProduitEJB;
import dta.commerce.persistance.Produit;

@Path("/produit")
public class ProduitRessource {
	
	@EJB IProduitEJB produitEjb;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getListProduits() {
		List<Produit> produits = produitEjb.listerProduits();
		return Response.ok(produits, MediaType.APPLICATION_JSON).build();
	}
	
	@GET
	@Path("/{id}")
	public Response getProduitByID(@PathParam("id") Integer idProduit) {
		Produit produit = produitEjb.getProduit(idProduit);
		return Response.ok(produit, MediaType.APPLICATION_JSON).build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addProduit(Produit produit) {
		produitEjb.addProduit(produit);
		return Response.status(Response.Status.CREATED).entity(produit).build();
	}
	
	@DELETE
	@Path("/{id}")
	public Response deleteProduit(@PathParam("id") Integer idProduit) {
		produitEjb.deleteProduit(idProduit);
		return Response.status(Response.Status.OK).build();
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateProduit(Produit produit) {
		produitEjb.updateProduit(produit);
		return Response.status(Response.Status.OK).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/byIds/{ids}")
	public Response listerProduitsById( @PathParam("ids") String idProduits){
		List<Produit> myProduits = new ArrayList<Produit>();
		for(String id : idProduits.split(",")) {
			myProduits.add(produitEjb.getProduit(Integer.valueOf(id)));
		}
		
		
		return Response.ok(myProduits, MediaType.APPLICATION_JSON).build();
	}
}
