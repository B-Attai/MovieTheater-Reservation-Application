package Model;

import java.util.Objects;

public class Ticket {

    private static int referenceNumber = 0;

    private final User user;
    private final int bookingReference;
    private final Movie movie;
    private final String dateTime;
    private final Theater theater;
    private final int showroomNumber;
    private final int seatNumber;

    //Constructor
    public Ticket(Theater theater, Movie movie, User user, int showroomNumber, int seatNumber) {
        this.theater = theater;
        this.movie = movie;
        this.user = user;
        this.showroomNumber = showroomNumber;
        this.seatNumber = seatNumber;

        //Get current date and time
        this.dateTime = new DateTime().getCurrentDateTime();
        this.bookingReference = generateReferenceNumber();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return bookingReference == ticket.bookingReference;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookingReference);
    }

    //Overridden toString, can be modified to get the required format

    @Override
    public String toString() {
        return "Ticket{" +
                "user=" + user.getUserName() +
                ", bookingReference=" + bookingReference +
                ", movie=" + movie.getMovieInfo() +
                ", dateTime='" + dateTime + '\'' +
//                ", theater=" + theater.getTheaterName() +
                ", showroomNumber=" + showroomNumber +
                ", seatNumber=" + seatNumber +
                '}';
    }


//Getters and Setters

    private static int generateReferenceNumber() {
        return ++referenceNumber;
    }

    public User getUser() {
        return user;
    }

    public Theater getTheater() {
        return theater;
    }

    public int getShowroomNumber() {
        return showroomNumber;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public int getBookingReference() {
        return bookingReference;
    }

    public Movie getMovie() {
        return movie;
    }

    public String getDateTime() {
        return dateTime;
    }
}
