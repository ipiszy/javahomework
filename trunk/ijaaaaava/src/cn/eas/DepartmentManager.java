package cn.eas;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class DepartmentManager {
	private static Log log = LogFactory.getLog(ActivityManager.class);

	@SuppressWarnings("unchecked")
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

			if (!departmentList.isEmpty())
				flag = false;

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

	@SuppressWarnings("unchecked")
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

			if (!departmentList.isEmpty())
				flag = false;

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

	@SuppressWarnings("unchecked")
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

	public static void main(String args[]) {
		DepartmentManager d = new DepartmentManager();
		d.addDepartment("aa");
		d.addDepartment("ce", "8:00-9:00", "gaizhang");
		// d.delDepartment("aa");
		for (Department de : d.selectAll())
			System.out.println(de.getName() + "," + de.getWorkTime() + ","
					+ de.getAffairs());
	}
}
