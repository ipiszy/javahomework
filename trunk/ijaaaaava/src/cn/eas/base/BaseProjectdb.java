package cn.eas.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the projectdb table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="projectdb"
 */

public abstract class BaseProjectdb  implements Serializable {

	public static String REF = "Projectdb";
	public static String PROP_NAME = "Name";
	public static String PROP_DATE = "Date";
	public static String PROP_USERNAME = "Username";
	public static String PROP_ID = "Id";


	// constructors
	public BaseProjectdb () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseProjectdb (long id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseProjectdb (
		long id,
		java.lang.String name,
		java.lang.String username) {

		this.setId(id);
		this.setName(name);
		this.setUsername(username);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private long id;

	// fields
	private java.lang.String date;
	private java.lang.String name;
	private java.lang.String username;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="identity"
     *  column="id"
     */
	public long getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId (long id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: date
	 */
	public java.lang.String getDate () {
		return date;
	}

	/**
	 * Set the value related to the column: date
	 * @param date the date value
	 */
	public void setDate (java.lang.String date) {
		this.date = date;
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
	 * Return the value associated with the column: username
	 */
	public java.lang.String getUsername () {
		return username;
	}

	/**
	 * Set the value related to the column: username
	 * @param username the username value
	 */
	public void setUsername (java.lang.String username) {
		this.username = username;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof cn.eas.Projectdb)) return false;
		else {
			cn.eas.Projectdb projectdb = (cn.eas.Projectdb) obj;
			return (this.getId() == projectdb.getId());
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			return (int) this.getId();
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}