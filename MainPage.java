package FrontEnd_GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

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
	
	//private ArrayList<City> cityList;  //Can go back in time if we change which element.
	
	private JMenuItem createPage;
	private JMenuItem listAllUsers;
	private JMenuItem listAllActivities;
	private JMenuItem editPageContent;
	
	private JMenuItem logout;
	private JComboBox selectCity;
	private JTextArea txtActivity;

	
	public void MainPageGui(Person user, DataBase DB2) {
		
		this.setTitle("Welcome to the Activity Review Center");
		
		//cityList = new ArrayList<City>();
		//cityList.add(city1);
		//city = city1;
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
		editPageContent.addActionListener(new MenuListener1());
		logout.addActionListener(new MenuListener1());
		adminMenu.add(createPage);
		adminMenu.add(listAllUsers);
		adminMenu.add(listAllActivities);
		contentCreatorMenu.add(editPageContent);
		
		menuBar.add(selectCity);
		menuBar.add(logout);
		menuBar.add(adminMenu);
		menuBar.add(contentCreatorMenu);
		setJMenuBar(menuBar);
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
			else if(e.getSource() == selectCity){
				cityFlyout();
			}
			else if(source.equals(logout)){
				logout();
			}
			else if(source.equals(editPageContent)){
				editPage();
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
			System.out.println(fullString);
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
			System.out.println(fullString);
		}
	}
	
	/*
	 * cityFlyout: Once the user selects a city we will open the activities
	 * 		for that city.
	 */
	private void cityFlyout(){
		System.out.println("TESTING");
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
	 * This page is only applicable for the Content Creator Class
	 * 	all other users will recieve an error.
	 */
	private void editPage(){
		if(currUser.getClass() != ContentCreator.class){
			JOptionPane.showMessageDialog(null, 
				"User Status Error", 
				"Only Admins can access User Info!",
				JOptionPane.ERROR_MESSAGE);
		}
		else{
			
		}
	}
	
	private void populatePageWithCity(String cityName){
		//Find the city Obj
		City c1 = DB.findCityObj(cityName);
		System.out.println("PopulatePage");
		if(c1 == null){
			JOptionPane.showMessageDialog(null, 
					"City Error", 
					"No City info was found!",
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
				btnActivityName.setBounds(160, 100+x, 250, 23);
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