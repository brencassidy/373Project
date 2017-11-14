package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;
import org.people.*;
import org.places.*;

public class Driver {

	@Test
	public void testCity() {
		System.out.println("Start of the JUnit Test");
		City c1 = new City();
		assertEquals("unnamedCity", c1.getCityName());
		
		City c2 = new City("Tucson");

		assertEquals("Tucson", c2.getCityName());
		System.out.println("Making a new person");
		Person p1 = new Person();
		System.out.println("Instantiated person");
		p1.setEmail("myEmail@gmail.com");
		p1.setName("Daniel");
		p1.setPassword("thisIsMyPassword1");
	//	System.out.println("Before Adding Daniel and Brendan");
		c2.addingNewUser(p1);
		c2.addingNewUser("Brendan", "Cassidy@gmail.com", "hisPassword3");
	//	System.out.println("Added brendan and myself");
		ArrayList<Person> pop = c2.getPopulation();
		System.out.println("Before population print");
		System.out.println("\n\n\n\n");
		for(Person p: pop)
		{
			System.out.println(p.getName() + " " + p.getEmail() + " " + p.getPassword());
		}
		
		Activities a1 = new Activities();
		assertEquals("notRealActivity", a1.getActivityName());
		assertEquals("NotAType", a1.getType());
		
		a1.setActivityAddress("U of A Library");
		a1.setActivityDescription("Study Sesh");
		a1.setActivityName("Studyin Bruh");
		a1.setContentOwner(p1);
		a1.setType("Boring Study");
		
		c2.addActivities(a1);
		Activities a2 = new Activities();
		c2.addActivities(a2);
		System.out.println("\n\n\n\n");
		for(Activities a: c2.getActivities())
		{
			System.out.println(a.getActivityName() + " " + a.getActivityAddress() + " " + a.getActivityDescription() + " " + a.getType());
		}
		
		
		
	}

}
