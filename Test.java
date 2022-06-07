import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import javax.swing.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Test implements ActionListener
{
    JFrame jf;
    JPanel jp;
    JTextField jtf1,jtf2,jtf3,jtf4;
    int c1=1;
    JButton c;
    Data acd=new Data();
    Member mem;
    public static void main(String [] args) throws IOException
    {          
         
       Test test=new Test();
    }
    public Test()
    {
        
        jf = new JFrame("test");
        
        Container contentPane = jf.getContentPane();
        contentPane.setLayout(new BorderLayout());
        
        jp = new JPanel();
        
        jtf1 = new JTextField("account",15);
        jtf2 = new JTextField("name",15);
        jtf3 = new JPasswordField("password",15);
        jtf4 = new JTextField("id",15);
        c=new JButton("con");
        c.setActionCommand("0");
        c.addActionListener(this);

        jp.add(jtf1);
        jp.add(jtf2);
        jp.add(jtf3);
        jp.add(jtf4);
        jp.add(c);

        contentPane.add(jp);
        
        jf.pack();
        jf.setLocation(400, 200);
        jf.setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
	{
		switch (Integer.parseInt(e.getActionCommand()))
		{
			case 0:

               mem=new Member(jtf1.getText(), jtf2.getText(), jtf3.getText(),jtf4.getText());
               mem.sign_up();
               System.exit(0);
				break;
			case 4:
				System.exit(0);
			default:
				break;
		}
	}

}