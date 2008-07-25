package cn.eas.dao.iface;

import java.io.Serializable;

public interface ProjectdbDAO {
	public cn.eas.Projectdb get(long key);

	public cn.eas.Projectdb load(long key);

	public java.util.List<cn.eas.Projectdb> findAll ();


	/**
	 * Persist the given transient instance, first assigning a generated identifier. (Or using the current value
	 * of the identifier property if the assigned generator is used.) 
	 * @param projectdb a transient instance of a persistent class 
	 * @return the class identifier
	 */
	public java.lang.Long save(cn.eas.Projectdb projectdb);

	/**
	 * Either save() or update() the given instance, depending upon the value of its identifier property. By default
	 * the instance is always saved. This behaviour may be adjusted by specifying an unsaved-value attribute of the
	 * identifier property mapping. 
	 * @param projectdb a transient instance containing new or updated state 
	 */
	public void saveOrUpdate(cn.eas.Projectdb projectdb);

	/**
	 * Update the persistent state associated with the given identifier. An exception is thrown if there is a persistent
	 * instance with the same identifier in the current session.
	 * @param projectdb a transient instance containing updated state
	 */
	public void update(cn.eas.Projectdb projectdb);

	/**
	 * Remove a persistent instance from the datastore. The argument may be an instance associated with the receiving
	 * Session or a transient instance with an identifier associated with existing persistent state. 
	 * @param id the instance ID to be removed
	 */
	public void delete(long id);

	/**
	 * Remove a persistent instance from the datastore. The argument may be an instance associated with the receiving
	 * Session or a transient instance with an identifier associated with existing persistent state. 
	 * @param projectdb the instance to be removed
	 */
	public void delete(cn.eas.Projectdb projectdb);


}