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
		admin1.setName("Todd");
		admin1.setEmail("admin@admin.com");
		admin1.setPassword("P4ssw0rd");		//Need to check the CheckPassword implementation.

		g1.setName("Bob");
		g1.setEmail("bob.test@gmail.com");
		g1.setPassword("P4ssw0rd");

		g2.setName("Jeff");
		g2.setEmail("jeff.test@yahoo.com");
		g2.setPassword("P4ssw0rd");

		a1.setActivityName("Arizona Wildcat Basketball");
		a2.setActivityName("University of Arizona Dance");

		a1.setActivityAddress("1721 E Enke Dr, Tucson, AZ 85721");
		a2.setActivityAddress("44444 First Ave");
		
		a1.setActivityDescription("The University of Arizona basketball team competes yearly for PAC-12 Championships.  One of the largest attractions"
				+ " for the city of Tucson getting a ticket is no small feat but well worth it.");
		a2.setActivityDescription("One of the most prestigious Dance crews on the West Coast, they students put on weekly shows as a small way to give"
				+ " back to such a wonderful town.");

		a1.setContentOwner(c1);

		city1.setCityName("Tucson");
		city1.addActivity(a1);
		city1.addActivity(a2);

		newDataBase.addCity(city1);

		newDataBase.addUser(g1);
		newDataBase.addUser(g2);

		newDataBase.addCreator(c1);

		newDataBase.addAdmin(admin1);

		
		newGUI = new WebPageGui(newDataBase);

	}
}