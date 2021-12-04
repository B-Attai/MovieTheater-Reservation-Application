package TheaterControllers;

import TheaterView.Ticket_UI;

public class RefundController {
	private Ticket_UI view;
	public RefundController(Ticket_UI ticketwindow) {
		view = ticketwindow;
		
		view.addRequestListener(e ->{
			System.out.println("Print Receipt pressed - This is lcoated in Refund Controller!!");
			
			// There are getters in the class! Every thing is set
			// Change the type as needed I just used string as illustration
//			String username, ticketid, movie, showtime, cost,date;
//			
//			username = view.getName();
//			ticketid = view.getTicketID();
//			movie = view.getMovie();
//			showtime = view.getShowtime();
//			cost = view.getCost();
//			date = view.getDate();


			
		});
	}

}
