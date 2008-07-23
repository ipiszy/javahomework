
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class GUIDemo5 extends JPanel implements ActionListener {
    JTextField textField;
    JTextArea textArea;
    String newline = "\n";
    
    public GUIDemo5( ) {
					//创建所需组件对象
        textField = new JTextField(20);
        textField.addActionListener(this);
        textArea = new JTextArea(5, 20);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea,
                                       JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                                       JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
					//将组件添加到面板
        GridBagLayout gridBag = new GridBagLayout( );
        setLayout(gridBag);
        GridBagConstraints c = new GridBagConstraints( );
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.fill = GridBagConstraints.HORIZONTAL;
        gridBag.setConstraints(textField, c);
        add(textField);
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1.0;
        c.weighty = 1.0;
        gridBag.setConstraints(scrollPane, c);
        add(scrollPane);       
}			// textField的事件服务方法
    public void actionPerformed(ActionEvent evt) {
        String text = textField.getText( );
        textArea.append(text + newline);
        textField.selectAll( );
    }
    public static void main(String[ ] args){
      JFrame frame=new JFrame("GUIDemo5");		//主窗口关闭事件处理
      	frame.addWindowListener(new WindowAdapter( ) {
	     public void windowClosing(WindowEvent e) {System.exit(0);}
    	});
      frame.getContentPane( ).add(new GUIDemo5( ));
      frame.pack( );
      frame.setVisible(true);
    };
} 

