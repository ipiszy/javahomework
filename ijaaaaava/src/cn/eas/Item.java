package cn.eas;
enum State{wait,ongoing,reject,finish}

public class Item {
	long id;
	String formName;
	int step;
	State state; 
	String comment;
	String content;
	
	/*Item(ItemDB itemDB){
		this=itemDB;
	}*/
	
	Item(String formName, String content){
		this.formName=formName;
		this.content=content;
		this.step=1;
		this.state=State.wait;
		this.id=0;
	}

}
