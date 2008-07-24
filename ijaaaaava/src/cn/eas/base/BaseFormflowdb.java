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
	public static String PROP_RDEPARTMENT = "Rdepartment";
	public static String PROP_STEP = "Step";
	public static String PROP_FINAL = "Final";
	public static String PROP_ID = "Id";
	public static String PROP_RNAME = "Rname";


	// constructors
	public BaseFormflowdb () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseFormflowdb (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseFormflowdb (
		java.lang.String id,
		cn.eas.Departmentdb rdepartment,
		cn.eas.Formdb rname,
		java.lang.Integer step,
		boolean m_final) {

		this.setId(id);
		this.setRdepartment(rdepartment);
		this.setRname(rname);
		this.setStep(step);
		this.setFinal(m_final);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String id;

	// fields
	private java.lang.Integer step;
	private boolean m_final;

	// many to one
	private cn.eas.Departmentdb rdepartment;
	private cn.eas.Formdb rname;



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



	/**
	 * Return the value associated with the column: rdepartment
	 */
	public cn.eas.Departmentdb getRdepartment () {
		return rdepartment;
	}

	/**
	 * Set the value related to the column: rdepartment
	 * @param rdepartment the rdepartment value
	 */
	public void setRdepartment (cn.eas.Departmentdb rdepartment) {
		this.rdepartment = rdepartment;
	}



	/**
	 * Return the value associated with the column: rname
	 */
	public cn.eas.Formdb getRname () {
		return rname;
	}

	/**
	 * Set the value related to the column: rname
	 * @param rname the rname value
	 */
	public void setRname (cn.eas.Formdb rname) {
		this.rname = rname;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof cn.eas.Formflowdb)) return false;
		else {
			cn.eas.Formflowdb formflowdb = (cn.eas.Formflowdb) obj;
			if (null == this.getId() || null == formflowdb.getId()) return false;
			else return (this.getId().equals(formflowdb.getId()));
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