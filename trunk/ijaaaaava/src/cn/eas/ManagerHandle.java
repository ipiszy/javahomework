package cn.eas;


public class ManagerHandle {
public Item getItem(String id){return ActivityManager.loadItem(Long.parseLong(id));}
//public boolean saveItem(Item item){return ActivityManager.saveItem(item);}
}
