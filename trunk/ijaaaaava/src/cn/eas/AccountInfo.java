package cn.eas;

public class AccountInfo {
	private String name;
	private String type;
	private String username; 
	
	public AccountInfo(){
		
	}
	
	public AccountInfo(String username, String name, String type){
		this.name=name;
		this.type=type;
		this.username=username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String toString(){
		return ("username:"+username+"\tname:"+name+"\ttype:"+type);
	}

}