package FrontEnd_GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import org.people.Person;

public class LoginGUI extends JFrame{
		private JFrame frame;
		private JTextField UsernameText;
		private JPasswordField PasswordText;
		
		private JButton buttonLogin;
		private JButton buttonReset;
		private JButton buttonForgotPassword;
		/*
		 * Initialize:
		 * 		-We must create a useable login screen with customizable buttons and 
		 * 		inputs (username and password.  We will add a "forgot password" later.
		 * 
		 * HOW TO:
		 * 		Use JFrame, JLabel, JButton we are able to add specified areas to the screen,
		 * 		mostly by trial and error cordinates at first..
		 */
		public void Initialize() {
		
			frame = new JFrame();
			frame.setBounds(100, 100, 400, 300);
			frame.setBackground(Color.ORANGE);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setLayout(null);
			
			//Labels & Buttons & Lines created
			JLabel LoginLabel = new JLabel("User Login");
			JLabel UsernameLabel = new JLabel("Username");
			JLabel PasswordLabel = new JLabel("Password");
			
			JButton buttonLogin = new JButton("Login");
			JButton buttonReset = new JButton("Reset");
			JButton buttonForgotPassword = new JButton("Forgot Password?");
	
			
			JSeparator separator = new JSeparator();
			JSeparator separator1 = new JSeparator();
	
			UsernameText = new JTextField();
			PasswordText = new JPasswordField();
			
			//Set fonts for  specific labels/buttons
			LoginLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
			buttonForgotPassword.setForeground(Color.RED);
			
			
			//Using x,y,z place the labels
			LoginLabel.setBounds(150, 10, 150, 50);
			UsernameLabel.setBounds(50, 100, 75, 15);
			PasswordLabel.setBounds(50, 150, 75, 15);
			
			UsernameText.setBounds(159, 93, 204, 20);
			PasswordText.setBounds(159, 147, 204, 20);
			
			buttonLogin.setBounds(10, 203, 123, 47);
			buttonReset.setBounds(261, 203, 113, 47);
			buttonForgotPassword.setBounds(125, 168, 155, 30);
	
			separator.setBounds(25, 200, 300, 25);
			separator1.setBounds(25, 75, 300, 25);
			
			//Add the Labels/Buttons/Lines to the Pane.
			frame.getContentPane().add(LoginLabel);
			frame.getContentPane().add(UsernameLabel);
			frame.getContentPane().add(PasswordLabel);
	
			frame.getContentPane().add(UsernameText);
			frame.getContentPane().add(PasswordText);
			
			frame.getContentPane().add(buttonLogin);
			frame.getContentPane().add(buttonReset);
			frame.getContentPane().add(buttonForgotPassword);
	
			
			frame.getContentPane().add(separator);
			frame.getContentPane().add(separator1);
			
			//Have been unable to add the buttons to menuListener function....
			//buttonLogin.addActionListener(new MenuListener()); 
			//buttonReset.addActionListener(new MenuListener()); 
			buttonLogin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					LoginPage();
				}
			});
			buttonReset.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Reset();
				}
			});
		
			buttonForgotPassword.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ForgotPassword();
				}
			});
			
			frame.setVisible(true);
			//return null;
		}
		
	private class MenuListener implements ActionListener {
		public void actionPerformed(ActionEvent e){
			JMenuItem source = (JMenuItem)(e.getSource());
			if(source.equals(buttonLogin)){
				LoginPage();
			}
			else if(source.equals(buttonReset)){
				Reset();
			}
			
		}
	}
	
	private void LoginPage() {
		String password = PasswordText.getText();
		String username = UsernameText.getText();
		//Person person = null;
		//WE SHOULD CALL THE CHECK PASSWORD
		if(password.length() > 10 && username.length() > 2){
			PasswordText.setText(null);
			UsernameText.setText(null);
			//return person;
		}
		else{
			JOptionPane.showMessageDialog(null, 
					"Invalid Login Details", 
					"Login Failed!",
					JOptionPane.ERROR_MESSAGE);
		}
		//return null;
	}
	
	private void Reset() {
		UsernameText.setText(null);
		PasswordText.setText(null);
	}

	private void ForgotPassword(){
		String eMail;
		eMail = JOptionPane.showInputDialog(null, "Please enter your email: ");
		
		//Wait for a valid email to be found (could look at curr population email also.
		while(!eMail.contains("@")){
			eMail = JOptionPane.showInputDialog(null, "Please enter a valid email: ");
		}
		
		//Show a success panel when done so
		JOptionPane.showMessageDialog(null,
					"An email has been sent to you with a temporary password!",
					"Valid Email",
					JOptionPane.DEFAULT_OPTION);
	}
}
