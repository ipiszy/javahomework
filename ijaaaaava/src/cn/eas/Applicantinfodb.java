package cn.eas;

import cn.eas.base.BaseApplicantinfodb;



public class Applicantinfodb extends BaseApplicantinfodb {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public Applicantinfodb () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public Applicantinfodb (java.lang.String id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public Applicantinfodb (
		java.lang.String id,
		java.lang.String project,
		java.lang.String item,
		java.lang.String aId) {

		super (
			id,
			project,
			item,
			aId);
	}

/*[CONSTRUCTOR MARKER END]*/


}