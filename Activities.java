package org.places;

import java.util.ArrayList;

import org.people.Person;

/*
 * Author: Brendan Cassidy/Daniel Peters
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
	private String type;
	private ArrayList<Double> overallRating = new ArrayList<Double>();
	private ArrayList<Double> foodRating = new ArrayList<Double>();
	private ArrayList<Double> priceRating = new ArrayList<Double>();
	private double newOverallRating;
	private double newFoodRating;
	private double newPriceRating;
	
	/*
	 * Constructor Usage:
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
		type = "NotAType";
	}
	
	
	public Activities(String _activityName, String _activityAddress, Person _contentCreator){
		activityName 	= _activityName;
		activityAddress =_activityAddress;
		setContentOwner(_contentCreator);
		newOverallRating = (double) -1;
		newFoodRating = (double) -1;
		newPriceRating = (double) -1;
//		overallRating 	= (Double) -1;
//		foodRating 		= (Double) -1;
//		priceRating 	= (Double) -1;
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
	public void calcNewRating(double newOverallRating, double newFoodRating, double newPriceRating){
		overallRating.add(newOverallRating);
		foodRating.add(newFoodRating);
		priceRating.add(newPriceRating);
		
		double overallRate = 0;
		double foodRate = 0;
		double priceRate = 0;
		
		for(double d: overallRating)
		{
			overallRate += d;
		}
		
		for(double d: foodRating)
		{
			foodRate += d;
		}
		
		for(double d: priceRating)
		{
			priceRate += d;
		}
		
		this.newOverallRating = (double) (overallRate/overallRating.size());
		this.newFoodRating = (double) (foodRate/foodRating.size());
		this.newPriceRating = (double) (priceRate/priceRating.size());
		
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
	
	public double getOverallRating(){
		return newOverallRating;
	}
	
	public double getFoodRating(){
		return newFoodRating;
	}
	
	public double getPriceRating(){
		return newPriceRating;
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
	
	public void setType(String type)
	{
		this.type = type;
	}
	
	public String getType()
	{
		return this.type;
	}
	
	public ArrayList<Double> getOverallList()
	{
		return this.overallRating;
	}
	
	public ArrayList<Double> getFoodList()
	{
		return this.foodRating;
	}
	
	public ArrayList<Double> getPriceList()
	{
		return this.priceRating;
	}


	public void addFoodRating(Double newFoodRating) {
		foodRating.add(newFoodRating);
	}
	
	public void addPriceRating(Double newPriceRating){
		priceRating.add(newPriceRating);
	}
	
	public void addOverallRating(Double newOverall){
		overallRating.add(newOverall);
	}
	

}