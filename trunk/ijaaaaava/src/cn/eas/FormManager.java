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
		ArrayList<String> flow = new ArrayList<String>();

		flow.add("东20楼306");
		flow.add("东20楼大阿姨");
		flow.add("东20楼全体女生");

		System.out.println(new FormManager().addForm(new Form(flow, null,
				"进东20楼", "进东20楼申请书--泣血")));
		flow.add("高声大叫我是女生");
		System.out.println(new FormManager().editForm(new Form(flow, null,
				"进东20楼", "进东20楼申请书--泣血")));
		
		//System.out.println(new FormManager().deleteForm("进东20楼"));
		System.out.println(new FormManager().addForm(new Form(flow,null,"进东20楼","")));

	}

	private static Log log = LogFactory.getLog(FormManager.class);

	@SuppressWarnings("unchecked")
	public ArrayList<FormInfo> selectAll() {
		Session s = HibernateUtil.currentSession();
		ArrayList<FormInfo> forms = new ArrayList<FormInfo>();

		try {
			HibernateUtil.beginTransaction();
			List formList = s.createSQLQuery("select name from formdb").list();
			HibernateUtil.commitTransaction();

			for (Object obj : formList) {
				forms.add(new FormInfo(obj.toString()));
			}

			for (FormInfo forminfo : forms) {
				HibernateUtil.beginTransaction();
				List formflowList = s.createSQLQuery(
						"select department from formflowdb "
								+ "where formname='" + forminfo.getName()
								+ "' order by step").list();
				HibernateUtil.commitTransaction();

				ArrayList<String> departments = new ArrayList<String>();
				for (Object obj : formflowList) {
					departments.add(obj.toString());
				}
				forminfo.setFlow(departments);
			}
		} catch (HibernateException e) {
			HibernateUtil.commitTransaction();
			e.printStackTrace();
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
			Formdb formdb = (Formdb) s.get(Formdb.class, name);
			form.setContent(formdb.getInfo());
			form.setName(name);

			HibernateUtil.beginTransaction();
			List formflowList = s.createSQLQuery(
					"select department from formflowdb " + "where formname='"
							+ name + "' order by step").list();
			HibernateUtil.commitTransaction();

			ArrayList<String> departments = new ArrayList<String>();
			for (Object obj : formflowList) {
				departments.add(obj.toString());
			}
			form.setFlow(departments);

		} catch (HibernateException e) {
			HibernateUtil.commitTransaction();
			e.printStackTrace();
			log.fatal(e);
		}
		HibernateUtil.closeSession();
		return form;
	}

	public boolean addForm(Form form) {
		Session s = HibernateUtil.currentSession();
		boolean flag = true;

		try {
			Formdb formdb = new Formdb();
			ArrayList<String> flow = form.getFlow();
			String name = form.getName();

			formdb.setId(form.getName());
			formdb.setInfo(form.getContent());

			HibernateUtil.beginTransaction();
			if (s.get(Formdb.class, form.getName())!=null)
				throw new HibernateException("duplicate form");
		
			else{
				s.save(formdb);
				HibernateUtil.commitTransaction();
				addFormflow(flow, name, s);
			}

		} catch (HibernateException e) {
			HibernateUtil.commitTransaction();
			e.printStackTrace();
			log.fatal(e);
			flag = false;
		}
		HibernateUtil.closeSession();
		return flag;
	}

	@SuppressWarnings("unchecked")
	public boolean editForm(Form form) {
		Session s = HibernateUtil.currentSession();
		boolean flag = true;

		ArrayList<String> flow = form.getFlow();
		String name = form.getName();

		try {
			HibernateUtil.beginTransaction();

			Formdb formdb = (Formdb) s.get(Formdb.class, form.getName());
			if (formdb==null)
				throw new HibernateException("no such form!");
			
			formdb.setInfo(form.getContent());	
			s.update(formdb);
			HibernateUtil.commitTransaction();

			removeFormflow(name, s);

			addFormflow(flow, name, s);

			flag = true;
		} catch (HibernateException e) {
			HibernateUtil.commitTransaction();
			e.printStackTrace();
			log.fatal(e);
			flag = false;
		}
		HibernateUtil.closeSession();
		return flag;
	}

	public boolean deleteForm(String name) {
		Session s = HibernateUtil.currentSession();
		boolean flag = true;

		try {
			HibernateUtil.beginTransaction();
			Formdb formdb = (Formdb) s.get(Formdb.class, name);
			HibernateUtil.commitTransaction();

			if (formdb == null)
				throw new HibernateException("no such form");
			
			HibernateUtil.beginTransaction();
			s.delete(formdb);
			HibernateUtil.commitTransaction();
			removeFormflow(name, s);
		} catch (HibernateException e) {
			HibernateUtil.commitTransaction();
			e.printStackTrace();
			log.fatal(e);
			flag=false;
		}

		return flag;
	}

	private void addFormflow(ArrayList<String> flow, String name, Session s)
			throws HibernateException {

		Formflowdb formflowdb;

		int step = 0;
		int size = flow.size();

		for (String department : flow) {
			HibernateUtil.beginTransaction();
			step++;
			formflowdb = new Formflowdb();

			formflowdb.setDepartment(department);
			formflowdb.setFormname(name);
			formflowdb.setStep(step);
			if (step == size)
				formflowdb.setFinal(true);
			else
				formflowdb.setFinal(false);

			s.save(formflowdb);
			HibernateUtil.commitTransaction();
		}
	}

	@SuppressWarnings("unchecked")
	private void removeFormflow(String name, Session s)
			throws HibernateException {
		Formflowdb formflowdb;

		List formflowList = s.createSQLQuery(
				"select id from formflowdb where formname='" + name + "'")
				.list();
		for (Object obj : formflowList) {
			HibernateUtil.beginTransaction();
			formflowdb = (Formflowdb) s.get(Formflowdb.class, Long
					.parseLong(obj.toString()));
			s.delete(formflowdb);
			HibernateUtil.commitTransaction();
		}
	}
}
