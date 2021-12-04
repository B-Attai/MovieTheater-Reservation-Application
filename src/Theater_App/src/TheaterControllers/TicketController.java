package TheaterControllers;

import TheaterView.Ticket_UI;

public class TicketController {
	private Ticket_UI view;
	public TicketController(Ticket_UI ticketwindow) {
		view = ticketwindow;
		
		view.addPrintReceiptListener(e ->{

			System.out.println("Print Receipt pressed - This is lcoated in Ticket Controller!!");
			
			// Here you can do whateve ryou need about the ticket.
			
		});
		// TODO Auto-generated constructor stub
	}

}
