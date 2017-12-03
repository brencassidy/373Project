package FrontEnd_GUI;

import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import org.people.*;
import org.places.*;

public class WebPageGui extends JFrame {
	
	//private City city; 			
	private DataBase currDB;
	
	//private ArrayList<City> cityList;  //Can go back in time if we change which element.
	
	private JButton Login;
	private JButton Guest;
	
	/*
	 * 
	 */
	public WebPageGui(DataBase DB){
		super("Welcome to the Activity Review Center");

		//cityList = new ArrayList<City>();
		//cityList.add(city1);
		//city = city1;
		currDB = DB;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setSize(500,300);
		setLayout(null); //So that components are placed by x,y,z
				
		buildGUI();
		setVisible(true);
	}
	
	/*
	 * 
	 * 
	 */
	public void buildGUI(){
		JButton Guest = new JButton("Guest");
		JButton Login = new JButton("Login");
		JButton CreateUser = new JButton("Create User");
		
		//Set all attributes for the TextArea
		JTextArea HomePageText = new JTextArea();
		HomePageText.setForeground(Color.WHITE);
		HomePageText.setBackground(Color.GRAY);
		HomePageText.setBounds(10, 15, 415, 85);
		HomePageText.setText("Welcome to the activity search web page.  Please login to have the ability"
				+ " to post comments and reviews to the activites.  If you would like to continue as a guest press guest. ");
		HomePageText.setLineWrap(true);
		HomePageText.setWrapStyleWord(true);
	
		Login.setBounds(285, 140, 89, 23);
		Guest.setBounds(50, 140, 89, 23);
		CreateUser.setBounds(150, 140, 125, 23);
	    //Swing button can;t add to menuListener.. Unsure why.
	    Login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginMenu();
			}
	    });
	    
	    Guest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guestLogin();
			}
	    });
	    
	    CreateUser.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent e){
	    		createUser();
	    	}
	    });
	   //To add Pictures we can do the following
	   //ImageIcon image = new ImageIcon("C:/Users/Brendan Cassidy/Pictures/Brendan.jpg");
	   //JLabel imageLabel = new JLabel(image);
	   //imageLabel.setVisible(true);
	   //imageLabel.setBounds(0, 0, 800, 800);
	   // this.getContentPane().add(imageLabel);
	    this.getContentPane().add(HomePageText);;
	    this.getContentPane().add(Login);
	    this.getContentPane().add(Guest);
	    this.getContentPane().add(CreateUser);
	}
	
	/*
	 * loginMenu: Calls the LoginGUI file.  The class will handle all events and integration from
	 * 	the login flyout. Should call generic login sequence with user found.
	 * 
	 */
	private void loginMenu(){
		dispose();
		LoginGUI loginScreen = new LoginGUI();
		loginScreen.Initialize(currDB);
		Person user = new Person();
		//Person user = loginScreen.Initialize();
		//MainPage mainScreen = new MainPage();
	    //mainScreen.MainPageGui(city, user);
	}
	
	/*
	 * guestLogin: Calls directly to generic login sequence with a "Guest"
	 * 	username and no ability to add content/comments/reviews.
	 * 
	 */
	private void guestLogin(){
		dispose();
		Person guest = new Person();
		MainPage mainScreen = new MainPage();
		mainScreen.MainPageGui(guest, currDB, new JTextArea());
	}
	
	private void createUser(){
		dispose();
		JTextField name = new JTextField(25);
		JTextField eMail = new JTextField(25);
		JTextField password = new JTextField(25);
		String _password = "false";
		
		JPanel newUser = new JPanel();
		newUser.setLayout(new BoxLayout(newUser, BoxLayout.Y_AXIS));
		newUser.add(new JLabel("Enter your Name:"));
		newUser.add(name);
		newUser.add(new JLabel("Enter your Email:"));
		newUser.add(eMail);
		newUser.add(new JLabel("Enter your Password:"));
		newUser.add(password);
		
		int result = JOptionPane.showConfirmDialog(null, newUser, 
	               "Please Enter a Review", JOptionPane.OK_CANCEL_OPTION);
	      if (result == JOptionPane.OK_OPTION) {
	    	  //Verify the password is valid
	         GenericUser newPerson = new GenericUser();
	         if(newPerson.checkValidPassword(password.getText()) == false){
		         while (newPerson.checkValidPassword(_password) == false) {
		        	 JFrame frame = new JFrame("Invalid Password");
		        	 _password =  JOptionPane.showInputDialog(frame, "Enter valid Password!");
		         } 
	         }
        	 newPerson.setEmail(eMail.getText());
        	 newPerson.setName(name.getText());
        	 if(newPerson.checkValidPassword(password.getText()) == false){
        		 newPerson.setPassword(_password);
        	 }
        	 else{
        	 newPerson.setPassword(password.getText());
        	 }
        	 currDB.addUser(newPerson);
        	 MainPage mainScreen = new MainPage();
        	 mainScreen.MainPageGui(newPerson, currDB, new JTextArea());
	        
	      }
	}
	
}