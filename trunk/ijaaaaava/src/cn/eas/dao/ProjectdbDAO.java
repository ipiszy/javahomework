package cn.eas.dao;

import org.hibernate.Session;

import cn.eas.base.BaseProjectdbDAO;
import cn.eas.dao.ProjectdbDAO;


public class ProjectdbDAO extends BaseProjectdbDAO implements cn.eas.dao.iface.ProjectdbDAO {

	public ProjectdbDAO () {}
	
	public ProjectdbDAO (Session session) {
		super(session);
	}


}