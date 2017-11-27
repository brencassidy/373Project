package FrontEnd_GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import org.places.Activities;
import org.places.City;


import org.places.DataBase;
import org.people.*;
import org.places.*;
/*
 * MainPage:
 * 		This page will have the user already logged in/guest and will
 * 		begin allowing them to manuever through the activities, comments,
 * 		
 * 
 */
public class MainPage extends JFrame {
	private City city; 			
	private Person currUser;
	private DataBase DB;
	
	private JMenuBar menuBar;
	private JMenu adminMenu;
	private JMenu contentCreatorMenu;
	
	private ArrayList<City> cityList;  //Can go back in time if we change which element.
	
	private JMenuItem createPage;
	private JMenuItem listAllUsers;
	private JMenuItem listAllActivities;
	private JMenuItem editPageContent;
	
	private JMenuItem logout;
	private JComboBox selectCity;
	
	public void MainPageGui(City city1, Person user, DataBase DB2) {
		
		this.setTitle("Welcome to the Activity Review Center");
		
		cityList = new ArrayList<City>();
		cityList.add(city1);
		city = city1;
		currUser = user;
		DB = DB2;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setSize(600,600);
		setLayout(null); //So that components are placed by x,y,z
				
		buildGUI();
		setVisible(true);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void buildGUI(){
		menuBar = new JMenuBar();
		
		adminMenu = new JMenu("Administrator");
		contentCreatorMenu = new JMenu("ContentCreator");
		
		logout = new JMenuItem("Logout");
		createPage = new JMenuItem("Create New Page");
		listAllUsers = new JMenuItem("Show All Users");
		listAllActivities = new JMenuItem("Show All Activities");
		editPageContent = new JMenuItem("Edit Page");
		
		@SuppressWarnings("rawtypes")
		JComboBox selectCity = new JComboBox();
		selectCity.setModel(new DefaultComboBoxModel(new String[] {"Select a City...", 
				"New York",	"Los Angeles", "Chicago", "Houston", "Pheonix", "Philadelphia", "San Antonio",
				"San Diego", "Dallas", "San Jose", "Austin", "Jacksonville", "San Francisco", "Colombus",
				"Indianapolis", "Fort Worth", "Charolotte", "Tucson"}));
		selectCity.setBounds(150, 10, 250, 40);
		this.getContentPane().add(selectCity);
		
		selectCity.addActionListener(new MenuListener1());
		createPage.addActionListener(new MenuListener1());
		listAllUsers.addActionListener(new MenuListener1());
		listAllActivities.addActionListener(new MenuListener1());
		editPageContent.addActionListener(new MenuListener1());
		logout.addActionListener(new MenuListener1());
		adminMenu.add(createPage);
		adminMenu.add(listAllUsers);
		adminMenu.add(listAllActivities);
		contentCreatorMenu.add(editPageContent);
		
		menuBar.add(logout);
		menuBar.add(adminMenu);
		menuBar.add(contentCreatorMenu);
		setJMenuBar(menuBar);
	}
	
	/*
	 * 
	 * 
	 */
	private class MenuListener1 implements ActionListener{
		public void actionPerformed(ActionEvent e){
			JMenuItem source = (JMenuItem)(e.getSource());
			if(source.equals(createPage)){
				createPage();
			}
			else if(source.equals(listAllUsers)){
				listAllUsers();
			}
			else if(source.equals(listAllActivities)){
				listAllActivities();
			}
			else if(source.equals(selectCity)){
				cityFlyout();
			}
			else if(source.equals(logout)){
				logout();
			}
			else if(source.equals(editPageContent)){
				
			}
		}
	}
	
	/*
	 * createPage: Will allow an admin to click on the tab to createPage
	 * 			and from there will be able to enter the Title, and category it will fall under
	 * 			as well as the ContentCreator of the page.
	 */
	private void createPage(){
		//Only admins have this ability thus check status
		if(currUser.getClass() != Admin.class){
			JOptionPane.showMessageDialog(null, 
					"User Status Error", 
					"Cannot Create Page!",
					JOptionPane.ERROR_MESSAGE);
		}
		else{
			Activities newAct = new Activities();
			//Ask admin to enter the info
			city.addActivity(newAct);
		}
	}
	
	/*
	 * listAllUsers: Admins are able to print out a list of all the
	 * 		current users in the page.
	 */
	private void listAllUsers(){
		if(currUser.getClass() != Admin.class){
			JOptionPane.showMessageDialog(null, 
					"User Status Error", 
					"Only Admins can access User Info!",
					JOptionPane.ERROR_MESSAGE);
		}
		else{
			//Call function to return the printed list
			String fullString = DB.printUsers();
		}
	}
	
	/*
	 * listAllActivities(): this allows the admin to keep track
	 * 		of all activities by simply showing them all.
	 */
	private void listAllActivities(){
		if(currUser.getClass() != Admin.class){
			JOptionPane.showMessageDialog(null, 
					"User Status Error", 
					"Only Admins can access Activity Lists!",
					JOptionPane.ERROR_MESSAGE);
		}
		else{
			String fullString = DB.printActivities();
		}
	}
	
	/*
	 * cityFlyout: Once the user selects a city we will open the activities
	 * 		for that city.
	 */
	private void cityFlyout(){
		
	}
	
	/*
	 * logout: If a user clicks this panel we will reopen the original panel to 
	 * 	allow a new user to select input.
	 * 
	 */
	private void logout(){
		dispose();
		WebPageGui wpg = new WebPageGui(city, DB);
	}

	
}