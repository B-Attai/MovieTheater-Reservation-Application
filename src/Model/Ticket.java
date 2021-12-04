package Model;

public class Ticket {

    private String theaterName;
    private String userInfo;
    private String bookingReference;
    private String movie;
    private String dateTime;

    //Constructor
    public Ticket(String userInfo, String theaterName, String bookingReference, String bookingInfo) {
        this.userInfo = userInfo;
        this.theaterName = theaterName;
        this.bookingReference = bookingReference;
        this.movie = bookingInfo;
        //Get current date and time
        this.dateTime = new DateTime().getCurrentDateTime();
    }

    //Overridden toString, can be modified to get the required format
    @Override
    public String toString() {
        return "Ticket{" +
                "theaterName='" + theaterName + '\'' +
                ", userInfo='" + userInfo + '\'' +
                ", bookingReference='" + bookingReference + '\'' +
                ", movie='" + movie + '\'' +
                ", dateTime='" + dateTime + '\'' +
                '}';
    }

//Getters and Setters

    public String getTheaterName() {
        return theaterName;
    }

    public void setTheaterName(String theaterName) {
        this.theaterName = theaterName;
    }

    public String getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(String userInfo) {
        this.userInfo = userInfo;
    }

    public String getBookingReference() {
        return bookingReference;
    }

    public void setBookingReference(String ticketInfo) {
        this.bookingReference = ticketInfo;
    }

    public String getMovie() {
        return movie;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }

    public String getDateTime() {
        return dateTime;
    }
}
