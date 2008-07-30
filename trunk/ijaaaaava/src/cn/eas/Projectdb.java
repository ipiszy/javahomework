package cn.eas;

import cn.eas.base.BaseProjectdb;

/** @pdOid b6679b41-cf31-4f33-ab0e-e695bf0ee44c */
public class Projectdb extends cn.eas.base.BaseProjectdb {
   /** @pdOid 8c2af4e9-e441-4dde-b21f-afa0117efc8e */
   private static final long serialVersionUID = 1L;
   
   /** [CONSTRUCTOR MARKER BEGIN]
    * 
    * @pdOid 27a0980d-36cd-48b0-9281-836ba5a070d6 */
   public Projectdb() {
   	super();
   }
   
   /** Constructor for primary key
    * 
    * 
    * @param id
    * @pdOid 03c94b85-6ea2-472c-9876-3871e5319864 */
   public Projectdb(long id) {
   	super(id);
   }
   
   /** Constructor for required fields
    * 
    * 
    * @param id 
    * @param name 
    * @param username
    * @pdOid 7ce8870f-7149-4351-beba-8a9381d4065e */
   public Projectdb(long id, java.lang.String name, java.lang.String username) 	{
   
   	super (
   		id,
   		name,
   		username);
   }

}

/*[CONSTRUCTOR MARKER END]*/