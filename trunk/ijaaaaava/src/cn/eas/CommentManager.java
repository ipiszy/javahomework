package cn.eas;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/** @pdOid e003723f-eb24-4e0d-bac6-118471efc740 */
public class CommentManager {
   /** @pdOid da7ae7a9-b0b8-495f-9665-b0e3a275f82c */
   private static Log log = LogFactory.getLog(ActivityManager.class);
   
   /** @param args
    * @pdOid b3e6e0a4-4691-4c70-99bf-b19970b8fd1f */
   public static void main(String[] args) {
   	new CommentManager().addComment(28, "WangJiaying", "test");
   	new CommentManager().addComment(28, "WangJiaying", "test");
   	new CommentManager().addComment(28, "WangJiaying", "test");
   	System.out.println(new CommentManager().queryComments(28));
   	
   }
   
   /** @param itemId 
    * @param managerUsername 
    * @param comment
    * @pdOid d2a37c00-a3c8-4434-a15b-eeb806830377 */
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
   
   /** @param itemId
    * @pdOid 10c1b12c-0b40-4981-b056-30cacb7032fe */
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