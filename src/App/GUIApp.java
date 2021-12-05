package App;

import Model.Movie;
import Model.RegisteredUser;
import Model.User;
import TheaterControllers.*;
import TheaterView.Login_UI;
import TheaterView.Menu_UI;
import TheaterView.Movie_UI;
import TheaterView.Ticket_UI;
import dataBase.DataBase;

import java.util.ArrayList;

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
		ArrayList<User> userList = new ArrayList<User>();
		userList.add(new RegisteredUser("Amir", "123", "123", "123"));
		LoginController logincontroller = new LoginController(loginWindow, menuWindow, userList);


		ArrayList<User> movieList = new ArrayList<Movie>();
		movieList.add(new Movie());
		MovieController moviecontroller = new MovieController(movieWindow, ticketWindow);


		MenuController menucontroller = new MenuController(loginWindow, menuWindow, movieWindow, ticketWindow);
		RefundController refundcontroller = new RefundController(ticketWindow);
		TicketController ticketcontroller = new TicketController(ticketWindow);
		
		
	}

}
