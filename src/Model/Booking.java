package Model;

public class Booking {

    private String movieBooked;
    private Theater theaterBooked;
    private int showroomBooked;
    private int seatBooked;

    public Booking(String movieBooked, Theater theaterBooked, int showroomBooked, int seatBooked) {
        this.movieBooked = movieBooked;
        this.theaterBooked = theaterBooked;
        this.showroomBooked = showroomBooked;
        this.seatBooked = seatBooked;
    }

    @Override
    public String toString() {
        return " showroomBooked=" + showroomBooked +", seatBooked=" + seatBooked;
    }
}
