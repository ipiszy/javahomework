package cn.eas;

import cn.eas.base.BaseAccountdb;

/** @pdOid bd3a910a-d19d-4cd1-b6f0-1c7c2d9708ba */
public class Accountdb extends cn.eas.base.BaseAccountdb {
   /** @pdOid 7977dd0d-6578-4f2c-a4fd-f4e521e37208 */
   private static final long serialVersionUID = 1L;
   
   /** [CONSTRUCTOR MARKER BEGIN]
    * 
    * @pdOid fcd71f9d-2e3b-41e3-b050-ec4e2d3370ac */
   public Accountdb() {
   	super();
   }
   
   /** Constructor for primary key
    * 
    * 
    * @param id
    * @pdOid 3dccfb04-546d-45bf-bb1c-ddcb74cb6a10 */
   public Accountdb(java.lang.String id) {
   	super(id);
   }
   
   /** Constructor for required fields
    * 
    * 
    * @param id 
    * @param name 
    * @param password 
    * @param type 
    * @param disabled
    * @pdOid 5cd1b21c-eb88-46dd-ab5c-de3ade65befa */
   public Accountdb(java.lang.String id, java.lang.String name, java.lang.String password, java.lang.String type, boolean disabled) 	{
   
   	super (
   		id,
   		name,
   		password,
   		type,
   		disabled);
   }

}

/*[CONSTRUCTOR MARKER END]*/