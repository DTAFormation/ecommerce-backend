package dta.commerce.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import dta.commerce.persistance.Adresse;
import dta.commerce.persistance.Personne;
import dta.commerce.persistance.User;

@Stateless
@TransactionManagement(value=TransactionManagementType.CONTAINER)
public class PersonneEJB {
	
	@PersistenceContext(unitName="my_pu") private EntityManager em;
	
	public PersonneEJB(){
			
	}
	
	public User createUser(){
		
		Adresse adr1 = new Adresse(6, "rue athenas", "Nantes");
		Adresse adr2 = new Adresse(1, "rue capitaine corhumel", "Nantes");
		List<Adresse> myListAdresse = new ArrayList<Adresse>();
		myListAdresse.add(adr1);
		myListAdresse.add(adr2);
		User myUser = new User("GUILLOTEAU", "Nathan", "login", "login", myListAdresse);
		
		em.persist(myUser);
		return myUser;		
	}
	
	public User getInfosUser(String pLogin, String pMdp){
		
		String textQuery="Select p from Personne as p where p.login = :login and p.password = :mdp";
		TypedQuery<Personne> query=em.createQuery(textQuery, Personne.class);
		query.setParameter("login",pLogin);
		query.setParameter("mdp",pMdp);
		User user=(User)query.getSingleResult();
		
		return user;
	}
	
}
