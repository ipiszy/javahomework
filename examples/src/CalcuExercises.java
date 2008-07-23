
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class CalcuExercises {
	//创建所需组件对象
   	static JFrame frame = new JFrame("算术练习测验");
   	static JPanel PRadio=new JPanel( );//单选按钮面板
   	static JRadioButton BAdd=new JRadioButton("做加法");//加法按钮
   	static JRadioButton BSub=new JRadioButton("做减法");//减法按钮
	static JRadioButton BMul=new JRadioButton("做乘法");     //乘法按钮
	static JRadioButton BDiv=new JRadioButton("做除法");     //除法按钮
   	static ButtonGroup group = new ButtonGroup( );       //单选按钮组
   	static JPanel PCheck=new JPanel( );                  //复选框面板
  	static JCheckBox Total=new JCheckBox("显示已做题数");//是否显示“已做题数”复选框，
                                                       //选中则显示
   	static JCheckBox Right=new JCheckBox("显示做对题数");//是否显示“做对题数”复选框，
                                                            //选中则显示
   	static JPanel PCalcu=new JPanel( );     //运算面板
	static JLabel LOperand1=new JLabel("    ");//操作数1
	static JLabel LOpcode=new JLabel("+");     //加号
	static JLabel LOperand2=new JLabel("    ");//操作数2
   	static JLabel LEqu=new JLabel("=");   //等号
	static JTextField Answer=new JTextField("0000");//计算结果
	static JButton Ok=new JButton("确认!");   		//确认按钮
   	static JPanel PRecord=new JPanel( );  		//记录面板
   	static int totalNunmber=0;           			//已做题数
   	static int rightNumber=0;           			//做对题数
   	static JLabel LTotal=new JLabel(" 已做 "+totalNunmber+" 题 ");//显示已做题数
	static JLabel LRight=new JLabel(" 做对 "+rightNumber+" 题 ");      //显示做对题数
   	static JPanel PCombine=new JPanel( );		//组合面板
   	static JPanel Exercise=new JPanel( );		//顶层面板
   	int calcuType=1;			//运算类型。1：加，2：减，3：乘，4：除
   	int totalSelected=1;
   	int rightSelected=1;
   	public CalcuExercises( ){
	//建立运算类型单选按钮面板
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
	//建立显示控制复选框面板
	PCheck.setLayout(new GridLayout(0, 1));
	PCheck.add(Total);
	PCheck.add(Right);
	//建立运算面板
	PCalcu.setLayout(new FlowLayout( ));
   	PCalcu.setBorder(BorderFactory.createEmptyBorder(0,0,20,0));
	PCalcu.add(LOperand1);
	PCalcu.add(LOpcode);
	PCalcu.add(LOperand2);
   	PCalcu.add(LEqu);
	PCalcu.add(Answer);
	//建立运算结果记录显示面板
	PRecord.setLayout(new FlowLayout( ));
	PRecord.add(LTotal);
   	PRecord.add(LRight);
   	PRecord.setBorder(BorderFactory.createEmptyBorder(20,0,0,0));
	//建立组合面板，含有运算面板和运算结果记录显示面板，两面板在组合面板中上下布局
	PCombine.setLayout(new BorderLayout( ));
	PCombine.add(PCalcu,BorderLayout.NORTH);
   	PCombine.add(Ok,BorderLayout.CENTER);
	PCombine.add(PRecord,BorderLayout.SOUTH);
	//建立顶层面板
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
	//产生随机数，作为参与运算的操作数，置于x，y中
	//确保x、y不为0且x>y
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
	//命令按钮事件服务类
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
         		LTotal.setText("已做"+totalNunmber+"题");
         		LRight.setText("做对"+rightNumber+"题");
         		if(totalNunmber>100)System.exit(0);
       	}
    }
    class CheckBoxListener implements ItemListener {	//复选框事件服务类
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
       class RadioListener implements ActionListener {		//单选按钮事件服务类
       public void actionPerformed(ActionEvent e) {
       if(e.getActionCommand( ).equals("+")){ calcuType=1;LOpcode.setText("+");}
       else if(e.getActionCommand( ).equals("-")){ calcuType=2;LOpcode.setText("-");}
       else if(e.getActionCommand( ).equals("*")){ calcuType=3;LOpcode.setText("*");}
       else { calcuType=4;LOpcode.setText("/");};
   }
}
public static void main(String s[ ]) {			//主方法
  	CalcuExercises exe1=new CalcuExercises( );
	}
}
