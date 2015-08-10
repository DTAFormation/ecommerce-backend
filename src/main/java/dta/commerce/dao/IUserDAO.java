package dta.commerce.dao;

import java.util.List;

import javax.transaction.Transactional;

import dta.commerce.persistance.User;

public interface IUserDAO {

	public abstract void addUser(User user);

	public abstract void deleteUser(int idAdmin);

	public abstract void updateUser(User user);

	public abstract List<User> listerUser();

	public abstract User getUser(Integer user);

	public abstract User getInfosUser(String pLogin, String pMdp);

}