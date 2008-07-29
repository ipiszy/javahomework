package cn.eas.base;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import cn.eas.dao.iface.RecordhistorydbDAO;
import org.hibernate.criterion.Order;

/**
 * This is an automatically generated DAO class which should not be edited.
 */
public abstract class BaseRecordhistorydbDAO extends cn.eas.dao._RootDAO {

	public BaseRecordhistorydbDAO () {}
	
	public BaseRecordhistorydbDAO (Session session) {
		super(session);
	}

	// query name references


	public static RecordhistorydbDAO instance;

	/**
	 * Return a singleton of the DAO
	 */
	public static RecordhistorydbDAO getInstance () {
		if (null == instance) instance = new cn.eas.dao.RecordhistorydbDAO();
		return instance;
	}

	public Class getReferenceClass () {
		return cn.eas.Recordhistorydb.class;
	}

    public Order getDefaultOrder () {
		return null;
    }

	/**
	 * Cast the object as a cn.eas.Recordhistorydb
	 */
	public cn.eas.Recordhistorydb cast (Object object) {
		return (cn.eas.Recordhistorydb) object;
	}

	public cn.eas.Recordhistorydb get(long key)
	{
		return (cn.eas.Recordhistorydb) get(getReferenceClass(), new java.lang.Long(key));
	}

	public cn.eas.Recordhistorydb get(long key, Session s)
	{
		return (cn.eas.Recordhistorydb) get(getReferenceClass(), new java.lang.Long(key), s);
	}

	public cn.eas.Recordhistorydb load(long key)
	{
		return (cn.eas.Recordhistorydb) load(getReferenceClass(), new java.lang.Long(key));
	}

	public cn.eas.Recordhistorydb load(long key, Session s)
	{
		return (cn.eas.Recordhistorydb) load(getReferenceClass(), new java.lang.Long(key), s);
	}

	public cn.eas.Recordhistorydb loadInitialize(long key, Session s) 
	{ 
		cn.eas.Recordhistorydb obj = load(key, s); 
		if (!Hibernate.isInitialized(obj)) {
			Hibernate.initialize(obj);
		} 
		return obj; 
	}

/* Generic methods */

	/**
	 * Return all objects related to the implementation of this DAO with no filter.
	 */
	public java.util.List<cn.eas.Recordhistorydb> findAll () {
		return super.findAll();
	}

	/**
	 * Return all objects related to the implementation of this DAO with no filter.
	 */
	public java.util.List<cn.eas.Recordhistorydb> findAll (Order defaultOrder) {
		return super.findAll(defaultOrder);
	}

	/**
	 * Return all objects related to the implementation of this DAO with no filter.
	 * Use the session given.
	 * @param s the Session
	 */
	public java.util.List<cn.eas.Recordhistorydb> findAll (Session s, Order defaultOrder) {
		return super.findAll(s, defaultOrder);
	}

	/**
	 * Persist the given transient instance, first assigning a generated identifier. (Or using the current value
	 * of the identifier property if the assigned generator is used.) 
	 * @param recordhistorydb a transient instance of a persistent class 
	 * @return the class identifier
	 */
	public java.lang.Long save(cn.eas.Recordhistorydb recordhistorydb)
	{
		return (java.lang.Long) super.save(recordhistorydb);
	}

	/**
	 * Persist the given transient instance, first assigning a generated identifier. (Or using the current value
	 * of the identifier property if the assigned generator is used.) 
	 * Use the Session given.
	 * @param recordhistorydb a transient instance of a persistent class
	 * @param s the Session
	 * @return the class identifier
	 */
	public java.lang.Long save(cn.eas.Recordhistorydb recordhistorydb, Session s)
	{
		return (java.lang.Long) save((Object) recordhistorydb, s);
	}

	/**
	 * Either save() or update() the given instance, depending upon the value of its identifier property. By default
	 * the instance is always saved. This behaviour may be adjusted by specifying an unsaved-value attribute of the
	 * identifier property mapping. 
	 * @param recordhistorydb a transient instance containing new or updated state 
	 */
	public void saveOrUpdate(cn.eas.Recordhistorydb recordhistorydb)
	{
		saveOrUpdate((Object) recordhistorydb);
	}

	/**
	 * Either save() or update() the given instance, depending upon the value of its identifier property. By default the
	 * instance is always saved. This behaviour may be adjusted by specifying an unsaved-value attribute of the identifier
	 * property mapping. 
	 * Use the Session given.
	 * @param recordhistorydb a transient instance containing new or updated state.
	 * @param s the Session.
	 */
	public void saveOrUpdate(cn.eas.Recordhistorydb recordhistorydb, Session s)
	{
		saveOrUpdate((Object) recordhistorydb, s);
	}

	/**
	 * Update the persistent state associated with the given identifier. An exception is thrown if there is a persistent
	 * instance with the same identifier in the current session.
	 * @param recordhistorydb a transient instance containing updated state
	 */
	public void update(cn.eas.Recordhistorydb recordhistorydb) 
	{
		update((Object) recordhistorydb);
	}

	/**
	 * Update the persistent state associated with the given identifier. An exception is thrown if there is a persistent
	 * instance with the same identifier in the current session.
	 * Use the Session given.
	 * @param recordhistorydb a transient instance containing updated state
	 * @param the Session
	 */
	public void update(cn.eas.Recordhistorydb recordhistorydb, Session s)
	{
		update((Object) recordhistorydb, s);
	}

	/**
	 * Remove a persistent instance from the datastore. The argument may be an instance associated with the receiving
	 * Session or a transient instance with an identifier associated with existing persistent state. 
	 * @param id the instance ID to be removed
	 */
	public void delete(long id)
	{
		delete((Object) load(id));
	}

	/**
	 * Remove a persistent instance from the datastore. The argument may be an instance associated with the receiving
	 * Session or a transient instance with an identifier associated with existing persistent state. 
	 * Use the Session given.
	 * @param id the instance ID to be removed
	 * @param s the Session
	 */
	public void delete(long id, Session s)
	{
		delete((Object) load(id, s), s);
	}

	/**
	 * Remove a persistent instance from the datastore. The argument may be an instance associated with the receiving
	 * Session or a transient instance with an identifier associated with existing persistent state. 
	 * @param recordhistorydb the instance to be removed
	 */
	public void delete(cn.eas.Recordhistorydb recordhistorydb)
	{
		delete((Object) recordhistorydb);
	}

	/**
	 * Remove a persistent instance from the datastore. The argument may be an instance associated with the receiving
	 * Session or a transient instance with an identifier associated with existing persistent state. 
	 * Use the Session given.
	 * @param recordhistorydb the instance to be removed
	 * @param s the Session
	 */
	public void delete(cn.eas.Recordhistorydb recordhistorydb, Session s)
	{
		delete((Object) recordhistorydb, s);
	}
	
	/**
	 * Re-read the state of the given instance from the underlying database. It is inadvisable to use this to implement
	 * long-running sessions that span many business tasks. This method is, however, useful in certain special circumstances.
	 * For example 
	 * <ul> 
	 * <li>where a database trigger alters the object state upon insert or update</li>
	 * <li>after executing direct SQL (eg. a mass update) in the same session</li>
	 * <li>after inserting a Blob or Clob</li>
	 * </ul>
	 */
	public void refresh (cn.eas.Recordhistorydb recordhistorydb, Session s)
	{
		refresh((Object) recordhistorydb, s);
	}


}