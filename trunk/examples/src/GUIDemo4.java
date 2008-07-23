
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class GUIDemo4 extends JPanel {
    static JFrame frame;
    static String birdString = "��";
    static String catString = "è";
    static String dogString = "��";
    static String rabbitString = "��";
    JLabel display;
    public GUIDemo4( ) {					        // ������ѡ��ť����
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
    	//����ѡ��ť���һ�飬��������֮��ĵ�ѡ��ϵ
        ButtonGroup group = new ButtonGroup( );
        group.add(birdButton);
        group.add(catButton);
        group.add(dogButton);
        group.add(rabbitButton);
				 //Ϊ��ѡ��ť����¼�������
        RadioListener myListener = new RadioListener( );
        birdButton.addActionListener(myListener);
        catButton.addActionListener(myListener);
        dogButton.addActionListener(myListener);
        rabbitButton.addActionListener(myListener);
				 //������ǩ����display
        display = new JLabel("����RadioButton��һ��ʾ����");       
        display.setPreferredSize(new Dimension(180, 60));//���ñ�ǩ����Ĵ�С     
        JPanel radioPanel = new JPanel( );
        radioPanel.setLayout(new GridLayout(0, 1));//��ť����һ����ӵ����
        radioPanel.add(birdButton);
        radioPanel.add(catButton);
        radioPanel.add(dogButton);
        radioPanel.add(rabbitButton);
        setLayout(new BorderLayout( ));
        add(radioPanel, BorderLayout.WEST);
        add(display, BorderLayout.CENTER);
        setBorder(BorderFactory.createEmptyBorder(20,20,20,0));
    }  
	//�¼�������
    class RadioListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            display.setText( "          ��ѡ����"+e.getActionCommand( )+"��");
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

