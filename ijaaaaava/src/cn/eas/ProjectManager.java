package cn.eas;

import java.util.ArrayList;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class ProjectManager {
	private static Log log = LogFactory.getLog(ActivityManager.class);
	
	//新建工程。注意检查重名情况
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
	
	//打开一个工程。返回工程内部全部的ItemInfo。需检索itemdb表。
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
	
	//查询所有工程。返回所有工程的ArrayList
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
