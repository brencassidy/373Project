package org.people;

import org.places.Activities;
import org.places.City;
import org.places.DataBase;

/*
 * Author: Brendan Cassidy
 * Description:
 * 	
 * 
 */

public class Admin extends Person{
	 
	private DataBase base1;
	
	public Admin(){}
	/*
	 * TODO: Implement
	 * 
	 * Function will represent a total reset of the system clearing all pages, comments, ratings
	 * 	will not delete users though.
	 * The clear function will clear all the event data related in that city, we need to clear one by one for security.
	 */
	public void clearAll(City c1){

		for(int i=0;i<base1.getCities().size();i++){
			if(base1.getCities().get(i).getCityName().equals(c1.getCityName())){
				base1.getCities().get(i).getActivities().clear();
				break;
			}
			
		}
	}
	
	/*
	 * TODO: Implement
	 * 
	 * Function will all the admin to delete a specific user account.
	 * Inputs:
	 * 		GenericUser : user -> represents the user to be deleted
	 */
	public void deleteUser(GenericUser user){
		
		//for(int i=0;i<base1.getUsers().size();i++)
		//{
			//if(base1.getUsers().get(i).equals(user)){
				//base1.getUsers().remove(i);
		//	}	
		//}
		base1.getUsers().remove(user);
	}
	
	/*
	 * TODO: Implement
	 * 
	 * Function will allow the admin to create the generic newPage
	 * 
	 * Inputs:
	 * 		String : newPage -> is to be used to set the title of the new page 
	 * 		cityName specifies the city to add the event
	 */
	public void addEvent(String newPage, String cityName){
		//find the city it related to
		int i=0,j=0,a=0;
		for(i=0; i<base1.getCities().size();i++){
			if(base1.getCities().get(i).getCityName().equals(cityName)){
				break;
			}
			
		}
		//check if same event exist with the same title
		for(j=0;j<base1.getCities().get(i).getActivities().size();j++){
			if(base1.getCities().get(i).getActivities().get(j).getActivityName().equals(newPage)){
				a=1;
				break;
			}
			
		}
		
		//add the event to the activities to the right city
		if(a==1){  //add the event 
			Activities e1= new Activities(newPage, "unknown", null);
			base1.getCities().get(i).getActivities().add(e1);
			
		}
		else{  //print the error message
			System.out.println("An event with the same name already exist");
			
		}
		
	}
	
	/*
	 * TODO: Implement
	 * 
	 * Method will be used to delete a comment that is deemed inappropriate by the 
	 * admin.
	 * Inputs:
	 * 		-Have not decided how this will be handled but most likely will need to be given the 
	 * 		String tobedeleted and the List/Activity that the comment resides
	 * 
	 */
	public void deleteComment(String oldComment, Activities aActivity){
		aActivity.getCommentList().remove(oldComment);
	}
}