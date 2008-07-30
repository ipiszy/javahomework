package cn.eas;

public class Record {
	private String date, applicantName, managerName, comment;
	private boolean result;
	private long itemId;

	public Record() {

	}

	public Record(String date, String applicantName, String managerName,
			String record, boolean result, long itemId) {
		super();
		this.date = date;
		this.applicantName = applicantName;
		this.managerName = managerName;
		this.comment = record;
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

	public boolean isResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
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

	public String toString() {
		return ("date:" + date + "\tapplicantName:" + applicantName
				+ "\tmanagerName:" + managerName + "\tcomment:" + comment
				+ "\tresult:" + result + "\titemId:" + itemId);
	}

}