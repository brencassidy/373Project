package org.people;

/*
 * Author: Brendan Cassidy
 * Description:
 * 	Class Person will be the super class of GenericUser, Content Creator, Admin
 * 		for the GUI User.
 * 
 */


public class Person {
	private String name;
	private String eMail;
	private String password; //Should set restrictions 1 Cap, 1 lowercase, 1 number, min 6 chars, max 30
	
	public Person(){
		name = "John Doe";
		eMail = "johndoe@test.com";
		password = "ThisIsV4lid";
	}
	public void setPerson(String _name, String _eMail, String _password){
		name=_name;
		eMail=_eMail;
		password=_password;
		
	}
	public Person(String _name, String _eMail, String _password){
		name=_name;
		eMail=_eMail;
		password=_password;
		
	}
	/*
	 * createUser:
	 * 			User will click create user, should enter info, if user is not in 
	 * 				population then we will create the user here.
	 * Inputs:
	 * 		String : _name
	 * 		String : _eMail
	 * 		String : _password
	 */
	public void createUser(String _name, String _eMail, String _password) {
		name = _name;
		eMail = _eMail;
		boolean checkValid = false;
		//Check valid password
		while(checkValid == false){
			//TODO: call checkValidPassword
			if(checkValid == true){
				password = _password;
			}
			//else prompt for new password
		}
	}
	
	/*
	 * TODO: Implement
	 * 
	 * checkValidPassword:
	 * 		Make sure password contains 1 Cap letter, 1 lowercase, 1 number, 6-30 Chars 
	 * Inputs:
	 * 		String : testPassword
	 * Outputs:
	 * 		If Password is NOT valid we must return false, and provide error message with the problem
	 * 		If Password is valid function returns true.
	 */
	public boolean checkValidPassword(String testPassword) {
		char c = testPassword.charAt(0); 		//If first digit is lower case it looks for upper and vice-versa
		if(testPassword.length() < 5 || testPassword.length() > 31) {
			return false;
		}
		
        else if (!(Character.isLowerCase(c))) {
            boolean test_ = false;
        	for (int i = 1; i < testPassword.length(); i++) {
                char l = testPassword.charAt(i);
                if (!Character.isLowerCase(l)) {  
                	test_ = false;
                }
                else{
                	test_ = true;
                }
            }
            return test_;
        }
        else if (!(Character.isUpperCase(c))) {
            boolean test = false;
        	for (int i = 0; i < testPassword.length(); i++) {       
                char u = testPassword.charAt(i);
                if (!Character.isUpperCase(u)) {
                   test = false;
                }
                else{
                	test = true;
                }
            }
            return test;
        }
		return true;
	}

	/*
	 * Below are necessary setters and getters
	 * 
	 */
	public void setName(String _name){
		name = _name;
	}
	
	public void setEmail(String _eMail){
		eMail = _eMail;
	}
	
	public void setPassword(String _password){
		password = _password;
		//boolean checkValid = false;
		//while(checkValid == false){
			//TODO: Call the checkValidPassword
		//	if(checkValid == true){
		//		return;
		//	}
		//	return;
			//else request new password
		//}
	}
	
	public String getName(){
		return name;
	}
	
	public String getEmail(){
		return eMail;
	}
	
	public String getPassword(){
		return password;
	}
	
	
	
	
	
	
	
	
	
	
	
}