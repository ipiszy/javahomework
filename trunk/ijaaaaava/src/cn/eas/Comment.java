package cn.eas;

public class Comment {
	String comment;
	String name;
	String date;
	
	public Comment(String comment, String name, String date) {
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
}
