package FrontEnd_GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import org.people.ContentCreator;
import org.people.Person;
import org.places.Activities;
import org.places.DataBase;

import javax.swing.JTextArea;
import javax.swing.JFormattedTextField;

import java.awt.Color;
import java.awt.Font;

public class ActivityGUIPage extends JFrame{
	private Activities currA;
	private Person currUser;
	private DataBase currDB;
	
	private JFrame frame;
	private JTextArea textField;
	private JTextArea FoodRating;
	private JTextArea ActivityText;
	private JTextArea Description;
	private JTextArea AddressText;
	private JButton btnAddComment;
	private JButton BackButton;
	
	private JMenuBar menuBar;
	private JMenu contentCreatorMenu;
	private JMenuItem editPageContent;

	/**
	 * Create the application.
	 * @return 
	 */
	public void ActivityGUIPageOpen(Activities a, Person p, DataBase db) {
		this.setTitle(a.getActivityName());
		currA = a; currUser = p; currDB = db;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setSize(452, 478);
		setLayout(null);
		
		buildGUI();
		setVisible(true);
		
	}
	
	public void buildGUI(){
		menuBar = new JMenuBar();
		
		contentCreatorMenu = new JMenu("ContentCreator");
		
		editPageContent = new JMenuItem("Edit Page");
		editPageContent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				editPage();
			}
		});
		
		textField = new JTextArea();
		FoodRating = new JTextArea();
		ActivityText = new JTextArea();
		Description = new JTextArea();
		AddressText = new JTextArea();

		btnAddComment = new JButton("Add Comment");		
		BackButton = new JButton("Back to Browse");
		
		btnAddComment.setBackground(Color.LIGHT_GRAY);
		btnAddComment.setBounds(150, 393, 295, 23);
		btnAddComment.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				addComment();
			}
		});
		
		textField.setBounds(0, 192, 445, 192);
		textField.setColumns(10);
		textField.setText("Comments: " + currA.printComments());
		textField.setLineWrap(true);
		textField.setWrapStyleWord(true);
		textField.setEditable(false);
		
		BackButton.setBackground(Color.LIGHT_GRAY);
		BackButton.setBounds(0, 393, 150, 23);
		BackButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				BackToActivities();
			}
		});
		
		FoodRating.setBackground(Color.GRAY);
		FoodRating.setForeground(Color.WHITE);
		FoodRating.setText("Overall Rating:\r " + currA.getOverallRating() +  "\nFood Rating:\r " + currA.getFoodRating()
					+ "\nPrice Rating: " + currA.getPriceRating());
		FoodRating.setBounds(0, 22, 226, 69);
		
		ActivityText.setFont(new Font("Monospaced", Font.BOLD, 16));
		ActivityText.setBackground(Color.LIGHT_GRAY);
		ActivityText.setText(currA.getActivityName());
		ActivityText.setBounds(0, 0, 445, 23);
		ActivityText.setEditable(false);

		Description.setBackground(Color.GRAY);
		Description.setForeground(Color.WHITE);
		Description.setText("Description: " + currA.getActivityDescription());
		Description.setLineWrap(true);
		Description.setWrapStyleWord(true);
		Description.setBounds(0, 102, 445, 79);
		
		AddressText.setBackground(Color.GRAY);
		AddressText.setForeground(Color.WHITE);
		AddressText.setText("Address: " + currA.getActivityAddress());
		AddressText.setLineWrap(true);
		AddressText.setWrapStyleWord(true);
		AddressText.setBounds(236, 22, 209, 69);
		
		FoodRating.setEditable(false);
		ActivityText.setEditable(false);
		Description.setEditable(false);

		this.getContentPane().add(textField);
		this.getContentPane().add(AddressText);
		this.getContentPane().add(Description);
		this.getContentPane().add(ActivityText);
		this.getContentPane().add(FoodRating);
		this.getContentPane().add(BackButton);
		this.getContentPane().add(btnAddComment);
		
		contentCreatorMenu.add(editPageContent);
		menuBar.add(contentCreatorMenu);
		setJMenuBar(menuBar);
	}
	
	
	private void BackToActivities(){
		dispose();
		MainPage mainScreen = new MainPage();
		mainScreen.MainPageGui(currUser, currDB, new JTextArea());
	}
	
	private void addComment(){
		JTextField comment = new JTextField(50);
		JTextField foodRating = new JTextField(5);
		JTextField overallRating = new JTextField(5);
		JTextField priceRating = new JTextField(5);

		JPanel addReviewPanel = new JPanel();
		addReviewPanel.setLayout(new BoxLayout(addReviewPanel, BoxLayout.Y_AXIS));

		addReviewPanel.add(new JLabel("Enter a comment:"));
		addReviewPanel.add(comment);
		addReviewPanel.add(new JLabel("Food Rating:"));
		addReviewPanel.add(foodRating);
		addReviewPanel.add(new JLabel("Overall Rating:"));
		addReviewPanel.add(overallRating);
		addReviewPanel.add(new JLabel("Price Rating:"));
		addReviewPanel.add(priceRating);
		
		 int result = JOptionPane.showConfirmDialog(null, addReviewPanel, 
	               "Please Enter a Review", JOptionPane.OK_CANCEL_OPTION);
	      if (result == JOptionPane.OK_OPTION) {
	         currA.addComment(comment.getText());
	         currA.addAllRating(Double.parseDouble(foodRating.getText()), Double.parseDouble(priceRating.getText()), Double.parseDouble(overallRating.getText()));
	         dispose();
	         ActivityGUIPage agp1 = new ActivityGUIPage();
	         agp1.ActivityGUIPageOpen(currA, currUser, currDB);
	      }
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
		else if(!currA.getContentOwner().getName().equals(currUser.getName())){
			JOptionPane.showMessageDialog(null, 
					"Wrong activity selected", 
					"You do not have access to this Activity!",
					JOptionPane.ERROR_MESSAGE);
		}
		else{
			JTextField description = new JTextField(50);
			JTextField address = new JTextField(5);

			JPanel addReviewPanel = new JPanel();
			addReviewPanel.setLayout(new BoxLayout(addReviewPanel, BoxLayout.Y_AXIS));

			addReviewPanel.add(new JLabel("Enter new Description (leave blank to remain the same):"));
			addReviewPanel.add(description);
			addReviewPanel.add(new JLabel("Enter new Address (leave blank to remain the same):"));
			addReviewPanel.add(address);
			
			int result = JOptionPane.showConfirmDialog(null, addReviewPanel, 
		               "Please Enter a Review", JOptionPane.OK_CANCEL_OPTION);
		    if (result == JOptionPane.OK_OPTION) {
		         if(address.getText().length() > 1 && address.getText() != null ){
		        	 currA.setActivityAddress(address.getText());
		         }
		         if(description.getText().length() > 1 && description.getText() != null){
		        	currA.setActivityDescription(description.getText());
		         }
		         
		         dispose();
		         ActivityGUIPage agp1 = new ActivityGUIPage();
		         agp1.ActivityGUIPageOpen(currA, currUser, currDB);
		      
		    }
		}
	}
}