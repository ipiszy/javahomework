package cn.eas;

import java.util.ArrayList;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class ProjectManager {
	private static Log log = LogFactory.getLog(ActivityManager.class);
	
	public long createProject(String name){

		Session s = HibernateUtil.currentSession();
		long id=-1;

		try {
			HibernateUtil.beginTransaction();

		} catch (HibernateException e) {
			HibernateUtil.commitTransaction();
			e.printStackTrace();
			log.fatal(e);
		}

		HibernateUtil.closeSession();

		return id;
	}
	
	public ArrayList<ItemInfo> openProject(long id){

		Session s = HibernateUtil.currentSession();
		ArrayList<ItemInfo> itemInfoList = null;

		try {
			HibernateUtil.beginTransaction();

		} catch (HibernateException e) {
			HibernateUtil.commitTransaction();
			e.printStackTrace();
			log.fatal(e);
		}

		HibernateUtil.closeSession();
		return itemInfoList;
	}
	
	public ArrayList<Project> queryProjects(){

		Session s = HibernateUtil.currentSession();
		ArrayList<Project> projectList = null;

		try {
			HibernateUtil.beginTransaction();

		} catch (HibernateException e) {
			HibernateUtil.commitTransaction();
			e.printStackTrace();
			log.fatal(e);
		}

		HibernateUtil.closeSession();
		return projectList;
	}

}
