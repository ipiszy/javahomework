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
	public Recordhistorydb (long id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public Recordhistorydb (
		long id,
		long iId,
		java.lang.String username,
		java.lang.String department,
		boolean result) {

		super (
			id,
			iId,
			username,
			department,
			result);
	}

/*[CONSTRUCTOR MARKER END]*/


}