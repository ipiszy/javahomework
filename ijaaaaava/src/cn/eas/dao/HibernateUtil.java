package cn.eas.dao;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



public class HibernateUtil {

	private static final SessionFactory sessionFactory;
	static{
		sessionFactory=new Configuration().configure().buildSessionFactory();
		
	}
	public static final ThreadLocal tLocalsess=new ThreadLocal();
	public static final ThreadLocal tLocaltx=new ThreadLocal();
	
	public static Session currentSession(){
		Session session=(Session) tLocalsess.get();
		try{
			if (session==null || !session.isOpen()){
				session=openSession();
				tLocalsess.set(session);
			}
		}
		catch (HibernateException e){
			//logger.error(e);
		}
		return session;
	}
	
	public static void closeSession(){
		Session session=(Session) tLocalsess.get();
		tLocalsess.set(null);
		try{
			if (session!=null && session.isOpen()){
				session.close();
			}
		}catch (HibernateException e){
			
		}
	}
	
	public static void beginTransaction(){
		System.out.println("begin tx");
		Transaction tx=(Transaction) tLocaltx.get();
		try{
			if (tx==null){
				tx=currentSession().beginTransaction();
				tLocaltx.set(tx);
			}
		} catch (HibernateException e){
			
		}
	}
	
	public static void commitTransaction(){
		Transaction tx=(Transaction) tLocaltx.get();
		try{
			if (tx!=null && !tx.wasCommitted() && !tx.wasRolledBack())
				tx.commit();
			tLocaltx.set(null);
			System.out.println("commit tx");
		}
		catch (HibernateException e){
			
		}
	}
	
	public static void rollbackTransaction(){
		Transaction tx=(Transaction) tLocaltx.get();
		try{
			if (tx!=null && !tx.wasCommitted() && !tx.wasRolledBack())
				tx.rollback();
		}
		catch (HibernateException e){
			
				
		}
	}
	
	private static Session openSession() throws HibernateException{
		return getSessionFactory().openSession();
	}
	
	private static SessionFactory getSessionFactory() throws HibernateException{
		return sessionFactory;
	}

}

