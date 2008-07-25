package cn.eas.base;

import org.hibernate.Hibernate;
import org.hibernate.Session;

import cn.eas.*;
import cn.eas.dao.iface.FormdbDAO;
import org.hibernate.criterion.Order;

/**
 * This is an automatically generated DAO class which should not be edited.
 */
public abstract class BaseFormdbDAO extends cn.eas.dao._RootDAO {

	public BaseFormdbDAO () {}
	
	public BaseFormdbDAO (Session session) {
		super(session);
	}

	// query name references


	public static FormdbDAO instance;

	/**
	 * Return a singleton of the DAO
	 */
	public static FormdbDAO getInstance () {
		if (null == instance) instance = new cn.eas.dao.FormdbDAO();
		return instance;
	}

	public Class getReferenceClass () {
		return cn.eas.Formdb.class;
	}

    public Order getDefaultOrder () {
		return null;
    }

	/**
	 * Cast the object as a cn.eas.Formdb
	 */
	public cn.eas.Formdb cast (Object object) {
		return (cn.eas.Formdb) object;
	}

	public cn.eas.Formdb get(java.lang.String key)
	{
		return (cn.eas.Formdb) get(getReferenceClass(), key);
	}

	public cn.eas.Formdb get(java.lang.String key, Session s)
	{
		return (cn.eas.Formdb) get(getReferenceClass(), key, s);
	}

	public cn.eas.Formdb load(java.lang.String key)
	{
		return (cn.eas.Formdb) load(getReferenceClass(), key);
	}

	public cn.eas.Formdb load(java.lang.String key, Session s)
	{
		return (cn.eas.Formdb) load(getReferenceClass(), key, s);
	}

	public cn.eas.Formdb loadInitialize(java.lang.String key, Session s) 
	{ 
		cn.eas.Formdb obj = load(key, s); 
		if (!Hibernate.isInitialized(obj)) {
			Hibernate.initialize(obj);
		} 
		return obj; 
	}

/* Generic methods */

	/**
	 * Return all objects related to the implementation of this DAO with no filter.
	 */
	public java.util.List<cn.eas.Formdb> findAll () {
		return super.findAll();
	}

	/**
	 * Return all objects related to the implementation of this DAO with no filter.
	 */
	public java.util.List<cn.eas.Formdb> findAll (Order defaultOrder) {
		return super.findAll(defaultOrder);
	}

	/**
	 * Return all objects related to the implementation of this DAO with no filter.
	 * Use the session given.
	 * @param s the Session
	 */
	public java.util.List<cn.eas.Formdb> findAll (Session s, Order defaultOrder) {
		return super.findAll(s, defaultOrder);
	}

	/**
	 * Persist the given transient instance, first assigning a generated identifier. (Or using the current value
	 * of the identifier property if the assigned generator is used.) 
	 * @param formdb a transient instance of a persistent class 
	 * @return the class identifier
	 */
	public java.lang.String save(cn.eas.Formdb formdb)
	{
		return (java.lang.String) super.save(formdb);
	}

	/**
	 * Persist the given transient instance, first assigning a generated identifier. (Or using the current value
	 * of the identifier property if the assigned generator is used.) 
	 * Use the Session given.
	 * @param formdb a transient instance of a persistent class
	 * @param s the Session
	 * @return the class identifier
	 */
	public java.lang.String save(cn.eas.Formdb formdb, Session s)
	{
		return (java.lang.String) save((Object) formdb, s);
	}

	/**
	 * Either save() or update() the given instance, depending upon the value of its identifier property. By default
	 * the instance is always saved. This behaviour may be adjusted by specifying an unsaved-value attribute of the
	 * identifier property mapping. 
	 * @param formdb a transient instance containing new or updated state 
	 */
	public void saveOrUpdate(cn.eas.Formdb formdb)
	{
		saveOrUpdate((Object) formdb);
	}

	/**
	 * Either save() or update() the given instance, depending upon the value of its identifier property. By default the
	 * instance is always saved. This behaviour may be adjusted by specifying an unsaved-value attribute of the identifier
	 * property mapping. 
	 * Use the Session given.
	 * @param formdb a transient instance containing new or updated state.
	 * @param s the Session.
	 */
	public void saveOrUpdate(cn.eas.Formdb formdb, Session s)
	{
		saveOrUpdate((Object) formdb, s);
	}

	/**
	 * Update the persistent state associated with the given identifier. An exception is thrown if there is a persistent
	 * instance with the same identifier in the current session.
	 * @param formdb a transient instance containing updated state
	 */
	public void update(cn.eas.Formdb formdb) 
	{
		update((Object) formdb);
	}

	/**
	 * Update the persistent state associated with the given identifier. An exception is thrown if there is a persistent
	 * instance with the same identifier in the current session.
	 * Use the Session given.
	 * @param formdb a transient instance containing updated state
	 * @param the Session
	 */
	public void update(cn.eas.Formdb formdb, Session s)
	{
		update((Object) formdb, s);
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
	 * @param formdb the instance to be removed
	 */
	public void delete(cn.eas.Formdb formdb)
	{
		delete((Object) formdb);
	}

	/**
	 * Remove a persistent instance from the datastore. The argument may be an instance associated with the receiving
	 * Session or a transient instance with an identifier associated with existing persistent state. 
	 * Use the Session given.
	 * @param formdb the instance to be removed
	 * @param s the Session
	 */
	public void delete(cn.eas.Formdb formdb, Session s)
	{
		delete((Object) formdb, s);
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
	public void refresh (cn.eas.Formdb formdb, Session s)
	{
		refresh((Object) formdb, s);
	}


}