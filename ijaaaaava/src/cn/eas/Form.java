package cn.eas;
import java.util.ArrayList;

public class Form {
	private ArrayList<String> flow=new ArrayList<String>();
	private ArrayList<String> previous=new ArrayList<String>();
	private String name;
	private String content;
	
	public Form(ArrayList<String> flow, ArrayList<String> previous, String name, String content){
		this.flow=flow;
		this.previous=previous;
		this.name=name;
		this.content=content;
	}
	
	public ArrayList<String> getFlow(){
		return this.flow;
	}
	
	public ArrayList<String> getPrevious(){
		return this.previous;
	}
	
	public String getName(){
		return this.name;
	}
	
	public String getContent(){
		return this.content;
	}
	
	public void setFlow(ArrayList<String> flow){
		this.flow=flow;
	}
	
	public void setPrevious(ArrayList<String> previous){
		this.previous=previous;
	}
	
	public void setName(String name){
		this.name=name;
	}
	
	public void setContent(String content){
		this.content=content;
	}
}
