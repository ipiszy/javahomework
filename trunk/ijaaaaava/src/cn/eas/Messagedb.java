package cn.eas;

import cn.eas.base.BaseMessagedb;



public class Messagedb extends BaseMessagedb {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public Messagedb () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public Messagedb (long id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public Messagedb (
		long id,
		java.lang.String username,
		java.lang.String messageleaver,
		java.lang.String message) {

		super (
			id,
			username,
			messageleaver,
			message);
	}

/*[CONSTRUCTOR MARKER END]*/


}