package cn.eas.dao;

import org.hibernate.Session;

import cn.eas.base.BaseAccountdbDAO;


public class AccountdbDAO extends BaseAccountdbDAO implements cn.eas.dao.iface.AccountdbDAO {

	public AccountdbDAO () {}
	
	public AccountdbDAO (Session session) {
		super(session);
	}


}