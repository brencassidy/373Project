package org.people;

import org.places.Activities;

/*
 * Author: Khas-Ochir Sod-Erdene
 * Description:
 * 		This class will allow the generic user to write a review, leave a comment. 
 */

public class GenericUser extends Person{
	
	
	/*
	 * TODO: implement
	 * addComment:
	 * 		Will allow a user to add a comment to a activity page.
	 * 
	 * Inputs:
	 * 	comment: the comment the user wishes to add
	 * 	thisActivity: the page at which we must add the comment to.
	 */
	public void addComment(String comment, Activities thisActivity){
			thisActivity.getCommentList().add(comment);
	}
	 
	/*
	 * TODO: implement
	 * addRating:
	 * 		Will add to the current ratings of the Activities
	 */
	public void addRating(Double newOverallRating, Double newFoodRating, Double newPriceRating, Activities thisActivity){		
		thisActivity.addOverallRating(newOverallRating);
		thisActivity.addFoodRating(newFoodRating);
		thisActivity.addPriceRating(newPriceRating);
		thisActivity.calcNewRating(newOverallRating, newFoodRating, newPriceRating); //calculate the ratings everytime new rating added
	}
}