import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class GUIDemo6 extends JPanel {
    public GUIDemo6( ) {
					//������ǩ���
        JTabbedPane tabbedPane = new JTabbedPane( );
        Component panel1 = makeTextPanel("��ѡ���˱�ǩ1");
        tabbedPane.addTab("��ǩ1", null, panel1, null);
        tabbedPane.setSelectedIndex(0);
        Component panel2 = makeTextPanel("��ѡ���˱�ǩ2");
        tabbedPane.addTab("��ǩ2", null, panel2, null);
        Component panel3 = makeTextPanel("��ѡ���˱�ǩ3");
        tabbedPane.addTab("��ǩ3", null, panel3, null);
        Component panel4 = makeTextPanel("��ѡ���˱�ǩ4");
        tabbedPane.addTab("��ǩ4", null, panel4, null);
        setLayout(new GridLayout(0, 1));
        add(tabbedPane);
}
 // makeTextPanel����������ֵ����ΪComponent
    protected Component makeTextPanel(String text) {
        JPanel panel = new JPanel( );
        JLabel filler = new JLabel(text);
        filler.setHorizontalAlignment(JLabel.CENTER);
        panel.setLayout(new GridLayout(1, 1));
        panel.add(filler);
        return panel;
    }
    public static void main(String[ ] args) {
        JFrame frame = new JFrame("TabbedPaneDemo");
        frame.addWindowListener(new WindowAdapter( ) {
            public void windowClosing(WindowEvent e) {System.exit(0);}
        });
        frame.getContentPane( ).add(new GUIDemo6( ));
        frame.setSize(400, 125);
        frame.setVisible(true);
    }
} 
