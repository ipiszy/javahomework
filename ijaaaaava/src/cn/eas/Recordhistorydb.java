package cn.eas;

import cn.eas.base.BaseRecordhistorydb;



public class Recordhistorydb extends BaseRecordhistorydb {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public Recordhistorydb () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public Recordhistorydb (java.lang.String id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public Recordhistorydb (
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