package cn.eas;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class MessageManager {

	private static Log log = LogFactory.getLog(ActivityManager.class);

	public void addMessage(String username, String message, String messageLeaver) {
		Session s = HibernateUtil.currentSession();
		try {
			Messagedb messagedb = new Messagedb();
			messagedb.setUsername(username);
			messagedb.setMessage(message);
			messagedb.setMessageleaver(messageLeaver);

			HibernateUtil.beginTransaction();

			s.save(messagedb);

			HibernateUtil.commitTransaction();

		} catch (HibernateException e) {
			HibernateUtil.commitTransaction();
			e.printStackTrace();
			log.fatal(e);
		}

		HibernateUtil.closeSession();
	}

	public void addMessage(String message) {
		Session s = HibernateUtil.currentSession();
		try {
			Messagedb messagedb = new Messagedb();
			messagedb.setUsername("");
			messagedb.setMessageleaver("");
			messagedb.setMessage(message);

			HibernateUtil.beginTransaction();
			s.save(messagedb);
			HibernateUtil.commitTransaction();

		} catch (HibernateException e) {
			HibernateUtil.commitTransaction();
			e.printStackTrace();
			log.fatal(e);
		}

		HibernateUtil.closeSession();
	}

	public boolean delMessage(long id) {
		boolean flag = false;
		Session s = HibernateUtil.currentSession();
		try {
			HibernateUtil.beginTransaction();
			Messagedb messagedb = (Messagedb) s.get(Messagedb.class, id);
			HibernateUtil.commitTransaction();

			if (messagedb == null)
				throw new HibernateException("no such message");
			else {
				HibernateUtil.beginTransaction();
				s.delete(messagedb);
				HibernateUtil.commitTransaction();
				flag = true;
			}

		} catch (HibernateException e) {
			HibernateUtil.commitTransaction();
			e.printStackTrace();
			log.fatal(e);
		}

		HibernateUtil.closeSession();
		return flag;
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Message> selectAll() {
		Session s = HibernateUtil.currentSession();
		ArrayList<Message> messageList = new ArrayList<Message>();
		try {
			HibernateUtil.beginTransaction();
			List list = s.createSQLQuery("select * from messagedb").list();
			HibernateUtil.commitTransaction();

			if (list.size() != 0) {

				for (Object obj : list) {
					Object[] o = (Object[]) obj;
					long messageID = Long.parseLong(o[0].toString());
					String userName = o[1].toString();
					String messageLeaver = o[2].toString();
					String message = o[3].toString();
					String date = o[4].toString();
					messageList.add(new Message(messageID, date, userName,
							message, messageLeaver));
				}
			}
		} catch (HibernateException e) {
			HibernateUtil.commitTransaction();
			e.printStackTrace();
			log.fatal(e);
		}

		HibernateUtil.closeSession();

		return messageList;
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Message> selectAll(String username) {
		Session s = HibernateUtil.currentSession();
		ArrayList<Message> messageList = new ArrayList<Message>();
		try {
			HibernateUtil.beginTransaction();
			List list = s.createSQLQuery(
					"select * from messagedb where username = '" + username
							+ "'").list();
			HibernateUtil.commitTransaction();

			if (list.size() != 0) {

				for (Object obj : list) {
					Object[] o = (Object[]) obj;
					long messageID = Long.parseLong(o[0].toString());
					String userName = o[1].toString();
					String messageLeaver = o[2].toString();
					String message = o[3].toString();
					String date = o[4].toString();
					messageList.add(new Message(messageID, date, userName,
							message, messageLeaver));
				}
			}
		} catch (HibernateException e) {
			HibernateUtil.commitTransaction();
			e.printStackTrace();
			log.fatal(e);
		}

		HibernateUtil.closeSession();

		return messageList;
	}

	public Message queryMessage(long id) {
		Session s = HibernateUtil.currentSession();
		Message message = new Message();
		try {
			HibernateUtil.beginTransaction();
			Messagedb messagedb = (Messagedb) s.get(Messagedb.class, id);
			HibernateUtil.commitTransaction();
			if (messagedb != null) {
				message.setID(messagedb.getId());
				message.setUsername(messagedb.getUsername());
				message.setMessageLeaver(messagedb.getMessageleaver());
				message.setMessage(messagedb.getMessage());
				message.setDate(messagedb.getDate());
			} else
				throw new HibernateException("no message!");

		} catch (HibernateException e) {
			HibernateUtil.commitTransaction();
			e.printStackTrace();
			log.fatal(e);
		}

		HibernateUtil.closeSession();
		return message;
	}

	public static void main(String args[]) {
		MessageManager m = new MessageManager();
		m.addMessage("hello");
		m.addMessage("zz", "hello,world", "yy");
		// m.delMessage(2);
		System.out.println(m.queryMessage(3).getID() + " "
				+ m.queryMessage(3).getUsername() + " "
				+ m.queryMessage(3).getMessageLeaver() + " "
				+ m.queryMessage(3).getMessage() + " "
				+ m.queryMessage(3).getDate());
		for (Message me : m.selectAll())
			System.out.println(me.getUsername() + "," + me.getMessageLeaver()
					+ "," + me.getMessage() + "," + me.getDate());

	}
}
