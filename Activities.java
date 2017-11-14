package org.places;

import java.util.ArrayList;

import org.people.Person;

/*
 * Author: Brendan Cassidy
 * Description:
 * 	Class Activities will hold info regarding each specified activity, including but not 
 * 		limited to contentCreator, name, address, rating, comment list displayed on the GUI page.
 * 
 */

public class Activities {
	private ArrayList<String> commentList;
	private Person contentOwner;
	private String activityName;
	private String activityDescription;
	private String activityAddress;
	private Double overallRating;
	private Double foodRating;
	private Double priceRating;
	
	/*
	 * Contstructor Usage:
	 * 		Generally the overloaded constructor should be called by an admin that creates
	 * 		a new page.  In doing so he will create a new ContentCreator with generic credentials.
	 * 		The contentCreator should then change these credentials (implied that the admin will 
	 * 		give the defaults to this creator.
	 * 
	 */
	public Activities(){
		setContentOwner(null);
		activityName 	= "notRealActivity";
		activityAddress = "12345 2nd Ave";
		activityDescription = "null";
	}
	
	public Activities(String _activityName, String _activityAddress, Person _contentCreator){
		activityName 	= _activityName;
		activityAddress =_activityAddress;
		setContentOwner(_contentCreator);
		overallRating 	= (double) -1;
		foodRating 		= (double) -1;
		priceRating 	= (double) -1;
	}
	
	
	/*
	 * TODO: implement 
	 * calcNewRating:
	 * 		Based on the new rating created we need to recalculate the rating for each
	 * 		category.		
	 * Inputs:
	 * 		newOverallRating : new OverallRating score to add
	 * 		newFoodRating	 : new FoodRating score to add
	 * 		newPriceRating   : new PriceRating score to add
	 */
	public void calcNewRating(Double newOverallRating, Double newFoodRating, Double newPriceRating){
		
	}
	
	//Setters and getters needed
	public void setActivityName(String newActName){
		activityName = newActName;
	}
	
	public void setActivityAddress(String newActAddress){
		activityAddress = newActAddress;
	}
	
	public String getActivityName(){
		return activityName;
	}
	
	public String getActivityAddress(){
		return activityAddress;
	}
	
	public Double getOverallRating(){
		return overallRating;
	}
	
	public Double getFoodRating(){
		return foodRating;
	}
	
	public Double getPriceRating(){
		return priceRating;
	}

	public Person getContentOwner() {
		return contentOwner;
	}

	public void setContentOwner(Person contentOwner) {
		this.contentOwner = contentOwner;
	}

	public ArrayList<String> getCommentList() {
		return commentList;
	}

	public void setCommentList(ArrayList<String> commentList) {
		this.commentList = commentList;
	}

	public String getActivityDescription() {
		return activityDescription;
	}

	public void setActivityDescription(String activityDescription) {
		this.activityDescription = activityDescription;
	}

	public void addOverallRating(Double o1) {
		// TODO Auto-generated method stub
		
	}

	public void addFoodRating(Double f1) {
		// TODO Auto-generated method stub
		
	}

	public void addPriceRating(Double p1) {
		// TODO Auto-generated method stub
		
	}
}
