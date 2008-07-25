package cn.eas.base;

import org.hibernate.Hibernate;
import org.hibernate.Session;

import cn.eas.*;
import cn.eas.dao.iface.AccountdbDAO;
import org.hibernate.criterion.Order;

/**
 * This is an automatically generated DAO class which should not be edited.
 */
public abstract class BaseAccountdbDAO extends cn.eas.dao._RootDAO {

	public BaseAccountdbDAO () {}
	
	public BaseAccountdbDAO (Session session) {
		super(session);
	}

	// query name references


	public static AccountdbDAO instance;

	/**
	 * Return a singleton of the DAO
	 */
	public static AccountdbDAO getInstance () {
		if (null == instance) instance = new cn.eas.dao.AccountdbDAO();
		return instance;
	}

	public Class getReferenceClass () {
		return cn.eas.Accountdb.class;
	}

    public Order getDefaultOrder () {
		return Order.asc("Name");
    }

	/**
	 * Cast the object as a cn.eas.Accountdb
	 */
	public cn.eas.Accountdb cast (Object object) {
		return (cn.eas.Accountdb) object;
	}

	public cn.eas.Accountdb get(java.lang.String key)
	{
		return (cn.eas.Accountdb) get(getReferenceClass(), key);
	}

	public cn.eas.Accountdb get(java.lang.String key, Session s)
	{
		return (cn.eas.Accountdb) get(getReferenceClass(), key, s);
	}

	public cn.eas.Accountdb load(java.lang.String key)
	{
		return (cn.eas.Accountdb) load(getReferenceClass(), key);
	}

	public cn.eas.Accountdb load(java.lang.String key, Session s)
	{
		return (cn.eas.Accountdb) load(getReferenceClass(), key, s);
	}

	public cn.eas.Accountdb loadInitialize(java.lang.String key, Session s) 
	{ 
		cn.eas.Accountdb obj = load(key, s); 
		if (!Hibernate.isInitialized(obj)) {
			Hibernate.initialize(obj);
		} 
		return obj; 
	}

/* Generic methods */

	/**
	 * Return all objects related to the implementation of this DAO with no filter.
	 */
	public java.util.List<cn.eas.Accountdb> findAll () {
		return super.findAll();
	}

	/**
	 * Return all objects related to the implementation of this DAO with no filter.
	 */
	public java.util.List<cn.eas.Accountdb> findAll (Order defaultOrder) {
		return super.findAll(defaultOrder);
	}

	/**
	 * Return all objects related to the implementation of this DAO with no filter.
	 * Use the session given.
	 * @param s the Session
	 */
	public java.util.List<cn.eas.Accountdb> findAll (Session s, Order defaultOrder) {
		return super.findAll(s, defaultOrder);
	}

	/**
	 * Persist the given transient instance, first assigning a generated identifier. (Or using the current value
	 * of the identifier property if the assigned generator is used.) 
	 * @param accountdb a transient instance of a persistent class 
	 * @return the class identifier
	 */
	public java.lang.String save(cn.eas.Accountdb accountdb)
	{
		return (java.lang.String) super.save(accountdb);
	}

	/**
	 * Persist the given transient instance, first assigning a generated identifier. (Or using the current value
	 * of the identifier property if the assigned generator is used.) 
	 * Use the Session given.
	 * @param accountdb a transient instance of a persistent class
	 * @param s the Session
	 * @return the class identifier
	 */
	public java.lang.String save(cn.eas.Accountdb accountdb, Session s)
	{
		return (java.lang.String) save((Object) accountdb, s);
	}

	/**
	 * Either save() or update() the given instance, depending upon the value of its identifier property. By default
	 * the instance is always saved. This behaviour may be adjusted by specifying an unsaved-value attribute of the
	 * identifier property mapping. 
	 * @param accountdb a transient instance containing new or updated state 
	 */
	public void saveOrUpdate(cn.eas.Accountdb accountdb)
	{
		saveOrUpdate((Object) accountdb);
	}

	/**
	 * Either save() or update() the given instance, depending upon the value of its identifier property. By default the
	 * instance is always saved. This behaviour may be adjusted by specifying an unsaved-value attribute of the identifier
	 * property mapping. 
	 * Use the Session given.
	 * @param accountdb a transient instance containing new or updated state.
	 * @param s the Session.
	 */
	public void saveOrUpdate(cn.eas.Accountdb accountdb, Session s)
	{
		saveOrUpdate((Object) accountdb, s);
	}

	/**
	 * Update the persistent state associated with the given identifier. An exception is thrown if there is a persistent
	 * instance with the same identifier in the current session.
	 * @param accountdb a transient instance containing updated state
	 */
	public void update(cn.eas.Accountdb accountdb) 
	{
		update((Object) accountdb);
	}

	/**
	 * Update the persistent state associated with the given identifier. An exception is thrown if there is a persistent
	 * instance with the same identifier in the current session.
	 * Use the Session given.
	 * @param accountdb a transient instance containing updated state
	 * @param the Session
	 */
	public void update(cn.eas.Accountdb accountdb, Session s)
	{
		update((Object) accountdb, s);
	}

	/**
	 * Remove a persistent instance from the datastore. The argument may be an instance associated with the receiving
	 * Session or a transient instance with an identifier associated with existing persistent state. 
	 * @param id the instance ID to be removed
	 */
	public void delete(java.lang.String id)
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
	public void delete(java.lang.String id, Session s)
	{
		delete((Object) load(id, s), s);
	}

	/**
	 * Remove a persistent instance from the datastore. The argument may be an instance associated with the receiving
	 * Session or a transient instance with an identifier associated with existing persistent state. 
	 * @param accountdb the instance to be removed
	 */
	public void delete(cn.eas.Accountdb accountdb)
	{
		delete((Object) accountdb);
	}

	/**
	 * Remove a persistent instance from the datastore. The argument may be an instance associated with the receiving
	 * Session or a transient instance with an identifier associated with existing persistent state. 
	 * Use the Session given.
	 * @param accountdb the instance to be removed
	 * @param s the Session
	 */
	public void delete(cn.eas.Accountdb accountdb, Session s)
	{
		delete((Object) accountdb, s);
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
	public void refresh (cn.eas.Accountdb accountdb, Session s)
	{
		refresh((Object) accountdb, s);
	}


}