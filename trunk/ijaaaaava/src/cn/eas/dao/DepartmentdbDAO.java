package cn.eas.dao;

import org.hibernate.Session;

import cn.eas.base.BaseDepartmentdbDAO;


public class DepartmentdbDAO extends BaseDepartmentdbDAO implements cn.eas.dao.iface.DepartmentdbDAO {

	public DepartmentdbDAO () {}
	
	public DepartmentdbDAO (Session session) {
		super(session);
	}


}