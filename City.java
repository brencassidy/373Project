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
	private ArrayList<Person> population = new ArrayList<Person>();
	private ArrayList<Activities> activities = new ArrayList<Activities>();
	private String cityName;
	
	public City(){
		setCityName("unnamedCity");
	}
	
	public City(String _cityName){
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
	
	public void addingNewUser(Person p1)
	{
		ArrayList<Person> popList = this.population;
		boolean goodUser = true;
		try {
			for(Person p: popList)
			{
				if(p.getEmail().equals(p1.getEmail()))
				{
					System.out.println("Bad user");
					goodUser = false;
				}
			}
		}catch(Exception e)
		{
			
		}
		if(goodUser == true)
		{
			System.out.println("Good user, adding to population");
			population.add(p1);
		}
			
	}
	public void addingNewUser(String _name, String _eMail, String _password){
		
		ArrayList<Person> popList = this.population;
		boolean goodUser = true;
		
		for(Person p: popList)
		{
			if(p.getEmail().equals(_eMail))
			{
				goodUser = false;
			}
		}
		
		if(goodUser == true)
		{
			Person p1 = new Person();
			p1.setEmail(_eMail);
			p1.setName(_name);
			p1.setPassword(_password);
			this.population.add(p1);
		}
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
		ArrayList<Activities> actList = this.activities;
		
		for(Activities a1: actList)
		{
			if(a1.getActivityName().equals(activityName))
			{
				return a1;
			}
		}
		return null;
	}

	public void addActivity(Activities a1){
		activities.add(a1);
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
	
	public void addActivities(Activities activity)
	{
		this.activities.add(activity);
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
}