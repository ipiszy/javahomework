package cn.eas;

import cn.eas.base.BaseAccountdb;

public class Accountdb extends BaseAccountdb {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public Accountdb () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public Accountdb (java.lang.String id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public Accountdb (
		java.lang.String id,
		java.lang.String name,
		java.lang.String password,
		java.lang.String type,
		boolean disabled) {

		super (
			id,
			name,
			password,
			type,
			disabled);
	}

/*[CONSTRUCTOR MARKER END]*/

}