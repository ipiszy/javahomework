
//多个进程运行时执行顺序是交叉的
public class MyThread extends Thread{
   int threadNum;
    public static void main(String args[])
    { MyThread array[]=new MyThread[3];
       for (int i=0;i<3;i++)  array[i]=new MyThread(i);
       for (int i=0;i<3;i++)  array[i].start();  }

   MyThread(int SerialNum)
   {	super();  
        threadNum=SerialNum;
     }
    public void run()
    { for(int j=0;j<5;j++) {
    	System.out.println(threadNum+": <"+j+">" );
    	try{sleep(1000);}catch(InterruptedException e){};
      }
    
     System.out.println("thread "+threadNum+ "bye.");}
}

