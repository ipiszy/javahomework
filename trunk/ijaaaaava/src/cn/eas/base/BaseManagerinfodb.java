package cn.eas.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the managerinfodb table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="managerinfodb"
 */

public abstract class BaseManagerinfodb  implements Serializable {

	public static String REF = "Managerinfodb";
	public static String PROP_ID = "Id";
	public static String PROP_DEPARTMENT = "Department";


	// constructors
	public BaseManagerinfodb () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseManagerinfodb (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseManagerinfodb (
		java.lang.String id,
		java.lang.String department) {

		this.setId(id);
		this.setDepartment(department);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String id;

	// fields
	private java.lang.String department;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  column="username"
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof cn.eas.Managerinfodb)) return false;
		else {
			cn.eas.Managerinfodb managerinfodb = (cn.eas.Managerinfodb) obj;
			if (null == this.getId() || null == managerinfodb.getId()) return false;
			else return (this.getId().equals(managerinfodb.getId()));
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