package cn.eas;

import cn.eas.base.BaseCommentdb;

/** @pdOid f463effc-101d-4993-8516-a944caf0eec8 */
public class Commentdb extends cn.eas.base.BaseCommentdb {
   /** @pdOid 82455222-30c2-4ec6-8c9e-7eb4371c2c29 */
   private static final long serialVersionUID = 1L;
   
   /** [CONSTRUCTOR MARKER BEGIN]
    * 
    * @pdOid c222a17c-8018-4023-8f00-a1aaaf799f92 */
   public Commentdb() {
   	super();
   }
   
   /** Constructor for primary key
    * 
    * 
    * @param id
    * @pdOid 62082e9b-c638-4da6-8a6b-f239cb277c2b */
   public Commentdb(long id) {
   	super(id);
   }
   
   /** Constructor for required fields
    * 
    * 
    * @param id 
    * @param itemid 
    * @param username 
    * @param comment
    * @pdOid 4677905f-b7fb-4a8c-852a-07319abbc0f1 */
   public Commentdb(long id, long itemid, java.lang.String username, java.lang.String comment) 	{
   
   	super (
   		id,
   		itemid,
   		username,
   		comment);
   }

}

/*[CONSTRUCTOR MARKER END]*/