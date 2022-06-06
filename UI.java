import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import javax.swing.*;

public class UI implements ActionListener
{
	JFrame frame;
	JPanel panel;
	
	private Member member;
	public int w=1000,h=750;
	public static void main(String[] args)
	{
		UI ui=new UI();
		ui.s1();
	}

	public UI()
	{
		frame = new JFrame("�Ϯ��]");
		frame.setResizable(false);
		frame.setSize(w, h);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		frame.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				int result = JOptionPane.showConfirmDialog(frame,
						"�O�_�����{��",
						"ĵ�i",
						JOptionPane.YES_NO_OPTION,
						JOptionPane.WARNING_MESSAGE);
				if (result == JOptionPane.YES_OPTION){System.exit(0);}
			}
		});
	}
	
	public void actionPerformed(ActionEvent e)
	{
		frame.remove(panel);
		switch (Integer.parseInt(e.getActionCommand()))
		{
			case 0:
				s1();
				break;
			case 1:
				log_in();
				break;
			case 2:
				sign_up();
			case 3:
				home();
				break;
			default:
				break;
		}
	}
	public void s1()
	{
		panel= new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER,w/3,h*3/4));
		//new ImageIcon("user.png")

		JButton log_in = new JButton("�n�J");
		JButton panel_up = new JButton("���U");
		log_in.setActionCommand("1");
		panel_up.setActionCommand("2");
		log_in.addActionListener(this);
		panel_up.addActionListener(this);

		panel.add(log_in);
		panel.add(panel_up);
		frame.add(panel);
		frame.setVisible(true);
	}
	


	public void log_in()
	{
		panel= new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.LEFT,w/50,h/2));
		//new ImageIcon("user.png")

		JButton confirm = new JButton("�T�{");
		JButton back = new JButton("��^");

		JLabel accLB=new JLabel("�b��");
		JTextField accTF = new JTextField(16);
		JLabel passLB=new JLabel("�K�X");
		JPasswordField passTF = new JPasswordField(12); // �D����K�X��J�F
		
		panel.add(accLB);
		panel.add(accTF);
		panel.add(passLB);
		panel.add(passTF);
		String password = String.valueOf(passTF.getPassword());
		if(accTF.getText()!=null && password!=null){member=new Member(accTF.getText(),password);}
		else{JOptionPane.showMessageDialog(null, "��J�Ȥ��ର��!","ĵ�i",3);}
		member=new Member(accTF.getText(),password);
		confirm.setActionCommand(member.log_in());
		back.setActionCommand("0");
		confirm.addActionListener(this);
		back.addActionListener(this);

		panel.add(confirm);
		panel.add(back);
		frame.add(panel);
		frame.setVisible(true);
	}
	
	public void sign_up()
	{
		panel= new JPanel();
		panel.setLayout(new FlowLayout());
		//new ImageIcon("user.png")

		JButton confirm = new JButton("�T�{");
		JButton back = new JButton("��^");

		JLabel nameLB=new JLabel("�m�W");
		JTextField nameTF = new JTextField(16);
		JLabel idLB=new JLabel("����");
		JTextField idTF = new JTextField(16);
		JLabel accLB=new JLabel("�b��");
		JTextField accTF = new JTextField(16);
		JLabel passLB=new JLabel("�K�X");
		JPasswordField passTF = new JPasswordField(12); // �D����K�X��J�F
		panel.add(nameLB);
		panel.add(nameTF);
		panel.add(idLB);
		panel.add(idTF);
		panel.add(accLB);
		panel.add(accTF);
		panel.add(passLB);
		panel.add(passTF);

		String password = String.valueOf(passTF.getPassword());
		if(accTF.getText()!=null && nameTF.getText()!=null && password!=null && idTF.getText()!=null){member=new Member(accTF.getText(), nameTF.getText(),password,idTF.getText());}
		else{JOptionPane.showMessageDialog(null, "��J�Ȥ��ର��!","ĵ�i",3);}

		confirm.setActionCommand(member.sign_up());
		back.setActionCommand("0");
		confirm.addActionListener(this);
		back.addActionListener(this);

		panel.add(confirm);
		panel.add(back);
		frame.add(panel);
		frame.setVisible(true);
	}
	
	public void home()
	{
		panel= new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER,w/50,h/4));
		
		JButton sear = new JButton("���y�d��");
		JButton returnBook = new JButton("�ٮ�");
		JButton inform = new JButton("�ӤH��T");
		JButton history = new JButton("���v����");
		JButton manaBook = new JButton("���y�޲z");
		JButton fee = new JButton("ú�ǻ@��");
		
		sear.setActionCommand("4");
		returnBook.setActionCommand("5");
		inform.setActionCommand("6");
		history.setActionCommand("7");
		manaBook.setActionCommand("8");
		fee.setActionCommand("9");
		sear.addActionListener(this);
		returnBook.addActionListener(this);
		inform.addActionListener(this);
		history.addActionListener(this);
		manaBook.addActionListener(this);
		fee.addActionListener(this);

		panel.add(sear);
		panel.add(returnBook);
		panel.add(inform);
		panel.add(history);
		if(member.getIdentity()=="Admin")
		{
			panel.add(manaBook);
			panel.add(fee);
		}
		frame.add(panel);
		frame.setVisible(true);
	}
}