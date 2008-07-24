package cn.eas.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the accountdb table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="accountdb"
 */

public abstract class BaseAccountdb  implements Serializable {

	public static String REF = "Accountdb";
	public static String PROP_NAME = "Name";
	public static String PROP_TYPE = "Type";
	public static String PROP_PASSWORD = "Password";
	public static String PROP_ID = "Id";


	// constructors
	public BaseAccountdb () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseAccountdb (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseAccountdb (
		java.lang.String id,
		java.lang.String name,
		java.lang.String password,
		java.lang.String type) {

		this.setId(id);
		this.setName(name);
		this.setPassword(password);
		this.setType(type);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String id;

	// fields
	private java.lang.String name;
	private java.lang.String password;
	private java.lang.String type;

	// collections
	private java.util.Set<cn.eas.Recordhistorydb> recordhistorydbs;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  column="id"
     */
	public java.lang.String getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId (java.lang.String id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: name
	 */
	public java.lang.String getName () {
		return name;
	}

	/**
	 * Set the value related to the column: name
	 * @param name the name value
	 */
	public void setName (java.lang.String name) {
		this.name = name;
	}



	/**
	 * Return the value associated with the column: password
	 */
	public java.lang.String getPassword () {
		return password;
	}

	/**
	 * Set the value related to the column: password
	 * @param password the password value
	 */
	public void setPassword (java.lang.String password) {
		this.password = password;
	}



	/**
	 * Return the value associated with the column: type
	 */
	public java.lang.String getType () {
		return type;
	}

	/**
	 * Set the value related to the column: type
	 * @param type the type value
	 */
	public void setType (java.lang.String type) {
		this.type = type;
	}



	/**
	 * Return the value associated with the column: Recordhistorydbs
	 */
	public java.util.Set<cn.eas.Recordhistorydb> getRecordhistorydbs () {
		return recordhistorydbs;
	}

	/**
	 * Set the value related to the column: Recordhistorydbs
	 * @param recordhistorydbs the Recordhistorydbs value
	 */
	public void setRecordhistorydbs (java.util.Set<cn.eas.Recordhistorydb> recordhistorydbs) {
		this.recordhistorydbs = recordhistorydbs;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof cn.eas.Accountdb)) return false;
		else {
			cn.eas.Accountdb accountdb = (cn.eas.Accountdb) obj;
			if (null == this.getId() || null == accountdb.getId()) return false;
			else return (this.getId().equals(accountdb.getId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}