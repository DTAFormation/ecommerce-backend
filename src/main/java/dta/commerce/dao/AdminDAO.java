package dta.commerce.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import dta.commerce.persistance.Admin;
import dta.commerce.persistance.User;

public class AdminDAO implements IAdminDAO {
	
	@PersistenceContext(unitName="my_pu") private EntityManager em;
	
	/* (non-Javadoc)
	 * @see dta.commerce.dao.IAdminDAO#addAdmin(dta.commerce.persistance.Admin)
	 */
	@Override
	public void addAdmin(Admin admin){
		em.persist(admin);	
	}

	/* (non-Javadoc)
	 * @see dta.commerce.dao.IAdminDAO#deleteAdmin(int)
	 */
	@Override
	public void deleteAdmin(int idAdmin) {
		em.remove(em.find(Admin.class, idAdmin));
	}

	/* (non-Javadoc)
	 * @see dta.commerce.dao.IAdminDAO#updateAdmin(dta.commerce.persistance.Admin)
	 */
	@Override
	public void updateAdmin(Admin admin) {
		em.merge(admin);
	}

	/* (non-Javadoc)
	 * @see dta.commerce.dao.IAdminDAO#listerAdmin()
	 */
	@Override
	@Transactional
	public List<Admin> listerAdmin() {
		return em.createNamedQuery("Admin.findAll").getResultList();
	}
	
	@Override
	@Transactional
	public Admin getAdmin(Integer admin) {
		String textQuery="Select a from Admin as a where a.id=:id";
		TypedQuery<Admin> query=em.createQuery(textQuery, Admin.class);
		query.setParameter("id",admin);
		Admin myAdmin=query.getSingleResult();
		return myAdmin;
		
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
