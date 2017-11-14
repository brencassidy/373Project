package FrontEnd_GUI;

import org.people.Admin;
import org.people.ContentCreator;
import org.people.GenericUser;
import org.places.Activities;
import org.places.City;

public class TestWebPageGui {

	public static void main(String[] args){

		City city1 = new City();

		WebPageGui newGUI;
		
		Activities a1 = new Activities();
		Activities a2 = new Activities();
		
		Admin admin1 = new Admin();
		
		ContentCreator c1 = new ContentCreator();
		ContentCreator c2 = new ContentCreator();
		
		GenericUser g1 = new GenericUser();
		
		/*admin1.setName("Todd");
		admin1.setEmail("admin@admin.com");
		admin1.setPassword("P4ssw0rd");
		
		c1.setName("Bob");
		c1.setEmail("bob.test@gmail.com");
		c1.setPassword("P4ssw0rd");
		
		c2.setName("Jeff");
		c2.setEmail("jeff.test@yahoo.com");
		c2.setPassword("P4ssw0rd");
		
		a1.setActivityName("NAMLS Tier 1 Soccer");
		a2.setActivityName("Hamilton Play");
		
		a1.setActivityAddress("12345 Smith Ave");
		a2.setActivityAddress("44444 First Ave");
		
		a1.setContentOwner(c1);
		a2.setContentOwner(c2);
		
		*/
		
		newGUI = new WebPageGui(city1);

	}
}
