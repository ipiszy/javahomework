package cn.eas;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;


public class FormManager {

	public static void main(String[] args){
		ArrayList<FormInfo> forms=new FormManager().selectAll();
		for (FormInfo forminfo:forms){
			System.out.println(forminfo.getName());
			System.out.println(forminfo.getFlow());
		}
	}

	
	private static Log log = LogFactory.getLog(FormManager.class);
	
	@SuppressWarnings("unchecked")
	public ArrayList<FormInfo> selectAll(){
		Session s=HibernateUtil.currentSession();
		ArrayList<FormInfo> forms=new ArrayList<FormInfo>();
		
		try{
			HibernateUtil.beginTransaction();
			List formList=s.createSQLQuery("select name from formdb").list();
			for (Object obj:formList){
				forms.add(new FormInfo(obj.toString()));
			}
			
			for (FormInfo forminfo:forms){
				List formflowList=s.
				createSQLQuery("select department from formflowdb " +
						"where formname='"+forminfo.getName()+"' order by step").list();
				ArrayList<String> departments=new ArrayList<String>();
				for (Object obj:formflowList){
					departments.add(obj.toString());
				}
				forminfo.setFlow(departments);
			}
			HibernateUtil.commitTransaction();
		}
		catch (HibernateException e){
			log.fatal(e);
		}
		HibernateUtil.closeSession();
		return forms;
	}
}
