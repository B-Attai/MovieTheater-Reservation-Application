package Model;

import java.util.Iterator;
import java.util.List;

public class Payment{
    private static Payment paymentInstance;

    private PaymentStrategy paymentStrategy;
    private UserRefundInterface refundStrategy;

    //Storage for Tickets generated to process refunds
    private List<Ticket> ticketDB;

    public static Payment getInstance(PaymentStrategy paymentStrategy){
        if (paymentInstance ==null){
            return new Payment(paymentStrategy);
        }
        paymentInstance.setPaymentStrategy(paymentStrategy);
        return paymentInstance;
    }


    private Payment(PaymentStrategy paymentStrategy) {
        setPaymentStrategy(paymentStrategy);
    }

    //Book a ticket and add to ticket database, returns the generated Ticket object
//    public Ticket generateTicket(String userInfo, String movieName, int showroomNumber, int seatNumber){
//
//        // Theater singleton?
//        Theater theater = Theater.getInstance();
//        setTheater(theater);
//        String bookingReference =  this.theater.bookASeat(movieName, showroomNumber, seatNumber);
//        String bookingInfo = theater.getABooking(bookingReference);
//        Ticket aTicket = new Ticket(userInfo, theater.getTheaterName(), bookingReference, bookingInfo);
//        ticketDB.add(aTicket);
//        return aTicket;
//    }

    // Version Amir
    public Ticket generateTicket(Theater theater, Movie movie, User user, int showroomNumber, int seatNumber){
//        Checking the logic of theater occupancy

        Ticket aTicket = new Ticket(theater, movie, user, showroomNumber, seatNumber);
        ticketDB.add(aTicket);
        return aTicket;
    }


    //Perform a transaction using Payment strategy
    public boolean performTransaction(long accountID, double amount){
        return paymentStrategy.makePayment(accountID, amount);
    }

    //Perform a refund and remove the booking and ticket for the respective DBs
    //Apply the refund strategy depending on the user
    //Note: Split ticket and booking separated
    //TODO: Verify time between booking reference and the current time to process refund
    public void performRefund(int bookingReference, double amount) throws Exception {
        for(Ticket ticket : ticketDB) {
        System.out.println("TEST: " + (ticket.getBookingReference() == bookingReference));
            if (ticket.getBookingReference() == bookingReference){
                System.out.println("Ticket found!");
                removeTicket(ticket.getBookingReference());
                ticket.getTheater().removeABooking(bookingReference);

                if (ticket.getUser().getUserType().equals("Registered")) {
                    setRefundStrategy(new RegisterUserRefund());
                } else {
                    setRefundStrategy(new RegularUserRefund());
                }
                refundStrategy.refund(amount);
                return;
            }
            // Ticket does not exist
            throw new Exception("Ticket not found");
        }
    }

    //TODO: implement functionality to check the time is within 72 hours.
    public boolean verifyTime(Ticket ticket){
        DateTime dt = new DateTime();
        dt.getCurrentDateTime();

//        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
//
//        Date date = format.parse(ticket.getDateTime());
//
//        if (dt.getCurrentDateTime() - ticket.getDateTime() > 50){
//            System.out.println("yes");
//        }

        return true;
    }

    //Remove ticket in-place while iterating the list
    public boolean removeTicket(int bookingReference) {
        Iterator<Ticket> itr = ticketDB.iterator();
        while (itr.hasNext()) {
            Ticket toRemove = itr.next();
            if (toRemove.getBookingReference() == bookingReference) {
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
}
