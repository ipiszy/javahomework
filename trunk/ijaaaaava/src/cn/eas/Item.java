package cn.eas;

import java.util.ArrayList;

public class Item {
	private long id;
	private String formname, state, date, lastModify, username, content;
	private int step;
	private long projectId;
	private ArrayList<Comment> commentList;

	public Item(long id, String formname, String state, String date,
			String lastModify, String username, String content, int step,
			long projectId, ArrayList<Comment> commentList) {
		super();
		this.id = id;
		this.formname = formname;
		this.state = state;
		this.date = date;
		this.lastModify = lastModify;
		this.username = username;
		this.content = content;
		this.step = step;
		this.projectId = projectId;
		this.commentList = commentList;
	}

	public Item(long id, String formname, String state, String date,
			String username, String content, int step, ArrayList<Comment> commentList,
			long projectId) 
	{
		super();
		this.id = id;
		this.formname = formname;
		this.state = state;
		this.date = date;
		this.username = username;
		this.content = content;
		this.step = step;
		this.projectId = projectId;
		this.commentList = commentList;
	}

	public Item() {
	}

	public Item(String username, String formname, String state, String content) {
		this.username=username;
		this.formname = formname;
		this.content = content;
		this.step = 1;
		this.state = state;
	}


	public String toString() {
		return ("id:" + id + "\tformname:" + formname + "\tstep:" + step
				+ "\tstate:" + state + "\tdate:" + date + "\tprojectID:"
				+ projectId + "\tusername:" + username + "\tcomment:" + commentList
				+ "\tcontent:" + content);
	}

	public void setFormname(String formname) {
		this.formname = formname;
	}

	public void setStep(int step) {
		this.step = step;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setProjectId(long projectID) {
		this.projectId = projectID;
	}

	public void setUsername(String username) {
		this.username = username;
	}


	public void setContent(String content) {
		this.content = content;
	}

	public String getFormname() {
		return this.formname;
	}

	public int getStep() {
		return this.step;
	}

	public String getState() {
		return this.state;
	}

	public String getDate() {
		return this.date;
	}

	public long getProjectId() {
		return this.projectId;
	}

	public String getUsername() {
		return this.username;
	}


	public String getContent() {
		return this.content;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public ArrayList<Comment> getCommentList() {
		return commentList;
	}

	public void setCommentList(ArrayList<Comment> commentList) {
		this.commentList = commentList;
	}

	public String getLastModify() {
		return lastModify;
	}

	public void setLastModify(String lastModify) {
		this.lastModify = lastModify;
	}
}
