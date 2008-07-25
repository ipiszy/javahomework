package cn.eas;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.apache.commons.logging.*;

public class HibernateUtil {

	private static final SessionFactory sessionFactory;
	static Log logger = LogFactory.getLog(HibernateUtil.class);

	static {
		try {
			sessionFactory = new Configuration().configure()
					.buildSessionFactory();
			
		} catch (Throwable ex) {
			ex.printStackTrace();
			throw new ExceptionInInitializerError(ex);
		}
	}
	@SuppressWarnings("unchecked")
	public static final ThreadLocal tLocalsess = new ThreadLocal();

	@SuppressWarnings("unchecked")
	public static final ThreadLocal tLocaltx = new ThreadLocal();

	@SuppressWarnings("unchecked")
	public static Session currentSession() {
		Session session = (Session) tLocalsess.get();
		try {
			if (session == null || !session.isOpen()) {
				session = openSession();
				tLocalsess.set(session);
			}
		} catch (HibernateException e) {
			logger.error(e);
		}
		return session;
	}

	@SuppressWarnings("unchecked")
	public static void closeSession() {
		Session session = (Session) tLocalsess.get();
		tLocalsess.set(null);
		try {
			if (session != null && session.isOpen()) {
				session.close();
			}
		} catch (HibernateException e) {
			logger.error(e);
		}
	}

	@SuppressWarnings("unchecked")
	public static void beginTransaction() {
		System.out.println("begin tx");
		Transaction tx = (Transaction) tLocaltx.get();
		try {
			if (tx == null) {
				tx = currentSession().beginTransaction();
				tLocaltx.set(tx);
			}
		} catch (HibernateException e) {
			logger.error(e);
		}
	}

	@SuppressWarnings("unchecked")
	public static void commitTransaction() {
		Transaction tx = (Transaction) tLocaltx.get();
		try {
			if (tx != null && !tx.wasCommitted() && !tx.wasRolledBack())
				tx.commit();
			tLocaltx.set(null);
			System.out.println("commit tx");
		} catch (HibernateException e) {
			logger.error(e);
		}
	}

	public static void rollbackTransaction() {
		Transaction tx = (Transaction) tLocaltx.get();
		try {
			if (tx != null && !tx.wasCommitted() && !tx.wasRolledBack())
				tx.rollback();
		} catch (HibernateException e) {
			logger.error(e);
		}
	}

	private static Session openSession() throws HibernateException {
		return getSessionFactory().openSession();
	}

	private static SessionFactory getSessionFactory() throws HibernateException {
		return sessionFactory;
	}

}
