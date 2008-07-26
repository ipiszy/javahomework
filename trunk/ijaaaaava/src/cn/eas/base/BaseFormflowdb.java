package cn.eas.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the formflowdb table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="formflowdb"
 */

public abstract class BaseFormflowdb  implements Serializable {

	public static String REF = "Formflowdb";
	public static String PROP_STEP = "Step";
	public static String PROP_FINAL = "Final";
	public static String PROP_FORMNAME = "Formname";
	public static String PROP_ID = "Id";
	public static String PROP_DEPARTMENT = "Department";


	// constructors
	public BaseFormflowdb () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseFormflowdb (long id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseFormflowdb (
		long id,
		java.lang.String formname,
		java.lang.Integer step,
		java.lang.String department,
		boolean m_final) {

		this.setId(id);
		this.setFormname(formname);
		this.setStep(step);
		this.setDepartment(department);
		this.setFinal(m_final);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private long id;

	// fields
	private java.lang.String formname;
	private java.lang.Integer step;
	private java.lang.String department;
	private boolean m_final;



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
	public java.lang.Integer getStep () {
		return step;
	}

	/**
	 * Set the value related to the column: step
	 * @param step the step value
	 */
	public void setStep (java.lang.Integer step) {
		this.step = step;
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
	 * Return the value associated with the column: final
	 */
	public boolean isFinal () {
		return m_final;
	}

	/**
	 * Set the value related to the column: final
	 * @param m_final the final value
	 */
	public void setFinal (boolean m_final) {
		this.m_final = m_final;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof cn.eas.Formflowdb)) return false;
		else {
			cn.eas.Formflowdb formflowdb = (cn.eas.Formflowdb) obj;
			return (this.getId() == formflowdb.getId());
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