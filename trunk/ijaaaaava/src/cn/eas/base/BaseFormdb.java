package cn.eas.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the formdb table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="formdb"
 */

public abstract class BaseFormdb  implements Serializable {

	public static String REF = "Formdb";
	public static String PROP_ID = "Id";
	public static String PROP_INFO = "Info";
	public static String PROP_DEPENDENCY = "Dependency";


	// constructors
	public BaseFormdb () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseFormdb (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseFormdb (
		java.lang.String id,
		java.lang.String info,
		boolean dependency) {

		this.setId(id);
		this.setInfo(info);
		this.setDependency(dependency);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String id;

	// fields
	private java.lang.String info;
	private boolean dependency;

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
	 * Return the value associated with the column: info
	 */
	public java.lang.String getInfo () {
		return info;
	}

	/**
	 * Set the value related to the column: info
	 * @param info the info value
	 */
	public void setInfo (java.lang.String info) {
		this.info = info;
	}



	/**
	 * Return the value associated with the column: dependency
	 */
	public boolean isDependency () {
		return dependency;
	}

	/**
	 * Set the value related to the column: dependency
	 * @param dependency the dependency value
	 */
	public void setDependency (boolean dependency) {
		this.dependency = dependency;
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
		if (!(obj instanceof cn.eas.Formdb)) return false;
		else {
			cn.eas.Formdb formdb = (cn.eas.Formdb) obj;
			if (null == this.getId() || null == formdb.getId()) return false;
			else return (this.getId().equals(formdb.getId()));
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