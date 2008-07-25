package cn.eas;

public class Item {
	private long id;
	private String formname,state,date,username,comment,content;
	private int step;
	private long projectID;
	
	public Item(){
	}
	
	public Item(String formname, String state, String content){
		this.formname=formname;
		this.content=content;
		this.step=1;
		this.state=state;
	}
	
	public Item(long id, String formname, int step,String state,String date,
			long projectID,String username,String comment,String content){
		this.id=id;
		this.formname=formname;
		this.step=step;
		this.state=state;
		this.date=date;
		this.projectID=projectID;
		this.username=username;
		this.comment=comment;
		this.content=content;
	}
	
	public String toString(){
		return ("id:"+id+"\tformname:"+formname+"\tstep:"+step+"\tstate:"+state+"\tdate:"+date+"\tprojectID:"+projectID+"\tusername:"+username+"\tcomment:"+comment+"\tcontent:"+content);
	}
	
	public void setID(long id){
		this.id=id;
	}
	
	public void setFormname(String formname){
		this.formname=formname;
	}
	
	public void setStep(int step){
		this.step=step;
	}
	
	public void setState(String state){
		this.state=state;
	}
	
	public void setDate(String date){
		this.date=date;
	}
	
	public void setProjectID(long projectID){
		this.projectID=projectID;
	}
	
	public void setUsername(String username){
		this.username=username;
	}
	
	public void setComment(String comment){
		this.comment=comment;
	}
	
	public void setContent(String content){
		this.content=content;
	}
	public long getID(){
		return this.id;
	}
	
	public String getFormname(){
		return this.formname;
	}
	
	public int getStep(){
		return this.step;
	}
	
	public String getState(){
		return this.state;
	}
	
	public String getDate(){
		return this.date;
	}
	
	public long getProjectID(){
		return this.projectID;
	}
	
	public String getUsername(){
		return this.username;
	}
	
	public String getComment(){
		return this.comment;
	}
	
	public String getContent(){
		return this.content;
	}
}
