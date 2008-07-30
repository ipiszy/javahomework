package cn.eas;

import cn.eas.base.BaseItemdb;

/** @pdOid 0e9a1dcd-7027-4c16-a03d-828448800b41 */
public class Itemdb extends cn.eas.base.BaseItemdb {
   /** @pdOid 6ac3e67e-9508-4b99-83bc-e6de71e3d626 */
   private static final long serialVersionUID = 1L;
   
   /** [CONSTRUCTOR MARKER BEGIN]
    * 
    * @pdOid 0072a512-5eeb-486f-bb4a-97629cc65e9c */
   public Itemdb() {
   	super();
   }
   
   /** Constructor for primary key
    * 
    * 
    * @param id
    * @pdOid a24f9156-c6e1-4df4-94de-2930e7b3373a */
   public Itemdb(long id) {
   	super(id);
   }
   
   /** Constructor for required fields
    * 
    * 
    * @param id 
    * @param formname 
    * @param step 
    * @param state 
    * @param projectid 
    * @param username 
    * @param comment 
    * @param content
    * @pdOid d60e47a7-f246-482a-bfb9-54b3cb7a9601 */
   public Itemdb(long id, java.lang.String formname, int step, java.lang.String state, long projectid, java.lang.String username, java.lang.String comment, java.lang.String content) 	{
   
   	super (
   		id,
   		formname,
   		step,
   		state,
   		projectid,
   		username,
   		comment,
   		content);
   }

}

/*[CONSTRUCTOR MARKER END]*/