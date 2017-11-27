package org.people;

import org.places.*;


public class Test1 
{
	public static void main(String[] args) 
	{
		System.out.println("Start");
		DataBase b1=new DataBase();
		//creating 2 cities
		City c1 =new City();
		City c2=new City("Tucson");
		
		c1.setCityName("LA");
		
		//creating activities
		Activities a1=new Activities();
		Activities a2 = new Activities("Ride", "6th st", null);
		Activities a3 =new Activities();
		a1.setActivityName("TestActivity");
		a3.setActivityName("Shoot");
		a3.setActivityAddress("downtown");
		a3.setActivityDescription("Good place near downtown");
		a3.setType("Sport");
		
		//creating people
		GenericUser p1= new GenericUser();
		GenericUser p2= new GenericUser();
		ContentCreator p3= new ContentCreator();  //creator
		Admin p4= new Admin(); //admin
		ContentCreator p5= new ContentCreator();  //creator
		
		p2.setPerson("Bek", "b@gmail.com", "ThisIsV4lid");
		p3.setPerson("Jack", "j@gmail.com", "ThisIsV4lid");	 //creator	
		p4.setPerson("Admin", "a@gmail.com", "ThisIsV4lid");
		p5.setPerson("Cont", "con@yahoo.com", "ThisIsV4lid");
		
		//linking them
		//adding users to the city population
		c1.addingNewUser(p1);
		c2.addingNewUser(p2);
//		c2.addingNewUser("NP", "n@hotmail.com", "ThisIs4lid");
		
		//adding creators to the activity
		a1.setContentOwner(p3);
		a2.setContentOwner(p5);
		
		
		//adding activities to the cities
		c1.addActivity(a1);
		c1.addActivity(a2);
		c2.addActivity(a3);
		
		//adding them to the database
				b1.addCity(c1);
				b1.addCity(c2);
				
				b1.addAdmin(p4);
				b1.addCreator(p3);
				b1.addCreator(p5);
				b1.addUser(p1);
				b1.addUser(p2);
		//before testing
		System.out.println("Before Testing .....~~~.....");
		b1.printCities();
		System.out.println("\nUsers:");
		b1.printUsers();
		System.out.println("\nCreators:");
		b1.printCreators();
		System.out.println("\nAdmins:");
		b1.printAdmins();
		
		System.out.println("\nThe size of comments in Activity 1: "+a1.getCommentList().size());
		
		System.out.println("\n\nTest Begin:....~~~>>>");
		//testing user
				p1.addComment("Nice", a1);
				p2.addComment("Good", a1);
				p1.addRating(5.0, 4.5, 4.0, a1);
				
		System.out.println("\na1 after tested: "+"\nComments: "+a1.getCommentList().get(0)+"   "+a1.getCommentList().get(1));
		System.out.println("\nRatings: "+ a1.getOverallRating()+" "+a1.getFoodRating()+" "+a1.getPriceRating());
		//testing creator
				p3.addDescription("We are welcome", a1);
				p5.addDescription("on sale", a2);
		System.out.println("\nCommentes added by the creators: "+a1.getActivityName()+"  Description:"+ a1.getActivityDescription());
		System.out.println(a2.getActivityName()+"  Description:"+ a2.getActivityDescription());
		//testing admin
		p4.deleteUser(p2,b1);  //delete user p2
		System.out.println("\nUser list after Bek got deleted");
		b1.printUsers();
		
		p4.addEvent("Movie", "Tucson",b1);
		System.out.println("\nNew event added:"+ c2.getCityName()+"  New activity name: "+c2.getActivities().get(1).getActivityName());
		
		p4.deleteComment("Nice", a1);
		System.out.println("\nThe size of comments in Activity 1: "+a1.getCommentList().size());
		
		p4.clearAll(c1,b1);
		System.out.println("\nThe size of activities in LA is  "+ c1.getActivities().size());
		
		//
		//System.out.println("\n\nAfter testing .....");

		
	}
}
