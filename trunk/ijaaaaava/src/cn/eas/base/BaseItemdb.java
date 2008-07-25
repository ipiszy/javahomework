package cn.eas.base;

import java.io.Serializable;

import cn.eas.*;


/**
 * This is an object that contains data related to the itemdb table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="itemdb"
 */

public abstract class BaseItemdb  implements Serializable {

	public static String REF = "Itemdb";
	public static String PROP_STEP = "Step";
	public static String PROP_STATE = "State";
	public static String PROP_DATE = "Date";
	public static String PROP_FORMNAME = "Formname";
	public static String PROP_USERNAME = "Username";
	public static String PROP_PROJECTID = "Projectid";
	public static String PROP_COMMENT = "Comment";
	public static String PROP_ID = "Id";
	public static String PROP_CONTENT = "Content";


	// constructors
	public BaseItemdb () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseItemdb (long id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseItemdb (
		long id,
		java.lang.String formname,
		int step,
		java.lang.String state,
		long projectid,
		java.lang.String username,
		java.lang.String comment,
		java.lang.String content) {

		this.setId(id);
		this.setFormname(formname);
		this.setStep(step);
		this.setState(state);
		this.setProjectid(projectid);
		this.setUsername(username);
		this.setComment(comment);
		this.setContent(content);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private long id;

	// fields
	private java.lang.String formname;
	private int step;
	private java.lang.String state;
	private java.lang.String date;
	private long projectid;
	private java.lang.String username;
	private java.lang.String comment;
	private java.lang.String content;



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
	 * Return the value associated with the column: formname
	 */
	public java.lang.String getFormname () {
		return formname;
	}

	/**
	 * Set the value related to the column: formname
	 * @param formname the formname value
	 */
	public void setFormname (java.lang.String formname) {
		this.formname = formname;
	}



	/**
	 * Return the value associated with the column: step
	 */
	public int getStep () {
		return step;
	}

	/**
	 * Set the value related to the column: step
	 * @param step the step value
	 */
	public void setStep (int step) {
		this.step = step;
	}



	/**
	 * Return the value associated with the column: state
	 */
	public java.lang.String getState () {
		return state;
	}

	/**
	 * Set the value related to the column: state
	 * @param state the state value
	 */
	public void setState (java.lang.String state) {
		this.state = state;
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
	 * Return the value associated with the column: projectid
	 */
	public long getProjectid () {
		return projectid;
	}

	/**
	 * Set the value related to the column: projectid
	 * @param projectid the projectid value
	 */
	public void setProjectid (long projectid) {
		this.projectid = projectid;
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
	 * Return the value associated with the column: content
	 */
	public java.lang.String getContent () {
		return content;
	}

	/**
	 * Set the value related to the column: content
	 * @param content the content value
	 */
	public void setContent (java.lang.String content) {
		this.content = content;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof cn.eas.Itemdb)) return false;
		else {
			cn.eas.Itemdb itemdb = (cn.eas.Itemdb) obj;
			return (this.getId() == itemdb.getId());
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