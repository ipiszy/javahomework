package cn.eas;

import cn.eas.base.BaseFormflowdb;

/** @pdOid c20b71ac-b00a-4571-bfa8-b58bac8a2dcf */
public class Formflowdb extends cn.eas.base.BaseFormflowdb {
   /** @pdOid cdccfa02-49c6-4310-8859-635943a4e953 */
   private static final long serialVersionUID = 1L;
   
   /** [CONSTRUCTOR MARKER BEGIN]
    * 
    * @pdOid 20f8997a-cc14-4a29-9163-b0db1af2635c */
   public Formflowdb() {
   	super();
   }
   
   /** Constructor for primary key
    * 
    * 
    * @param id
    * @pdOid 9741ce1d-7806-4774-bbcd-5637821d7eed */
   public Formflowdb(long id) {
   	super(id);
   }
   
   /** Constructor for required fields
    * 
    * 
    * @param id 
    * @param formname 
    * @param step 
    * @param department 
    * @param m_final
    * @pdOid 9d46d430-d4c6-4744-845a-d2ad64f1c710 */
   public Formflowdb(long id, java.lang.String formname, java.lang.Integer step, java.lang.String department, boolean m_final) 	{
   
   	super (
   		id,
   		formname,
   		step,
   		department,
   		m_final);
   }

}

/*[CONSTRUCTOR MARKER END]*/