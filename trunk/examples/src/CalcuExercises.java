
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class CalcuExercises {
	//���������������
   	static JFrame frame = new JFrame("������ϰ����");
   	static JPanel PRadio=new JPanel( );//��ѡ��ť���
   	static JRadioButton BAdd=new JRadioButton("���ӷ�");//�ӷ���ť
   	static JRadioButton BSub=new JRadioButton("������");//������ť
	static JRadioButton BMul=new JRadioButton("���˷�");     //�˷���ť
	static JRadioButton BDiv=new JRadioButton("������");     //������ť
   	static ButtonGroup group = new ButtonGroup( );       //��ѡ��ť��
   	static JPanel PCheck=new JPanel( );                  //��ѡ�����
  	static JCheckBox Total=new JCheckBox("��ʾ��������");//�Ƿ���ʾ��������������ѡ��
                                                       //ѡ������ʾ
   	static JCheckBox Right=new JCheckBox("��ʾ��������");//�Ƿ���ʾ��������������ѡ��
                                                            //ѡ������ʾ
   	static JPanel PCalcu=new JPanel( );     //�������
	static JLabel LOperand1=new JLabel("    ");//������1
	static JLabel LOpcode=new JLabel("+");     //�Ӻ�
	static JLabel LOperand2=new JLabel("    ");//������2
   	static JLabel LEqu=new JLabel("=");   //�Ⱥ�
	static JTextField Answer=new JTextField("0000");//������
	static JButton Ok=new JButton("ȷ��!");   		//ȷ�ϰ�ť
   	static JPanel PRecord=new JPanel( );  		//��¼���
   	static int totalNunmber=0;           			//��������
   	static int rightNumber=0;           			//��������
   	static JLabel LTotal=new JLabel(" ���� "+totalNunmber+" �� ");//��ʾ��������
	static JLabel LRight=new JLabel(" ���� "+rightNumber+" �� ");      //��ʾ��������
   	static JPanel PCombine=new JPanel( );		//������
   	static JPanel Exercise=new JPanel( );		//�������
   	int calcuType=1;			//�������͡�1���ӣ�2������3���ˣ�4����
   	int totalSelected=1;
   	int rightSelected=1;
   	public CalcuExercises( ){
	//�����������͵�ѡ��ť���
   	PRadio.setLayout(new GridLayout(0, 1));
   	BAdd.setSelected(true);
   	group.add(BAdd);
   	group.add(BSub);
   	group.add(BMul);
	group.add(BDiv);
	PRadio.add(BAdd);
	PRadio.add(BSub);
	PRadio.add(BMul);
	PRadio.add(BDiv);
   	PRadio.setBorder(BorderFactory.createEmptyBorder(0,30,0,20));
   	Total.setSelected(true);
   	Right.setSelected(true);
	//������ʾ���Ƹ�ѡ�����
	PCheck.setLayout(new GridLayout(0, 1));
	PCheck.add(Total);
	PCheck.add(Right);
	//�����������
	PCalcu.setLayout(new FlowLayout( ));
   	PCalcu.setBorder(BorderFactory.createEmptyBorder(0,0,20,0));
	PCalcu.add(LOperand1);
	PCalcu.add(LOpcode);
	PCalcu.add(LOperand2);
   	PCalcu.add(LEqu);
	PCalcu.add(Answer);
	//������������¼��ʾ���
	PRecord.setLayout(new FlowLayout( ));
	PRecord.add(LTotal);
   	PRecord.add(LRight);
   	PRecord.setBorder(BorderFactory.createEmptyBorder(20,0,0,0));
	//���������壬��������������������¼��ʾ��壬������������������²���
	PCombine.setLayout(new BorderLayout( ));
	PCombine.add(PCalcu,BorderLayout.NORTH);
   	PCombine.add(Ok,BorderLayout.CENTER);
	PCombine.add(PRecord,BorderLayout.SOUTH);
	//�����������
   	Exercise.setLayout(new FlowLayout( ));
   	Exercise.add(PCombine);
   	Exercise.add(PRadio);
   	Exercise.add(PCheck);
   	Exercise.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
	
   	ButtonListener myButtonListener=new ButtonListener( );
   	Ok.addActionListener(myButtonListener);
   	CheckBoxListener myCheckBoxListener = new CheckBoxListener( );
   	Total.addItemListener(myCheckBoxListener);
  	Right.addItemListener(myCheckBoxListener);
   	BAdd.setActionCommand("+");
   	BSub.setActionCommand("-");
   	BMul.setActionCommand("*");
   	BDiv.setActionCommand("/");
   	RadioListener myRadioListener = new RadioListener( );
   	BAdd.addActionListener(myRadioListener);
   	BSub.addActionListener(myRadioListener);
   	BMul.addActionListener(myRadioListener);
   	BDiv.addActionListener(myRadioListener);
   	int x,y,temp;
   	String s=new String( );
	//�������������Ϊ��������Ĳ�����������x��y��
	//ȷ��x��y��Ϊ0��x>y
   	x=(int)(90*Math.random( ));
   	while(x==0){x=(int)(90*Math.random( ));};
   	y=(int)(90*Math.random( ));
   	while(y==0){y=(int)(90*Math.random( ));};
   	if(y>x){temp=x;x=y;y=temp;};
   	LOperand1.setText(s.valueOf(" "+x+" "));
   	LOperand2.setText(s.valueOf(" "+y+" "));
	frame.getContentPane( ).setLayout(new FlowLayout( ));
    	frame.getContentPane( ).add(Exercise);
	frame.pack( );
    	frame.setVisible(true);
    	frame.addWindowListener(new WindowAdapter( ) {
     	public void windowClosing(WindowEvent e) {
       	System.exit(0);
     	}
});
}
	//���ť�¼�������
    class ButtonListener implements ActionListener {
       	public void actionPerformed(ActionEvent event) {
       		int x,y,z,temp;
         		String s=new String( );
         		z=(int)Integer.valueOf(Answer.getText( ).trim( )).intValue( );
         		x=(int)Integer.valueOf(LOperand1.getText( ).trim( )).intValue( );
         		y=(int)Integer.valueOf(LOperand2.getText( ).trim( )).intValue( );
         		if(calcuType==1){if(x+y==z){rightNumber++;};}else
         		if(calcuType==2){if(x-y==z){rightNumber++;};}else
         		if(calcuType==3){if(x*y==z){rightNumber++;};}else
             		{if(x/y==z){rightNumber++;};};        
        		x=(int)(90*Math.random( ));while(x==0){x=(int)(90*Math.random( ));};
         		y=(int)(90*Math.random( )); while(y==0){y=(int)(90*Math.random( ));};
         		if(y>x){temp=x;x=y;y=temp;};
         		LOperand1.setText(s.valueOf(" "+x+" "));
         		LOperand2.setText(s.valueOf(" "+y+" "));        
         		totalNunmber++;
         		LTotal.setText("����"+totalNunmber+"��");
         		LRight.setText("����"+rightNumber+"��");
         		if(totalNunmber>100)System.exit(0);
       	}
    }
    class CheckBoxListener implements ItemListener {	//��ѡ���¼�������
        public void itemStateChanged(ItemEvent e) {
       Object source = e.getItemSelectable( );
       if (source == Total) {
           totalSelected =(totalSelected+1)%2;
       } else if (source == Right) {
           rightSelected =(rightSelected+1)%2;               
       };
       if(totalSelected==1){LTotal.setVisible(true);}else{LTotal.setVisible(false);};
       if(rightSelected==1){LRight.setVisible(true);}else{LRight.setVisible(false);};
       }
	}	
       class RadioListener implements ActionListener {		//��ѡ��ť�¼�������
       public void actionPerformed(ActionEvent e) {
       if(e.getActionCommand( ).equals("+")){ calcuType=1;LOpcode.setText("+");}
       else if(e.getActionCommand( ).equals("-")){ calcuType=2;LOpcode.setText("-");}
       else if(e.getActionCommand( ).equals("*")){ calcuType=3;LOpcode.setText("*");}
       else { calcuType=4;LOpcode.setText("/");};
   }
}
public static void main(String s[ ]) {			//������
  	CalcuExercises exe1=new CalcuExercises( );
	}
}
