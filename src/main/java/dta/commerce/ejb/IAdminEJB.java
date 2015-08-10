package dta.commerce.ejb;

import java.util.List;

import javax.transaction.Transactional;

import dta.commerce.persistance.Admin;

public interface IAdminEJB {

	/* (non-Javadoc)
	 * @see dta.commerce.ejb.IAdminEJB#listerAdmin()
	 */
	public abstract List<Admin> listerAdmin();

	/* (non-Javadoc)
	 * @see dta.commerce.ejb.IAdminEJB#addAdmin(dta.commerce.persistance.Admin)
	 */
	public abstract void addAdmin(Admin admin);

	/* (non-Javadoc)
	 * @see dta.commerce.ejb.IAdminEJB#deleteAdmin(java.lang.Integer)
	 */
	public abstract void deleteAdmin(Integer admin);

	/* (non-Javadoc)
	 * @see dta.commerce.ejb.IAdminEJB#updateAdmin(dta.commerce.persistance.Admin)
	 */
	public abstract void updateAdmin(Admin admin);

}