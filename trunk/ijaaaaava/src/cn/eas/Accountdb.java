package cn.eas;

import cn.eas.base.BaseAccountdb;
import cn.eas.dao.AccountdbDAO;
import cn.eas.dao._RootDAO;



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
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_RootDAO.initialize();
		AccountdbDAO accountdbDAO=new AccountdbDAO();
		System.out.println(accountdbDAO.queryLogin("ipiszy", "123455555"));

	}

}