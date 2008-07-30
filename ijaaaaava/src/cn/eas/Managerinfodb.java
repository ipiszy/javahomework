package cn.eas;

import cn.eas.base.BaseManagerinfodb;

/** @pdOid 1a307ca3-d5ce-4f84-9830-8c51e38923ef */
public class Managerinfodb extends cn.eas.base.BaseManagerinfodb {
   /** @pdOid 151b553d-fda5-41ed-a438-bb88d685a409 */
   private static final long serialVersionUID = 1L;
   
   /** [CONSTRUCTOR MARKER BEGIN]
    * 
    * @pdOid 9c00ce62-9325-4ab4-aac7-e791c406255c */
   public Managerinfodb() {
   	super();
   }
   
   /** Constructor for primary key
    * 
    * 
    * @param id
    * @pdOid f387248b-c809-4c4e-b610-07d0e6be63fa */
   public Managerinfodb(java.lang.String id) {
   	super(id);
   }
   
   /** Constructor for required fields
    * 
    * 
    * @param id 
    * @param department
    * @pdOid 8e04188d-7b2b-4dd6-914c-e70b69a16610 */
   public Managerinfodb(java.lang.String id, java.lang.String department) 	{
   
   	super (
   		id,
   		department);
   }

}

/*[CONSTRUCTOR MARKER END]*/