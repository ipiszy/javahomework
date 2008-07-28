package cn.eas;
import java.util.ArrayList;

public class Form {
	private ArrayList<String> flow;
	private ArrayList<String> previous;
	private String name;
	private String content;
	private long id;
	
    public Form (){
    	
    }

    public Form(ArrayList<String> flow, ArrayList<String> previous,
			String name, String content) {
		super();
		this.flow = flow;
		this.previous = previous;
		this.name = name;
		this.content = content;
	}
	
	public Form(long id, ArrayList<String> flow, ArrayList<String> previous, String name, String content){
		this.id=id;
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
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
}
