import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Adder implements ActionListener {
    JFrame AdderFrame;
    JTextField TOprand1;		//������
    JTextField TOprand2;		//����
    JLabel LAdd, LSum;		//�Ӻţ���
    JButton BAdd;			//Add����ť
    int i=0;
    public Adder( ) {//����ͼ�ν������Ļ��ʾ����
	AdderFrame = new JFrame("AdderFrame");
	TOprand1 = new JTextField("0.0");
	TOprand2 = new JTextField("0.0");
	LAdd=new JLabel("+");
	LSum=new JLabel("=     ");
	BAdd=new JButton("Add!");
  	AdderFrame.setLayout(new FlowLayout( ));
	AdderFrame.add(TOprand1);
	AdderFrame.add(LAdd);
	AdderFrame.add(TOprand2);
  	AdderFrame.add(LSum);
  	AdderFrame.add(BAdd);
	AdderFrame.pack( );
	AdderFrame.setVisible(true);  
    AdderFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
//Ϊ���ť����¼�����������������ʵ����Adder��Ķ���
BAdd.addActionListener(this);
}
// Adder����¼����񷽷�
public void actionPerformed(ActionEvent event) {  //�¼��������
i=(i+1)%2;
         if(i==1){	//iΪ���������
             int sum= (int)(Double.valueOf(TOprand1.getText( )).doubleValue( )
                      +Double.valueOf(TOprand2.getText( )).doubleValue( ));
 LSum.setText("="+sum);
          }else{	//iΪż��������
                         TOprand1.setText("0.0");
                         TOprand2.setText("0.0");
                          LSum.setText("=   ");        };
      }
    
public static void main(String[ ] args) {
Adder adder = new Adder( );     }
}
