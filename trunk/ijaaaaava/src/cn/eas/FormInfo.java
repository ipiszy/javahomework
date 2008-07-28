package cn.eas;

import java.util.ArrayList;

public class FormInfo {
	private long id;
	private ArrayList<String> flow;
	private String name;
	
	public FormInfo(){
	}
	
	public FormInfo(ArrayList<String> flow, String name){
		this.flow=flow;
		this.name=name;
	}
	
	public FormInfo(long id, String name){
		this.id=id;
		this.name=name;
	}

	public FormInfo(long id, ArrayList<String> flow, String name) {
		super();
		this.id = id;
		this.flow = flow;
		this.name = name;
	}

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
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}