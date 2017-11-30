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
		Activities a3 = new Activities();
		Activities a4 = new Activities();
		Activities a5 = new Activities();
		Activities a6 = new Activities();
		Activities a7 = new Activities();
		Activities a8 = new Activities();
		
		Admin admin1 = new Admin();
		
		GenericUser g1 = new GenericUser();
		GenericUser g2 = new GenericUser();
		GenericUser g3 = new GenericUser();
		GenericUser g4 = new GenericUser();
		GenericUser g5 = new GenericUser();
		GenericUser g6 = new GenericUser();
		GenericUser g7 = new GenericUser();
		GenericUser g8 = new GenericUser();
		
		ContentCreator c1 = new ContentCreator();
		ContentCreator c2 = new ContentCreator();
		ContentCreator c3 = new ContentCreator();
		ContentCreator c4 = new ContentCreator();
		
		//Create Admins
		admin1.setName("Todd");
		admin1.setEmail("admin@admin.com");
		admin1.setPassword("P4ssw0rd");		//Need to check the CheckPassword implementation.

		//Create genericUsers
		g1.setName("Bob");
		g1.setEmail("bob.test@gmail.com");
		g1.setPassword("P4ssw0rd");

		g2.setName("Jeff");
		g2.setEmail("jeff.test@yahoo.com");
		g2.setPassword("P4ssw0rd");

		g3.setName("Daniel");
		g3.setEmail("dp@email.com");
		g3.setPassword("P4ssw0rd");
		
		g4.setName("Amanda");
		g4.setEmail("amanda@gmail.com");
		g4.setPassword("P4ssw0rd");

		g5.setName("Taylor");
		g5.setEmail("tTest@yahoo.com");
		g5.setPassword("P4ssw0rd");

		g6.setName("Eric");
		g6.setEmail("Eric.example@email.com");
		g6.setPassword("P4ssw0rd");
		
		g5.setName("Ariella");
		g5.setEmail("aLee@aol.com");
		g5.setPassword("P4ssw0rd");

		g6.setName("Zach");
		g6.setEmail("ZCraft@email.com");
		g6.setPassword("P4ssw0rd");
		
		g7.setName("Max");
		g7.setEmail("Max@aol.com");
		g7.setPassword("P4ssw0rd");

		g8.setName("Matt");
		g8.setEmail("mArmell@email.com");
		g8.setPassword("P4ssw0rd");
		
		//Create ContentCreators
		c1.setName("Sean");
		c1.setEmail("seanUA@yahoo.com");
		c1.setPassword("C0ntent");

		c2.setName("Kyle");
		c2.setEmail("Kyle@email.com");
		c2.setPassword("C0ntent");
		
		c3.setName("Brendan");
		c3.setEmail("Brendan@aol.com");
		c3.setPassword("C0ntent");

		c4.setName("Khas");
		c4.setEmail("Khas@email.com");
		c4.setPassword("C0ntent");
		
		//Create Activities
		a1.setActivityName("Arizona Wildcat Basketball");
		a2.setActivityName("University of Arizona Dance");
		a3.setActivityName("Saguaro National Park");
		a4.setActivityName("Pima Air & Space Museum");
		a5.setActivityName("Reid Park Zoo");
		a6.setActivityName("Tohono Chul Park");
		a7.setActivityName("Old Tucson Studios");
		a8.setActivityName("Kitt Peak National Observatory");

		a1.setActivityAddress("1721 E Enke Dr, Tucson, AZ 85721");
		a2.setActivityAddress("44444 First Ave");
		a3.setActivityAddress("10950 West Rudasill Road");
		a4.setActivityAddress("West Lizard Lane");
		a5.setActivityAddress("12345 NE Main");
		a6.setActivityAddress("64234 Woodhollow Lane");
		a7.setActivityAddress("26789 Westwood Ave");
		a8.setActivityAddress("43578 Cambell Road");
		
		a1.setActivityDescription("The University of Arizona basketball team competes yearly for PAC-12 Championships.  One of the largest attractions"
				+ " for the city of Tucson getting a ticket is no small feat but well worth it.");
		a2.setActivityDescription("One of the most prestigious Dance crews on the West Coast, they students put on weekly shows as a small way to give"
				+ " back to such a wonderful town.");
		a3.setActivityDescription("he giant saguaro is the universal symbol of the American west. These majestic plants, found only in a small portion"
				+ " of the United States, are protected by Saguaro National Park, to the east and west of the modern city of Tucson. Here you have a "
				+ " chance to see these enormous cacti, silhouetted by the beauty of a magnificent desert sunset.");
		a4.setActivityDescription("The Pima Air & Space Museum is one of the largest non-government funded aviation and space museums in the world! "
				+ " Featuring over 350 historical aircrafts, from a Wright Flyer to a 787 Dreamliner.");
		a5.setActivityDescription("Animals tend to be most active and visitor attendance tends to be lowest early in the morning and just prior to closing.");
		a6.setActivityDescription("Tohono Chul (aka Tohono Chul Park) is a botanical garden, nature preserve and cultural museum located in Casas Adobes,"
				+ " a suburb of Tucson, Arizona.");
		a7.setActivityDescription("Old Tucson is a movie studio and theme park just west of Tucson, Arizona, adjacent to the Tucson Mountains and close"
				+ " to the western portion of Saguaro National Park.");
		a8.setActivityDescription("With 24 optical and two radio telescopes, it is the largest, most diverse gathering of astronomical instruments in"
				+ " the world. The observatory is administered by the National Optical Astronomy Observatory (NOAO).");

		a1.setContentOwner(c1);
		a2.setContentOwner(c1);
		a3.setContentOwner(c2);
		a4.setContentOwner(c2);
		a5.setContentOwner(c3);
		a6.setContentOwner(c3);
		a7.setContentOwner(c4);
		a8.setContentOwner(c4);
		
		a1.calcNewRating(3.0, 3.5, 3.5);
        a2.calcNewRating(3.0, 3.5, 3.5);
        a3.calcNewRating(3.0, 3.5, 3.5);
        a4.calcNewRating(3.0, 3.5, 3.5);
        a5.calcNewRating(3.0, 3.5, 3.5);
        a6.calcNewRating(3.0, 3.5, 3.5);
        a7.calcNewRating(3.0, 3.5, 3.5);
        a8.calcNewRating(3.0, 3.5, 3.5);

		a1.addComment("Nice place and comfortable");
        a1.addComment("Slow but worth it");
        a2.addComment("Close to the bus stop");
        a3.addComment("Classy but old");
        a4.addComment("The smell is comfy and the owner is friendly");
        a5.addComment("Cheap place to hang out");
        a6.addComment("Haunted place for you");
        a7.addComment("If your girl can't decide where to go. Don't choose this palce");
        a8.addComment("Chill place to be social");

		
		//Add all activities to the correct City
		city1.setCityName("Tucson");
		city1.addActivity(a1);
		city1.addActivity(a2);
		city1.addActivity(a3);
		city1.addActivity(a4);
		city1.addActivity(a5);
		city1.addActivity(a6);
		city1.addActivity(a7);
		city1.addActivity(a8);
		
		//Add all Created Objects to the DB
		newDataBase.addCity(city1);

		newDataBase.addUser(g1);
		newDataBase.addUser(g2);
		newDataBase.addUser(g3);
		newDataBase.addUser(g4);
		newDataBase.addUser(g5);
		newDataBase.addUser(g6);
		newDataBase.addUser(g7);
		newDataBase.addUser(g8);
		

		newDataBase.addCreator(c1);
		newDataBase.addCreator(c2);
		newDataBase.addCreator(c3);
		newDataBase.addCreator(c4);
		
		newDataBase.addAdmin(admin1);

		
		newGUI = new WebPageGui(newDataBase);

	}
}