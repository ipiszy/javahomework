package cn.eas;

public class Comment {
	private String comment;
	private String name;
	private String date;
	private String department;
	
	public Comment(String comment, String name, String date, String department) {
		super();
		this.comment = comment;
		this.name = name;
		this.date = date;
	}
	public Comment(String comment, String name) {
		super();
		this.comment = comment;
		this.name = name;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}

	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
	public String toString(){
		return ("comment:"+comment+"\tname£º"+name+"\tdate£º"+date);
	}
}
