package TheaterControllers;

import Model.User;
import TheaterView.Login_UI;
import TheaterView.Menu_UI;

import javax.swing.*;
import java.util.ArrayList;

public class LoginController {
	Login_UI loginView;
	Menu_UI menuView;
	ArrayList<User> usersDB;
	User currentUser;
	
	public LoginController(Login_UI loginWindow, Menu_UI menuWindow, ArrayList<User> userData) {
		loginView = loginWindow;
		menuView = menuWindow;
		loginView.setVisible(true);

		usersDB = userData;

		// 1. Login Button is pressed
		loginView.addLoginListener(e ->{

			// Get 2 arguments Username, Password
			String username = loginView.getUsernameInput();
			String password = loginView.getPasswordInput();
			
			// Backend logic stuffs.
			User u = new User(username, password);
			currentUser = checkUser(u);

			if (currentUser==null){
				JOptionPane.showMessageDialog(null, "Username or password is invalid.\nPlease try again", "LoginError" ,JOptionPane.PLAIN_MESSAGE);
				return;
			}
			
			// Prompt News
//			JOptionPane.showMessageDialog(null,"Movie Update: Spiderman No Way Home in Theaters on December 17th!!", "Latest News for Registered User!",JOptionPane.PLAIN_MESSAGE);
			
			// Removing the view
			loginView.setVisible(false);
			
			// Displaying Option UI
			menuView.setVisible(true);
			// Open new UI
			
		});
		
		// 2. Guest Button is pressed
		loginView.addGuestListener(e ->{
			//Backend stuffs where you set user to null or guest user
			currentUser = new User("guest", "guest");
			
			// Removing the view
			loginView.setVisible(false);
			
			// Displaying Option UI
			menuView.setVisible(true);
		});
		
		
	}


	public void setUsersDB(ArrayList<User> usersDB) {
		this.usersDB = usersDB;
	}

	private User checkUser(User user){
		for (User u: usersDB){
			if (u.equals(user)){
				return u;
			}
		}
		return null;
	}
}
