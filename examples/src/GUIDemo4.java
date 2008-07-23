
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class GUIDemo4 extends JPanel {
    static JFrame frame;
    static String birdString = "鸟";
    static String catString = "猫";
    static String dogString = "狗";
    static String rabbitString = "兔";
    JLabel display;
    public GUIDemo4( ) {					        // 创建单选按钮对象
        JRadioButton birdButton = new JRadioButton(birdString);
        birdButton.setMnemonic(KeyEvent.VK_B);
        birdButton.setActionCommand(birdString);        
        JRadioButton catButton = new JRadioButton(catString);
        catButton.setMnemonic(KeyEvent.VK_C);
        catButton.setActionCommand(catString);
        JRadioButton dogButton = new JRadioButton(dogString);
        dogButton.setMnemonic(KeyEvent.VK_D);
        dogButton.setActionCommand(dogString);
        JRadioButton rabbitButton = new JRadioButton(rabbitString);
        rabbitButton.setMnemonic(KeyEvent.VK_R);
        rabbitButton.setActionCommand(rabbitString);     
    	//将单选按钮组成一组，建立它们之间的单选关系
        ButtonGroup group = new ButtonGroup( );
        group.add(birdButton);
        group.add(catButton);
        group.add(dogButton);
        group.add(rabbitButton);
				 //为单选按钮添加事件监听器
        RadioListener myListener = new RadioListener( );
        birdButton.addActionListener(myListener);
        catButton.addActionListener(myListener);
        dogButton.addActionListener(myListener);
        rabbitButton.addActionListener(myListener);
				 //建立标签对象display
        display = new JLabel("这是RadioButton的一个示例。");       
        display.setPreferredSize(new Dimension(180, 60));//设置标签对象的大小     
        JPanel radioPanel = new JPanel( );
        radioPanel.setLayout(new GridLayout(0, 1));//按钮对象按一列添加到面板
        radioPanel.add(birdButton);
        radioPanel.add(catButton);
        radioPanel.add(dogButton);
        radioPanel.add(rabbitButton);
        setLayout(new BorderLayout( ));
        add(radioPanel, BorderLayout.WEST);
        add(display, BorderLayout.CENTER);
        setBorder(BorderFactory.createEmptyBorder(20,20,20,0));
    }  
	//事件服务类
    class RadioListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            display.setText( "          你选中了"+e.getActionCommand( )+"。");
        }
    }
    public static void main(String s[ ]) {
         frame = new JFrame("RadioButtonDemo");
         frame.addWindowListener(new WindowAdapter( ) {
             public void windowClosing(WindowEvent e) {System.exit(0);}
         });
         frame.getContentPane( ).add(new GUIDemo4( ), BorderLayout.CENTER);
         frame.pack( );
         frame.setVisible(true);
    }
} 

