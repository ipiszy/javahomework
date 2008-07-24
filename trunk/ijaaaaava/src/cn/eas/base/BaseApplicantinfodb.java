package cn.eas.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the applicantinfodb table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="applicantinfodb"
 */

public abstract class BaseApplicantinfodb  implements Serializable {

	public static String REF = "Applicantinfodb";
	public static String PROP_ITEM = "Item";
	public static String PROP_ID = "Id";
	public static String PROP_A_ID = "AId";
	public static String PROP_PROJECT = "Project";


	// constructors
	public BaseApplicantinfodb () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseApplicantinfodb (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseApplicantinfodb (
		java.lang.String id,
		java.lang.String project,
		java.lang.String item,
		java.lang.String aId) {

		this.setId(id);
		this.setProject(project);
		this.setItem(item);
		this.setAId(aId);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String id;

	// fields
	private java.lang.String project;
	private java.lang.String item;
	private java.lang.String aId;



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
	 * Return the value associated with the column: project
	 */
	public java.lang.String getProject () {
		return project;
	}

	/**
	 * Set the value related to the column: project
	 * @param project the project value
	 */
	public void setProject (java.lang.String project) {
		this.project = project;
	}



	/**
	 * Return the value associated with the column: item
	 */
	public java.lang.String getItem () {
		return item;
	}

	/**
	 * Set the value related to the column: item
	 * @param item the item value
	 */
	public void setItem (java.lang.String item) {
		this.item = item;
	}



	/**
	 * Return the value associated with the column: a_id
	 */
	public java.lang.String getAId () {
		return aId;
	}

	/**
	 * Set the value related to the column: a_id
	 * @param aId the a_id value
	 */
	public void setAId (java.lang.String aId) {
		this.aId = aId;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof cn.eas.Applicantinfodb)) return false;
		else {
			cn.eas.Applicantinfodb applicantinfodb = (cn.eas.Applicantinfodb) obj;
			if (null == this.getId() || null == applicantinfodb.getId()) return false;
			else return (this.getId().equals(applicantinfodb.getId()));
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