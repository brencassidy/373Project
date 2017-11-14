package org.places;

import java.util.ArrayList;

import org.people.*;
import org.places.Activities;
/*
 * Author: Brendan Cassidy
 * Description:
 * 	Class City will represent the city and contain its activities and population
 * 		for the GUI.
 * 
 */
public class City {
	private ArrayList<Person> population;
	private ArrayList<Activities> activities;
	private String cityName;
	
	public City(){
		setCityName("unnamedCity");
	}
	
	City(String _cityName){
		setCityName(_cityName);
	}
	
	/*
	 * TODO: 
	 * 
	 * addingNewUser:
	 * 		After clicking on NewUser icon newPerson can be created
	 * 		as long as that eMail is not currently registered. 
	 * Inputs:
	 * 		String : _name -> will be Persons name attribute
	 * 		String : _eMail -> check that this is not already in the population, 
	 * 							then use this as Persons eMail attribute.
	 * 		String : _password -> will be Persons password attribute assuming it is valid.
	 * 
	 */
	public void addingNewUser(String _name, String _eMail, String _password){
		
	}
	
	
	/*
	 * TODO: create a SearchForActivity?
	 * 
	 * searchForActivity:
	 * 		If a user knows the activity they are looking for there should be a search bar 
	 * 			that can accept a string and search the activities in that city and provide
	 * 			the specified page or an error if it does not exist
	 */
	public Activities searchForActivity(String activityName){
		return null;
	}

	public ArrayList<Person> getPopulation() {
		return population;
	}

	public void setPopulation(ArrayList<Person> population) {
		this.population = population;
	}

	public ArrayList<Activities> getActivities() {
		return activities;
	}

	public void setActivities(ArrayList<Activities> activities) {
		this.activities = activities;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
}
