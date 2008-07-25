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
}