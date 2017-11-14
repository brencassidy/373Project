package org.places;

import java.util.ArrayList;

import org.people.*;


public class DataBase {
	
	private ArrayList<City> cities;
	private ArrayList<GenericUser> users;
	private ArrayList<ContentCreator> creators;
	private ArrayList<Admin> admins;

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
}