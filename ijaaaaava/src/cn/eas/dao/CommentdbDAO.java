package cn.eas.dao;

import org.hibernate.Session;

import cn.eas.base.BaseCommentdbDAO;


public class CommentdbDAO extends BaseCommentdbDAO implements cn.eas.dao.iface.CommentdbDAO {

	public CommentdbDAO () {}
	
	public CommentdbDAO (Session session) {
		super(session);
	}


}