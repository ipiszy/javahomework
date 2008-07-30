package cn.eas.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the messagedb table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="messagedb"
 */

public abstract class BaseMessagedb  implements Serializable {

	public static String REF = "Messagedb";
	public static String PROP_DATE = "Date";
	public static String PROP_MESSAGE = "Message";
	public static String PROP_USERNAME = "Username";
	public static String PROP_ID = "Id";
	public static String PROP_MESSAGELEAVER = "Messageleaver";


	// constructors
	public BaseMessagedb () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMessagedb (long id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseMessagedb (
		long id,
		java.lang.String username,
		java.lang.String messageleaver,
		java.lang.String message) {

		this.setId(id);
		this.setUsername(username);
		this.setMessageleaver(messageleaver);
		this.setMessage(message);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private long id;

	// fields
	private java.lang.String username;
	private java.lang.String messageleaver;
	private java.lang.String message;
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
	 * Return the value associated with the column: messageleaver
	 */
	public java.lang.String getMessageleaver () {
		return messageleaver;
	}

	/**
	 * Set the value related to the column: messageleaver
	 * @param messageleaver the messageleaver value
	 */
	public void setMessageleaver (java.lang.String messageleaver) {
		this.messageleaver = messageleaver;
	}



	/**
	 * Return the value associated with the column: message
	 */
	public java.lang.String getMessage () {
		return message;
	}

	/**
	 * Set the value related to the column: message
	 * @param message the message value
	 */
	public void setMessage (java.lang.String message) {
		this.message = message;
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
		if (!(obj instanceof cn.eas.Messagedb)) return false;
		else {
			cn.eas.Messagedb messagedb = (cn.eas.Messagedb) obj;
			return (this.getId() == messagedb.getId());
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