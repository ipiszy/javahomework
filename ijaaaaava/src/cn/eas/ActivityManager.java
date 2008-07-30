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

		/*
		 * System.out.println(new ProjectManager().queryProjects("ipiszy"));
		 * long id = new
		 * ProjectManager().createProject("\"按图索骥，饮水思源\"团改金设摊申请","ipiszy");
		 * System.out.println(new ProjectManager().queryProjects("ipiszy"));
		 * 
		 * long id2 = new ProjectManager().createProject("交换生申请","ruciwawa");
		 * System.out.println(new ProjectManager().queryProjects("ruciwawa"));
		 * 
		 * //System.out.println(new ActivityManager().addItem("test1", "团改金申请表",
		 * "等待批复", "ipiszy", id)); //System.out.println(new
		 * ActivityManager().addItem("test1", "团改金申请表", "用户保存", "ipiszy", id));
		 * //System.out.println(new ActivityManager().addItem("test2", "交换生申请表",
		 * "等待批复", "ruciwawa", id2));
		 */

		// System.out.println(new ActivityManager().queryItems(1));
		// System.out.println(new
		// ActivityManager().queryCurrentRecordInfo("WangJiaying"));
		/*
		 * Item item1 = new ActivityManager().queryItem(44);
		 * item1.setContent("test_modified"); item1.setState("等待批复");
		 * System.out.println (new ActivityManager().addItem(item1));
		 * 
		 * Item item = new ActivityManager().loadItem("WangJiaying");
		 * System.out.println(item); System.out.println(new
		 * ActivityManager().submitItem(item.getId(), "WangJiaying", false,
		 * "申请驳回"));
		 */

		/*
		 * System.out.println(new ActivityManager()
		 * .queryCurrentApplicantInfo("ipiszy"));
		 */

		/*
		 * System.out.println(new ActivityManager().queryNews("ipiszy"));
		 * System.out.println(new
		 * ActivityManager().queryCurrentApplicantInfo("ipiszy"));
		 * System.out.println(new ActivityManager().queryItems(1));
		 * System.out.println(new ActivityManager().queryItem(47));
		 */

		// Item item = new ActivityManager().loadItem("Azu");
		// System.out.println(item); System.out.println(new
		// ActivityManager().submitItem(item.getId(), "Azu", true, "so
		// clever!"));
		// System.out.println(new ActivityManager().queryItem(44));
		// System.out.println(new ActivityManager().addItem("缺省工程", "团改金申请表",
		// "等待批复", "ruciwawa", 0));
		// System.out.println(new ActivityManager().addItem("缺省工程", "交换生申请表",
		// "等待批复", "ipiszy", 0));
		// System.out.println(new ActivityManager().addItem("缺省工程", "团改金申请表",
		// "等待批复", "ipiszy", 0));
		System.out.println(new ProjectManager().openProject(0, "ipiszy"));
		System.out.println(new ProjectManager().openProject(0, "ruciwawa"));
		System.out.println(new ActivityManager().queryItem(44));
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

			if (itemList.size()==0)
				throw new HibernateException("no such item");
			
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
				List departmentList = s.createSQLQuery(
						"select department from formflowdb "
								+ "where formname='" + formname + "' and step="
								+ step).list();
				HibernateUtil.commitTransaction();
				if (departmentList.size() == 0)
					throw new HibernateException("no such department");
				String department = departmentList.get(0).toString();

				List dateList = s.createSQLQuery(
						"select date from recordhistorydb where i_id=" + id
								+ " order by date desc").list();

				String dateModify;

				if (dateList.size() == 0)
					dateModify = "";
				else
					dateModify = dateList.get(0).toString();

				itemInfoList.add(new ItemInfo(id, formname, state, date,
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

	@SuppressWarnings("unchecked")
	public Item queryItem(long id) {
		Session s = HibernateUtil.currentSession();
		Item item = null;

		try {
			HibernateUtil.beginTransaction();
			Itemdb itemdb = (Itemdb) s.get(Itemdb.class, id);
			HibernateUtil.commitTransaction();

			if (itemdb != null)
				item = new Item(itemdb.getId(), itemdb.getFormname(), itemdb
						.getState(), itemdb.getDate(), itemdb.getUsername(),
						itemdb.getContent(), itemdb.getStep(),
						new RecordHistoryManager().queryComments(id), itemdb
								.getProjectid());

			List departmentList = s.createSQLQuery(
					"select department from formflowdb " + "where formname='"
							+ itemdb.getFormname() + "' and step="
							+ itemdb.getStep()).list();

			if (departmentList.size() == 0)
				throw new HibernateException("no such department");
			String department = departmentList.get(0).toString();

			List dateList = s.createSQLQuery(
					"select date from recordhistorydb where i_id=" + id
							+ " and department='" + department + "'").list();

			if (dateList.size() == 0)
				item.setLastModify("");
			else
				item.setLastModify(dateList.get(0).toString());

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
			itemdb.setState(item.getState());// state:用户保存;等待批复;正在批复;申请完成
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
			itemdb.setState(item.getState());// state:用户保存;等待批复;正在批复;申请完成
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

	public boolean addItem(String content, String formname, String state,
			String username, long projectId) {

		Session s = HibernateUtil.currentSession();
		boolean flag = true;

		try {
			HibernateUtil.beginTransaction();
			Itemdb itemdb = new Itemdb();
			itemdb.setContent(content);
			itemdb.setFormname(formname);
			itemdb.setProjectid(projectId);
			itemdb.setState(state);// state:用户保存;等待批复;正在批复;申请完成
			itemdb.setStep(1);
			itemdb.setUsername(username);
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
	public ArrayList<ItemInfo> queryCurrentRecordInfo(String username) {
		Session s = HibernateUtil.currentSession();
		ArrayList<ItemInfo> itemInfoList = new ArrayList<ItemInfo>();
		String department;

		try {
			HibernateUtil.beginTransaction();
			Managerinfodb managerinfodb = (Managerinfodb) s.get(
					Managerinfodb.class, username);
			if (managerinfodb == null)
				throw new HibernateException("no such manager");
			department = managerinfodb.getDepartment();

			List itemList = s
					.createSQLQuery(
							"SELECT itemdb.id,itemdb.formname,state,date "
									+ "from itemdb inner join formflowdb "
									+ "on itemdb.formname=formflowdb.formname AND itemdb.step=formflowdb.step "
									+ "where itemdb.state='等待批复' AND department='"
									+ department + "'").list();
			HibernateUtil.commitTransaction();

			if (itemList.size() == 0)
				throw new HibernateException("no such item");

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

	@SuppressWarnings("unchecked")
	public Item loadItem(long id) {
		Session s = HibernateUtil.currentSession();
		Item item = new Item();

		try {
			HibernateUtil.beginTransaction();

			Itemdb itemdb = (Itemdb) s.get(Itemdb.class, id);
			if (itemdb == null)
				throw new HibernateException("no such item");
			itemdb.setState("正在批复");
			s.update(itemdb);
			HibernateUtil.commitTransaction();

			item = new Item(id, itemdb.getFormname(), itemdb.getState(), itemdb
					.getDate(), itemdb.getUsername(), itemdb.getContent(),
					itemdb.getStep(), new CommentManager().queryComments(itemdb
							.getId()), itemdb.getProjectid());

			List dateList = s.createSQLQuery(
					"select date from recordhistorydb where i_id=" + id
							+ " order by date desc").list();

			if (dateList.size() == 0)
				item.setLastModify("");
			else
				item.setLastModify(dateList.get(0).toString());

			item.setCommentList(new RecordHistoryManager().queryComments(id));

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
									+ ") temp2 " + "where temp2.state='等待批复'")
					.list();
			HibernateUtil.commitTransaction();

			if (itemList.size() == 0)
				throw new HibernateException("no such item");
			for (Object obj : itemList) {
				if (obj == null)
					throw new HibernateException("no such item");
				else
					id = Long.parseLong(obj.toString());
			}

			item = loadItem(id);

		} catch (HibernateException e) {
			e.printStackTrace();
			log.fatal(e);
		}

		return item;

	}

	@SuppressWarnings("unchecked")
	public boolean submitItem(long id, String managerUsername, boolean result,
			String comment) {
		boolean flag = true;
		boolean finalStep = false;
		Session s = HibernateUtil.currentSession();

		try {
			HibernateUtil.beginTransaction();
			Itemdb itemdb = (Itemdb) s.get(Itemdb.class, id);
			HibernateUtil.commitTransaction();

			if (itemdb == null) {
				flag = false;
				throw new HibernateException("no such item");
			} else {

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

					if (listFormflow.size() == 0)
						throw new HibernateException("no sucn formflow");

					for (Object obj : listFormflow) {
						finalStep = (Boolean) obj;
						flag = true;
					}

					if (flag == true) {
						if (finalStep == true)
							itemdb.setState("申请完成");
						else {
							itemdb.setState("等待批复");
							itemdb.setStep(step + 1);
						}
					}
				} else {
					itemdb.setState("申请驳回");
					flag = true;
				}
			}

			HibernateUtil.beginTransaction();
			s.update(itemdb);
			HibernateUtil.commitTransaction();
			// new CommentManager().addComment(id, managerUsername, comment);
			new RecordHistoryManager().addRecord(itemdb, managerUsername,
					comment, result);

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
				if (itemdb.getState().equals("正在批复")) {
					itemdb.setState("等待批复");
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

	@SuppressWarnings("unchecked")
	public ArrayList<ItemInfo> queryNews(String username) {

		Session s = HibernateUtil.currentSession();
		ArrayList<ItemInfo> itemInfoList = new ArrayList<ItemInfo>();

		try {
			HibernateUtil.beginTransaction();
			List newsList = s
					.createSQLQuery(
							"SELECT distinct recordhistorydb.i_id, "
									+ "recordhistorydb.date, itemdb.formname, itemdb.state, itemdb.step "
									+ "from recordhistorydb "
									+ "inner join itemdb on itemdb.id=recordhistorydb.i_id "
									+ "where itemdb.username='" + username
									+ "' "
									+ "order by recordhistorydb.date desc")
					.list();
			HibernateUtil.commitTransaction();

			long id;
			String dateOrigin, dateModify, formname, state, department;
			int step;
			Itemdb itemdb;

			if (newsList.size() == 0)
				throw new HibernateException("no news");

			for (Object obj : newsList) {
				Object[] o = (Object[]) obj;
				id = Long.parseLong(o[0].toString());
				dateModify = o[1].toString();
				formname = o[2].toString();
				state = o[3].toString();
				step = Integer.parseInt(o[4].toString());

				HibernateUtil.beginTransaction();
				itemdb = (Itemdb) s.get(Itemdb.class, id);
				dateOrigin = itemdb.getDate();

				List departmentList = s.createSQLQuery(
						"select department from formflowdb "
								+ "where formname='" + formname + "' and step="
								+ step).list();

				if (departmentList.size() == 0)
					throw new HibernateException("no such department");
				department = departmentList.get(0).toString();

				itemInfoList.add(new ItemInfo(id, formname, state, dateOrigin,
						department, dateModify));
				if (itemInfoList.size() >= 10)
					break;

				HibernateUtil.commitTransaction();
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
}
