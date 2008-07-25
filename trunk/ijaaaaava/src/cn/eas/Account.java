package cn.eas;

public class Account {
	private String name;
	private String type;
	private long id;
	@SuppressWarnings("unused")
	private String password;
	
	Account(String name, String type, long id, String password){
		this.name=name;
		this.type=type;
		this.id=id;
		this.password=password;
	}
	
	String getName(){
		return this.name;
	}
	
	String getType(){
		return this.type;
	}
	
	long getID(){
		return this.id;
	}
	
	void setName(String name){
		this.name=name;
	}
	
	void setType(String type){
		this.type=type;
	}
	
	void setID(long id){
		this.id=id;
	}
	
}
