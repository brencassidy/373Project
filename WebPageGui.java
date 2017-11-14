package FrontEnd_GUI;

import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;


import javax.swing.*;

import org.people.*;
import org.places.*;

public class WebPageGui extends JFrame {
	
	private City city; 			//This object will be serializable. (It would be world but for this project scope we
								//are only using A city.
	private JMenuBar menuBar;
	private JMenu adminMenu;
	
	private ArrayList<City> cityList;  //Can go back in time if we change which element.
	
	private JMenuItem createPage;
	private JMenuItem listAllUsers;
	private JMenuItem listAllActivities;
	
	private JButton Login;
	private JButton Guest;
	
	/*
	 * 
	 */
	public WebPageGui(City city1){
		super("Welcome to the Activity Review Center");

		cityList = new ArrayList<City>();
		cityList.add(city1);
		city = city1;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setSize(600,600);
		setLayout(null); //So that components are placed by x,y,z
				
		buildGUI();
		setVisible(true);
	}
	
	/*
	 * 
	 * 
	 */
	public void buildGUI(){
		menuBar = new JMenuBar();
		
		adminMenu = new JMenu("Administrator");
		
		createPage = new JMenuItem("Create New Page");
		listAllUsers = new JMenuItem("Show All Users");
		listAllActivities = new JMenuItem("Show All Activities");
		
		JButton Guest = new JButton("Guest");
		JButton Login = new JButton("Login");


		
		//Set all attributes for the TextArea
		JTextArea HomePageText = new JTextArea();
		HomePageText.setForeground(Color.WHITE);
		HomePageText.setBackground(Color.GRAY);
		HomePageText.setBounds(10, 15, 415, 85);
		HomePageText.setText("Welcome to the activity search web page.  Please login to have the ability"
				+ " to post comments and reviews to the activites.  If you would like to continue as a guest press guest. ");
		HomePageText.setLineWrap(true);
		HomePageText.setWrapStyleWord(true);
		
		Login.setBounds(270, 140, 89, 23);
		Guest.setBounds(75, 140, 89, 23);
		
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
	    
	    
		createPage.addActionListener(new MenuListener());
		listAllUsers.addActionListener(new MenuListener());
		listAllActivities.addActionListener(new MenuListener());
				
		adminMenu.add(createPage);
		adminMenu.add(listAllUsers);
		adminMenu.add(listAllActivities);
		this.getContentPane().add(HomePageText);;
	    this.getContentPane().add(Login);
	    this.getContentPane().add(Guest);
	    	
		menuBar.add(adminMenu);
		setJMenuBar(menuBar);
	}
	
	/*
	 * 
	 * 
	 */
	private class MenuListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			JMenuItem source = (JMenuItem)(e.getSource());
			if(source.equals(Login)){
				loginMenu();
			}
			if(source.equals(Guest)){
				guestLogin();
			}
		}
	}
	
	/*
	 * loginMenu: Calls the LoginGUI file.  The class will handle all events and integration from
	 * 	the login flyout. Should call generic login sequence with user found.
	 * 
	 */
	private void loginMenu(){
		LoginGUI loginScreen = new LoginGUI();
		loginScreen.Initialize();
		Person user = new Person();
		//Person user = loginScreen.Initialize();
		MainPage mainScreen = new MainPage();
	    mainScreen.MainPageGui(city, user);
	}
	
	/*
	 * guestLogin: Calls directly to generic login sequence with a "Guest"
	 * 	username and no ability to add content/comments/reviews.
	 * 
	 */
	private void guestLogin(){
		Person guest = new Person();
		MainPage mainScreen = new MainPage();
		mainScreen.MainPageGui(city, guest);
	}
	
	private void mainPage(){
		
	}
	
}
