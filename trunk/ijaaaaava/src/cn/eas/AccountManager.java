package cn.eas;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class AccountManager {
	private static Log log = LogFactory.getLog(AccountManager.class);

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
			log.fatal(e);
			returnString = null;
		}
		HibernateUtil.closeSession();
		return returnString;
		
		
		
	}

}
