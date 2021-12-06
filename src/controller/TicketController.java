package controller;

import model.Ticket;
import model.User;
import view.Ticket_UI;

import javax.swing.*;
import java.util.ArrayList;

public class TicketController {
	private User user;
	Ticket ticket;

	private Ticket_UI view;
	public TicketController(Ticket_UI ticketwindow, ArrayList<Ticket> ticketDB) {
		view = ticketwindow;
		ticketDB = ticketDB;
		
		view.addPrintReceiptListener(e ->{

			System.out.println("Print Receipt pressed - This is lcoated in Ticket Controller!!");
			
			// Here you can do whateve you need about the ticket.
			JOptionPane.showMessageDialog(null, ticket, "Receipt" ,JOptionPane.PLAIN_MESSAGE);

		});
		// TODO Auto-generated constructor stub
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}
}
