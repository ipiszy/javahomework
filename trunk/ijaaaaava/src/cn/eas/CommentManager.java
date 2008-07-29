package cn.eas;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class CommentManager {
	private static Log log = LogFactory.getLog(ActivityManager.class);
	
	public static void main(String[] args){
		new CommentManager().addComment(28, "WangJiaying", "test");
		new CommentManager().addComment(28, "WangJiaying", "test");
		new CommentManager().addComment(28, "WangJiaying", "test");
		System.out.println(new CommentManager().queryComments(28));
		
	}

	public void addComment(long itemId, String managerUsername, String comment) {

		Session s = HibernateUtil.currentSession();

		try {
			HibernateUtil.beginTransaction();
			Commentdb commentdb = new Commentdb();
			commentdb.setComment(comment);
			commentdb.setItemid(itemId);
			commentdb.setUsername(managerUsername);
			s.save(commentdb);
			HibernateUtil.commitTransaction();

		} catch (HibernateException e) {
			HibernateUtil.commitTransaction();
			e.printStackTrace();
			log.fatal(e);
		}

		HibernateUtil.closeSession();
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Comment> queryComments(long itemId) {
		ArrayList<Comment> comments = new ArrayList<Comment>();

		Session s = HibernateUtil.currentSession();

		try {
			HibernateUtil.beginTransaction();

			List commentList = s.createSQLQuery(
					"select username, comment, date from commentdb where itemid="
							+ itemId).list();
			HibernateUtil.commitTransaction();
			
			String username, comment, date, name;
			Accountdb accountdb;
			
			for (Object obj : commentList){
				Object[] objArray = (Object[])obj;
				username = objArray[0].toString();
				
				HibernateUtil.beginTransaction();
				accountdb = (Accountdb)s.get(Accountdb.class, username);
				HibernateUtil.commitTransaction();
				
				if (accountdb==null)
					throw new HibernateException (" no such user");
				else
					name = accountdb.getName();
				
				comment = objArray[1].toString();
				date = objArray[2].toString();
				comments.add(new Comment (comment,name,date,""));
			}

		} catch (HibernateException e) {
			HibernateUtil.commitTransaction();
			e.printStackTrace();
			log.fatal(e);
		}

		return comments;
	}

}
