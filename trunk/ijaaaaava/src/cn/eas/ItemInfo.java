package cn.eas;

public class ItemInfo {
	long id;
	String formname;
	String state;
	String date;

	
	public ItemInfo(long id,String formname, String state, String date){
		this.id=id;
		this.formname=formname;
		this.state=state;
		this.date=date;
	}
	
	public String toString(){
		return("id:"+id+"\tformname:"+formname+"\tstate:"+state+"\tdate:"+date);
	}
}
