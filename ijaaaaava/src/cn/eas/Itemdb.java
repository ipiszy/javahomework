package cn.eas;

import cn.eas.base.BaseItemdb;



public class Itemdb extends BaseItemdb {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public Itemdb () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public Itemdb (long id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public Itemdb (
		long id,
		java.lang.String formname,
		int step,
		java.lang.String state,
		long projectid,
		java.lang.String username,
		java.lang.String comment,
		java.lang.String content) {

		super (
			id,
			formname,
			step,
			state,
			projectid,
			username,
			comment,
			content);
	}

/*[CONSTRUCTOR MARKER END]*/


}