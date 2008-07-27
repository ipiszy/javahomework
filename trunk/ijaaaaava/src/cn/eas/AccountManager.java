package cn.eas;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class AccountManager {
	private static Log log = LogFactory.getLog(AccountManager.class);
	
	public static void main(String[] args){
		System.out.println(new AccountManager().selectAll());
		System.out.println(new AccountManager().queryAccount("ipiszy"));
		System.out.println(new AccountManager().delAccount("ipiszy"));
		System.out.println(new AccountManager().addAccount(new Account("ipiszy","Applicant","ipiszy","ipiszy")));
	}

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

	public boolean addAccount(Account account, String department) {
		Session s = HibernateUtil.currentSession();
		boolean flag;
		flag = addAccount(account);

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

	public boolean delAccount(String username) {
		boolean flag = true;
		Session s = HibernateUtil.currentSession();
		try {
			HibernateUtil.beginTransaction();
			Accountdb accountdb = (Accountdb) s.get(Accountdb.class, username);
			HibernateUtil.commitTransaction();
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

	public String queryDepartment(String username) {
		String department=null;

		Session s = HibernateUtil.currentSession();
		try {
			HibernateUtil.beginTransaction();

			Managerinfodb managerinfodb = (Managerinfodb) s.get(
					Managerinfodb.class, username);

			HibernateUtil.commitTransaction();

			if (managerinfodb != null)
				department = managerinfodb.getDepartment();
			else
				department = null;

		} catch (HibernateException e) {
			HibernateUtil.commitTransaction();
			e.printStackTrace();
			log.fatal(e);
		}

		HibernateUtil.closeSession();

		return department;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<AccountInfo> selectAll(){
		Session s = HibernateUtil.currentSession();
		ArrayList<AccountInfo> accountInfoList=new ArrayList<AccountInfo>();
		try{
			HibernateUtil.beginTransaction();
			List accountList=s.createSQLQuery("select username,name,type,disabled from accountdb").list();
			HibernateUtil.commitTransaction();
			String username,name,type;
			boolean disabled;
			
			for (Object obj:accountList){
				username=((Object[])obj)[0].toString();
				name=((Object[])obj)[1].toString();
				type=((Object[])obj)[2].toString();
				disabled=Boolean.parseBoolean(((Object[])obj)[2].toString());
				if (disabled==false)
					accountInfoList.add(new AccountInfo(username,name,type));
			}
		}
		catch (HibernateException e){
			HibernateUtil.commitTransaction();
			e.printStackTrace();
			log.fatal(e);
		}
		
		HibernateUtil.closeSession();
		
		return accountInfoList;
	}
	
	public AccountInfo queryAccount (String username){
		Session s = HibernateUtil.currentSession();
		AccountInfo accountinfo = null;
		
		try{
			HibernateUtil.beginTransaction();
			Accountdb accountdb = (Accountdb)s.get(Accountdb.class, username);
			HibernateUtil.commitTransaction();
			
			if ((accountdb!=null) && (accountdb.isDisabled()==false))
				accountinfo=new AccountInfo(accountdb.getId(),accountdb.getName(),accountdb.getType());
		}
		catch (HibernateException e){
			HibernateUtil.commitTransaction();
			e.printStackTrace();
			log.fatal(e);
		}
		HibernateUtil.closeSession();
		return accountinfo;
	}
}
