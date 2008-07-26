package cn.eas.dao;

import org.hibernate.Session;

import cn.eas.base.BaseManagerinfodbDAO;


public class ManagerinfodbDAO extends BaseManagerinfodbDAO implements cn.eas.dao.iface.ManagerinfodbDAO {

	public ManagerinfodbDAO () {}
	
	public ManagerinfodbDAO (Session session) {
		super(session);
	}


}