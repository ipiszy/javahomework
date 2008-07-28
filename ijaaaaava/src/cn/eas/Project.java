package cn.eas;

public class Project {
	long id;
	String date;
	String name;
	
	public Project(String name) {
		super();
		this.name = name;
	}

	public Project(long id, String date, String name) {
		super();
		this.id = id;
		this.date = date;
		this.name = name;
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

}
