package cn.eas;

import cn.eas.base.BaseFormdb;

/** @pdOid df42c55a-90d5-44ae-9786-39f90299b3f6 */
public class Formdb extends cn.eas.base.BaseFormdb {
   /** @pdOid c81143c3-baf9-411c-acac-8a923bd828e5 */
   private static final long serialVersionUID = 1L;
   
   /** [CONSTRUCTOR MARKER BEGIN]
    * 
    * @pdOid c7f098b1-c91d-444a-aee2-5accb75b45a9 */
   public Formdb() {
   	super();
   }
   
   /** Constructor for primary key
    * 
    * 
    * @param id
    * @pdOid 9a01042a-739e-49a2-a509-1d617db42017 */
   public Formdb(java.lang.String id) {
   	super(id);
   }
   
   /** Constructor for required fields
    * 
    * 
    * @param id 
    * @param info 
    * @param dependency
    * @pdOid cdad57a9-0ce9-4adc-9ebd-3b4134d02e82 */
   public Formdb(java.lang.String id, java.lang.String info, boolean dependency) 	{
   
   	super (
   		id,
   		info,
   		dependency);
   }

}

/*[CONSTRUCTOR MARKER END]*/