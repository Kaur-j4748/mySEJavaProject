import javax.swing.*;
import java.awt.event.*;


	public class Home{
		
		
		JFrame f = new JFrame("Online Examination System");
		ImageIcon icon = new ImageIcon("E:\\SE\\exam.jpg");
		JLabel label = new JLabel(icon);
		
		JButton b = new JButton("Admin Login");
		JButton b1 = new JButton("Student Login");
		JButton b2 = new JButton("Register");

		
	
			
			public Home()
			{
				frame();	
			}
			

			
			public void frame()
			{
				f.setSize(500,570);
				f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				f.setVisible(true);
				f.setResizable(false);
			
				
				JPanel p = new JPanel();
				p.add(label);
				p.add(b);
				p.add(b1);
				p.add(b2);
				
				
				f.add(p);
				
				b.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						new Admin();
					}
				});
				
				b1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
				new Login();
			}
				});
				
				b2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
				new Register();
			}
				});
				
				
			}
			public static void main(String[] args) {
				// TODO Auto-generated method stub
				
				new Home();

			}

	}
