package cn.eas;

import cn.eas.base.BaseFormdb;



public class Formdb extends BaseFormdb {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public Formdb () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public Formdb (java.lang.String id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public Formdb (
		java.lang.String id,
		java.lang.String info,
		boolean dependency) {

		super (
			id,
			info,
			dependency);
	}

/*[CONSTRUCTOR MARKER END]*/


}