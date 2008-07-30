package cn.eas.dao;

import org.hibernate.Session;

import cn.eas.base.BaseMessagedbDAO;


public class MessagedbDAO extends BaseMessagedbDAO implements cn.eas.dao.iface.MessagedbDAO {

	public MessagedbDAO () {}
	
	public MessagedbDAO (Session session) {
		super(session);
	}


}