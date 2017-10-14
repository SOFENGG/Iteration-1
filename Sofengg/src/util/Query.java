package util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Database;
import model.User;

public class Query {
	private static Query instance = new Query();
	
	private Query(){
		
	}
	
	public static Query getInstance(){
		return instance;
	}
	
	//handles user related queries
	public ArrayList<User> userQuery(String query){
		ArrayList<User> users = new ArrayList<User>();
		ResultSet rs = Database.getInstance().query(query);
		
		try {
			while(rs.next()){
				User user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
				users.add(user);
			}
			Database.getInstance().queryClose();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}
	
	//add more query for each class
}
