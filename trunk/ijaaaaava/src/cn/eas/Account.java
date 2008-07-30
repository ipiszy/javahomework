package cn.eas;

/** @pdOid e88c1e82-3cc2-4d74-83dc-9e12fc4d4a5b */
public class Account {
   /** @pdOid 6542fcc3-e70e-481d-8c48-ee4737619f64 */
   private String name;
   /** @pdOid 9e367a1d-bc85-4f68-a069-08efd7cae490 */
   private String type;
   /** @pdOid 668687da-9206-4b8c-9a19-be91917cd93f */
   private String username;
   /** @pdOid c428251d-25d2-4dad-ae37-a6fcda60c8ba */
   private boolean disabled;
   /** @pdOid b360dfb6-6484-4cb7-8522-e5eb4a1a1a1f */
   private String password;
   
   /** @pdOid 4f4cebff-3806-4bbd-a0b1-b4881baff9a8 */
   public Account() {
   	
   }
   
   /** @param name 
    * @param type 
    * @param username 
    * @param password
    * @pdOid 728b2e16-61cf-415c-a052-a0934deeaa51 */
   public Account(String name, String type, String username, String password) {
   	this.name=name;
   	this.type=type;
   	this.username=username;
   	this.password=password;
   	this.disabled=false;
   }
   
   /** @param name 
    * @param type 
    * @param username 
    * @param password 
    * @param disabled
    * @pdOid 2505e7c9-52b9-42bc-b13f-344a93bf92c0 */
   public Account(String name, String type, String username, String password, boolean disabled) {
   	this.name=name;
   	this.type=type;
   	this.username=username;
   	this.password=password;
   	this.disabled=disabled;
   }
   
   /** @pdOid 08d992cf-b751-4f4a-bd97-583e7398d55b */
   public String getName() {
   	return this.name;
   }
   
   /** @pdOid 0e53ee1d-7320-40a4-b23b-bb559045f524 */
   public String getType() {
   	return this.type;
   }
   
   /** @param name
    * @pdOid 67c726c4-c419-4cf7-9c19-3a7052d26bbf */
   public void setName(String name) {
   	this.name=name;
   }
   
   /** @param type
    * @pdOid 5ec0332a-26d3-4e41-ac03-22a74953db88 */
   public void setType(String type) {
   	this.type=type;
   }
   
   /** @pdOid f3852295-9002-41fe-9594-f8e2be59c417 */
   public String getUsername() {
   	return username;
   }
   
   /** @param username
    * @pdOid 9026c37f-38a7-4ba9-937e-6e664f8dc48e */
   public void setUsername(String username) {
   	this.username = username;
   }
   
   /** @pdOid 4c9994eb-f3da-489d-9a9b-86eb33b74cb0 */
   public String getPassword() {
   	return password;
   }
   
   /** @param password
    * @pdOid 314f4bca-3bec-4fee-ba97-ea3dee1c940f */
   public void setPassword(String password) {
   	this.password = password;
   }
   
   /** @pdOid a5bafbc6-279c-4b3a-b615-2c9f777b4373 */
   public boolean isDisabled() {
   	return disabled;
   }
   
   /** @param disabled
    * @pdOid 2c32c4ba-931f-483d-81d2-d8cad8727683 */
   public void setDisabled(boolean disabled) {
   	this.disabled = disabled;
   }

}