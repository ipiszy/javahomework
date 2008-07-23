
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class GUIDemo3 extends JPanel {
    JCheckBox right1;
    JCheckBox right2;
    JCheckBox right4;
    JCheckBox right8;
    StringBuffer choices;
    JLabel displayLabel;
    public GUIDemo3( ) {
        right1 = new JCheckBox("1");
        right1.setMnemonic(KeyEvent.VK_4);
        right1.setSelected(true);
        right2 = new JCheckBox("2");
        right2.setMnemonic(KeyEvent.VK_3);
        right2.setSelected(true);
        right4 = new JCheckBox("4");
        right4.setMnemonic(KeyEvent.VK_2);
        right4.setSelected(true);        
        right8 = new JCheckBox("8");
        right8.setMnemonic(KeyEvent.VK_1);
        right8.setSelected(true);
        //创建事件服务类CheckBoxListener的对象myListener
        CheckBoxListener myListener = new CheckBoxListener( );
	   //为right1、 right2、 right4、right8添加事件监听器
        right1.addItemListener(myListener);
        right2.addItemListener(myListener);
        right4.addItemListener(myListener);
        right8.addItemListener(myListener);
        //初始化choices
        choices = new StringBuffer("0000");
        //创建标签对象
        displayLabel = new JLabel(choices.toString( ));
        //创建面板对象checkPanel
        JPanel checkPanel = new JPanel( );
        //将复选框按钮添加到checkPanel的同一列
        checkPanel.setLayout(new GridLayout(0, 1)); 
        checkPanel.add(right1);
        checkPanel.add(right2);
        checkPanel.add(right4);
        checkPanel.add(right8);        
        setLayout(new BorderLayout( ));
        add(checkPanel, BorderLayout.WEST);
        add(displayLabel, BorderLayout.CENTER);
        setBorder(BorderFactory.createEmptyBorder(10,60,10,60));//设置边距
    }
    //复选框的事件服务类
    class CheckBoxListener implements ItemListener {
        public void itemStateChanged(ItemEvent e) {
            int index = 0;
            char c = '-';
            Object source = e.getItemSelectable( );
            if (source == right8) {
                index = 0;
                c = '8';
            } else if (source == right4) {
                index = 1;
                c = '4';
            } else if (source == right2) {
                index = 2;
                c = '2';
            } else if (source == right1) {
                index = 3;
                c = '1';
            }            
            if (e.getStateChange( ) == ItemEvent.DESELECTED)
                c = '-';
            choices.setCharAt(index, c);
            displayLabel.setText(choices.toString( ));
        }
    }
    public static void main(String s[ ]) {
         JFrame frame = new JFrame("CheckBoxDemo");
		//主窗口关闭事件处理
         frame.addWindowListener(new WindowAdapter( ) {
             public void windowClosing(WindowEvent e) {
                 System.exit(0);
             }
         });
         frame.setContentPane(new GUIDemo3( ));
         frame.pack( );
         frame.setVisible(true);
    }
} 

