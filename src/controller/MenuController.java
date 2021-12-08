package controller;

import view.Login_UI;
import view.Menu_UI;
import view.Movie_UI;
import view.Ticket_UI;

public class MenuController {
	private Login_UI loginView;
	private Menu_UI menuView;
	private Movie_UI movieView;
	private Ticket_UI ticketView;
	public MenuController(Login_UI loginwindow, Menu_UI menuwindow, Movie_UI moviewindow, Ticket_UI ticketwindow) {
		
		loginView = loginwindow;
		menuView = menuwindow;
		movieView = moviewindow;
		ticketView = ticketwindow;
		
		menuView.addLoginListener(e ->{

			// Removing the view
			menuView.setVisible(false);
			loginView.clearall();
			// Open new UI
			loginView.setVisible(true);
			
		});
		
		menuView.addMovieListener(e ->{
			menuView.setVisible(false);
			movieView.setVisible(true);
			// Open new UI
			
		});
		
		menuView.addRefundListener(e ->{
			// Removing the view
			menuView.setVisible(false);
			// Displaying UI
			ticketView.setVisible(true);
			ticketView.requestRefundButton.setVisible(true);
			
		});
	}

}
