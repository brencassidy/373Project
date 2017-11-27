package org.people;

import org.places.Activities;

/*
 * Author: Brendan Cassidy
 * Description:
 * 	
 * 
 */

public class ContentCreator extends Person{

	/*
	 * TODO: Implement
	 * We need to pass the related activity to let the creator to edit the description
	 * This method must be used to add a description to a webpage (or edit an exsisting)
	 */
	public void addDescription(String newDescription, Activities A1){
		A1.setActivityDescription(newDescription);
		
	}
}