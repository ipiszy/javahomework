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
	
	public String getName(){
		return this.name;
	}
	
	public String getType(){
		return this.type;
	}
	
	public void setName(String name){
		this.name=name;
	}
	
	public void setType(String type){
		this.type=type;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
}
