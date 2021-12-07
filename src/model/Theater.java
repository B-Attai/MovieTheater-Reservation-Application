package model;

/**
 * NOTE Theater is currently a SINGLETON.
 */

import java.util.*;

public class Theater {
    private static Theater instance;

    // dates to ShowDates
    private HashMap<String, ShowDate> operationDates;
    private ArrayList<Movie> movieList;
    private final String theaterName;
    private final double ticketPrice;

    private Theater(){
        operationDates = new HashMap<>();
        movieList = new ArrayList<>();
        theaterName = "Calgary Theater";
        ticketPrice =15.;
    }

    public void reserveASeat(String movieName, String date, int hour, int showroomNumber, int seatNumber){
        if (findMovieByName(movieName)==null){
            return;
        }
        ShowDate shd = operationDates.get(date);
        ShowTime sht = shd.getShowTimeByMovie(movieName);
        TheaterShowRooms shrs = sht.getShowRoomByHour(hour);
        Showroom shr = shrs.getShowRoomsByNumber(showroomNumber);
        shr.bookASeat(seatNumber);
    }

    public Movie findMovieByName(String movieName){
        for(Movie m:movieList){
            if (m.getMovieName().equals(movieName)){
                return m;
            }
        }
        throw new NoSuchElementException("Such movie does not exist");
    }

    public void addShowDate(ShowDate showDate){
        instance.operationDates.put(showDate.getDate(), showDate);
    }

    public ArrayList<Movie> getMovieList() {
        return movieList;
    }

    public ArrayList<String> getAllShowDatesByMovie(String movieName){
        ArrayList<String> showDates = new ArrayList<>();
        for (ShowDate shd:operationDates.values()){
            ShowTime existingTime = shd.getShowTimeByMovie(movieName);
            if (existingTime!=null){
                for (int hours:existingTime.getShowDateSchedule().keySet()){
                    showDates.add(shd.getDate() + " " + hours);
                }
            }
        }
        return showDates;
    }

    public ArrayList<Integer> returnShowrooms(String movieName, String dateTime){
        ArrayList<Integer> myResult = new ArrayList<>();
        String showDate = dateTime.split(" ")[0];
        int showtime = Integer.parseInt(dateTime.split(" ")[1]);

        for (ShowDate shd:operationDates.values()){
            if (shd.getShowTimeByMovie(movieName) == null) continue;
            ShowTime existingTime = shd.getShowTimeByMovie(movieName);
            if (!existingTime.getDate().equals(showDate)) continue;

            TheaterShowRooms tshr = existingTime.getShowRoomByHour(showtime);
            return tshr.getShowRoomsNumbers();
        }
        return myResult;
    }

    public ArrayList<Integer> returnRoomNumbers(String movieName, String dateTime, int showRoomNumber){
        ArrayList<Integer> myResult = new ArrayList<>();
        String showDate = dateTime.split(" ")[0];
        int showtime = Integer.parseInt(dateTime.split(" ")[1]);

        for (ShowDate shd:operationDates.values()){
            ShowTime existingTime = shd.getShowTimeByMovie(movieName);
            if (!existingTime.getDate().equals(showDate)) continue;

            TheaterShowRooms tshr = existingTime.getShowRoomByHour(showtime);
            return tshr.getShowRoomNumbers(showRoomNumber);
        }
        System.out.println(myResult);
        return myResult;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void makeBooking(Ticket ticket){
        String movie = ticket.getMovie().getMovieName();
        String date = ticket.getDate();
        int hour = ticket.getTime();
        int roomNumber = ticket.getShowroomNumber();
        int seatNumber = ticket.getSeatNumber();
        this.operationDates.get(date).getShowTimeByMovie(movie).getShowRoomByHour(hour).getShowRoomsByNumber(roomNumber).bookASeat(seatNumber);
    }

    public void removeABooking(Ticket ticket){
        String movie = ticket.getMovie().getMovieName();
        String date = ticket.getDate();
        int hour = ticket.getTime();
        int roomNumber = ticket.getShowroomNumber();
        int seatNumber = ticket.getSeatNumber();
        this.operationDates.get(date).getShowTimeByMovie(movie).getShowRoomByHour(hour).getShowRoomsByNumber(roomNumber).unbookASeat(seatNumber);
    }

    public static Theater getInstance() {
        if (instance==null){
            instance = new Theater();
            return instance;
        }
        return instance;
    }

    public void setMovieList(ArrayList<Movie> movieList) {
        this.movieList = movieList;
    }

    public HashMap<String, ShowDate> getOperationDates(){
        return operationDates;
    }
}
