import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Adder2 implements ActionListener {
    JFrame AdderFrame;
    JTextField TOprand1;
    JTextField TOprand2;
    JLabel LAdd, LSum;
    JButton BAdd,BClear;
    JPanel panel1,panel2;
    public Adder2( ) {			  	// �������������������
	    AdderFrame = new JFrame("AdderFrame");
	    TOprand1 = new JTextField("0.0");
	    TOprand2 = new JTextField("0.0");
	    LAdd=new JLabel("+");
	    LSum=new JLabel("= 0.0 ");
	    BAdd=new JButton(" Add! ");
	    BClear=new JButton("Clear!");
     	    panel1=new JPanel( );
 	    panel2=new JPanel( );
 	 //��������Badd���¼�
	  	BAdd.addActionListener(this);
		//��ťBclear���¼�����
	  	BClear.addActionListener(new ActionListener( ){
      		      public void actionPerformed(ActionEvent event){
          		      TOprand1.setText("0.0");
          		      TOprand2.setText("0.0");
          		      LSum.setText("= 0.0 ");
      		    }
    		  });		
	//�����м��������panel1�� panel1�Ĳ��ֹ�����ΪFlowLayout
    		panel1.setLayout(new FlowLayout( ));
    	 	panel1.add(TOprand1);
	  	panel1.add(LAdd);
	 	panel1.add(TOprand2);
   		panel1.add(LSum);
	//�����м��������panel2�� panel2�Ĳ��ֹ�����ΪFlowLayout
    		panel2.setLayout(new FlowLayout( ));
    		panel2.add(BAdd);
    		panel2.add(BClear);
    		//������������ContentPane��ContentPane�Ĳ��ֹ�����ΪBorderLayout
            AdderFrame.setLayout(new BorderLayout( ));
AdderFrame.add(panel1,BorderLayout.NORTH);
AdderFrame.add(panel2,BorderLayout.SOUTH);
//���ڹرմ���
               AdderFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
AdderFrame.pack( );
AdderFrame.setVisible(true);
}
public void actionPerformed(ActionEvent event) {
int sum= (int)(Double.valueOf(TOprand1.getText( )).doubleValue( )
                 +Double.valueOf(TOprand2.getText( )).doubleValue( ));
LSum.setText("="+sum);
}
public static void main(String[ ] args) {
Adder2 adder2 = new Adder2( );
}
} 

