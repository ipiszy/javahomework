package cn.eas;

/** @pdOid 82c8f2db-2a9e-496d-a539-93958fd6a3a5 */
public class Project {
   /** @pdOid ef67ccde-671d-4ac2-b8f7-6481a2b3b05a */
   private long id;
   /** @pdOid ec3d3a90-60f9-48a9-b3e6-994aeab1d93c */
   private String date;
   /** @pdOid 2553ad1a-1e29-4fe1-af0e-ecd6a775e174 */
   private String name;
   /** @pdOid f5f690eb-c924-4084-9857-3e2f2d3ea43a */
   private String username;
   
   /** @param name 
    * @param username
    * @pdOid 4406fa2a-c7a3-43c5-94d9-072b34ba77b4 */
   public Project(String name, String username) {
   	super();
   	this.name = name;
   	this.username = username;
   }
   
   /** @param id 
    * @param date 
    * @param name 
    * @param username
    * @pdOid d9fb14a2-c441-4e4e-a7f3-2a39edf06901 */
   public Project(long id, String date, String name, String username) {
   	super();
   	this.id = id;
   	this.date = date;
   	this.name = name;
   	this.username = username;
   }
   
   /** @pdOid 234b4788-4009-4139-b42e-92d7bcf57c29 */
   public long getId() {
   	return id;
   }
   
   /** @param id
    * @pdOid a7b395e1-a154-48d9-8824-307bc862ba63 */
   public void setId(long id) {
   	this.id = id;
   }
   
   /** @pdOid dec5a115-6e67-4fea-aec6-8fc68f78ec7c */
   public String getDate() {
   	return date;
   }
   
   /** @param date
    * @pdOid 7993f052-a956-4b40-ac60-0b04b2e8ad54 */
   public void setDate(String date) {
   	this.date = date;
   }
   
   /** @pdOid f0d1b07b-3bce-48d0-b4e8-c03e9cd29ea2 */
   public String getName() {
   	return name;
   }
   
   /** @param name
    * @pdOid 009d6e3c-2d4a-4189-9406-6a9f98ef4add */
   public void setName(String name) {
   	this.name = name;
   }
   
   /** @pdOid 8508a04d-784e-4433-b543-77d9cdfe3bcf */
   public String getUsername() {
   	return username;
   }
   
   /** @param username
    * @pdOid 7fb3d469-9188-43df-bf42-9479d902ed69 */
   public void setUsername(String username) {
   	this.username = username;
   }
   
   /** @pdOid 71f90a5c-ba62-486b-988c-67f09404ebe7 */
   public String toString() {
   	return ("id:"+id+"\tname:"+name+"\tusername"+username+"\tdate"+date);
   }

}