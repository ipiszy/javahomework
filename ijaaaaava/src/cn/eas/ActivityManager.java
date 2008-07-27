package cn.eas;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class ActivityManager {
	private static Log log = LogFactory.getLog(ActivityManager.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new ActivityManager()
				.queryCurrentApplicantInfo("ipiszy"));
		System.out.println(new ActivityManager().queryItem(1));
		new ActivityManager().addItem(new Item(13, "lalala", 2, "wait",
				"1988-12-18", 12, "ipiszy", "", ""));
		System.out.println(new ActivityManager().loadItem("aay").getId());
		System.out.println(new ActivityManager().loadItem(4));
		System.out.println(new ActivityManager().releaseItem(4));
		System.out.println(new ActivityManager().submitItem(1, true,
				"excellent!"));
		// System.out.println(new ActivityManager().addItem(item))
	}

	@SuppressWarnings("unchecked")
	public ArrayList<ItemInfo> queryCurrentApplicantInfo(String username) {
		Session s = HibernateUtil.currentSession();
		ArrayList<ItemInfo> itemInfoList = new ArrayList<ItemInfo>();

		try {
			HibernateUtil.beginTransaction();
			List itemList = s.createSQLQuery(
					"SELECT id, formname, state, date ,step from itemdb where username='"
							+ username + "'").list();
			HibernateUtil.commitTransaction();

			for (Object obj : itemList) {
				Object[] o = (Object[]) obj;
				long id = Long.parseLong(o[0].toString());
				String formname = o[1].toString();
				String state = o[2].toString();
				String date = o[3].toString();
				int step = Integer.parseInt(o[4].toString());
				System.out.println(step);
				System.out.println(formname);
				HibernateUtil.beginTransaction();
				List departmentList = s.createSQLQuery("select department from formflowdb "+
						"where formname='"+formname+"' and step="+step).list();
				HibernateUtil.commitTransaction();
				String department = departmentList.get(0).toString();
				itemInfoList.add(new ItemInfo(id, formname, state, date, department));
			}		
			
		} catch (HibernateException e){
			HibernateUtil.commitTransaction();
			e.printStackTrace();
			log.fatal(e);
		}
		  catch (java.lang.IndexOutOfBoundsException e){
			e.printStackTrace();
			log.fatal(e);
		}
		HibernateUtil.closeSession();
		return itemInfoList;
	}

	public Item queryItem(long id) {
		Session s = HibernateUtil.currentSession();
		Item item = null;

		try {
			HibernateUtil.beginTransaction();
			Itemdb itemdb = (Itemdb) s.get(Itemdb.class, id);
			HibernateUtil.commitTransaction();

			if (itemdb != null)
				item = new Item(itemdb.getId(), itemdb.getFormname(), itemdb
						.getStep(), itemdb.getState(), itemdb.getDate(), itemdb
						.getProjectid(), itemdb.getUsername(), itemdb
						.getComment(), itemdb.getContent());

		} catch (HibernateException e) {
			e.printStackTrace();
			log.fatal(e);
		}

		HibernateUtil.closeSession();
		return item;
	}

	public boolean updateItem(Item item) {
		Session s = HibernateUtil.currentSession();
		boolean flag = true;

		try {
			HibernateUtil.beginTransaction();
			Itemdb itemdb = new Itemdb();
			itemdb.setId(item.getId());
			itemdb.setContent(item.getContent());
			itemdb.setDate(item.getDate());
			itemdb.setFormname(item.getFormname());
			itemdb.setProjectid(item.getProjectId());
			itemdb.setState(item.getState());// state:user;wait;ongoing;finish
			itemdb.setStep(1);
			itemdb.setUsername(item.getUsername());
			itemdb.setComment("");

			s.update(itemdb);
			HibernateUtil.commitTransaction();

		} catch (HibernateException e) {
			e.printStackTrace();
			log.fatal(e);
			flag = false;
		}

		HibernateUtil.closeSession();
		return flag;

	}

	public boolean addItem(Item item) {

		Session s = HibernateUtil.currentSession();
		boolean flag = true;

		try {

			HibernateUtil.beginTransaction();
			Itemdb itemdb = new Itemdb();
			itemdb.setContent(item.getContent());
			itemdb.setFormname(item.getFormname());
			itemdb.setProjectid(item.getProjectId());
			itemdb.setState(item.getState());// state:user;wait;ongoing;finish
			itemdb.setStep(1);
			itemdb.setUsername(item.getUsername());
			itemdb.setComment("");
			s.save(itemdb);
			HibernateUtil.commitTransaction();

		} catch (HibernateException e) {
			e.printStackTrace();
			log.fatal(e);
			flag = false;
		}

		HibernateUtil.closeSession();
		return flag;
	}

	@SuppressWarnings("unchecked")
	public ArrayList<ItemInfo> queryCurrentRecordInfo(String department) {
		Session s = HibernateUtil.currentSession();
		ArrayList<ItemInfo> itemInfoList = new ArrayList<ItemInfo>();

		try {
			HibernateUtil.beginTransaction();
			List itemList = s
					.createSQLQuery(
							"SELECT itemdb.id,itemdb.formname,state,date "
									+ "from itemdb inner join formflowdb "
									+ "on itemdb.formname=formflowdb.formname AND itemdb.step=formflowdb.step "
									+ "where itemdb.state='wait' AND department='"
									+ department + "'").list();
			HibernateUtil.commitTransaction();

			for (Object obj : itemList) {
				Object[] o = (Object[]) obj;
				long id = Long.parseLong(o[0].toString());
				String formname = o[1].toString();
				String state = o[2].toString();
				String date = o[3].toString();
				itemInfoList.add(new ItemInfo(id, formname, state, date));
			}

		} catch (HibernateException e) {
			e.printStackTrace();
			log.fatal(e);
		}

		HibernateUtil.closeSession();
		return itemInfoList;
	}

	public Item loadItem(long id) {
		Session s = HibernateUtil.currentSession();
		Item item = new Item();

		try {
			HibernateUtil.beginTransaction();

			Itemdb itemdb = (Itemdb) s.get(Itemdb.class, id);
			itemdb.setState("ongoing");
			s.update(itemdb);
			HibernateUtil.commitTransaction();

			item = new Item(itemdb.getId(), itemdb.getFormname(), itemdb
					.getStep(), itemdb.getState(), itemdb.getDate(), itemdb
					.getProjectid(), itemdb.getUsername(), itemdb.getComment(),
					itemdb.getContent());
		} catch (HibernateException e) {
			e.printStackTrace();
			log.fatal(e);
		}
		HibernateUtil.closeSession();
		return item;
	}

	@SuppressWarnings("unchecked")
	public Item loadItem(String username) {

		Session s = HibernateUtil.currentSession();
		Item item = null;
		long id = 0;

		try {
			HibernateUtil.beginTransaction();
			List itemList = s
					.createSQLQuery(
							"select min(temp2.id) "
									+ "from "
									+ "(select itemdb.id,itemdb.state "
									+ "from itemdb "
									+ "inner join "
									+ "(select distinct formname,step "
									+ "from formflowdb "
									+ "inner join managerinfodb "
									+ "on formflowdb.department= "
									+ "(select department "
									+ "from managerinfodb "
									+ "where username='"
									+ username
									+ "' "
									+ ") "
									+ ") temp1 "
									+ "on itemdb.step=temp1.step and itemdb.formname=temp1.formname "
									+ ") temp2 " + "where temp2.state='wait'")
					.list();
			HibernateUtil.commitTransaction();

			for (Object obj : itemList) {
				if (obj == null)
					id = 0;
				else
					id = Long.parseLong(obj.toString());
			}

			if (id == 0)
				item = null;
			else
				item = loadItem(id);

		} catch (HibernateException e) {
			e.printStackTrace();
			log.fatal(e);
		}

		return item;

	}

	@SuppressWarnings("unchecked")
	public boolean submitItem(long id, boolean result, String comment) {
		boolean flag = true;
		boolean finalStep = false;
		Session s = HibernateUtil.currentSession();

		try {
			HibernateUtil.beginTransaction();
			Itemdb itemdb = (Itemdb) s.get(Itemdb.class, id);
			HibernateUtil.commitTransaction();

			if (itemdb == null)
				flag = false;
			else {
				itemdb.setComment(comment);
				if (result == true) {
					String formname = itemdb.getFormname();
					int step = itemdb.getStep();

					HibernateUtil.beginTransaction();
					List listFormflow = s.createSQLQuery(
							"select final from formflowdb "
									+ "where formname='" + formname
									+ "' and step=" + step).list();
					HibernateUtil.commitTransaction();

					for (Object obj : listFormflow) {
						finalStep = (Boolean) obj;
						flag = true;
					}

					if (flag == true) {
						if (finalStep == true)
							itemdb.setState("finish");
						else {
							itemdb.setState("wait");
							itemdb.setStep(step + 1);
						}
					}
				} else {
					itemdb.setState("user");
					flag = true;
				}
			}

			HibernateUtil.beginTransaction();
			s.update(itemdb);
			HibernateUtil.commitTransaction();
		} catch (HibernateException e) {
			e.printStackTrace();
			log.fatal(e);
			flag = false;
		}
		HibernateUtil.closeSession();
		return flag;
	}

	public boolean releaseItem(long id) {
		Session s = HibernateUtil.currentSession();
		boolean flag = true;
		try {
			HibernateUtil.beginTransaction();
			Itemdb itemdb = (Itemdb) s.get(Itemdb.class, id);
			HibernateUtil.commitTransaction();

			if (itemdb != null) {
				flag = true;
				if (itemdb.getState().equals("ongoing")) {
					itemdb.setState("wait");
					HibernateUtil.beginTransaction();
					s.update(itemdb);
					HibernateUtil.commitTransaction();
				}
			}

		} catch (HibernateException e) {
			e.printStackTrace();
			log.fatal(e);
			flag = false;
		}
		return flag;
	}
}
