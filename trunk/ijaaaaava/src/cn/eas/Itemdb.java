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
	public Itemdb (java.lang.String id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public Itemdb (
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

/*[CONSTRUCTOR MARKER END]*/


}