package cn.eas;

import cn.eas.base.BaseManagerinfodb;

public class Managerinfodb extends BaseManagerinfodb {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public Managerinfodb () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public Managerinfodb (java.lang.String id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public Managerinfodb (
		java.lang.String id,
		java.lang.String department) {

		super (
			id,
			department);
	}

/*[CONSTRUCTOR MARKER END]*/

}