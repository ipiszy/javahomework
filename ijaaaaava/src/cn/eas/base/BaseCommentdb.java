package cn.eas.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the commentdb table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="commentdb"
 */

public abstract class BaseCommentdb  implements Serializable {

	public static String REF = "Commentdb";
	public static String PROP_DATE = "Date";
	public static String PROP_USERNAME = "Username";
	public static String PROP_COMMENT = "Comment";
	public static String PROP_ITEMID = "Itemid";
	public static String PROP_ID = "Id";


	// constructors
	public BaseCommentdb () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseCommentdb (long id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseCommentdb (
		long id,
		long itemid,
		java.lang.String username,
		java.lang.String comment) {

		this.setId(id);
		this.setItemid(itemid);
		this.setUsername(username);
		this.setComment(comment);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private long id;

	// fields
	private long itemid;
	private java.lang.String username;
	private java.lang.String comment;
	private java.lang.String date;



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
	 * Return the value associated with the column: itemid
	 */
	public long getItemid () {
		return itemid;
	}

	/**
	 * Set the value related to the column: itemid
	 * @param itemid the itemid value
	 */
	public void setItemid (long itemid) {
		this.itemid = itemid;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof cn.eas.Commentdb)) return false;
		else {
			cn.eas.Commentdb commentdb = (cn.eas.Commentdb) obj;
			return (this.getId() == commentdb.getId());
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