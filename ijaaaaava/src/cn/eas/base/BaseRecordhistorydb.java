package cn.eas.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the recordhistorydb table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="recordhistorydb"
 */

public abstract class BaseRecordhistorydb  implements Serializable {

	public static String REF = "Recordhistorydb";
	public static String PROP_RESULT = "Result";
	public static String PROP_DATE = "Date";
	public static String PROP_I_ID = "IId";
	public static String PROP_USERNAME = "Username";
	public static String PROP_COMMENT = "Comment";
	public static String PROP_ID = "Id";
	public static String PROP_DEPARTMENT = "Department";


	// constructors
	public BaseRecordhistorydb () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseRecordhistorydb (long id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseRecordhistorydb (
		long id,
		long iId,
		java.lang.String username,
		java.lang.String department,
		boolean result) {

		this.setId(id);
		this.setIId(iId);
		this.setUsername(username);
		this.setDepartment(department);
		this.setResult(result);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private long id;

	// fields
	private java.lang.String comment;
	private long iId;
	private java.lang.String username;
	private java.lang.String department;
	private java.lang.String date;
	private boolean result;



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
	 * Return the value associated with the column: comment
	 */
	public java.lang.String getComment () {
		return comment;
	}

	/**
	 * Set the value related to the column: comment
	 * @param comment the comment value
	 */
	public void setComment (java.lang.String comment) {
		this.comment = comment;
	}



	/**
	 * Return the value associated with the column: i_id
	 */
	public long getIId () {
		return iId;
	}

	/**
	 * Set the value related to the column: i_id
	 * @param iId the i_id value
	 */
	public void setIId (long iId) {
		this.iId = iId;
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



	/**
	 * Return the value associated with the column: department
	 */
	public java.lang.String getDepartment () {
		return department;
	}

	/**
	 * Set the value related to the column: department
	 * @param department the department value
	 */
	public void setDepartment (java.lang.String department) {
		this.department = department;
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
	 * Return the value associated with the column: result
	 */
	public boolean isResult () {
		return result;
	}

	/**
	 * Set the value related to the column: result
	 * @param result the result value
	 */
	public void setResult (boolean result) {
		this.result = result;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof cn.eas.Recordhistorydb)) return false;
		else {
			cn.eas.Recordhistorydb recordhistorydb = (cn.eas.Recordhistorydb) obj;
			return (this.getId() == recordhistorydb.getId());
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