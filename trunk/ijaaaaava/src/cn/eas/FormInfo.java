package cn.eas;

import java.util.ArrayList;

/** @pdOid 444778d5-61cf-4076-b81d-9cd8059aaf76 */
public class FormInfo {
   /** @pdOid cd4c696a-a174-440e-aa99-d7ee3b4c7284 */
   private ArrayList<String> flow;
   /** @pdOid fba70a44-93d2-40da-a596-ae96dd2dce1b */
   private String name;
   
   /** @pdOid ab19d356-f282-452d-8e20-1232921e89d4 */
   public ArrayList<String> getFlow() {
   	return flow;
   }
   
   /** @pdOid 6d29fa81-45ab-4a6c-bee9-8e0dce00a342 */
   public String getName() {
   	return name;
   }
   
   /** @param flow
    * @pdOid 99d71273-1ee4-4630-b949-1496ef854b66 */
   public void setFlow(ArrayList<String> flow) {
   	this.flow=flow;
   }
   
   /** @param name
    * @pdOid 6fd99b67-cd41-489d-b2fe-02f3327e2460 */
   public void setName(String name) {
   	this.name=name;
   }
   
   /** @pdOid b86ee137-48b4-451d-b8a0-d0513bfa6ec5 */
   public FormInfo() {
   }
   
   /** @param flow 
    * @param name
    * @pdOid 58d13392-bcdd-40c4-b37c-91c21beecd8b */
   public FormInfo(ArrayList<String> flow, String name) {
   	this.flow=flow;
   	this.name=name;
   }
   
   /** @param name
    * @pdOid 436326d6-c633-4a37-9c2c-167f2ad1856a */
   public FormInfo(String name) {
   	this.name=name;
   }

}