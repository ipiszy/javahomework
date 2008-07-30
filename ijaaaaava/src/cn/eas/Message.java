package cn.eas;

public class Message {
	private String date, username, message, messageLeaver;
	private long id;

	public Message(long id, String date, String username, String message,
			String messageLeaver) {
		this.id = id;
		this.date = date;
		this.username = username;
		this.message = message;
		this.messageLeaver = messageLeaver;
	}

	public Message(String date, String username, String messageLeaver) {
		this.date = date;
		this.username = username;
		this.messageLeaver = messageLeaver;

	}

	public Message() {
	}

	public String toString() {
		return ("date:" + date + "\tusername:" + username + "\tmessage:"
				+ message + "\tmessageLeaver:" + messageLeaver);
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setMessageLeaver(String messageLeaver) {
		this.messageLeaver = messageLeaver;
	}

	public void setID(long id) {
		this.id = id;
	}

	public long getID() {
		return id;
	}

	public String getDate() {
		return this.date;
	}

	public String getUsername() {
		return this.username;
	}

	public String getMessage() {
		return this.message;
	}

	public String getMessageLeaver() {
		return this.messageLeaver;
	}

}
