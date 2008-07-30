package cn.eas;

import java.util.ArrayList;

/** @pdOid 77d58df4-434d-42b6-a29e-482397ca7e07 */
public class Item {
   /** @pdOid 285eef23-f1f5-4fc9-8a34-7ee4abaf7b5c */
   private long id;
   /** @pdOid 14306d4d-93b2-4759-ae45-6849c4d4277c */
   private String formname;
   /** @pdOid b6e26a2e-cef1-4736-954b-c016a5b9966a */
   private String state;
   /** @pdOid 8aa03437-432a-4df2-a913-cbdbc716a1c9 */
   private String date;
   /** @pdOid fcb07aa7-a92c-466a-928a-6c3614272b08 */
   private String lastModify;
   /** @pdOid 7b0fc3af-7543-4192-82f4-c067c6c1bf29 */
   private String username;
   /** @pdOid ff11b0e0-5be2-40c8-8783-561fc974b847 */
   private String content;
   /** @pdOid 65ce5741-630f-4aaa-b919-96cf67b3e961 */
   private int step;
   /** @pdOid 8ef45866-055d-4aa4-ba7f-9ac8f1b6bfbf */
   private long projectId;
   /** @pdOid 7d5e9476-6823-457a-9d0f-5a2c5b704c95 */
   private ArrayList<Comment> commentList;
   
   /** @param id 
    * @param formname 
    * @param state 
    * @param date 
    * @param lastModify 
    * @param username 
    * @param content 
    * @param step 
    * @param projectId 
    * @param commentList
    * @pdOid 450ce6d3-d6f8-4a03-a75b-75151e781573 */
   public Item(long id, String formname, String state, String date, String lastModify, String username, String content, int step, long projectId, ArrayList<Comment> commentList) 		{
   	super();
   	this.id = id;
   	this.formname = formname;
   	this.state = state;
   	this.date = date;
   	this.lastModify = lastModify;
   	this.username = username;
   	this.content = content;
   	this.step = step;
   	this.projectId = projectId;
   	this.commentList = commentList;
   }
   
   /** @param id 
    * @param formname 
    * @param state 
    * @param date 
    * @param username 
    * @param content 
    * @param step 
    * @param commentList 
    * @param projectId
    * @pdOid 6d5044cb-f3ad-414c-9867-479739d87860 */
   public Item(long id, String formname, String state, String date, String username, String content, int step, ArrayList<Comment> commentList, long projectId) {
   	super();
   	this.id = id;
   	this.formname = formname;
   	this.state = state;
   	this.date = date;
   	this.username = username;
   	this.content = content;
   	this.step = step;
   	this.projectId = projectId;
   	this.commentList = commentList;
   }
   
   /** @pdOid 50c6bf27-64a4-4bda-a3ec-a6cccd85c1aa */
   public Item() {
   }
   
   /** @param username 
    * @param formname 
    * @param state 
    * @param content
    * @pdOid a0e6cdb1-1e98-483f-a044-c8f6a7612554 */
   public Item(String username, String formname, String state, String content) {
   	this.username=username;
   	this.formname = formname;
   	this.content = content;
   	this.step = 1;
   	this.state = state;
   }
   
   /** @pdOid f91a65b4-11a5-441c-a7df-b92e9cfcf208 */
   public String toString() {
   	return ("id:" + id + "\tformname:" + formname + "\tstep:" + step
   			+ "\tstate:" + state + "\tdate:" + date + "\tprojectID:"
   			+ projectId + "\tusername:" + username + "\tcomment:" + commentList
   			+ "\tcontent:" + content);
   }
   
   /** @param formname
    * @pdOid eb218fd9-9372-41f2-9fca-1d6cb1826ae2 */
   public void setFormname(String formname) {
   	this.formname = formname;
   }
   
   /** @param step
    * @pdOid e7ceafc8-f765-4cf6-a2fc-8f732bda4341 */
   public void setStep(int step) {
   	this.step = step;
   }
   
   /** @param state
    * @pdOid 4ad199a8-7de2-4e11-8599-64dd1a3030a3 */
   public void setState(String state) {
   	this.state = state;
   }
   
   /** @param date
    * @pdOid 56e1b591-c714-4c40-aa49-2b35b0c37932 */
   public void setDate(String date) {
   	this.date = date;
   }
   
   /** @param projectID
    * @pdOid 44f4aa31-6e56-41e4-9d2d-97e642076fb5 */
   public void setProjectId(long projectID) {
   	this.projectId = projectID;
   }
   
   /** @param username
    * @pdOid 18d4aa0e-1bc5-41e0-9983-7e89fde3607c */
   public void setUsername(String username) {
   	this.username = username;
   }
   
   /** @param content
    * @pdOid aaf2b9cd-5a3c-4b06-893e-1d757d57930c */
   public void setContent(String content) {
   	this.content = content;
   }
   
   /** @pdOid 90a5d4a0-8bbb-4ec0-be7e-14b8cbcace03 */
   public String getFormname() {
   	return this.formname;
   }
   
   /** @pdOid f16e333e-5004-46d9-b256-d2f25f699a4f */
   public int getStep() {
   	return this.step;
   }
   
   /** @pdOid 2c959559-752c-4617-afd0-0dfb67391822 */
   public String getState() {
   	return this.state;
   }
   
   /** @pdOid 5a74f827-b339-4de4-9ef9-6928732fb23b */
   public String getDate() {
   	return this.date;
   }
   
   /** @pdOid 4fb720eb-398b-4c42-88bb-c3ef324cf488 */
   public long getProjectId() {
   	return this.projectId;
   }
   
   /** @pdOid fd1e4b08-61a4-4c2f-9fc8-ea6545d6acc1 */
   public String getUsername() {
   	return this.username;
   }
   
   /** @pdOid 80ecf62d-de9e-44d3-81a5-7bf306afb1e8 */
   public String getContent() {
   	return this.content;
   }
   
   /** @pdOid e3ce110d-70ce-44cd-adff-cd7de2e04eae */
   public long getId() {
   	return id;
   }
   
   /** @param id
    * @pdOid 907726cb-85f9-44f0-8ebd-deec3132d91e */
   public void setId(long id) {
   	this.id = id;
   }
   
   /** @pdOid 08e3fd71-e675-4b9c-bc23-952196e22759 */
   public ArrayList<Comment> getCommentList() {
   	return commentList;
   }
   
   /** @param commentList
    * @pdOid ac370936-1b7d-452a-8438-a5602e0fffff */
   public void setCommentList(ArrayList<Comment> commentList) {
   	this.commentList = commentList;
   }
   
   /** @pdOid 25d1edf3-c069-4e17-891a-d0b765501830 */
   public String getLastModify() {
   	return lastModify;
   }
   
   /** @param lastModify
    * @pdOid e5b3d857-4232-4bbb-b877-58f873cc67bc */
   public void setLastModify(String lastModify) {
   	this.lastModify = lastModify;
   }

}