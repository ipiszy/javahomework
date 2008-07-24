package cn.eas.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the departmentdb table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="departmentdb"
 */

public abstract class BaseDepartmentdb  implements Serializable {

	public static String REF = "Departmentdb";
	public static String PROP_AFFAIRS = "Affairs";
	public static String PROP_WORKTIME = "Worktime";
	public static String PROP_ID = "Id";


	// constructors
	public BaseDepartmentdb () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseDepartmentdb (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String id;

	// fields
	private java.lang.String worktime;
	private java.lang.String affairs;

	// collections
	private java.util.Set<cn.eas.Formflowdb> formflowdbs;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  column="name"
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
	 * Return the value associated with the column: worktime
	 */
	public java.lang.String getWorktime () {
		return worktime;
	}

	/**
	 * Set the value related to the column: worktime
	 * @param worktime the worktime value
	 */
	public void setWorktime (java.lang.String worktime) {
		this.worktime = worktime;
	}



	/**
	 * Return the value associated with the column: affairs
	 */
	public java.lang.String getAffairs () {
		return affairs;
	}

	/**
	 * Set the value related to the column: affairs
	 * @param affairs the affairs value
	 */
	public void setAffairs (java.lang.String affairs) {
		this.affairs = affairs;
	}



	/**
	 * Return the value associated with the column: Formflowdbs
	 */
	public java.util.Set<cn.eas.Formflowdb> getFormflowdbs () {
		return formflowdbs;
	}

	/**
	 * Set the value related to the column: Formflowdbs
	 * @param formflowdbs the Formflowdbs value
	 */
	public void setFormflowdbs (java.util.Set<cn.eas.Formflowdb> formflowdbs) {
		this.formflowdbs = formflowdbs;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof cn.eas.Departmentdb)) return false;
		else {
			cn.eas.Departmentdb departmentdb = (cn.eas.Departmentdb) obj;
			if (null == this.getId() || null == departmentdb.getId()) return false;
			else return (this.getId().equals(departmentdb.getId()));
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