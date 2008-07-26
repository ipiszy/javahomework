package cn.eas;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class FormManager {

	public static void main(String[] args) {
		ArrayList<FormInfo> forms = new FormManager().selectAll();
		for (FormInfo forminfo : forms) {
			System.out.println(forminfo.getName());
			System.out.println(forminfo.getFlow());
		}
		System.out.println(new FormManager().queryForm("交换生申请表").getContent());
		ArrayList<String> flow=new ArrayList<String>();
		
		flow.add("东20楼306");
		flow.add("东20楼大阿姨");
		flow.add("东20楼全体女生");
		
		System.out.println(new FormManager().addForm(new Form(flow,null,"进东20楼","进东20楼申请书--泣血")));
	}

	private static Log log = LogFactory.getLog(FormManager.class);

	@SuppressWarnings("unchecked")
	public ArrayList<FormInfo> selectAll() {
		Session s = HibernateUtil.currentSession();
		ArrayList<FormInfo> forms = new ArrayList<FormInfo>();

		try {
			HibernateUtil.beginTransaction();
			List formList = s.createSQLQuery("select name from formdb").list();
			for (Object obj : formList) {
				forms.add(new FormInfo(obj.toString()));
			}

			for (FormInfo forminfo : forms) {
				List formflowList = s.createSQLQuery(
						"select department from formflowdb "
								+ "where formname='" + forminfo.getName()
								+ "' order by step").list();
				ArrayList<String> departments = new ArrayList<String>();
				for (Object obj : formflowList) {
					departments.add(obj.toString());
				}
				forminfo.setFlow(departments);
			}
			HibernateUtil.commitTransaction();
		} catch (HibernateException e) {
			log.fatal(e);
		}
		HibernateUtil.closeSession();
		return forms;
	}

	@SuppressWarnings("unchecked")
	public Form queryForm(String name) {
		Session s = HibernateUtil.currentSession();
		Form form = new Form();

		try {
			HibernateUtil.beginTransaction();
			Formdb formdb = (Formdb) s.get(Formdb.class, name);
			form.setContent(formdb.getInfo());
			form.setName(name);

			List formflowList = s.createSQLQuery(
					"select department from formflowdb " + "where formname='"
							+ name + "' order by step").list();
			ArrayList<String> departments = new ArrayList<String>();
			for (Object obj : formflowList) {
				departments.add(obj.toString());
			}
			form.setFlow(departments);

			HibernateUtil.commitTransaction();
		} catch (HibernateException e) {
			log.fatal(e);
		}
		HibernateUtil.closeSession();
		return form;
	}
	
	public boolean addForm(Form form){
		Session s = HibernateUtil.currentSession();
		boolean flag=false;
		
		try {
			HibernateUtil.beginTransaction();
			Formdb formdb = new Formdb();
			
			formdb.setId(form.getName());
			formdb.setInfo(form.getContent());
			s.save(formdb);
			
			Formflowdb formflowdb;
			int step=0;
			int size=form.getFlow().size();
			
			for (String department:form.getFlow()){
				step++;
				formflowdb=new Formflowdb();
				
				formflowdb.setDepartment(department);
				formflowdb.setFormname(form.getName());
				formflowdb.setStep(step);
				if (step==size)
					formflowdb.setFinal(true);
				else
					formflowdb.setFinal(false);
				
				s.save(formflowdb);
			}
			
			HibernateUtil.commitTransaction();
			flag=true;
		} catch (HibernateException e) {
			log.fatal(e);
			flag=false;
		}
		HibernateUtil.closeSession();
		return flag;
	}
}
