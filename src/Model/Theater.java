package Model;

/**
 * NOTE Theater is currently a SINGLETON.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Theater {

    private String theaterName = "Calgary Theater";
    private List<Movie> movieList; //Loaded from DB
    private List<Showroom> showroomList; //Loaded from DB
    private Map<Movie, Showroom> showtimes; //Mapping of Movie to Showroom(show-time) entities
    private Map<String, Map<Movie, Booking>> bookings; //Mapping of Booking reference number to Movie and Booking
    private Movie movie;
    private String ticketInfo;

    //Singleton
    private static Theater theater_instance = null;

    //Singleton getInstance()
    public static Theater getInstance(){
        if (theater_instance == null)
            theater_instance = new Theater();

        return theater_instance;
    }

    //Theater is a private constructor, cannot be instantiated externally
    private Theater(){
        this.movieList = loadFromMovieDB();
        this.showroomList = loadFromShowroomDB();

        //Map for bookings and booking id.
        bookings = new HashMap<String, Map<Movie, Booking>>();

        //Temporary loading of HashMap - can be moved
        showtimes = new HashMap<Movie,Showroom>();
        showtimes.put(movieList.get(0), showroomList.get(0));
        showtimes.put(movieList.get(1), showroomList.get(1));
        showtimes.put(movieList.get(2), showroomList.get(2));
    }

    //Book a seat, iterate the hash map, search for movie name, showroom number and seat number
    //If true, create and store a booking, may be able to make more efficient
    public String bookASeat(String movieName, int showroomNumber, int seatNumber) {
        //Book a seat
        for (Map.Entry<Movie, Showroom> mapElement : showtimes.entrySet()) {
            if (mapElement.getKey().getMovieInfo() == movieName
                    && mapElement.getValue().getShowroomNumber() == showroomNumber
                    && mapElement.getValue().getSeatState(seatNumber) == false) {
                mapElement.getValue().bookASeat(seatNumber); //Change seat state from 0 to 1

                //Set booking ref
                Map<Movie, Booking> booking = new HashMap<Movie, Booking>();

                //Create booking object
                Booking theBooking = new Booking(movieName,this, showroomNumber, seatNumber);

                booking.put(mapElement.getKey(), theBooking);
                String bookingReferenceNumber = String.format("%.0f", Math.random()*10000000); //Generate random booking number
                bookings.put(bookingReferenceNumber, booking);
                return bookingReferenceNumber;
            }
        }
        return "";
    }

    //Get a booking based on a reference number
    public String getABooking(String bookingReferenceNumber){
        for (Map.Entry<String, Map<Movie, Booking>> mapElement : bookings.entrySet()) {
            if(mapElement.getKey().equals(bookingReferenceNumber)){
                Map<Movie, Booking> specificBooking;// = new HashMap<Movie, Showroom>();
                specificBooking = mapElement.getValue();

                String movieInfo = "";

                for(Map.Entry<Movie, Booking> map : specificBooking.entrySet()){
                    movieInfo = map.getKey().toString()+ " " + map.getValue().toString();
                }
                return movieInfo;
            }
        }
        return "";
    }

    //Remove a booking
    //TODO: change seat state back to 0 for the booking
    public boolean removeABooking(String bookingReferenceNumber){
        Map<Movie, Booking> returnedValue = bookings.remove(bookingReferenceNumber);
        if(returnedValue == null){
            return false;
        }else{
            System.out.println("Removing from removeABooking! - TRUE VALUE");
            return true;
        }
    }

    //Get the showroom DB for a given showroom number
    public Showroom getShowroomSeating(int showroomNumber){
        for (Showroom showroom: showroomList){
            if(showroom.getShowroomNumber() == showroomNumber){
                return showroom;
            }
        } return null;
    }

    //Search for a movie in the DB
    public boolean searchMovie(String movieName){
        for (Movie movie: movieList){
            if (movie.getMovieInfo().equals(movieName));
            return true;
        }return false;
    }

    //Get showtimes
    //TODO: Currently tied to showroom, need to update to showtime
    public List<String>  getShowtimes(){
        List<String> showtimeList = new ArrayList<String>();
        showtimes.entrySet().forEach(movieShowroomEntry ->
                showtimeList.add((movieShowroomEntry.getKey() + ", " + movieShowroomEntry.getValue()))
        );
        return showtimeList;
    }

    //Getters and setters
    public List<Movie> getMovieList() {
        return movieList;
    }

    public void setMovieList(List<Movie> movieList) {
        this.movieList = movieList;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public String getTicketInfo() {
        return ticketInfo;
    }

    public void setTicketInfo(String ticketInfo) {
        this.ticketInfo = ticketInfo;
    }

    public String getTheaterName() {
        return theaterName;
    }

    public void setTheaterName(String theaterName) {
        this.theaterName = theaterName;
    }

    //Temporary loading from DB
    private static List<Movie> loadFromMovieDB() {

        List<Movie> testMovieDB = new ArrayList();

        testMovieDB.add(new Movie("John Wick 3"));
        testMovieDB.add(new Movie("Home Alone"));
        testMovieDB.add(new Movie("James Bond"));
        return testMovieDB;
    }

    private static List<Showroom> loadFromShowroomDB(){
        List<Showroom> testShowroomDB = new ArrayList();

        testShowroomDB.add(new Showroom(1));
        testShowroomDB.add(new Showroom( 2));
        testShowroomDB.add(new Showroom(3));
        return testShowroomDB;
    }
}
