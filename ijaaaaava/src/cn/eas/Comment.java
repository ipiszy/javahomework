package cn.eas;

public class Comment {
	String comment;
	String name;
	
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
}
