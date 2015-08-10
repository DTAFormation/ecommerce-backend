package dta.commerce.dao;

import java.util.List;

import javax.transaction.Transactional;

import dta.commerce.persistance.Admin;

public interface IAdminDAO {

	public abstract void addAdmin(Admin admin);

	public abstract void deleteAdmin(int idAdmin);

	public abstract void updateAdmin(Admin admin);

	public abstract List<Admin> listerAdmin();

}