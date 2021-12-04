package Controller;

import Model.Payment;
import Model.Theater;
import Model.Ticket;
import Model.User;

public class TicketController {

    private Payment payment;
    private Theater theater;
    private User user;

    //Constructor
    public TicketController(User user){
        Payment payment = new Payment();
        setPayment(payment);
        setUser(user);
    }

    //Make a payment then generate a ticket
    public void makePayment(long accountId, double amount, String movieName, int showroomNumber, int seatNumber){
        if(payment.performTransaction(accountId, amount) == true){
            Ticket theTicket = payment.generateTicket(user.getUserInfo(), movieName, showroomNumber, seatNumber);
            System.out.println("Make payment in controller tested successfully."); //Test string to be updated
            System.out.println(theTicket);
        }else{
            System.out.println("Make payment in controller test failed."); //Test string to be updated
        }
    }

    //Getters and Setters
    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Theater getTheater() {
        return theater;
    }

    public void setTheater(Theater theater) {
        this.theater = theater;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
