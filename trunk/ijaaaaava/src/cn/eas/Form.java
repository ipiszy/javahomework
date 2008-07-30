package cn.eas;

import java.util.ArrayList;

/** @pdOid 6287e4a4-4caa-48e3-8f47-1aae85c6fd18 */
public class Form {
   /** @pdOid 163010c5-01f2-49af-8375-075ca87e40b1 */
   private ArrayList<String> flow;
   /** @pdOid 71f30885-da18-4c05-8d38-ae81d31f2345 */
   private ArrayList<String> previous;
   /** @pdOid ddf423ae-e915-4815-9938-eb6c8544a5cd */
   private String name;
   /** @pdOid 16e3a182-655a-4066-8994-8c763ff20b96 */
   private String content;
   /** @pdOid 08843afb-5d25-479c-80d7-0372f32e179b */
   private long id;
   
   /** @pdOid 2fa67422-21c0-4a0d-9d31-64fef24adfb4 */
   public Form() {
   	
   }
   
   /** @param flow 
    * @param previous 
    * @param name 
    * @param content
    * @pdOid 50c8f3dc-d4c1-400c-b208-179ee5ea16da */
   public Form(ArrayList<String> flow, ArrayList<String> previous, String name, String content) 		{
   	super();
   	this.flow = flow;
   	this.previous = previous;
   	this.name = name;
   	this.content = content;
   }
   
   /** @param id 
    * @param flow 
    * @param previous 
    * @param name 
    * @param content
    * @pdOid e4fae579-69d2-467b-8244-c5a6e12cc5a0 */
   public Form(long id, ArrayList<String> flow, ArrayList<String> previous, String name, String content) {
   	this.id=id;
   	this.flow=flow;
   	this.previous=previous;
   	this.name=name;
   	this.content=content;
   }
   
   /** @pdOid 4ab41e34-e9e5-4107-b194-f9746c1cb38d */
   public ArrayList<String> getFlow() {
   	return this.flow;
   }
   
   /** @pdOid 5ca0ca70-5269-4cc9-aaf2-c63040ebc85f */
   public ArrayList<String> getPrevious() {
   	return this.previous;
   }
   
   /** @pdOid 7a2d6b24-9645-4607-8676-d7b529270516 */
   public String getName() {
   	return this.name;
   }
   
   /** @pdOid 6170eb81-ca2b-4d36-87e0-4606bfd867b6 */
   public String getContent() {
   	return this.content;
   }
   
   /** @param flow
    * @pdOid b4a53830-5219-4a56-a2d3-f36de3d6519c */
   public void setFlow(ArrayList<String> flow) {
   	this.flow=flow;
   }
   
   /** @param previous
    * @pdOid 9e535d90-c06a-4c0c-8e21-7514a7e424a0 */
   public void setPrevious(ArrayList<String> previous) {
   	this.previous=previous;
   }
   
   /** @param name
    * @pdOid 242299cf-3ee6-4c28-9740-1fa61897c131 */
   public void setName(String name) {
   	this.name=name;
   }
   
   /** @param content
    * @pdOid 73b5eb25-db5e-4b83-9457-d9c3cc32f13f */
   public void setContent(String content) {
   	this.content=content;
   }
   
   /** @pdOid 3a05b550-7978-498e-9c3f-679f75790737 */
   public long getId() {
   	return id;
   }
   
   /** @param id
    * @pdOid 095cb433-ff51-4ba5-85c2-481c8671d28c */
   public void setId(long id) {
   	this.id = id;
   }

}