package org.places;

import java.util.ArrayList;

import org.people.*;


public class DataBase {
	
	private ArrayList<City> cities = new ArrayList<City>();
	private ArrayList<GenericUser> users = new ArrayList<GenericUser>();
	private ArrayList<ContentCreator> creators = new ArrayList<ContentCreator>();
	private ArrayList<Admin> admins = new ArrayList<Admin>();

	public DataBase(){
		
	}
	
	public void addCity(City city){
		cities.add(city);
	}
	
	public void addUser(GenericUser user){
		users.add(user);
	}
	
	public void addCreator(ContentCreator creator){
		creators.add(creator);
	}
	
	public void addAdmin(Admin a){
		admins.add(a);
	}
	
	public ArrayList<City> getCities(){
		
		return cities;
	}
	public ArrayList<GenericUser> getUsers(){
		
		return users;
	}
	
	public ArrayList<ContentCreator> getCreator(){
		
		return creators;
	}
	
	public ArrayList<Admin> getAdmins(){
		return admins;
	}
	
	public City findCityObj(String CityName){
		for(City c: cities){
			if(CityName == c.getCityName()){
				return c;
			}
		}
		return null;
	}
	//Return a list to be added to a text window for all active users
	public String printUsers(){
		String listUsers = null;
		for(GenericUser g : users){
			listUsers += g.getName() + " \n";
		}
		return listUsers;
	}
	public String printCreators(){
		String listUsers = null;
		for(ContentCreator g : creators){
			listUsers += g.getName() + " \n";
		}
		return listUsers;
	}
	public String printAdmins(){
		String listUsers = null;
		for(Admin g : admins){
			listUsers += g.getName() + " \n";
		}
		return listUsers;
	}
	
	public String printActivities(){
		String listActivities = null;
		for(City c : cities){
			for(Activities a : c.getActivities()){
				listActivities += a.getActivityName() + " \n";
			}
		}
		return listActivities;
	}

		
	public String printCities() {
		String listCities = null;
		for(City c : cities){
			listCities += c.getCityName() + " \n";
		}
		return listCities;
	}
}