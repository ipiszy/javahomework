import java.util.*;
import java.io.File;

public class MsnNameFinder {
	public static void outPut(StringBuffer Finder, Map<String,String> FriendsGroup, Set<String> Friends){
		Iterator<String> FriendsIterator=Friends.iterator();
		String s;
		while (FriendsIterator.hasNext()){
			s=FriendsIterator.next();
			if (s.contains(Finder))
				System.out.println(s);
			else
				FriendsIterator.remove();
			
		/*for (String s:Friends){
			System.out.println(s);
			if (s.contains(Finder))
				System.out.println(s);
			else
				Friends.remove(s);*/
		}
			
		
		
	}
	//public static void outPutFinal(StringBuffer Finder, Map<String,String> FriendsGroup, Set<String> Friends){}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuffer Finder=new StringBuffer();
		Map<String,String> FriendsGroup=new HashMap<String,String>();
		//File FileTemp=new File("msnname.txt") throws Expection;
		Scanner sc = new Scanner(System.in);
        int m,n;
        String Group;
        m=sc.nextInt();
        System.out.println(m);
        //Group=sc.next("\\s");???
        //System.out.println(Group);
        for (int i=0;i<m;i++){
        	Group=sc.next("\\w+");
        	//System.out.println(Group);
        	//sc.next("\\s");
        	n=sc.nextInt();
        	//System.out.println(n);
        	//sc.next("\\s");
        	for (int j=0;j<n;j++){
        		FriendsGroup.put(sc.next("\\w+"), Group);
        		//sc.next("\\s");   		
        	}
        }
		
        System.out.println(FriendsGroup);
        Set<String> Friends=FriendsGroup.keySet();
        
        //Map<String,String> FriendsTemp=FriendsGroup.clone();
        
        while (!sc.hasNext("#")){
        	Finder.append(sc.next("\\w"));
        	System.out.println(Finder);
        	outPut(Finder,FriendsGroup,Friends);
        	
        }
        //outPutFinal(Finder,FriendsGroup,Friends);
        System.out.println(FriendsGroup);
   }

}
