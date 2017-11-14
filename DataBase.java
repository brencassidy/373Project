package org.places;

import java.util.ArrayList;

import org.people.*;


public class DataBase {
	
private ArrayList<City> cities;
private ArrayList<GenericUser> users;
private ArrayList<ContentCreator> creators;

public DataBase(){
	
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
}
