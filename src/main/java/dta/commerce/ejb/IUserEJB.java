package dta.commerce.ejb;

import java.util.List;

import dta.commerce.persistance.User;

public interface IUserEJB {

	public abstract List<User> listerUser();

	public abstract void addUser(User user);

	public abstract void deleteUser(Integer user);

	public abstract void updateUser(User user);

	public abstract User getUser(Integer user);

	public abstract User getInfosUser(String pLogin, String pMdp);

}