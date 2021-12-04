package App;
import TheaterControllers.*;
import TheaterView.*;

public class GUIApp {
	
	public static void main(String[] args) {
				
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
		
		// Creating Models
		
		
		// Creating Controllers (NOTE BACKEND PEOPLE NEED TO PASS IN MODEL AS WELL, FOR NOW JUST PASSING IN UI to TEST UI LOGIC)
		LoginController logincontroller = new LoginController(loginWindow, menuWindow);
		MovieController moviecontroller = new MovieController(movieWindow, ticketWindow);
		MenuController menucontroller = new MenuController(loginWindow, menuWindow, movieWindow, ticketWindow);
		RefundController refundcontroller = new RefundController(ticketWindow);
		TicketController ticketcontroller = new TicketController(ticketWindow);
		
		
	}

}
