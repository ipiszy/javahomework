package cn.eas;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/** @pdOid c8750a1b-a786-48b1-899d-6e1054f25167 */
public class AccountManager {
	/** @pdOid 81de4a53-7d67-44cd-9bee-fc48f3c57f07 */
	private static Log log = LogFactory.getLog(AccountManager.class);

	/**
	 * @param args
	 * @pdOid 50ef8812-1f8c-4ac7-9ea8-8b1916a1d79d
	 */
	public static void main(String[] args) {
		/*
		 * System.out.println(new AccountManager().selectAll());
		 * System.out.println(new AccountManager().queryAccount("ipiszy"));
		 * System.out.println(new AccountManager().delAccount("ipiszy"));
		 */

		System.out.println(new AccountManager().addAccount(new Account(
				"ipiszy", "Applicant", "ipiszy", "ipiszy")));
		System.out.println(new AccountManager().addAccount(new Account(
				"ipiszy", "Applicant", "ipiszy", "ipiszy"), "ipiszy"));

		System.out.println(new AccountManager().queryLogin("ipiszy", "ipiszy"));
		System.out.println(new AccountManager().queryLogin("aay", "a"));
	}

	/**
	 * @param username
	 * @param password
	 * @pdOid 96127e1c-b77b-46d8-ae3f-1a10c08b4179
	 */
	public String queryLogin(String username, String password) {
		Session s = HibernateUtil.currentSession();
		String returnString;

		try {
			HibernateUtil.beginTransaction();
			Accountdb accountdb = (Accountdb) s.get(Accountdb.class, username);
			HibernateUtil.commitTransaction();

			if (accountdb == null)
				returnString = null;
			else if (!accountdb.getPassword().equals(password))
				returnString = null;
			else if (accountdb.isDisabled() == true)
				returnString = "disabled";
			else
				returnString = accountdb.getType();

		} catch (HibernateException e) {
			HibernateUtil.commitTransaction();
			log.fatal(e);
			returnString = null;
		}
		HibernateUtil.closeSession();
		return returnString;

	}

	/**
	 * @param account
	 * @pdOid b82f4ed0-2565-4f5b-9c15-0c2f900a3a20
	 */
	public boolean addAccount(Account account) {
		boolean flag = true;
		Session s = HibernateUtil.currentSession();
		try {
			Accountdb accountdb = new Accountdb();
			accountdb.setDisabled(false);
			accountdb.setId(account.getUsername());
			accountdb.setName(account.getName());
			accountdb.setPassword(account.getPassword());
			accountdb.setType(account.getType());
			accountdb.setNote("");

			HibernateUtil.beginTransaction();
			s.saveOrUpdate(accountdb);
			HibernateUtil.commitTransaction();
		} catch (HibernateException e) {
			HibernateUtil.commitTransaction();
			e.printStackTrace();
			log.fatal(e);
			flag = false;
		}

		HibernateUtil.closeSession();
		return flag;
	}

	/**
	 * @param account
	 * @param department
	 * @pdOid 231c2c43-de73-42ba-9b12-50c24d9f9520
	 */
	public boolean addAccount(Account account, String department) {

		boolean flag;
		flag = addAccount(account);
		Session s = HibernateUtil.currentSession();

		try {
			HibernateUtil.beginTransaction();

			Managerinfodb managerinfodb = new Managerinfodb();
			managerinfodb.setDepartment(department);
			managerinfodb.setId(account.getUsername());
			s.saveOrUpdate(managerinfodb);
			HibernateUtil.commitTransaction();

		} catch (HibernateException e) {
			HibernateUtil.commitTransaction();
			e.printStackTrace();
			log.fatal(e);
			flag = false;
		}

		HibernateUtil.closeSession();
		return flag;
	}

	/**
	 * @param username
	 * @pdOid 876e3bf9-97dd-4adf-9fec-594190d5da2a
	 */
	public boolean delAccount(String username) {
		boolean flag = true;
		Session s = HibernateUtil.currentSession();
		try {
			HibernateUtil.beginTransaction();
			Accountdb accountdb = (Accountdb) s.get(Accountdb.class, username);
			HibernateUtil.commitTransaction();
			if (accountdb == null)
				throw new HibernateException("no such user");
			accountdb.setDisabled(true);
			HibernateUtil.beginTransaction();
			s.update(accountdb);
			HibernateUtil.commitTransaction();

		} catch (HibernateException e) {
			HibernateUtil.commitTransaction();
			e.printStackTrace();
			log.fatal(e);
			flag = false;
		}

		HibernateUtil.closeSession();
		return flag;
	}

	/**
	 * @param username
	 * @pdOid 6356e7d5-5567-4bda-929d-484dfc24a785
	 */
	public String queryDepartment(String username) {
		String department = "";

		Session s = HibernateUtil.currentSession();
		try {
			HibernateUtil.beginTransaction();

			Managerinfodb managerinfodb = (Managerinfodb) s.get(
					Managerinfodb.class, username);

			HibernateUtil.commitTransaction();

			if (managerinfodb != null)
				department = managerinfodb.getDepartment();

		} catch (HibernateException e) {
			HibernateUtil.commitTransaction();
			e.printStackTrace();
			log.fatal(e);
		}

		HibernateUtil.closeSession();

		return department;
	}

	/** @pdOid 1fa744e6-e89d-4023-b434-ca7c62c65a5b */
	@SuppressWarnings("unchecked")
	public ArrayList<AccountInfo> selectAll() {
		Session s = HibernateUtil.currentSession();
		ArrayList<AccountInfo> accountInfoList = new ArrayList<AccountInfo>();
		try {
			HibernateUtil.beginTransaction();
			List accountList = s.createSQLQuery(
					"select username,name,type,disabled from accountdb").list();
			HibernateUtil.commitTransaction();
			String username, name, type;
			boolean disabled;

			for (Object obj : accountList) {
				username = ((Object[]) obj)[0].toString();
				name = ((Object[]) obj)[1].toString();
				type = ((Object[]) obj)[2].toString();
				disabled = Boolean.parseBoolean(((Object[]) obj)[3].toString());
				if (disabled == false)
					accountInfoList.add(new AccountInfo(username, name, type));
			}
		} catch (HibernateException e) {
			HibernateUtil.commitTransaction();
			e.printStackTrace();
			log.fatal(e);
		}

		HibernateUtil.closeSession();

		return accountInfoList;
	}

	/**
	 * @param username
	 * @pdOid a0128984-dff4-4fbe-9c5e-2e9070a24991
	 */
	public AccountInfo queryAccount(String username) {
		Session s = HibernateUtil.currentSession();
		AccountInfo accountinfo = new AccountInfo();

		try {
			HibernateUtil.beginTransaction();
			Accountdb accountdb = (Accountdb) s.get(Accountdb.class, username);
			HibernateUtil.commitTransaction();

			if ((accountdb != null) && (accountdb.isDisabled() == false))
				accountinfo = new AccountInfo(accountdb.getId(), accountdb
						.getName(), accountdb.getType());
		} catch (HibernateException e) {
			HibernateUtil.commitTransaction();
			e.printStackTrace();
			log.fatal(e);
		}
		HibernateUtil.closeSession();
		return accountinfo;
	}

}