package cn.eas;

import java.util.ArrayList;

public class FormInfo {
	private ArrayList<String> flow;
	private String name;
	
	public ArrayList<String> getFlow(){
		return flow;
	}
	
	public String getName(){
		return name;
	}
	
	public void setFlow(ArrayList<String> flow){
		this.flow=flow;
	}
	
	public void setName(String name){
		this.name=name;
	}
	
	public FormInfo(){
	}
	
	public FormInfo(ArrayList<String> flow, String name){
		this.flow=flow;
		this.name=name;
	}
	
	public FormInfo(String name){
		this.name=name;
	}
}