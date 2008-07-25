package cn.eas;

import cn.eas.base.BaseFormflowdb;



public class Formflowdb extends BaseFormflowdb {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public Formflowdb () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public Formflowdb (long id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public Formflowdb (
		long id,
		java.lang.String rname,
		java.lang.Integer step,
		java.lang.String rdepartment,
		boolean m_final) {

		super (
			id,
			rname,
			step,
			rdepartment,
			m_final);
	}

/*[CONSTRUCTOR MARKER END]*/


}