package FrontEnd_GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

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
	
	//private ArrayList<City> cityList;  //Can go back in time if we change which element.
	
	private JMenuItem createPage;
	private JMenuItem listAllUsers;
	private JMenuItem listAllActivities;
	
	private JMenuItem logout;
	private JComboBox selectCity;
	private JTextArea txtActivity;
	private JTextArea userList;
	private JTextArea activityList;

	
	public void MainPageGui(Person user, DataBase DB2, JTextArea messageToAdd) {
		
		this.setTitle("Welcome to the Activity Review Center");
		
		//cityList = new ArrayList<City>();
		//cityList.add(city1);
		//city = city1;
		currUser = user;
		DB = DB2;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setSize(600,600);
		setLayout(null); //So that components are placed by x,y,z
				
		buildGUI(messageToAdd);
		setVisible(true);
	}
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void buildGUI(JTextArea message){
		menuBar = new JMenuBar();
		
		adminMenu = new JMenu("Administrator");
		
		logout = new JMenuItem("Logout");
		createPage = new JMenuItem("Create New Page");
		listAllUsers = new JMenuItem("Show All Users");
		listAllActivities = new JMenuItem("Show All Activities");
		
		//@SuppressWarnings("rawtypes")
		JComboBox selectCity = new JComboBox();
		selectCity.addItem("Tucson");
		selectCity.addItem("Los Angeles");
		selectCity.addItem("San Diego");
		selectCity.addItem("New York");
		selectCity.setBounds(150, 10, 250, 40);
		selectCity.addActionListener(new Action());
		
		createPage.addActionListener(new MenuListener1());
		listAllUsers.addActionListener(new MenuListener1());
		listAllActivities.addActionListener(new MenuListener1());
		logout.addActionListener(new MenuListener1());
		adminMenu.add(createPage);
		adminMenu.add(listAllUsers);
		adminMenu.add(listAllActivities);
		
		menuBar.add(selectCity);
		menuBar.add(logout);
		menuBar.add(adminMenu);
		setJMenuBar(menuBar);
		this.getContentPane().add(message);
	}
	
	/*
	 * Specified action Listener to the JComboBox.  This allows us to begin posting the info for 
	 * different pages available.
	 */
	private class Action implements ActionListener{
		public void actionPerformed(ActionEvent e){
			JComboBox combo = (JComboBox)e.getSource();
			String currentQ = (String)combo.getSelectedItem();
			//Call the function to populate the file with activities from that page
			populatePageWithCity(currentQ);
		}
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
			else if(source.equals(logout)){
				logout();
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
			JTextField ActivName = new JTextField(50);
			JTextField ContentCreator = new JTextField(50);
			JTextField CityName = new JTextField(50);
			JPanel addReviewPanel = new JPanel();
			
			addReviewPanel.setLayout(new BoxLayout(addReviewPanel, BoxLayout.Y_AXIS));

			addReviewPanel.add(new JLabel("Enter the Activities Name:"));
			addReviewPanel.add(ActivName);
			addReviewPanel.add(new JLabel("Enter Content Creators Name:"));
			addReviewPanel.add(ContentCreator);
			addReviewPanel.add(new JLabel("Enter City Name:"));
			addReviewPanel.add(CityName);
			
			 int result = JOptionPane.showConfirmDialog(null, addReviewPanel, 
		               "Please Enter a Review", JOptionPane.OK_CANCEL_OPTION);
		      if (result == JOptionPane.OK_OPTION) {
		    	  Activities newAct = new Activities();
		    	  newAct.setActivityName(ActivName.getText());
		    	  for(Person p : DB.getCreator()){
		    		  if(p.getName().equals(ContentCreator)){
				    	  newAct.setContentOwner(p);
		    		  }
		    	  }
		    	  for(City c: DB.getCities()){
		    		  if(c.getCityName().equals(CityName.getText())) {
		    			c.addActivities(newAct);
		    			String fullString = DB.printActivities();
		    			activityList = new JTextArea();
		    			activityList.setBackground(Color.LIGHT_GRAY);
		    			activityList.setLineWrap(true);
		    			activityList.setWrapStyleWord(true);
		    			activityList.setEditable(false);
		    			activityList.setText("Users in the DataBase: " + fullString);
		    			activityList.setBounds(50, 10, 500, 500);
		    		    activityList.setFont(new Font("Monospaced", Font.BOLD, 16));
		    		    dispose();
		 		    	MainPage mp1 = new MainPage();
					    mp1.MainPageGui(currUser, DB, activityList);
		    		  }
		    	  }
		    	 
		      }
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
			userList = new JTextArea();
			userList.setBackground(Color.LIGHT_GRAY);
			userList.setLineWrap(true);
			userList.setWrapStyleWord(true);
			userList.setEditable(false);
			userList.setText("Users in the DataBase: " + fullString);
			userList.setBounds(50, 10, 500, 500);
			userList.setFont(new Font("Monospaced", Font.BOLD, 16));
			this.getContentPane().add(userList);
			dispose();
	        MainPage agp1 = new MainPage();
	        agp1.MainPageGui(currUser, DB, userList);
	        //agp1.ActivityGUIPageOpen(currA, currUser, currDB);
			
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
			activityList = new JTextArea();
			activityList.setBackground(Color.LIGHT_GRAY);
			activityList.setLineWrap(true);
			activityList.setWrapStyleWord(true);
			activityList.setEditable(false);
			activityList.setText("Users in the DataBase: " + fullString);
			activityList.setBounds(50, 10, 500, 500);
			activityList.setFont(new Font("Monospaced", Font.BOLD, 16));
			//this.getContentPane().add(activityList);
			dispose();
	        MainPage mp1 = new MainPage();
	        mp1.MainPageGui(currUser, DB, activityList);
		}
	}
	
	
	/*
	 * logout: If a user clicks this panel we will reopen the original panel to 
	 * 	allow a new user to select input.
	 * 
	 */
	private void logout(){
		dispose();
		WebPageGui wpg = new WebPageGui(DB);
	}
	
	/*
	 * cityFlyout: Once the user selects a city we will open the activities
	 * 		for that city.
	 */
	private void populatePageWithCity(String cityName){
		//Find the city Obj
		City c1 = DB.findCityObj(cityName);
		if(c1 == null){
			JOptionPane.showMessageDialog(null, 
					"No Activities available!", 
					"City Error!",
					JOptionPane.ERROR_MESSAGE);
		}
		/*If city exists we will list every possible activity for the City as a button.
		* If a user then clicks on the button we will pull up the final Page with the information of that activity.
		*/
		else {
			Integer x = 0;			
			JTextArea txtActivity = new JTextArea();
			txtActivity.setBackground(Color.LIGHT_GRAY);
			txtActivity.setLineWrap(true);
			txtActivity.setWrapStyleWord(true);
			txtActivity.setText("Activities in " + c1.getCityName() + ":");
			txtActivity.setBounds(175, 10, 300, 25);
			txtActivity.setFont(new Font("Monospaced", Font.BOLD, 16));
			this.getContentPane().add(txtActivity);
			
			//Loop through and post the activities
			for(Activities a : c1.getActivities()){
				JButton btnActivityName = new JButton(a.getActivityName());
				btnActivityName.setBounds(150, 100+x, 250, 23);
				btnActivityName.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						dispose();
						ActivityGUIPage agp = new ActivityGUIPage();
						agp.ActivityGUIPageOpen(a, currUser, DB);
					}
				});
				x+=23;			//To change the Spacing down
				this.getContentPane().add(btnActivityName);
			}
		}
		
	}

	
}