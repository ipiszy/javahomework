package cn.eas;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class ProjectManager {
	private static Log log = LogFactory.getLog(ActivityManager.class);

	public static void main(String args[]) {
		ProjectManager p = new ProjectManager();
		p.createProject("aaa");
		for (ItemInfo i : p.openProject(1))
			System.out.println(i.getDate() + " " + i.getFormname() + " "
					+ i.getId() + " " + i.getState());
		for (Project pro : p.queryProjects())
			System.out.println(pro.getDate() + " " + pro.getId() + " "
					+ pro.getName());
	}

	@SuppressWarnings("unchecked")
	public long createProject(String name) {

		Session s = HibernateUtil.currentSession();
		long id = -1;

		try {
			Projectdb projectdb = new Projectdb();
			projectdb.setName(name);
			HibernateUtil.beginTransaction();

			List projectList = s.createSQLQuery(
					"select * from projectdb where name='" + name + "'").list();

			if (projectList.isEmpty())
				s.save(projectdb);

			HibernateUtil.commitTransaction();

		} catch (HibernateException e) {
			HibernateUtil.commitTransaction();
			e.printStackTrace();
			log.fatal(e);
		}

		HibernateUtil.closeSession();

		return id;
	}

	@SuppressWarnings("unchecked")
	public ArrayList<ItemInfo> openProject(long id) {

		Session s = HibernateUtil.currentSession();
		ArrayList<ItemInfo> itemInfoList = new ArrayList<ItemInfo>();

		try {
			HibernateUtil.beginTransaction();

			List itemList = s.createSQLQuery(
					"SELECT id, formname, state,date from itemdb where projectid="
							+ id).list();
			HibernateUtil.commitTransaction();

			for (Object obj : itemList) {
				Object[] o = (Object[]) obj;
				long itemid = Long.parseLong(o[0].toString());
				String formname = o[1].toString();
				String state = o[2].toString();
				String date = o[3].toString();
				itemInfoList.add(new ItemInfo(itemid, formname, state, date));
			}

		} catch (HibernateException e) {
			HibernateUtil.commitTransaction();
			e.printStackTrace();
			log.fatal(e);
		}

		HibernateUtil.closeSession();
		return itemInfoList;
	}

	// ��ѯ���й��̡��������й��̵�ArrayList
	@SuppressWarnings("unchecked")
	public ArrayList<Project> queryProjects() {

		Session s = HibernateUtil.currentSession();
		ArrayList<Project> projectList = new ArrayList<Project>();

		try {
			HibernateUtil.beginTransaction();
			List itemList = s.createSQLQuery(
					"SELECT id,date,name from projectdb ").list();
			HibernateUtil.commitTransaction();

			for (Object obj : itemList) {
				Object[] o = (Object[]) obj;
				long id = Long.parseLong(o[0].toString());
				String date = o[1].toString();
				String name = o[2].toString();
				projectList.add(new Project(id, date, name));
			}

		} catch (HibernateException e) {
			HibernateUtil.commitTransaction();
			e.printStackTrace();
			log.fatal(e);
		}

		HibernateUtil.closeSession();
		return projectList;
	}

}