package dta.commerce.ejb;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import dta.commerce.dao.IAdressesDAO;
import dta.commerce.dao.IUserDAO;
import dta.commerce.persistance.Adresse;
import dta.commerce.persistance.Personne;
import dta.commerce.persistance.User;


@Stateless
@TransactionManagement(value=TransactionManagementType.CONTAINER)
public class UserEJB implements IUserEJB  {
	

	@Inject private IUserDAO userDao;
	@Inject private IAdressesDAO adresseDao;
	
	/* (non-Javadoc)
	 * @see dta.commerce.ejb.IUserEJB#listerUser()
	 */
	/* (non-Javadoc)
	 * @see dta.commerce.ejb.IUserEJB#listerUser()
	 */

	/* (non-Javadoc)
	 * @see dta.commerce.ejb.IUserEJB#listerUser()
	 */
	@Override
	public List<User> listerUser() {
		return userDao.listerUser();
	}
	
	/* (non-Javadoc)
	 * @see dta.commerce.ejb.IUserEJB#addUser(dta.commerce.persistance.User)
	 */
	/* (non-Javadoc)
	 * @see dta.commerce.ejb.IUserEJB#addUser(dta.commerce.persistance.User)
	 */

	/* (non-Javadoc)
	 * @see dta.commerce.ejb.IUserEJB#addUser(dta.commerce.persistance.User)
	 */
	@Override
	public void addUser(User user){
		userDao.addUser(user);
	}
	
	/* (non-Javadoc)
	 * @see dta.commerce.ejb.IUserEJB#deleteUser(java.lang.Integer)
	 */
	/* (non-Javadoc)
	 * @see dta.commerce.ejb.IUserEJB#deleteUser(java.lang.Integer)
	 */

	/* (non-Javadoc)
	 * @see dta.commerce.ejb.IUserEJB#deleteUser(java.lang.Integer)
	 */
	@Override
	public void deleteUser(Integer user) {
		userDao.deleteUser(user);
	}
	
	/* (non-Javadoc)
	 * @see dta.commerce.ejb.IUserEJB#updateUser(dta.commerce.persistance.User)
	 */
	/* (non-Javadoc)
	 * @see dta.commerce.ejb.IUserEJB#updateUser(dta.commerce.persistance.User)
	 */

	/* (non-Javadoc)
	 * @see dta.commerce.ejb.IUserEJB#updateUser(dta.commerce.persistance.User)
	 */
	@Override
	public void updateUser(User user) {
		userDao.updateUser(user);
	}
	

	/* (non-Javadoc)
	 * @see dta.commerce.ejb.IUserEJB#getUser(java.lang.Integer)
	 */
	@Override
	public User getUser(Integer user){
		return userDao.getUser(user);
	}
	
	/* (non-Javadoc)
	 * @see dta.commerce.ejb.IUserEJB#getInfosUser(java.lang.String, java.lang.String)
	 */
	@Override
	public User getInfosUser(String pLogin, String pMdp){
		return userDao.getInfosUser(pLogin, pMdp);
	}

	@Override
	public void addAdressesUser(List<Adresse> adresses) {
		for (Adresse adresse : adresses) {
			adresseDao.addAdresse(adresse);
		}
	}	
}
