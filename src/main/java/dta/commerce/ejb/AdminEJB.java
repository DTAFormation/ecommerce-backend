package dta.commerce.ejb;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;
import javax.transaction.Transactional;

import dta.commerce.dao.IAdminDAO;
import dta.commerce.persistance.Admin;

@Stateless
@TransactionManagement(value=TransactionManagementType.CONTAINER)
public class AdminEJB  {
	

	@Inject private IAdminDAO adminDao;
	
	/* (non-Javadoc)
	 * @see dta.commerce.ejb.IAdminEJB#listerAdmin()
	 */
	/* (non-Javadoc)
	 * @see dta.commerce.ejb.IAdminEJB#listerAdmin()
	 */

	public List<Admin> listerAdmin() {
		return adminDao.listerAdmin();
	}
	
	/* (non-Javadoc)
	 * @see dta.commerce.ejb.IAdminEJB#addAdmin(dta.commerce.persistance.Admin)
	 */
	/* (non-Javadoc)
	 * @see dta.commerce.ejb.IAdminEJB#addAdmin(dta.commerce.persistance.Admin)
	 */

	public void addAdmin(Admin admin){
		adminDao.addAdmin(admin);
	}
	
	/* (non-Javadoc)
	 * @see dta.commerce.ejb.IAdminEJB#deleteAdmin(java.lang.Integer)
	 */
	/* (non-Javadoc)
	 * @see dta.commerce.ejb.IAdminEJB#deleteAdmin(java.lang.Integer)
	 */

	public void deleteAdmin(Integer admin) {
		adminDao.deleteAdmin(admin);
	}
	
	/* (non-Javadoc)
	 * @see dta.commerce.ejb.IAdminEJB#updateAdmin(dta.commerce.persistance.Admin)
	 */
	/* (non-Javadoc)
	 * @see dta.commerce.ejb.IAdminEJB#updateAdmin(dta.commerce.persistance.Admin)
	 */

	public void updateAdmin(Admin admin) {
		adminDao.updateAdmin(admin);
	}
	
	
	
	
}
