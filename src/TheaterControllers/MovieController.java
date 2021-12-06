package TheaterControllers;

import Model.Movie;
import Model.Theater;
import TheaterView.Movie_UI;
import TheaterView.Ticket_UI;

import javax.swing.*;
import java.util.ArrayList;

public class MovieController {
	private Movie_UI view;
	private Ticket_UI nextview;
	private ArrayList<Movie> movieDB;
	private Theater theater;

	private String showtimestring;
	
	public MovieController(Movie_UI mainWindow, Ticket_UI ticketWindow, ArrayList<Movie> movieDB, Theater theater) {
		view = mainWindow;
		nextview = ticketWindow;
		this.movieDB = movieDB;
		this.theater = theater;
		// ---------------------------------- First View -----------------------------------------------//
		// If Search is press (from first view)
		/*
		 * 1. Get movie name 
		 * 2. Create the SQL query and call movie class to find that movie
		 * 3. Create an Arraylist of possible movies from movie list (should just be 1 in our case)
		 * 4. Set View to display that arraylist 
		 */
		view.addSearchListener(e ->{

			System.out.println("Search Movie pressed");
			// Get 2 arguments Username, Passwowrd
			String movie = view.getMovienameInput();
			System.out.println(movie);
			
			// Backend logic stuffs.

			// Create SQL Query or pass movie name to movie. Get a list of possible movies
			
			//1. Update Jlist for displaying movies:
			// i.e. ArrayList<movie> movies = new ArrayList<movie>(); 
			//2. update this list from query/movie class/model
			
			//3. Set Jlist i.e.:
			DefaultListModel<Movie> model = new DefaultListModel<>();
			for (Movie m:findMovies(movie)){
				model.addElement(m);
			}
			view.movielist.setModel(model);


		});
		
		// ---------------------------------- 2nd View -----------------------------------------------//
		// If Confirm Selection From first page is clicked
		view.addConfirmSelectionListener(e ->{

			System.out.println("Confirmed movie pressed");
			
			// Example of what we could do with the model. 
			
			// Not sure how complex we want this but I think ideally we just showcase 1 movie from the selection
			// and we just do nothing here.
			 String SelectedMovie = view.getMovieSelection(); // Returning a string, but could return selected list OR element easy change instead...

			// Set Showtime from backend (once we get confirm movie)
			// ArrayList<showtime> showtimelist = moviemodel.getshowtimes(SelectedMovie);
			// view.showtimeList = new Jlist(showtimeList.toArray())
			DefaultListModel<String> model = new DefaultListModel<>();
			for (String shd:theater.getAllShowDatesByMovie(view.getMovienameInput())){
				model.addElement(shd);
			}
			view.showtimeList.setModel(model);

			
			// Move to next View
			view.layeredPanel.removeAll();
			view.layeredPanel.add(view.showtimePanel);
			view.showtimePanel.setVisible(true);
			view.layeredPanel.repaint();

		});
		
		// ---------------------------------- 3rd View -----------------------------------------------//
		// if Confirm showtime from 2nd page is clicked
		view.addShowtimeListener(e ->{

			System.out.println("Confirm Showtime pressed");
			
			// Example of itneraction with model
			
			// Get selected showtime
			showtimestring = view.getSelectedShowtime();

			
			// Interact with backend As shown above.
			// Get Seats of showtime from backend
			
			// Set available row and columsn in view Foe example:
			ArrayList<Integer> rows = theater.returnShowrooms(view.getMovienameInput(), showtimestring);

			//int[] rows = arrayList.toArray(movie or showtime.getRowSeats()]);
			//int[] cols = arrayList.toArray(movie or showtime.getColSeats()]);
//			view.SeatColComboBoxInput = new JComboBox(rows);
			DefaultComboBoxModel<Integer> modelRoom = new DefaultComboBoxModel<>();
			for (Integer shd:rows){
				modelRoom.addElement(shd);
			}
			view.RoomComboBoxInput.setModel(modelRoom);


			//view.SeatRowComboBox = new JComboBox(rows);
			//view.SeatColComboBox = new JComboBox(cols);
			
			
			// Display next view
			view.layeredPanel.removeAll();
			view.layeredPanel.add(view.seatPanel);
			view.seatPanel.setVisible(true);
			view.layeredPanel.repaint();

		});
		
		view.addShowAvailableSeatListener(e ->{
			// We can't print a 2d array to jframe, need to create a graphic, this button would pop up the grpahic!
			System.out.println("Graphic for seats should be POPPING UP pressed");

			ArrayList<Integer> seats = theater.returnRoomNumbers(view.getMovieSelection(), showtimestring, view.getRoomComboBoxInput()+1);
			System.out.println(seats);
			DefaultComboBoxModel<Integer> modelSeat = new DefaultComboBoxModel<>();
			for (Integer shd:seats){
				modelSeat.addElement(shd);
			}
			view.SeatComboBoxInput.setModel(modelSeat);
			
			//int[] rows = arrayList.toArray(movie or showtime.getRowSeats()]);
			//int[] cols = arrayList.toArray(movie or showtime.getColSeats()]);
			
			// Create graphic from the 2d array or use From saved graphic above 
			//https://stackoverflow.com/questions/16277156/java-drawing-graphics-from-an-array
			
			// Show graphic

		});
		
		// ---------------------------------- final viewView -----------------------------------------------//
		// if Confirm Seat from 3page is clicked
		view.addConfirmSeatListener(e ->{
			// Getting selection
//			int selectedrow = view.getSeatRowComboBoxInput();
//			int selectedcol = view.getSeatColComboBoxInput();
			
			// Display next view
			view.layeredPanel.removeAll();
			view.layeredPanel.add(view.buyPanel);
			// Printint summary of tickets
			view.ConfirmationSummaryTextArea.setText("Summary of ticket should be here");
			// view.ConfirmationSummaryTextArea.setText(print stuffs about movie, showtime, date, price)
			view.buyPanel.setVisible(true);
			view.layeredPanel.repaint();

		});
		
		
		
		// If Buy from page 4 is clicked :
		view.addConfirmListener(e ->{
			System.out.println("Buy button is pressed");
			
			// Update Database for seats and user ticket
			
			// Payment system here...
			
			
			// Display Ticket Buy UI
			view.setVisible(false);
			// Ticket controller needs to be called and populate the ticket UI
			
			nextview.populateTicket("Michael", "0010", "Spiderman Far from home", "7pm Saturday", "14$", "17th December");
			// Basically pass those from each model populateTicket(String name, String ticket, String moviename, String Showtime, String Cost, String Date) 
			nextview.printReceiptButton.setVisible(true);
			nextview.setVisible(true);


		});
	}

//	private ArrayList<Movie> findMovies(String  movie){
//		ArrayList<Movie> movies = new ArrayList<>();
//		for (Movie m:movieDB){
//			if (m.getMovieName().equals(movie)){
//				System.out.println(m);
//				movies.add(m);
//			}
//		}
//		return movies;
//	}

	private ArrayList<Movie> findMovies(String  movie){
		ArrayList<Movie> movies = new ArrayList<>();
		for (Movie m:theater.getMovieList()){
			if (m.getMovieName().equals(movie)){
				System.out.println(m);
				movies.add(m);
			}
		}
		return movies;
	}

}
