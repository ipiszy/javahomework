package cn.eas.dao;

import org.hibernate.Session;

import cn.eas.base.BaseRecordhistorydbDAO;


public class RecordhistorydbDAO extends BaseRecordhistorydbDAO implements cn.eas.dao.iface.RecordhistorydbDAO {

	public RecordhistorydbDAO () {}
	
	public RecordhistorydbDAO (Session session) {
		super(session);
	}


}