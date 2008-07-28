package cn.eas;

public class Item {
	private long id;
	private String formname, state, date, username, comment, content;
	private int step;
	private long projectId;

	public Item() {
	}

	public Item(String formname, String state, String content) {
		this.formname = formname;
		this.content = content;
		this.step = 1;
		this.state = state;
	}

	public Item(long id, String formname, int step, String state, String date,
			long projectID, String username, String comment, String content) {
		this.id = id;
		this.formname = formname;
		this.step = step;
		this.state = state;
		this.date = date;
		this.projectId = projectID;
		this.username = username;
		this.comment = comment;
		this.content = content;
	}

	public String toString() {
		return ("id:" + id + "\tformname:" + formname + "\tstep:" + step
				+ "\tstate:" + state + "\tdate:" + date + "\tprojectID:"
				+ projectId + "\tusername:" + username + "\tcomment:" + comment
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

	public void setComment(String comment) {
		this.comment = comment;
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

	public String getComment() {
		return this.comment;
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

/*	public static String switchState(String state) {
		String stateReturn = null;

		if (state.equals("wait"))
			stateReturn = "等待批复";
		else if (state.equals("ongoing"))
			stateReturn = "正在批复";
		else if (state.equals("user"))
			stateReturn = "用户保存";
		else if (state.equals("finish"))
			stateReturn = "申请完成";

		return stateReturn;

	}
	*/
}
