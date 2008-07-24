package cn.eas;
import java.util.ArrayList;


public class Form {
	ArrayList<String> flow=new ArrayList<String>();
	ArrayList<String> previous=new ArrayList<String>();
	String name;
	String content;
	
	Form(ArrayList<String> flow, ArrayList<String> previous, String name, String content){
		this.name=name;
		this.previous=previous;
		this.name=name;
		this.content=content;
	}
}
