package cn.eas.dao;

import org.hibernate.Session;

import cn.eas.base.BaseFormflowdbDAO;
import cn.eas.base.*;


public class FormflowdbDAO extends BaseFormflowdbDAO implements cn.eas.dao.iface.FormflowdbDAO {

	public FormflowdbDAO () {}
	
	public FormflowdbDAO (Session session) {
		super(session);
	}


}