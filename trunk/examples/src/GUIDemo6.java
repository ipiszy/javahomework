import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class GUIDemo6 extends JPanel {
    public GUIDemo6( ) {
					//建立标签面板
        JTabbedPane tabbedPane = new JTabbedPane( );
        Component panel1 = makeTextPanel("你选中了标签1");
        tabbedPane.addTab("标签1", null, panel1, null);
        tabbedPane.setSelectedIndex(0);
        Component panel2 = makeTextPanel("你选中了标签2");
        tabbedPane.addTab("标签2", null, panel2, null);
        Component panel3 = makeTextPanel("你选中了标签3");
        tabbedPane.addTab("标签3", null, panel3, null);
        Component panel4 = makeTextPanel("你选中了标签4");
        tabbedPane.addTab("标签4", null, panel4, null);
        setLayout(new GridLayout(0, 1));
        add(tabbedPane);
}
 // makeTextPanel方法，返回值类型为Component
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
