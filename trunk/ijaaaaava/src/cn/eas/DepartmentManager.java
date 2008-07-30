package cn.eas;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/** @pdOid 02d8e00c-c5f2-4f54-a498-732039a147c9 */
public class DepartmentManager {
   /** @pdOid 4f7ee996-c9e1-49c8-a8c5-20cbf74726e2 */
   private static Log log = LogFactory.getLog(ActivityManager.class);
   
   /** @param dename
    * @pdOid 2eb9a576-6882-41d3-8638-0140dfe71413 */
   public boolean addDepartment(String dename) {
   	boolean flag = true;
   	Session s = HibernateUtil.currentSession();
   	try {
   		Departmentdb departmentdb = new Departmentdb();
   		departmentdb.setId(dename);
   		departmentdb.setWorktime("");
   		departmentdb.setAffairs("");
   		HibernateUtil.beginTransaction();
   
   		List departmentList = s.createSQLQuery(
   				"select * from departmentdb where name='" + dename + "'")
   				.list();
   
   		if (!departmentList.isEmpty()){
   			flag = false;
   			throw new HibernateException("Duplicate department");
   		}
   
   		else
   			s.save(departmentdb);
   
   		HibernateUtil.commitTransaction();
   
   	} catch (HibernateException e) {
   		HibernateUtil.commitTransaction();
   		e.printStackTrace();
   		log.fatal(e);
   	}
   
   	HibernateUtil.closeSession();
   	return flag;
   }
   
   /** @param dename 
    * @param worktime 
    * @param affairs
    * @pdOid 69c23b6b-2e35-4efa-9265-63ffa03f6303 */
   public boolean addDepartment(String dename, String worktime, String affairs) {
   	boolean flag = true;
   	Session s = HibernateUtil.currentSession();
   	try {
   		Departmentdb departmentdb = new Departmentdb();
   		departmentdb.setId(dename);
   		departmentdb.setWorktime(worktime);
   		departmentdb.setAffairs(affairs);
   		HibernateUtil.beginTransaction();
   
   		List departmentList = s.createSQLQuery(
   				"select * from departmentdb where name='" + dename + "'")
   				.list();
   
   		if (!departmentList.isEmpty()){
   			flag = false;
   			throw new HibernateException("Dulicate department");
   		}
   
   		else
   			s.save(departmentdb);
   		HibernateUtil.commitTransaction();
   
   	} catch (HibernateException e) {
   		HibernateUtil.commitTransaction();
   		e.printStackTrace();
   		log.fatal(e);
   	}
   
   	HibernateUtil.closeSession();
   	return flag;
   }
   
   /** @param name
    * @pdOid f0974685-01a3-41a9-b0b1-8d16655678f2 */
   public boolean delDepartment(String name) {
   	boolean flag = false;
   	Session s = HibernateUtil.currentSession();
   	try {
   		HibernateUtil.beginTransaction();
   		Departmentdb departmentdb = (Departmentdb) s.get(
   				Departmentdb.class, name);
   
   		if (departmentdb == null)
   			throw new HibernateException("no such department");
   		else {
   			s.delete(departmentdb);
   			flag = true;
   		}
   		HibernateUtil.commitTransaction();
   
   	} catch (HibernateException e) {
   		HibernateUtil.commitTransaction();
   		e.printStackTrace();
   		log.fatal(e);
   	}
   
   	HibernateUtil.closeSession();
   	return flag;
   }
   
   /** @pdOid 52f2de44-206d-4ef5-812e-494660c3b22b */
   public ArrayList<Department> selectAll() {
   	Session s = HibernateUtil.currentSession();
   	ArrayList<Department> departmentList = new ArrayList<Department>();
   	try {
   		HibernateUtil.beginTransaction();
   
   		List dList = s.createSQLQuery(
   				"SELECT name,worktime, affairs from departmentdb").list();
   		HibernateUtil.commitTransaction();
   
   		for (Object obj : dList) {
   			Object[] o = (Object[]) obj;
   			String name = o[0].toString();
   			String worktime = o[1].toString();
   			String affairs = o[2].toString();
   			departmentList.add(new Department(name, worktime, affairs));
   		}
   
   	} catch (HibernateException e) {
   		HibernateUtil.commitTransaction();
   		e.printStackTrace();
   		log.fatal(e);
   	}
   
   	HibernateUtil.closeSession();
   
   	return departmentList;
   }
   
   /** @param args
    * @pdOid 65da1523-3d70-4db8-847a-5a081fe4488f */
   public static void main(String[] args) {
   	DepartmentManager d = new DepartmentManager();
   	d.addDepartment("aa");
   	d.addDepartment("ce", "8:00-9:00", "gaizhang");
   	// d.delDepartment("aa");
   	for (Department de : d.selectAll())
   		System.out.println(de.getName() + "," + de.getWorkTime() + ","
   				+ de.getAffairs());
   }

}