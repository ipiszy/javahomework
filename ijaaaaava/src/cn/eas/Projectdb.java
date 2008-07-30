package cn.eas;

import cn.eas.base.BaseProjectdb;

public class Projectdb extends BaseProjectdb {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public Projectdb () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public Projectdb (long id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public Projectdb (
		long id,
		java.lang.String name,
		java.lang.String username) {

		super (
			id,
			name,
			username);
	}

/*[CONSTRUCTOR MARKER END]*/


}