package cn.eas;

import cn.eas.base.BaseCommentdb;



public class Commentdb extends BaseCommentdb {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public Commentdb () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public Commentdb (long id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public Commentdb (
		long id,
		long itemid,
		java.lang.String username,
		java.lang.String comment) {

		super (
			id,
			itemid,
			username,
			comment);
	}

/*[CONSTRUCTOR MARKER END]*/


}