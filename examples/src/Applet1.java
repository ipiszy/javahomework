
import javax.swing.*;
import java.awt.*;

public class Applet1 extends JApplet 
{    C t1,t2;
     myCanvas c1,c2;
     Container contentPane = getContentPane( );
     public void init()  { 
     c1=new myCanvas();
     c2=new myCanvas();
       contentPane.setLayout(new GridLayout(2,1));
     contentPane.validate();     
     contentPane.add(c1);
     contentPane.add(c2);
     t1=new C(c1,5);
     t2=new C(c2,-5);
     t1.start();
     t2.start();}        
 }

class myCanvas extends Canvas{
	public void paint(Graphics g, int x,int y)
	{
	g.drawString("Hello World", x, y);
	}
	}

	 class C extends Thread
	 {  myCanvas a;
	    int steps;
	    int x;
	    C(myCanvas b,int size)
	{ a=b;
	      steps=size;
	      x=0;}
	public void run()
	{ while(true)
	   {  
	x=x+steps;
	if (x<0) x=a.getWidth();
	if (x>a.getWidth()) x=0;
	a.repaint();
	a.paint(a.getGraphics(),x,50);
	try{
	  sleep(10);
	} catch(InterruptedException e){}
	 }
	   }
	 }

