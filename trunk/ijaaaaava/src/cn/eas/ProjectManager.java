package cn.eas;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/** @pdOid 914644b0-02d6-4332-82dd-1e0902d49794 */
public class ProjectManager {
   /** @pdOid c9b0d91d-efd9-46da-be32-b21a3ea2176f */
   private static Log log = LogFactory.getLog(ActivityManager.class);
   
   /** @param args
    * @pdOid bca01438-742e-4fc0-a468-c72146762799 */
   public static void main(String[] args) {
   	// ProjectManager p = new ProjectManager();
   	// p.createProject("aaa");
   	// for (ItemInfo i : p.openProject(1))
   	// System.out.println(i.getDate() + " " + i.getFormname() + " "
   	// + i.getId() + " " + i.getState());
   	// for (Project pro : p.queryProjects())
   	// System.out.println(pro.getDate() + " " + pro.getId() + " "
   	// + pro.getName());
   }
   
   /** @param name 
    * @param username
    * @pdOid 83c8ea4e-11bc-495d-9de7-e6ba4f6c9602 */
   public long createProject(String name, String username) {
   
   	Session s = HibernateUtil.currentSession();
   	long id = -1;
   
   	try {
   		Projectdb projectdb = new Projectdb();
   		projectdb.setName(name);
   		projectdb.setUsername(username);
   		HibernateUtil.beginTransaction();
   
   		List projectList = s.createSQLQuery(
   				"select * from projectdb where name='" + name + "'").list();
   
   		if (projectList.isEmpty())
   			s.save(projectdb);
   		else
   			throw new HibernateException("duplicate project name");
   
   		projectList = s.createSQLQuery(
   				"select id from projectdb where name='" + name
   						+ "' and username='" + username + "'").list();
   		if (projectList.size() == 0)
   			throw new HibernateException("no such project");
   
   		id = Long.parseLong(projectList.get(0).toString());
   
   		HibernateUtil.commitTransaction();
   
   	} catch (HibernateException e) {
   		HibernateUtil.commitTransaction();
   		e.printStackTrace();
   		log.fatal(e);
   	}
   
   	HibernateUtil.closeSession();
   
   	return id;
   }
   
   /** @param id 
    * @param username
    * @pdOid 6ca7350d-7d2c-4a52-a12c-48fcfdcfedbc */
   public ArrayList<ItemInfo> openProject(long id, String username) {
   
   	Session s = HibernateUtil.currentSession();
   	ArrayList<ItemInfo> itemInfoList = new ArrayList<ItemInfo>();
   	try {
   		HibernateUtil.beginTransaction();
   		List itemList = s.createSQLQuery(
   				"SELECT id, formname, state, date ,step from itemdb where projectid="
   						+ id + " and username = '" + username + "'").list();
   		HibernateUtil.commitTransaction();
   
   		if (itemList.size() == 0)
   			throw new HibernateException("no such item");
   		for (Object obj : itemList) {
   			Object[] o = (Object[]) obj;
   			long i_id = Long.parseLong(o[0].toString());
   			String formname = o[1].toString();
   			String state = o[2].toString();
   			String date = o[3].toString();
   			int step = Integer.parseInt(o[4].toString());
   			System.out.println(step);
   			System.out.println(formname);
   			HibernateUtil.beginTransaction();
   			List departmentList = s.createSQLQuery(
   					"select department from formflowdb "
   							+ "where formname='" + formname + "' and step="
   							+ step).list();
   			HibernateUtil.commitTransaction();
   			if (departmentList.size() == 0)
   				throw new HibernateException("no such department");
   			String department = departmentList.get(0).toString();
   
   			List dateList = s.createSQLQuery(
   					"select date from recordhistorydb where i_id=" + i_id
   							+ " order by date desc").list();
   
   			String dateModify;
   
   			if (dateList.size() == 0)
   				dateModify = "";
   			else
   				dateModify = dateList.get(0).toString();
   
   			itemInfoList.add(new ItemInfo(i_id, formname, state, date,
   					department, dateModify));
   		}
   
   	} catch (HibernateException e) {
   		HibernateUtil.commitTransaction();
   		e.printStackTrace();
   		log.fatal(e);
   	} catch (java.lang.IndexOutOfBoundsException e) {
   		e.printStackTrace();
   		log.fatal(e);
   	}
   	HibernateUtil.closeSession();
   	return itemInfoList;
   }
   
   /**  查询所有工程。返回所有工程的ArrayList
    * 
    * @param username
    * @pdOid 32400652-9ac6-4938-8f21-b80220edbab4 */
   public ArrayList<Project> queryProjects(String username) {
   
   	Session s = HibernateUtil.currentSession();
   	ArrayList<Project> projectList = new ArrayList<Project>();
   	projectList.add(new Project(0, "", "缺省工程", username));
   
   	try {
   		HibernateUtil.beginTransaction();
   		List itemList = s.createSQLQuery(
   				"SELECT id,date,name from projectdb where username='"
   						+ username + "'").list();
   		HibernateUtil.commitTransaction();
   
   		if (itemList.size() == 0)
   			throw new HibernateException("no such item");
   
   		for (Object obj : itemList) {
   			Object[] o = (Object[]) obj;
   			long id = Long.parseLong(o[0].toString());
   			String date = o[1].toString();
   			String name = o[2].toString();
   			projectList.add(new Project(id, date, name, username));
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