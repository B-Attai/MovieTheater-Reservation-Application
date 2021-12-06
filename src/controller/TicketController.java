package controller;

import Model.Ticket;
import Model.User;
import view.Ticket_UI;

import java.util.ArrayList;

public class TicketController {
	private User user;

	private Ticket_UI view;
	public TicketController(Ticket_UI ticketwindow, ArrayList<Ticket> ticketDB) {
		view = ticketwindow;
		ticketDB = ticketDB;
		
		view.addPrintReceiptListener(e ->{

			System.out.println("Print Receipt pressed - This is lcoated in Ticket Controller!!");
			
			// Here you can do whateve you need about the ticket.


		});
		// TODO Auto-generated constructor stub
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
