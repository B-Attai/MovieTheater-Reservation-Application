package controller;

import model.User;
import view.Login_UI;
import view.Menu_UI;

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
//			showAnnouncement(currentUser);

			if (currentUser==null){
				JOptionPane.showMessageDialog(null, "Username or password is invalid.\nPlease try again", "LoginError" ,JOptionPane.PLAIN_MESSAGE);
				return;
			}
			
			if(currentUser.getUserType().equals("Registered")) {
				if( currentUser.isAnnualFee() == true) {
					
					JOptionPane.showMessageDialog(null, "You have not paid your membership fees, 20$ will be added to your receipt. For cancellation, please email customer service!", "Membership Fees" ,JOptionPane.PLAIN_MESSAGE);
				}
			}
			
			// Prompt News
			JOptionPane.showMessageDialog(null,"Movie Update: Home Alone in Theaters on December 25!!", "Latest News for Registered User!",JOptionPane.PLAIN_MESSAGE);
			
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

//	public void showAnnouncement(User user){
//		if(user!= null)
//			JOptionPane.showMessageDialog(null, "There is a new movie, you can purchase now!", "Announcement!" ,JOptionPane.PLAIN_MESSAGE);
//	}


	public void setUsersDB(ArrayList<User> usersDB) {
		this.usersDB = usersDB;
	}

	public User getCurrentUser() {
		return currentUser;
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
