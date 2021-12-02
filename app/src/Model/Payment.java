package Model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Payment{
    private final double TICKET_COST = 15.00;
    private Ticket ticket ;
    private PaymentStrategy paymentStrategy;
    private UserRefundInterface refundStrategy;
    private User user;
    private String userInfo;
    private double paymentAmount;
    private Theater theater;

    //Storage for Tickets generated to process refunds
    private List<Ticket> ticketDB;

    //Default Constructor
    public Payment() {
        ticketDB = new ArrayList<Ticket>(); //Can be moved
    }

    //Book a ticket and add to ticket database, returns the generated Ticket object
    public Ticket generateTicket(String userInfo, String movieName, int showroomNumber, int seatNumber){
        Theater theater = Theater.getInstance();
        setTheater(theater);
        String bookingReference =  this.theater.bookASeat(movieName, showroomNumber, seatNumber);
        String bookingInfo = theater.getABooking(bookingReference);
        Ticket aTicket = new Ticket(userInfo, theater.getTheaterName(), bookingReference, bookingInfo);
        ticketDB.add(aTicket);
        return aTicket;
    }

    //Perform a transaction using Payment strategy
    public boolean performTransaction(long accountID, double amount){
        setPaymentStrategy(new CreditCardStrategy());
        return paymentStrategy.makePayment(accountID, amount);
    }

    //Perform a refund and remove the booking and ticket for the respective DBs
    //Apply the refund strategy depending on the user
    //Note: Split ticket and booking separated
    //TODO: Verify time between booking reference and the current time to process refund
    public double performRefund(User user, String bookingReference){
        for(Ticket ticket : ticketDB) {
        System.out.println("TEST: " + ticket.getBookingReference().equals(bookingReference));
            if (ticket.getBookingReference().equals(bookingReference)
                    && removeTicket(bookingReference) &&
                        theater.removeABooking(bookingReference)) {
                if (user.getUserType().equals("regular")) {
                    setRefundStrategy(new RegularUserRefund());
                    return refundStrategy.refund(TICKET_COST);
                } else {
                    setRefundStrategy(new RegisterUserRefund());
                    return refundStrategy.refund(TICKET_COST);
                }
            }
        }
        return 0.0; //If no ticket return 0.0;
    }

    //TODO: implement functionality to check the time is within 72 hours.
    public boolean verifyTime(String ticketDateTime){
        DateTime dt = new DateTime();
        dt.getCurrentDateTime();
        return true;
    }

    //Remove ticket in-place while iterating the list
    public boolean removeTicket(String bookingReference) {
        Iterator<Ticket> itr = ticketDB.iterator();
        while (itr.hasNext()) {
            Ticket toRemove = itr.next();
            if (toRemove.getBookingReference().equals(bookingReference)) {
                itr.remove();
                System.out.println("Removing from removeTicket! - TRUE VALUE");
                return true;
            }
        }
        System.out.println("Removing from removeTicket! - FALSE VALUE");
        return false;
    }


    //Payment Strategies
    public void setPaymentStrategy(PaymentStrategy paymentStrategy){
        this.paymentStrategy = paymentStrategy;
    }

    public void setRefundStrategy(UserRefundInterface refundStrategy){
        this.refundStrategy = refundStrategy;
    }

    //Get User info from a specific user
    public String getUserInfo(User user){
        return this.userInfo = user.getUserInfo();
    }


    //Getters and Setters
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public String getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(String userInfo) {
        this.userInfo = userInfo;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Theater getTheater() {
        return theater;
    }

    public void setTheater(Theater theater) {
        this.theater = theater;
    }


}
