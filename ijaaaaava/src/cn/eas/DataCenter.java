package cn.eas;

import cn.eas.dao.AccountdbDAO;
import cn.eas.dao._RootDAO;



public class DataCenter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_RootDAO.initialize();
		AccountdbDAO accountdbDAO=new AccountdbDAO();
		System.out.println(accountdbDAO.queryLogin("ipiszy", ""));

	}

}
