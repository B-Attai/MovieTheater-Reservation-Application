package App;
import TheaterView.*;
import TheaterControllers.*;

public class TheaterApp {
	
	public static void main(String args[]) {
				
		// Creating UI's
		Login_UI loginwindow = new Login_UI();
		loginwindow.setVisible(true);

		Movie_UI moviewindow = new Movie_UI();
		// Visibility of this should be set after login is done
		moviewindow.setVisible(false);
		Ticket_UI ticketwindow = new Ticket_UI();
		ticketwindow.setVisible(false);
		
		Menu_UI menuwindow = new Menu_UI();
		menuwindow.setVisible(false);
		
		// Creating Models
		
		
		// Creating Controllers (NOTE BACKEND PEOPLE NEED TO PASS IN MODEL AS WELL, FOR NOW JUST PASSING IN UI to TEST UI LOGIC)
		LoginController logincontroller = new LoginController(loginwindow, menuwindow);
		MovieController moviecontroller = new MovieController(moviewindow, ticketwindow);
		MenuController menucontroller = new MenuController(loginwindow, menuwindow, moviewindow, ticketwindow);
		RefundController refundcontroller = new RefundController(ticketwindow);
		TicketController ticketcontroller = new TicketController(ticketwindow);
		
		
	}

}
