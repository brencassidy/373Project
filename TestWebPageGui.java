package FrontEnd_GUI;

import org.people.Admin;
import org.people.ContentCreator;
import org.people.GenericUser;
import org.places.Activities;
import org.places.City;
import org.places.DataBase;

public class TestWebPageGui {

	public static void main(String[] args){

		City city1 = new City();

		WebPageGui newGUI;
		
		DataBase newDataBase = new DataBase();
		
		Activities a1 = new Activities();
		Activities a2 = new Activities();
		
		Admin admin1 = new Admin();
		
		GenericUser g1 = new GenericUser();
		GenericUser g2 = new GenericUser();
		
		ContentCreator c1 = new ContentCreator();
		
		/*admin1.setName("Todd");
		admin1.setEmail("admin@admin.com");
		admin1.setPassword("P4ssw0rd");
		
		g1.setName("Bob");
		g1.setEmail("bob.test@gmail.com");
		g1.setPassword("P4ssw0rd");
		
		g2.setName("Jeff");
		g2.setEmail("jeff.test@yahoo.com");
		g2.setPassword("P4ssw0rd");
		
		a1.setActivityName("NAMLS Tier 1 Soccer");
		a2.setActivityName("Hamilton Play");
		
		a1.setActivityAddress("12345 Smith Ave");
		a2.setActivityAddress("44444 First Ave");
		
		a1.setContentOwner(c1);
		
		newDataBase.addCity(city1);
		
		newDataBase.addUser(g1);
		newDataBase.addUser(g2);
		
		newDataBase.addCreator(c1);
		
		newDataBase.addAdmin(admin1);
		*/
		newGUI = new WebPageGui(city1, newDataBase);

	}
}