package TheaterControllers;

import Model.Payment;
import Model.Ticket;
import TheaterView.Ticket_UI;

import java.util.ArrayList;

public class RefundController {
//	private final ArrayList<Ticket> ticketDB;
	private Ticket_UI view;
	public RefundController(Ticket_UI ticketwindow, ArrayList<Ticket> ticketDB) {
		view = ticketwindow;
//		this.ticketDB = ticketDB;
		
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
			Payment instance = Payment.getInstance();
			instance.setTicketDB(ticketDB);
			int ticketRefNo = Integer.parseInt(view.getTicketID());
			try {
//				instance.performRefund(ticketRefNo, 5);
			} catch (Exception ex) {
				ex.printStackTrace();
			}


		});
	}

//	private Ticket findTicket(int ticketId){
//		for(Ticket t:ticketDB){
//			if (t.getBookingReference() == ticketId){
//				return t;
//			}
//		}
//		return null;
//	}

}
