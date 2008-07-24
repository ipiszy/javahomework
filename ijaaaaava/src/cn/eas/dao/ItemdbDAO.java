package cn.eas.dao;

import org.hibernate.Session;

import cn.eas.base.BaseItemdbDAO;


public class ItemdbDAO extends BaseItemdbDAO implements cn.eas.dao.iface.ItemdbDAO {

	public ItemdbDAO () {}
	
	public ItemdbDAO (Session session) {
		super(session);
	}


}