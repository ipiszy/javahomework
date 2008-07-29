package cn.eas;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class RecordHistoryManager {
	private static Log log = LogFactory.getLog(ActivityManager.class);
	
	public static void main(String[] args){
		System.out.println(new RecordHistoryManager().queryRecordHistory("WangJiaying"));
	}

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

			String comment, username, date;
			boolean result;
			long i_id;

			for (Object obj : recordHistoryList) {
				Object[] o = (Object[]) obj;
				comment = o[0].toString();
				i_id = Long.parseLong(o[1].toString());
				username = o[2].toString();
				date = o[3].toString();
				result = Boolean.parseBoolean(o[4].toString());

				Accountdb accountdb1 = (Accountdb) s.get(Accountdb.class,
						username);
				if (accountdb1 == null)
					throw new HibernateException("no such manager");

				Itemdb itemdb = (Itemdb) s.get(Itemdb.class, i_id);
				if (itemdb == null)
					throw new HibernateException("no such item");

				Accountdb accountdb2 = (Accountdb) s.get(Accountdb.class,
						itemdb.getUsername());
				if (accountdb2 == null)
					throw new HibernateException("no such account");

				recordList.add(new Record(date, accountdb2.getName(),
						accountdb1.getName(), comment, result, i_id));
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

	/*
	 * public ArrayList<Record> queryRecordHistory(String department) { }
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
			
			for (Object obj : commentList){
				Object[] objArray = (Object[])obj;
				managerUsername = objArray[0].toString();
				
				HibernateUtil.beginTransaction();
				accountdb = (Accountdb)s.get(Accountdb.class, managerUsername);
				HibernateUtil.commitTransaction();
				
				if (accountdb==null)
					throw new HibernateException (" no such manager");
				else
					managerName = accountdb.getName();
				
				comment = objArray[1].toString();
				date = objArray[2].toString();
				department = objArray[3].toString();
				comments.add(new Comment (comment,managerName,date, department));
			}

		} catch (HibernateException e) {
			HibernateUtil.commitTransaction();
			e.printStackTrace();
			log.fatal(e);
		}

		return comments;
	}

}
