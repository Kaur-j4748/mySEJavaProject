
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Login {

	Connection con;
	Statement st;
	ResultSet rs;
	
	
	JFrame f = new JFrame("User Login");
	JLabel l = new JLabel("UserID:");
	JLabel l1 = new JLabel("Password:");
	JTextField t = new JTextField(10);
	JTextField t1 = new JTextField(10);
	JButton b = new JButton("Login");
	JButton b1 = new JButton("Register");
	JButton b2 = new JButton("Home");
	
	public Login()
	{
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
		f.setSize(400,200);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		f.setResizable(false);
		
		JPanel p = new JPanel();
		p.add(l);
		p.add(t);
		p.add(l1);
		p.add(t1);
		p.add(b);
		p.add(b1);
		p.add(b2);
		
		f.add(p);
		
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				String user = t.getText();
				String pass = t1.getText();
				
				
					
					String sql = ("select UserID,Password from Register where UserID = '"+user+"' and Password = '"+pass+"'");
					rs = st.executeQuery(sql);
					
					if(rs.next()) {
						String p = rs.getString("Password");
						if(pass.equals(p)) {
							
						JOptionPane.showMessageDialog(null, "Login successfull");
						//new Test();
							
						}
						else {
							JOptionPane.showMessageDialog(null, "Invalid Password","Login Error",JOptionPane.ERROR_MESSAGE);
							t.setText("");
							t1.setText("");
						}
						
					}
					
					else {
						JOptionPane.showMessageDialog(null, "User Not Found,\nPlease Register First!","ERROR",JOptionPane.ERROR_MESSAGE);
						t.setText("");
						t1.setText("");
					}
					
				rs.close();
				
				}
		
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null, e);
				}
				
				
			}
		});
		
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		new Register();
	}
		});
		
		
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		new Home();
	}
		});
		
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new Home();

	}

}