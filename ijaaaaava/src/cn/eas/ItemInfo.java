package cn.eas;

/** @pdOid e116cc74-b341-4e77-862c-96015f695392 */
public class ItemInfo {
   /** @pdOid 07bb80b2-5ef6-4ab0-b66d-f0e464d2cd60 */
   private long id;
   /** @pdOid 1c20f1f5-cad7-4d5e-825d-f040879ee618 */
   private String formname;
   /** @pdOid 3e0e2119-bfa0-4e82-b846-99778d6e6a11 */
   private String state;
   /** @pdOid 0f71974c-4003-40e9-bfeb-d1cbb8a189fe */
   private String date;
   /** @pdOid 46b79963-a7ee-4f57-8f87-0e933476ccaf */
   private String department;
   /** @pdOid 17b4b419-5a38-47a4-b03a-612c4bef361a */
   private String lastModify;
   
   /** @param id 
    * @param formname 
    * @param state 
    * @param date 
    * @param department 
    * @param lastModify
    * @pdOid a8a65d86-d40e-4053-af4d-578c4d08a790 */
   public ItemInfo(long id, String formname, String state, String date, String department, String lastModify) 		{
   	super();
   	this.id = id;
   	this.formname = formname;
   	this.state = state;
   	this.date = date;
   	this.department = department;
   	this.lastModify = lastModify;
   }
   
   /** @param id 
    * @param formname 
    * @param state 
    * @param date 
    * @param department
    * @pdOid 62ac0ed4-a1fe-452a-a5f8-0d3691b0d606 */
   public ItemInfo(long id, String formname, String state, String date, String department)                 {
           super();
           this.id = id;
           this.formname = formname;
           this.state = state;
           this.date = date;
           this.department = department;
   }
   
   /** @param id 
    * @param formname 
    * @param state 
    * @param date
    * @pdOid c7b9a67b-75e7-4314-be6d-a08460cf00ac */
   public ItemInfo(long id, String formname, String state, String date) {
           this.id=id;
           this.formname=formname;
           this.state=state;
           this.date=date;
   }
   
   /** @pdOid 5b3e0641-6310-487b-b974-8ff84a6e7d71 */
   public String toString() {
           return("id:"+id+"\tformname:"+formname+"\tstate:"+state+"\tdate:"+date+"\tdepartment:"+department+"\tlastModify:"+lastModify);
   }
   
   /** @pdOid 5030ccac-38b9-4925-b4f0-e31f88d5cafa */
   public String getFormname() {
           return this.formname;
   }
   
   /** @pdOid abe7127d-0b94-4554-b886-d40c9d3790fd */
   public String getState() {
           return this.state;
   }
   
   /** @pdOid cdb8c8ed-3fd7-47ec-9433-db6885931855 */
   public String getDate() {
           return this.date;
   }
   
   /** @param formname
    * @pdOid 5b8d23aa-7a6c-4699-bbb5-96e04ffeea7b */
   public void setFormname(String formname) {
           this.formname=formname;
   }
   
   /** @param state
    * @pdOid 60deace9-7a5d-4eec-b281-44031b558528 */
   public void setState(String state) {
           this.state=state;
   }
   
   /** @param date
    * @pdOid b9babc34-3b29-4b84-ad04-0e25587c4a99 */
   public void setDate(String date) {
           this.date=date;
   }
   
   /** @pdOid 46234797-e1be-42e2-9464-6a0cbee93990 */
   public long getId() {
           return id;
   }
   
   /** @param id
    * @pdOid 48f022b7-c746-44f9-a1ae-cdfe8bb18068 */
   public void setId(long id) {
           this.id = id;
   }
   
   /** @pdOid 5b9be10d-4366-4103-aa60-c9793ec8d12f */
   public String getDepartment() {
           return department;
   }
   
   /** @param department
    * @pdOid 44361322-298e-44ec-9a23-e8567046cab2 */
   public void setDepartment(String department) {
           this.department = department;
   }
   
   /** @pdOid 1fa8e357-2e9f-426a-8ee9-a591e1f8eea2 */
   public String getLastModify() {
   	return lastModify;
   }
   
   /** @param lastModify
    * @pdOid 7bdd4b17-9a20-4bbf-add0-ffe1c8e78658 */
   public void setLastModify(String lastModify) {
   	this.lastModify = lastModify;
   }

}