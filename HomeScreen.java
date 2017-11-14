package FrontEnd_GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;

import java.awt.FlowLayout;
import javax.swing.JTextPane;
import javax.swing.DropMode;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JToolBar;

public class HomeScreen {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeScreen window = new HomeScreen();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public HomeScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextArea txtpnWelcomeToThe = new JTextArea();
		txtpnWelcomeToThe.setForeground(Color.WHITE);
		txtpnWelcomeToThe.setBackground(Color.GRAY);
		txtpnWelcomeToThe.setBounds(10, 11, 414, 86);
		txtpnWelcomeToThe.setText("Welcome to the activity search web page.  Please login to have the ability to post comments and reviews to the activites.  If you would like to continue as a guest press guest. ");
		txtpnWelcomeToThe.setLineWrap(true);
		txtpnWelcomeToThe.setWrapStyleWord(true);
		frame.getContentPane().add(txtpnWelcomeToThe);
		
		JButton Guest = new JButton("Guest");
		Guest.setForeground(Color.RED);
		Guest.setBounds(75, 140, 89, 23);
		frame.getContentPane().add(Guest);
		
		JButton Login = new JButton("Login");
		Login.setForeground(Color.RED);
		Login.setBounds(270, 140, 89, 23);
		frame.getContentPane().add(Login);
	}

}
