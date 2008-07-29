package cn.eas;

public class Project {
	private long id;
	private String date, name, username;
	
	public Project(String name, String username) {
		super();
		this.name = name;
		this.username = username;
	}

	public Project(long id, String date, String name, String username) {
		super();
		this.id = id;
		this.date = date;
		this.name = name;
		this.username = username;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String toString(){
		return ("id:"+id+"\tname:"+name+"\tusername"+username+"\tdate"+date);
	}

}
