package cn.eas;
enum Type {Applicant,Manager,Admin}

public class Account {
	String name;
	Type type;
	long id;
	private String password;
	
	Account(String name, Type type, long id, String password){
		this.name=name;
		this.type=type;
		this.id=id;
		this.password=password;
	}
}
