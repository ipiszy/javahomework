
class MThread extends Thread
{  public void run()
   { System.out.println("Thread say:Hello,World!"); } 
} 
public class MoreThreads{
  public static void main(String[] args){
    new MThread();
    new MThread().start();     
    System.out.println("Main say:Hello,World"); } 
} 
