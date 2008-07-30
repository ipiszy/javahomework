package cn.eas;

/** @pdOid 68d68866-e0d9-4af5-baf4-2f34c0edc2bb */
public class Record {
   /** @pdOid 94f4ec26-6718-46d0-93b1-060e8d00e18b */
   private String date;
   /** @pdOid 7b30a0c1-d817-4364-bc28-51ec8b12ee10 */
   private String applicantName;
   /** @pdOid a06b3ad7-64b5-4426-abe4-ac6986bf8a93 */
   private String managerName;
   /** @pdOid e12c6ab4-98fb-4336-b13e-1b710b8c3aa1 */
   private String comment;
   /** @pdOid ec2c9554-13d7-4f5c-a913-2208b063515d */
   private String formName;
   /** @pdOid 389e8011-7c84-4f71-a43c-8f24cdf63ca7 */
   private String result;
   /** @pdOid c80d5ae1-4ad6-43ce-ac33-6da900ec75a9 */
   private long itemId;
   
   /** @pdOid 992699af-d5a9-4541-8d0d-afb1cac9e415 */
   public Record() {
   
   }
   
   /** @param date 
    * @param applicantName 
    * @param managerName 
    * @param comment 
    * @param formName 
    * @param result 
    * @param itemId
    * @pdOid 6d4b9b3a-4c81-434e-8b07-66079a6675d4 */
   public Record(String date, String applicantName, String managerName, String comment, String formName, String result, long itemId) 		{
   	super();
   	this.date = date;
   	this.applicantName = applicantName;
   	this.managerName = managerName;
   	this.comment = comment;
   	this.formName = formName;
   	this.result = result;
   	this.itemId = itemId;
   }
   
   /** @pdOid 4685190a-75f3-473a-8de4-b712f83a3405 */
   public String getDate() {
   	return date;
   }
   
   /** @param date
    * @pdOid 2784b954-5495-46e7-8c32-65089c4f6b34 */
   public void setDate(String date) {
   	this.date = date;
   }
   
   /** @pdOid a908662a-fb70-4d83-b058-e32a6f4912e4 */
   public String getApplicantName() {
   	return applicantName;
   }
   
   /** @param applicantName
    * @pdOid 567e492f-ab81-42c4-a8e4-b5d28c1527a9 */
   public void setApplicantName(String applicantName) {
   	this.applicantName = applicantName;
   }
   
   /** @pdOid e96bfd10-3ef3-4239-9661-816616a710e6 */
   public String getManagerName() {
   	return managerName;
   }
   
   /** @param managerName
    * @pdOid 0831fd96-db51-446d-ac6a-47ac3eb29d5e */
   public void setManagerName(String managerName) {
   	this.managerName = managerName;
   }
   
   /** @pdOid f7b31c9c-397f-4119-8b42-6cb1bbd881ae */
   public long getItemId() {
   	return itemId;
   }
   
   /** @param itemId
    * @pdOid 37101785-22a1-41f2-a27d-bef87f491234 */
   public void setItemId(long itemId) {
   	this.itemId = itemId;
   }
   
   /** @pdOid 917037da-d948-46ae-b6fc-3ec55f497fec */
   public String getRecord() {
   	return comment;
   }
   
   /** @param record
    * @pdOid 654b54fc-eae8-4fb3-a405-73a8e3c4e4c0 */
   public void setRecord(String record) {
   	this.comment = record;
   }
   
   /** @pdOid 9e3df9e7-9d38-479c-b16f-0ceb761e979a */
   public String getComment() {
   	return comment;
   }
   
   /** @param comment
    * @pdOid 1511da3f-29a7-40c7-beb0-65625544d0ba */
   public void setComment(String comment) {
   	this.comment = comment;
   }
   
   /** @pdOid 8d3ebc56-8545-43b3-8123-b40b2b17bfdc */
   public String getFormName() {
   	return formName;
   }
   
   /** @param formName
    * @pdOid e10ee0d7-a2d2-4c60-ac56-93661374d6f6 */
   public void setFormName(String formName) {
   	this.formName = formName;
   }
   
   /** @pdOid a02b4e62-ba1e-4dd2-bf15-1f769569bcb1 */
   public String getResult() {
   	return result;
   }
   
   /** @param result
    * @pdOid 5bd4365c-c668-4d54-91d8-22350861df9c */
   public void setResult(String result) {
   	this.result = result;
   }
   
   /** @pdOid 30009477-5f48-4232-aa2e-9e1462a6056b */
   public String toString() {
   	return ("date:" + date + "\tapplicantName:" + applicantName
   			+ "\tmanagerName:" + managerName + "\tcomment:" + comment
   			+ "\tresult:" + result + "\titemId:" + itemId);
   }

}