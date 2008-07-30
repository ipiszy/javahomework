package cn.eas;

/** @pdOid ffff4737-a751-4359-b0ad-5f0bd84b6660 */
public class AccountInfo {
   /** @pdOid f475b263-c03f-4c0d-9736-9272cb918e7f */
   private String name;
   /** @pdOid 53aca69c-6517-4d78-88f3-59e81ab6f4cb */
   private String type;
   /** @pdOid 4fc26ecf-ff8d-4303-a028-de0ef67e612c */
   private String username;
   
   /** @pdOid 39a1982c-9e79-4369-8a47-b85601fdb122 */
   public AccountInfo() {
   	
   }
   
   /** @param username 
    * @param name 
    * @param type
    * @pdOid a0637834-cc4a-49e9-8fdb-81025bc28185 */
   public AccountInfo(String username, String name, String type) {
   	this.name=name;
   	this.type=type;
   	this.username=username;
   }
   
   /** @pdOid bc302e13-a900-4b75-ac1d-b269b3055b7c */
   public String getName() {
   	return name;
   }
   
   /** @param name
    * @pdOid 3324abd0-90ef-4b6c-a8ed-eadfff4eb597 */
   public void setName(String name) {
   	this.name = name;
   }
   
   /** @pdOid 352515f9-42a3-41c9-bd4f-b9098f35b6fa */
   public String getType() {
   	return type;
   }
   
   /** @param type
    * @pdOid d6e5e2e9-f59b-477f-82fd-ed78e757ba8e */
   public void setType(String type) {
   	this.type = type;
   }
   
   /** @pdOid 926842fc-5668-4862-9db6-19c5005eb4fe */
   public String getUsername() {
   	return username;
   }
   
   /** @param username
    * @pdOid e9ce2fda-83b4-4ae4-95b3-8efda6c19bbf */
   public void setUsername(String username) {
   	this.username = username;
   }
   
   /** @pdOid de579900-37dc-4bb0-9ddd-21985065aede */
   public String toString() {
   	return ("username:"+username+"\tname:"+name+"\ttype:"+type);
   }

}