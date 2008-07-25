package cn.eas;

public class Item {
	long id;
	String formname;
	int step;
	String state;
	String date;
	long projectID;
	String username;
	String comment;
	String content;
	
	/*Item(ItemDB itemDB){
		this=itemDB;
	}*/
	
	Item(String formname, String state, String content){
		this.formname=formname;
		this.content=content;
		this.step=1;
		this.state=state;
	}
	
	Item(long id, String formname, int step,String state,String date,
			long projectID,String username,String comment,String content){
		this.id=id;
		this.formname=formname;
		this.step=step;
		this.state=state;
		this.date=date;
		this.projectID=projectID;
		this.username=username;
		this.username=username;
		this.comment=comment;
		this.content=content;
	}
	
	public String toString(){
		return ("id:"+id+"\tformname:"+formname+"\tstep:"+step+"\tstate:"+state+"\tdate:"+date+"\tprojectID:"+projectID+"\tusername:"+username+"\tcomment:"+comment+"\tcontent:"+content);
	}

}
