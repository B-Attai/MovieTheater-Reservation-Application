package app;

import controller.*;
import view.Login_UI;
import view.Menu_UI;
import view.Movie_UI;
import view.Ticket_UI;
import dataBase.DataBase;

public class GUIApp {
	
	public static void main(String[] args) {

		DataBase theaterDatabase = new DataBase();
				
		// Creating UI's
		Login_UI loginWindow = new Login_UI();
		loginWindow.setVisible(true);

		Movie_UI movieWindow = new Movie_UI();
		// Visibility of this should be set after login is done
		movieWindow.setVisible(false);
		Ticket_UI ticketWindow = new Ticket_UI();
		ticketWindow.setVisible(false);
		
		Menu_UI menuWindow = new Menu_UI();
		menuWindow.setVisible(false);



		
		// Creating Controllers (NOTE BACKEND PEOPLE NEED TO PASS IN MODEL AS WELL, FOR NOW JUST PASSING IN UI to TEST UI LOGIC)
		LoginController logincontroller = new LoginController(loginWindow, menuWindow, theaterDatabase.getUsers());
		TicketController ticketcontroller = new TicketController(ticketWindow, theaterDatabase.getTickets());
		MovieController moviecontroller = new MovieController(movieWindow, ticketWindow, theaterDatabase.getMovies(), logincontroller, ticketcontroller);


		MenuController menucontroller = new MenuController(loginWindow, menuWindow, movieWindow, ticketWindow);
		RefundController refundcontroller = new RefundController(ticketWindow, theaterDatabase.getTickets());
//		TicketController ticketcontroller = new TicketController(ticketWindow, theaterDatabase.getTickets());
		
		
	}

}
