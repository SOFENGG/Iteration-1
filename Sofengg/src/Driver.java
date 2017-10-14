import java.util.ArrayList;
import java.util.Scanner;

import model.Database;
import model.User;
import util.Query;
import util.Service;

public class Driver {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		boolean isLoggedIn = false;
		String user, pass;
		
		do{
			System.out.print("enter username: ");
			user = sc.nextLine();
			System.out.print("enter password: ");
			pass = sc.nextLine();
			
			User u = Service.logIn(user, pass);
			
			if(u != null){
				isLoggedIn = true;
				if (u.getAccessLevel() == 1)
					System.out.println("Welcome back manager " + u.getName());
				else if (u.getAccessLevel() == 2)
					System.out.println("Welcome back cashier " + u.getName());
			}else{
				System.out.println("log in failed");
			}
			
		}while(!isLoggedIn);
		
		Database.getInstance().close();
	}
}
