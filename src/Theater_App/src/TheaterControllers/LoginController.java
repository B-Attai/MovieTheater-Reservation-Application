package TheaterControllers;

import javax.swing.JOptionPane;

import TheaterView.Login_UI;
import TheaterView.Movie_UI;
import TheaterView.Menu_UI;

public class LoginController {
	Login_UI loginView;
	Menu_UI menuView;
	
	public LoginController(Login_UI loginwindow, Menu_UI menuwindow) {
		loginView = loginwindow;
		menuView = menuwindow;
		loginView.setVisible(true);

		// 1. Login Button is pressed
		loginView.addLoginListener(e ->{

			// Get 2 arguments Username, Passwowrd
			String username = loginView.getUsernameInput();
			String password = loginView.getPasswordInput();
			
			// Backend logic stuffs.
			
			// Prompt News
			JOptionPane.showMessageDialog(null,"Movie Update: Spiderman No Way Home in Theaters on December 17th!!", "Latest News for Registered User!",JOptionPane.PLAIN_MESSAGE);
			
			// Removing the view
			loginView.setVisible(false);
			
			// Displaying Option UI
			menuView.setVisible(true);
			// Open new UI
			
		});
		
		// 2. Guest Button is pressed
		loginView.addGuestListener(e ->{
			//Backend stuffs where you set user to null or guest user
			
			// Removing the view
			loginView.setVisible(false);
			
			// Displaying Option UI
			menuView.setVisible(true);
		});
		
		
	}
	

	

}
