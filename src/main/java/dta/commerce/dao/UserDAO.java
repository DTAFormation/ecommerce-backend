package dta.commerce.dao;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import dta.commerce.persistance.Personne;
import dta.commerce.persistance.User;

public class UserDAO implements IUserDAO {
	
	@PersistenceContext(unitName="my_pu") private EntityManager em;
	
	/* (non-Javadoc)
	 * @see dta.commerce.dao.IUserDAO#addUser(dta.commerce.persistaUserdmin)
	 */
	@Override
	public void addUser(User user){
		try{
			em.persist(user);
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		
		
	}

	/* (non-Javadoc)
	 * @see dta.commerce.dao.IUserDAO#deleteUser(int)
	 */
	@Override
	public void deleteUser(int idUser) {
		em.remove(em.find(User.class, idUser));
	}

	/* (non-Javadoc)
	 * @see dta.commerce.dao.IUsernDAO#updateUser(dta.commerce.persistance.User)
	 */
	@Override
	public void updateUser(User User) {
		em.merge(User);
	}

	/* (non-Javadoc)
	 * @see dta.commerce.dao.IUserDAO#listerUser()
	 */
	@Override
	@Transactional
	public List<User> listerUser() {
		return em.createNamedQuery("User.findAll").getResultList();
	}
	
	@Override
	@Transactional
	public User getUser(Integer user) {
		User myUser = (User) em.createQuery("Select u from User as u where u.id=" + user + "").getSingleResult();
		return myUser;
	}
	
	@Override
	@Transactional
	public User getInfosUser(String pLogin, String pMdp){
		String textQuery="Select p from Personne as p where p.login = :login and p.password = :mdp";
		TypedQuery<Personne> query=em.createQuery(textQuery, Personne.class);
		query.setParameter("login",pLogin);
		query.setParameter("mdp",pMdp);
		User user=(User)query.getSingleResult();
		
		return user;
	}
	
	/**
	 * Getter & setters
	 */
	
	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}
	
}
