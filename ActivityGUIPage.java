package FrontEnd_GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import org.places.Activities;

import javax.swing.JTextArea;
import javax.swing.JFormattedTextField;
import java.awt.Color;
import java.awt.Font;

public class ActivityGUIPage extends JFrame{
	private Activities currA;
	
	private JFrame frame;
	private JTextField textField;
	private JTextArea FoodRating;
	private JTextArea ActivityText;
	private JTextArea Description;
	private JTextArea AddressText;

	/**
	 * Create the application.
	 * @return 
	 */
	public void ActivityGUIPageOpen(Activities a) {
		this.setTitle(a.getActivityName());
		currA = a;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setSize(600, 600);
		setLayout(null);
		
		buildGUI();
		setVisible(true);
		
	}
	
	public void buildGUI(){
		//frame = new JFrame();
		//frame.setBounds(100, 100, 450, 300);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.getContentPane().setLayout(null);
		textField = new JTextField();
		FoodRating = new JTextArea();
		ActivityText = new JTextArea();
		Description = new JTextArea();
		AddressText = new JTextArea();

		JButton btnAddComment = new JButton("Add Comment");		
		JButton BackButton = new JButton("Back to Browse");
		
		btnAddComment.setBackground(Color.LIGHT_GRAY);
		btnAddComment.setBounds(0, 525, 458, 25);
		btnAddComment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		textField.setBounds(0, 321, 458, 204);
		this.getContentPane().add(textField);
		textField.setColumns(10);
		
		BackButton.setBackground(Color.LIGHT_GRAY);
		BackButton.setBounds(0, 0, 150, 23);
		
		FoodRating.setBackground(Color.GRAY);
		FoodRating.setText("Overall Rating:\r\nFood Rating:\r\nPrice Rating:");
		FoodRating.setBounds(0, 23, 179, 165);
		FoodRating.setEditable(false);
		
		ActivityText.setFont(new Font("Monospaced", Font.BOLD, 16));
		ActivityText.setBackground(Color.GRAY);
		ActivityText.setText(currA.getActivityName());
		ActivityText.setBounds(201, 0, 354, 23);
		ActivityText.setEditable(false);

		Description.setBackground(Color.GRAY);
		Description.setForeground(Color.BLACK);
		Description.setText("Description: " + currA.getActivityDescription());
		Description.setLineWrap(true);
		Description.setWrapStyleWord(true);
		Description.setBounds(201, 156, 354, 154);
		Description.setEditable(false);
		
		AddressText.setBackground(Color.GRAY);
		AddressText.setForeground(Color.BLACK);
		AddressText.setText("Address:");
		AddressText.setBounds(201, 58, 163, 85);
		
		this.getContentPane().add(AddressText);
		this.getContentPane().add(Description);
		this.getContentPane().add(ActivityText);
		this.getContentPane().add(FoodRating);
		this.getContentPane().add(BackButton);
		this.getContentPane().add(btnAddComment);

	}
}
