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

import org.places.City;


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
	private City city; 			//This object will be serializable. (It would be world but for this project scope we
	//are only using A city.
	private JMenuBar menuBar;
	private JMenu adminMenu;
	
	private ArrayList<City> cityList;  //Can go back in time if we change which element.
	
	private JMenuItem createPage;
	private JMenuItem listAllUsers;
	private JMenuItem listAllActivities;
	private JMenuItem logout;
	private JComboBox selectCity;
	
	public void MainPageGui(City city1, Person user) {
		
		this.setTitle("Welcome to the Activity Review Center");
		
		cityList = new ArrayList<City>();
		cityList.add(city1);
		city = city1;
		
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
		
		logout = new JMenuItem("Logout");
		createPage = new JMenuItem("Create New Page");
		listAllUsers = new JMenuItem("Show All Users");
		listAllActivities = new JMenuItem("Show All Activities");
		
		@SuppressWarnings("rawtypes")
		JComboBox selectCity = new JComboBox();
		selectCity.setModel(new DefaultComboBoxModel(new String[] {"Select a City...", 
				"New York",	"Los Angeles", "Chicago", "Houston", "Pheonix", "Philadelphia", "San Antonio",
				"San Diego", "Dallas", "San Jose", "Austin", "Jacksonville", "San Francisco", "Colombus",
				"Indianapolis", "Fort Worth", "Charolotte", "Tucson"}));
		selectCity.setBounds(150, 10, 250, 40);
		this.getContentPane().add(slectCity);
		
		selectCity.addActionListener(new MenuListener1());
		createPage.addActionListener(new MenuListener1());
		listAllUsers.addActionListener(new MenuListener1());
		listAllActivities.addActionListener(new MenuListener1());
		adminMenu.add(createPage);
		adminMenu.add(listAllUsers);
		adminMenu.add(listAllActivities);
		
		menuBar.add(logout);
		menuBar.add(adminMenu);
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
				
			}
			else if(source.equals(logout)){
				
			}
		}
	}
	
	/*
	 * createPage: Will allow an admin to click on the 
	 * 
	 */
	private void createPage(){
		
	}
	
	/*
	 * 
	 * 
	 */
	private void listAllUsers(){
		
	}
	
	/*
	 * 
	 * 
	 */
	private void listAllActivities(){
		
	}
	
}
