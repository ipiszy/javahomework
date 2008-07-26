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
		java.lang.String formname,
		java.lang.Integer step,
		java.lang.String department,
		boolean m_final) {

		super (
			id,
			formname,
			step,
			department,
			m_final);
	}

/*[CONSTRUCTOR MARKER END]*/


}