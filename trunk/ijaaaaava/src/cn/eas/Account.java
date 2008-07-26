package cn.eas;

public class Account {
	private String name;
	private String type;
	private String username;
	private boolean disabled;
	@SuppressWarnings("unused")
	private String password;
	
	public Account(){
		
	}
	
	public Account(String name, String type, String username, String password){
		this.name=name;
		this.type=type;
		this.username=username;
		this.password=password;
		this.disabled=false;
	}
	
	public Account(String name, String type, String username, String password, boolean disabled){
		this.name=name;
		this.type=type;
		this.username=username;
		this.password=password;
		this.disabled=disabled;
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
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isDisabled() {
		return disabled;
	}

	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}
	
}
