package cn.eas.base;

import java.io.Serializable;

import cn.eas.*;


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
	public BaseFormflowdb (long id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseFormflowdb (
		long id,
		java.lang.String rname,
		java.lang.Integer step,
		java.lang.String rdepartment,
		boolean m_final) {

		this.setId(id);
		this.setRname(rname);
		this.setStep(step);
		this.setRdepartment(rdepartment);
		this.setFinal(m_final);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private long id;

	// fields
	private java.lang.String rname;
	private java.lang.Integer step;
	private java.lang.String rdepartment;
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
	 * Return the value associated with the column: rname
	 */
	public java.lang.String getRname () {
		return rname;
	}

	/**
	 * Set the value related to the column: rname
	 * @param rname the rname value
	 */
	public void setRname (java.lang.String rname) {
		this.rname = rname;
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
	 * Return the value associated with the column: rdepartment
	 */
	public java.lang.String getRdepartment () {
		return rdepartment;
	}

	/**
	 * Set the value related to the column: rdepartment
	 * @param rdepartment the rdepartment value
	 */
	public void setRdepartment (java.lang.String rdepartment) {
		this.rdepartment = rdepartment;
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