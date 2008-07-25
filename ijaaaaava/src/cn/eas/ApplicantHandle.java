package cn.eas;

public class ApplicantHandle {
//public List<Project> queryProject(String username){return ActivityManager.queryApplicantInfo(username);}
//public Project openProject(String username,String projectname){return ActivityManager.queryProject(username,projectname);}
//public boolean creatProject(String username,String projectname){return ActivityManager.addProject(username,projectname);}
public Item getItem(String id){return ActivityManager.queryItem(Long.parseLong(id));}
public boolean saveItem(Item item){return ActivityManager.saveItem(item);}
//public List<FormInfo> allForms(){return ActivityManager.selectAll();}
//public Form getForm(String formname){return ActivityManager.query(formname);}
}
