package cn.eas.dao;

import org.hibernate.Session;

import cn.eas.base.BaseFormdbDAO;


public class FormdbDAO extends BaseFormdbDAO implements cn.eas.dao.iface.FormdbDAO {

	public FormdbDAO () {}
	
	public FormdbDAO (Session session) {
		super(session);
	}


}