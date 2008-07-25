package cn.eas;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.eas.dao.HibernateUtil;
import cn.eas.dao.ItemdbDAO;
import cn.eas.dao._RootDAO;

public class ActivityManager {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new ActivityManager().queryCurrentApplicantInfo("ipiszy"));
		System.out.println(new ActivityManager().queryItem(1));
		new ActivityManager().saveItem(new Item(13,"lalala",2,"wait","1988-12-18",12,"ipiszy","",""));

	}
	public ArrayList<ItemInfo> queryCurrentApplicantInfo(String username){
		Session s=HibernateUtil.currentSession();
		ArrayList<ItemInfo> itemInfoList=new ArrayList<ItemInfo>();
		List itemList=s.createSQLQuery("SELECT id, formname, state, date from itemdb where username='"+username+"'").list();
		for (Object obj:itemList){
			Object[] o=(Object[])obj;
			long id=Long.parseLong(o[0].toString());
			String formname=o[1].toString();
			String state=o[2].toString();
			String date=o[3].toString();
			itemInfoList.add(new ItemInfo(id,formname,state,date));
		}
		return itemInfoList;
	}
	
	public Item queryItem(long id){
		_RootDAO.initialize();
		Itemdb itemdb=new ItemdbDAO().get(id);
		return (new Item(itemdb.getId(),itemdb.getFormname(),itemdb.getStep(),
				itemdb.getState(),itemdb.getDate(),itemdb.getProjectid(),
				itemdb.getUsername(),itemdb.getComment(),itemdb.getContent()));
	}
	
	public boolean saveItem(Item item){
		
		Session s=HibernateUtil.currentSession();
		HibernateUtil.beginTransaction();
		Itemdb itemdb=new Itemdb();
		if (item.id!=-1)//如何判断这个id是否有效？
			itemdb.setId(item.id);
		itemdb.setComment(item.comment);
		itemdb.setContent(item.content);
		itemdb.setDate(item.date);
		itemdb.setFormname(item.formname);
		itemdb.setProjectid(item.projectID);
		itemdb.setState(item.state);
		itemdb.setStep(item.step);
		itemdb.setUsername(item.username);
		s.saveOrUpdate(itemdb);
		HibernateUtil.commitTransaction();
		return true;
	}
	
	public ArrayList<ItemInfo> queryCurrentRecordInfo(String department){
		Session s=HibernateUtil.currentSession();
		ArrayList<ItemInfo> itemInfoList=new ArrayList<ItemInfo>();
		List itemList=s.createSQLQuery("SELECT itemdb.id,itemdb.formname,state,date " +
				"from itemdb inner join formflowdb " +
				"on itemdb.formname=formflowdb.formname AND itemdb.step=formflowdb.step " +
				"where itemdb.state='wait' AND department='"+department+"'").list();
		for (Object obj:itemList){
			Object[] o=(Object[])obj;
			long id=Long.parseLong(o[0].toString());
			String formname=o[1].toString();
			String state=o[2].toString();
			String date=o[3].toString();
			itemInfoList.add(new ItemInfo(id,formname,state,date));
		}
		return itemInfoList;
	}

	public Item loadItem(long id){
		_RootDAO.initialize();
		Itemdb itemdb=new ItemdbDAO().get(id);
		Session s=HibernateUtil.currentSession();
		HibernateUtil.beginTransaction();
		
		itemdb.setState("ongoing");
		s.update(itemdb);
		HibernateUtil.commitTransaction();
		
		Item item=new Item(itemdb.getId(),itemdb.getFormname(),itemdb.getStep(),
				itemdb.getState(),itemdb.getDate(),itemdb.getProjectid(),
				itemdb.getUsername(),itemdb.getComment(),itemdb.getContent());
		
		return item;
	}
	
	
}
