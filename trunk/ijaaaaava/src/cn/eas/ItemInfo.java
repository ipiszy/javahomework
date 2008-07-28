package cn.eas;

public class ItemInfo {
	private long id;
	private String formname,state,date;
	
	public ItemInfo(long id,String formname, String state, String date){
		this.id=id;
		this.formname=formname;
		this.state = state;
		this.date=date;
	}
	
	public String toString(){
		return("id:"+id+"\tformname:"+formname+"\tstate:"+state+"\tdate:"+date);
	}
	
	public String getFormname(){
		return this.formname;
	}
	
	public String getState(){
		return this.state;
	}
	
	public String getDate(){
		return this.date;
	}
	
	public void setFormname(String formname){
		this.formname=formname;
	}
	
	public void setState(String state){
		this.state=state;
	}
	
	public void setDate(String date){
		this.date=date;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}
