package cn.eas;

/** @pdOid 42df8375-dbaf-4f7b-b519-e6f58cdd9492 */
public class Department {
   /** @pdOid 0f815537-f298-4508-a3ec-d97dd44e7279 */
   private String name;
   /** @pdOid af7b8533-d8b5-461d-9147-705808da397c */
   private String workTime;
   /** @pdOid 2cee0285-2b66-49c1-b56e-0c2d9f8c4855 */
   private String affairs;
   
   /** @param name 
    * @param workTime 
    * @param affairs
    * @pdOid d15735b5-895f-4d9f-be40-95fef9af69d5 */
   public Department(String name, String workTime, String affairs) {
   	this.name=name;
   	this.workTime=workTime;
   	this.affairs=affairs;
   }
   
   /** @pdOid 6d9e0d0f-3392-428c-95cd-2f186cfc936d */
   public String getName() {
   	return this.name;
   }
   
   /** @pdOid f577609f-277a-43b9-8c7a-6022398dcf79 */
   public String getWorkTime() {
   	return this.workTime;
   }
   
   /** @pdOid 5e013979-44fe-47f4-b0e3-34664f6191ec */
   public String getAffairs() {
   	return this.affairs;
   }
   
   /** @param name
    * @pdOid 166726ab-554a-416b-8d77-811f0d6ab2db */
   public void setName(String name) {
   	this.name=name;
   }
   
   /** @param workTime
    * @pdOid 3f11c65a-81a7-40fa-8889-00b77c9cf1d3 */
   public void setWorkTime(String workTime) {
   	this.workTime=workTime;
   }
   
   /** @param affairs
    * @pdOid 3c3d29cd-b413-4042-bfcf-8aaf18fb9db7 */
   public void setAffairs(String affairs) {
   	this.affairs=affairs;
   }

}