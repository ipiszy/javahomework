package cn.eas;

import org.hibernate.HibernateException;
import org.hibernate.Session;

public class NoteManager {
	
	public static void main(String[] args){
		new NoteManager().editNote("ipiszy", "уес╠");
		new NoteManager().editNote("ipiszy", "уес╠");
		new NoteManager().editNote("ipiszy", "уес╠");
		System.out.println(new NoteManager().queryNote("ipiszy"));
		
	}
	public String queryNote(String username) {
		Session s = HibernateUtil.currentSession();
		String note = "";
		try {
			HibernateUtil.beginTransaction();
			Accountdb accountdb = (Accountdb) s.get(Accountdb.class, username);
			if (accountdb == null)
				throw new HibernateException("no such user");
			note = accountdb.getNote();
			HibernateUtil.commitTransaction();
		} catch (HibernateException e) {
			HibernateUtil.commitTransaction();
			e.printStackTrace();
		}

		return note;
	}

	public boolean editNote(String username, String note) {
		Session s = HibernateUtil.currentSession();
		boolean flag = true;
		try {
			HibernateUtil.beginTransaction();
			Accountdb accountdb = (Accountdb) s.get(Accountdb.class, username);
			if (accountdb == null)
				throw new HibernateException("no such user");
			accountdb.setNote(note);
			s.update(accountdb);
			HibernateUtil.commitTransaction();
		} catch (HibernateException e) {
			flag = false;
			HibernateUtil.commitTransaction();
			e.printStackTrace();
		}

		return flag;
	}

}
