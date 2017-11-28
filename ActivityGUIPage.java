package FrontEnd_GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;

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
	private JTextField textField;
	private JTextArea FoodRating;
	private JTextArea ActivityText;
	private JTextArea Description;
	private JTextArea AddressText;
	private JButton btnAddComment;
	private JButton BackButton;
	/**
	 * Create the application.
	 * @return 
	 */
	public void ActivityGUIPageOpen(Activities a, Person p, DataBase db) {
		this.setTitle(a.getActivityName());
		currA = a; currUser = p; currDB = db;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setSize(462, 455);
		setLayout(null);
		
		buildGUI();
		setVisible(true);
		
	}
	
	public void buildGUI(){
		textField = new JTextField();
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

	}
	
	
	private void BackToActivities(){
		dispose();
		MainPage mainScreen = new MainPage();
		mainScreen.MainPageGui(currUser, currDB);
	}
	
	private void addComment(){
		String comment;
		comment = JOptionPane.showInputDialog(null, "Enter the comment you would like to add: ");

		currA.addComment(comment);
	}
}