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

public abstract class BaseRecordhistorydb extends cn.eas.Itemdb  implements Serializable {

	public static String REF = "Recordhistorydb";
	public static String PROP_A = "A";
	public static String PROP_COMMENT = "Comment";
	public static String PROP_ID = "Id";


	// constructors
	public BaseRecordhistorydb () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseRecordhistorydb (java.lang.String id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public BaseRecordhistorydb (
		java.lang.String id,
		java.lang.String formname,
		java.lang.Integer step,
		java.lang.String state) {

		super (
			id,
			formname,
			step,
			state);
	}



	private int hashCode = Integer.MIN_VALUE;


	// fields
	private java.lang.String comment;

	// many to one
	private cn.eas.Accountdb a;






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
	 * Return the value associated with the column: a_id
	 */
	public cn.eas.Accountdb getA () {
		return a;
	}

	/**
	 * Set the value related to the column: a_id
	 * @param a the a_id value
	 */
	public void setA (cn.eas.Accountdb a) {
		this.a = a;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof cn.eas.Recordhistorydb)) return false;
		else {
			cn.eas.Recordhistorydb recordhistorydb = (cn.eas.Recordhistorydb) obj;
			if (null == this.getId() || null == recordhistorydb.getId()) return false;
			else return (this.getId().equals(recordhistorydb.getId()));
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