package cn.eas;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/** @pdOid 381bd4a2-435b-41b8-ba29-24b7c17f5a27 */
public class RecordHistoryManager {
	/** @pdOid 028dad48-9c5c-44e0-9ba8-2b3970c24dab */
	private static Log log = LogFactory.getLog(ActivityManager.class);

	/**
	 * @param args
	 * @pdOid ce9eac34-4f94-4b96-9576-eda821e29055
	 */
	public static void main(String[] args) {
		System.out.println(new RecordHistoryManager()
				.queryRecordHistory("WangJiaying"));
	}

	/**
	 * @param managerUsername
	 * @pdOid 81e2497a-552c-4df4-bb38-d08fcc4b8576
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<Record> queryRecordHistory(String managerUsername) {
		Session s = HibernateUtil.currentSession();
		ArrayList<Record> recordList = new ArrayList<Record>();

		try {
			HibernateUtil.beginTransaction();

			Managerinfodb managerinfodb = (Managerinfodb) s.get(
					Managerinfodb.class, managerUsername);
			if (managerinfodb == null)
				throw new HibernateException("no such manager");

			String department = managerinfodb.getDepartment();

			List recordHistoryList = s.createSQLQuery(
					"select comment, i_id, username, date, result from recordhistorydb "
							+ "where department='" + department + "'").list();

			if (recordHistoryList.size() != 0) {

				String comment, username, date, formName;
				boolean result;
				String resultString;
				long i_id;

				for (Object obj : recordHistoryList) {
					Object[] o = (Object[]) obj;
					comment = o[0].toString();
					i_id = Long.parseLong(o[1].toString());
					username = o[2].toString();
					date = o[3].toString();
					result = Boolean.parseBoolean(o[4].toString());
					if (result == true)
						resultString = "Õ¨“‚…Í«Î";
					else
						resultString = "…Í«Î≤µªÿ";

					Accountdb accountdb1 = (Accountdb) s.get(Accountdb.class,
							username);
					if (accountdb1 == null)
						throw new HibernateException("no such manager");

					Itemdb itemdb = (Itemdb) s.get(Itemdb.class, i_id);
					if (itemdb == null)
						throw new HibernateException("no such item");
					formName = itemdb.getFormname();

					Accountdb accountdb2 = (Accountdb) s.get(Accountdb.class,
							itemdb.getUsername());
					if (accountdb2 == null)
						throw new HibernateException("no such account");

					recordList.add(new Record(date, accountdb2.getName(),
							accountdb1.getName(), comment, formName,
							resultString, i_id));
				}
			}
			HibernateUtil.commitTransaction();

		} catch (HibernateException e) {
			HibernateUtil.commitTransaction();
			e.printStackTrace();
			log.fatal(e);
		}

		HibernateUtil.closeSession();
		return recordList;

	}

	/**
	 * @param itemdb
	 * @param managerUsername
	 * @param comment
	 * @param result
	 * @pdOid 313710e7-aa64-4075-b9b9-fbbdcadcf363
	 */
	public boolean addRecord(Itemdb itemdb, String managerUsername,
			String comment, boolean result) {

		boolean flag = true;
		Session s = HibernateUtil.currentSession();

		try {
			HibernateUtil.beginTransaction();
			Recordhistorydb recordhistorydb = new Recordhistorydb();

			recordhistorydb.setComment(comment);
			recordhistorydb.setIId(itemdb.getId());
			recordhistorydb.setUsername(managerUsername);
			recordhistorydb.setResult(result);

			Managerinfodb managerinfodb = (Managerinfodb) s.get(
					Managerinfodb.class, managerUsername);
			if (managerinfodb == null)
				throw new HibernateException("no such manager");
			recordhistorydb.setDepartment(managerinfodb.getDepartment());

			s.save(recordhistorydb);

			HibernateUtil.commitTransaction();

		} catch (HibernateException e) {
			flag = false;
			HibernateUtil.commitTransaction();
			e.printStackTrace();
			log.fatal(e);
		}

		HibernateUtil.closeSession();
		return flag;
	}

	/**
	 * @param itemId
	 * @pdOid 357b1e3d-8820-4544-8049-0efcf43a30c5
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<Comment> queryComments(long itemId) {
		ArrayList<Comment> comments = new ArrayList<Comment>();

		Session s = HibernateUtil.currentSession();

		try {
			HibernateUtil.beginTransaction();

			List commentList = s.createSQLQuery(
					"select username, comment, date, department from recordhistorydb where i_id="
							+ itemId).list();
			HibernateUtil.commitTransaction();

			String department, comment, date, managerUsername, managerName;
			Accountdb accountdb;

			for (Object obj : commentList) {
				Object[] objArray = (Object[]) obj;
				managerUsername = objArray[0].toString();

				HibernateUtil.beginTransaction();
				accountdb = (Accountdb) s.get(Accountdb.class, managerUsername);
				HibernateUtil.commitTransaction();

				if (accountdb == null)
					throw new HibernateException(" no such manager");
				else
					managerName = accountdb.getName();

				comment = objArray[1].toString();
				date = objArray[2].toString();
				department = objArray[3].toString();
				comments
						.add(new Comment(comment, managerName, date, department));
			}

		} catch (HibernateException e) {
			HibernateUtil.commitTransaction();
			e.printStackTrace();
			log.fatal(e);
		}

		return comments;
	}

}