import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class Register {
	
	Connection con;
	Statement st;
	int rs;
	
	
	JFrame f = new JFrame("Student Registration");
	JLabel l = new JLabel("First Name:");
	JLabel l1 = new JLabel("Last Name:");
	JLabel l2 = new JLabel("UserID:");
	JLabel l3 = new JLabel("Password:");
	JLabel l4 = new JLabel("Phone Number:");
	JTextField t = new JTextField(10);
	JTextField t1 = new JTextField(10);
	JTextField t2 = new JTextField(10);
	JTextField t3 = new JTextField(10);
	JTextField t4 = new JTextField(10);
	JButton b = new JButton("Register");
	JButton b1 = new JButton("Go back to Login Page");
	

	public Register() {

		connect();
		frame();	
		
	}
	
	public void connect()
	{
		try {
			
		
		//Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		
		con = DriverManager.getConnection("jdbc:ucanaccess://E:\\SE\\Login.accdb");
		st = con.createStatement();
		}
		
		catch(Exception ex) 
		{
			
		}
	}
	
	public void frame()
	{
		f.setSize(400,300);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		f.setResizable(false);
		
		JPanel p = new JPanel();
		p.add(l);
		p.add(t);
		p.add(l1);
		p.add(t1);
		p.add(l2);
		p.add(t2);
		p.add(l3);
		p.add(t3);
		p.add(l4);
		p.add(t4);
	
		
		p.add(b);
		p.add(b1);
		
		
		f.add(p);
		
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				String FirstName = t.getText();
				String LastName = t1.getText();
				String UserID = t2.getText();
				String Password = t3.getText();
				int PhNo = Integer.parseInt(t4.getText());
				
				String sql = "insert into Register(FirstName,LastName,UserID,Password,PhNo) values('"+FirstName+"','"+LastName+"','"+UserID+"','"+Password+"','"+PhNo+"')";
				st.executeUpdate(sql);
				
				t.setText("");
				t1.setText("");
				t2.setText("");
				t3.setText("");
				t4.setText("");
			
				}
				catch(Exception ex)
				{
					
				}
				
			}
		});
		
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Login();
			}
		});
	
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Home();
	}

}
