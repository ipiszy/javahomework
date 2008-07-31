package cn.eas;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/** @pdOid ffa005cd-c14e-4bec-bbc2-9dff672a8c46 */
public class ActivityManager {
	/** @pdOid 7cb1fbda-3213-421c-b4e7-e2be49007a19 */
	private static Log log = LogFactory.getLog(ActivityManager.class);

	/**
	 * @param args
	 * @pdOid 976b1c0d-5e75-49a1-9ef2-f9acb9a5b8d0
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * System.out.println(new ProjectManager().queryProjects("ipiszy"));
		 * long id = new
		 * ProjectManager().createProject("","ipiszy");
		 * System.out.println(new ProjectManager().queryProjects("ipiszy"));
		 * 
		 * long id2 = new ProjectManager().createProject("","ruciwawa");
		 * System.out.println(new ProjectManager().queryProjects("ruciwawa"));
		 * 
		 * //System.out.println(new ActivityManager().addItem("test1",
		 * "", "", "ipiszy", id)); //System.out.println(new
		 * ActivityManager().addItem("test1", "", "", "ipiszy",
		 * id)); //System.out.println(new ActivityManager().addItem("test2",
		 * "", "", "ruciwawa", id2));
		 */

		// System.out.println(new ActivityManager().queryItems(1));
		// System.out.println(new
		// ActivityManager().queryCurrentRecordInfo("WangJiaying"));
		/*
		 * Item item1 = new ActivityManager().queryItem(44);
		 * item1.setContent("test_modified"); item1.setState("");
		 * System.out.println (new ActivityManager().addItem(item1));
		 * 
		 * Item item = new ActivityManager().loadItem("WangJiaying");
		 * System.out.println(item); System.out.println(new
		 * ActivityManager().submitItem(item.getId(), "WangJiaying", false,
		 * ""));
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
		// System.out.println(new ActivityManager().addItem("",
		// "",
		// "", "ruciwawa", 0));
		// System.out.println(new ActivityManager().addItem("",
		// "",
		// "", "ipiszy", 0));
		// System.out.println(new ActivityManager().addItem("",
		// "",
		// "", "ipiszy", 0));
		System.out.println(new ProjectManager().openProject(0, "ipiszy"));
		System.out.println(new ProjectManager().openProject(0, "ruciwawa"));
		System.out.println(new ActivityManager().queryItem(44));
	}

	/**
	 * @param username
	 * @pdOid 54269acf-f4db-4f72-906e-ee4d3a2e8eef
	 */
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

			if (itemList.size() != 0) {

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
									+ "where formname='" + formname
									+ "' and step=" + step).list();
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

	/**
	 * @param id
	 * @pdOid 7766edae-c44f-4969-86ec-7d1aa51cb3e9
	 */
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

	/**
	 * @param item
	 * @pdOid b009ab53-fea0-415f-990d-c7b2a3e96776
	 */
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
			itemdb.setState(item.getState());// state:等待审批，申请驳回，用户保存，申请完成
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

	/**
	 * @param item
	 * @pdOid 51230feb-1aae-4f5f-928c-9212b3e940f1
	 */
	public boolean addItem(Item item) {

		Session s = HibernateUtil.currentSession();
		boolean flag = true;

		try {

			HibernateUtil.beginTransaction();
			Itemdb itemdb = new Itemdb();
			itemdb.setContent(item.getContent());
			itemdb.setFormname(item.getFormname());
			itemdb.setProjectid(item.getProjectId());
			itemdb.setState(item.getState());
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

	/**
	 * @param content
	 * @param formname
	 * @param state
	 * @param username
	 * @param projectId
	 * @pdOid f01d6a7a-4211-4957-bee1-43eccd618803
	 */
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
			itemdb.setState(state);
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

	/**
	 * @param username
	 * @pdOid b941fd96-e992-4283-a841-c6a9235d064d
	 */
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
									+ "where itemdb.state='等待审批' AND department='"
									+ department + "'").list();
			HibernateUtil.commitTransaction();

			if (itemList.size() != 0) {
				for (Object obj : itemList) {
					Object[] o = (Object[]) obj;
					long id = Long.parseLong(o[0].toString());
					String formname = o[1].toString();
					String state = o[2].toString();
					String date = o[3].toString();
					itemInfoList.add(new ItemInfo(id, formname, state, date));
				}
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			log.fatal(e);
		}

		HibernateUtil.closeSession();
		return itemInfoList;
	}

	/**
	 * @param id
	 * @pdOid 05d8080f-44ed-4d39-9222-2bdb89b7017e
	 */
	@SuppressWarnings("unchecked")
	public Item loadItem(long id) {
		Session s = HibernateUtil.currentSession();
		Item item = new Item();

		try {
			HibernateUtil.beginTransaction();

			Itemdb itemdb = (Itemdb) s.get(Itemdb.class, id);
			if (itemdb == null)
				throw new HibernateException("no such item");
			itemdb.setState("正在审批");
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

	/**
	 * @param username
	 * @pdOid cfa1c258-1624-46f1-bc22-68e5057ead62
	 */
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
									+ ") temp2 " + "where temp2.state='等待审批'")
					.list();
			HibernateUtil.commitTransaction();

			if (itemList.size() != 0) {
				for (Object obj : itemList) {
					if (obj != null)
						id = Long.parseLong(obj.toString());
				}

				item = loadItem(id);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			log.fatal(e);
		}

		return item;

	}

	/**
	 * @param id
	 * @param managerUsername
	 * @param result
	 * @param comment
	 * @pdOid ce22bfa9-cedc-4854-b773-97ea209fe93d
	 */
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
							itemdb.setState("等待审批");
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

	/**
	 * @param id
	 * @pdOid 58d22788-3002-4415-bd9d-8ea8662c4b7e
	 */
	public boolean releaseItem(long id) {
		Session s = HibernateUtil.currentSession();
		boolean flag = true;
		try {
			HibernateUtil.beginTransaction();
			Itemdb itemdb = (Itemdb) s.get(Itemdb.class, id);
			HibernateUtil.commitTransaction();

			if (itemdb != null) {
				flag = true;
				if (itemdb.getState().equals("正在审批")) {
					itemdb.setState("等待审批");
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

	/**
	 * @param username
	 * @pdOid d0674341-c71c-466d-a330-3d26c179288f
	 */
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

			if (newsList.size() != 0) {

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
									+ "where formname='" + formname
									+ "' and step=" + step).list();

					if (departmentList.size() == 0)
						throw new HibernateException("no such department");
					department = departmentList.get(0).toString();

					itemInfoList.add(new ItemInfo(id, formname, state,
							dateOrigin, department, dateModify));
					if (itemInfoList.size() >= 10)
						break;

					HibernateUtil.commitTransaction();
				}
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