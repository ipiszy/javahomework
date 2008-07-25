package cn.eas;
public class Department {
	private String name, workTime,affairs;
	
	public Department(String name, String workTime, String affairs){
		this.name=name;
		this.workTime=workTime;
		this.affairs=affairs;
	}
	
	public String getName(){
		return this.name;
	}
	
	public String getWorkTime(){
		return this.workTime;
	}
	
	public String getAffairs(){
		return this.affairs;
	}
	
	public void setName(String name){
		this.name=name;
	}
	
	public void setWorkTime(String workTime){
		this.workTime=workTime;
	}
	
	public void setAffairs(String affairs){
		this.affairs=affairs;
	}
	
}
