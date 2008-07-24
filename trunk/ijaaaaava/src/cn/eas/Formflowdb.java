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
	public Formflowdb (java.lang.String id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public Formflowdb (
		java.lang.String id,
		cn.eas.Departmentdb rdepartment,
		cn.eas.Formdb rname,
		java.lang.Integer step,
		boolean m_final) {

		super (
			id,
			rdepartment,
			rname,
			step,
			m_final);
	}

/*[CONSTRUCTOR MARKER END]*/


}