package dta.commerce.ejb;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import dta.commerce.persistance.Adresse;

import dta.commerce.persistance.CommandeClient;
import dta.commerce.persistance.Facture;
import dta.commerce.persistance.Produit;
import dta.commerce.persistance.Stock;

import dta.commerce.persistance.User;

@Stateless
@TransactionManagement(value=TransactionManagementType.CONTAINER)
public class PersonneEJB {
	
	@PersistenceContext(unitName="my_pu") private EntityManager em;
	
	public PersonneEJB(){
			
	}
	
	public User createUser(){
		
		// Cette fonction me sert de test mon JPA 
		User myUser = new User("GUILLOTEAU", "Nathan", "login", "login");
		CommandeClient myCommande = new CommandeClient(myUser, "en cours");
		
		Produit myProd = new Produit("Velo", "Il roule", "Vehicule", "url/image", new Float(4));
		em.persist(myProd);
		
		List<Produit> myProduits = new ArrayList<Produit>();
		myProduits.add(myProd);
		//myCommande.setCommandeProduits(myProduits);
		
		
		em.persist(myCommande);
		
		
		Adresse adr1 = new Adresse(6, "rue athenas", "Nantes");
		Adresse adr2 = new Adresse(1, "rue capitaine corhumel", "Nantes");
		List<Adresse> myListAdresse = new ArrayList<Adresse>();
		myListAdresse.add(adr1);
		myListAdresse.add(adr2);
		myUser.setAdresses(myListAdresse);
		em.persist(myUser);

		
		Facture myFacture = new Facture(new Date(11/11/1991), "Par CB", adr1, adr2, myCommande);
		em.persist(myFacture);
		
		Stock leStock = new Stock(myProd, 4);
		em.persist(leStock);
		
		return myUser;
			
	
	}
	
	public User getInfosUser(String pLogin, String pMdp){
		
		String textQuery="Select u from User as u where u.login = :login and u.password = :mdp";
		TypedQuery<User> query=em.createQuery(textQuery, User.class);
		query.setParameter("login",pLogin);
		query.setParameter("mdp",pMdp);
		User user=query.getSingleResult();
		
		return user;

	}
	
}
