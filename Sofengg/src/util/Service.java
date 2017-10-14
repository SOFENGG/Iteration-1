package util;

import java.util.ArrayList;

import model.User;

public class Service {
	
	//assume logging in will only return one user 
	public static User logIn(String user, String pass){
		ArrayList<User> users = Query.getInstance().userQuery("select * from users where username = '"+user+"' and password = '"+pass+"';");
		
		if(users.size() > 0)
			//log in success
			return users.get(0);
		else
			return null;
		
	}
	
}
