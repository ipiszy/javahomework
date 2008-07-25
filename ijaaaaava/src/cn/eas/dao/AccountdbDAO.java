package cn.eas.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import cn.eas.Accountdb;
import cn.eas.base.BaseAccountdbDAO;
import cn.eas.base.*;


public class AccountdbDAO extends BaseAccountdbDAO implements cn.eas.dao.iface.AccountdbDAO {

	public AccountdbDAO () {}
	
	public AccountdbDAO (Session session) {
		super(session);
	}
	
	public String queryLogin(String username, String password){
		try{
			Accountdb accountdb=new AccountdbDAO().get(username);
			if (accountdb==null)
				return null;
			else if (!accountdb.getPassword().equals(password))
				return null;
			else if (accountdb.isDisabled()==true)
				return "disabled";
			else 
				return accountdb.getType();
			
		}
		catch (HibernateException e){
			
		}
		return null;
	}


}