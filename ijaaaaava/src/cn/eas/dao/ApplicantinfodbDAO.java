package cn.eas.dao;

import org.hibernate.Session;

import cn.eas.base.BaseApplicantinfodbDAO;


public class ApplicantinfodbDAO extends BaseApplicantinfodbDAO implements cn.eas.dao.iface.ApplicantinfodbDAO {

	public ApplicantinfodbDAO () {}
	
	public ApplicantinfodbDAO (Session session) {
		super(session);
	}


}