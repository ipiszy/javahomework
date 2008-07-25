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
		new ActivityManager().saveItem(new Item(13, "lalala", 2, "wait",
				"1988-12-18", 12, "ipiszy", "", ""));
		System.out.println(new ActivityManager().loadItem("ZhangKunpeng")
				.getID());

	}

	@SuppressWarnings("unchecked")
	public ArrayList<ItemInfo> queryCurrentApplicantInfo(String username) {
		Session s = HibernateUtil.currentSession();
		ArrayList<ItemInfo> itemInfoList = new ArrayList<ItemInfo>();

		try {
			HibernateUtil.beginTransaction();
			List itemList = s.createSQLQuery(
					"SELECT id, formname, state, date from itemdb where username='"
							+ username + "'").list();
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
			log.fatal(e);
		}

		HibernateUtil.closeSession();
		return item;
	}

	public boolean saveItem(Item item) {

		Session s = HibernateUtil.currentSession();
		boolean flag = true;

		try {

			HibernateUtil.beginTransaction();
			Itemdb itemdb = new Itemdb();
			if (item.getID() != -1)// 如何判断这个id是否有效？
				itemdb.setId(item.getID());
			itemdb.setComment(item.getComment());
			itemdb.setContent(item.getContent());
			itemdb.setDate(item.getDate());
			itemdb.setFormname(item.getFormname());
			itemdb.setProjectid(item.getProjectID());
			itemdb.setState(item.getState());
			itemdb.setStep(item.getStep());
			itemdb.setUsername(item.getUsername());
			s.saveOrUpdate(itemdb);
			HibernateUtil.commitTransaction();

		} catch (HibernateException e) {
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
			log.fatal(e);
		}
		HibernateUtil.closeSession();
		return item;
	}

	@SuppressWarnings("unchecked")
	public Item loadItem(String username) {

		Session s = HibernateUtil.currentSession();
		Item item = null;
		long id=0;

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
				id = Long.parseLong(obj.toString());
			}

			if (id == 0)
				item = null;
			else
				item = loadItem(id);

		} catch (HibernateException e) {
			log.fatal(e);
		}

		return item;

	}
}
