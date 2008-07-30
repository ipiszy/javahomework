package cn.eas;

import cn.eas.base.BaseRecordhistorydb;

/** @pdOid 99a3e2d3-fbac-406a-9fdb-e3bff0510e86 */
public class Recordhistorydb extends cn.eas.base.BaseRecordhistorydb {
   /** @pdOid 92a36b3c-54fe-4e65-873a-1f9dc4b229d3 */
   private static final long serialVersionUID = 1L;
   
   /** [CONSTRUCTOR MARKER BEGIN]
    * 
    * @pdOid f3ad614d-0e91-4625-94eb-60ce61e3da2f */
   public Recordhistorydb() {
   	super();
   }
   
   /** Constructor for primary key
    * 
    * 
    * @param id
    * @pdOid abb6d6a2-54ad-434f-887c-27f6a89cdb67 */
   public Recordhistorydb(long id) {
   	super(id);
   }
   
   /** Constructor for required fields
    * 
    * 
    * @param id 
    * @param iId 
    * @param username 
    * @param department 
    * @param result
    * @pdOid 13b61978-fa66-4680-a2d9-921c9238601d */
   public Recordhistorydb(long id, long iId, java.lang.String username, java.lang.String department, boolean result) 	{
   
   	super (
   		id,
   		iId,
   		username,
   		department,
   		result);
   }

}

/*[CONSTRUCTOR MARKER END]*/