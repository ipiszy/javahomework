package cn.eas;

public class Record {
	private String date, applicantName, managerName, comment, formName;
	private String result;
	private long itemId;

	public Record() {

	}

	public Record(String date, String applicantName, String managerName,
			String comment, String formName, String result, long itemId) {
		super();
		this.date = date;
		this.applicantName = applicantName;
		this.managerName = managerName;
		this.comment = comment;
		this.formName = formName;
		this.result = result;
		this.itemId = itemId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getApplicantName() {
		return applicantName;
	}

	public void setApplicantName(String applicantName) {
		this.applicantName = applicantName;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public long getItemId() {
		return itemId;
	}

	public void setItemId(long itemId) {
		this.itemId = itemId;
	}

	public String getRecord() {
		return comment;
	}

	public void setRecord(String record) {
		this.comment = record;
	}


	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getFormName() {
		return formName;
	}

	public void setFormName(String formName) {
		this.formName = formName;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	
	public String toString() {
		return ("date:" + date + "\tapplicantName:" + applicantName
				+ "\tmanagerName:" + managerName + "\tcomment:" + comment
				+ "\tresult:" + result + "\titemId:" + itemId);
	}

}