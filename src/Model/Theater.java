package Model;

/**
 * NOTE Theater is currently a SINGLETON.
 */

import java.util.*;

public class Theater {

    // dates to ShowDates
    private HashMap<String, ShowDate> operationDates;
    private ArrayList<Movie> movieList;
    private String theaterName;
    private final double ticketPrice;

    public Theater(ArrayList<Movie> movieList, HashMap<String, ShowDate> operationDates){
        this.movieList = movieList;
        this.operationDates = operationDates;
        theaterName = "Calgary theater";
        ticketPrice = 15.;
    }

    public Theater(ArrayList<Movie> movieList) {
        this.movieList = movieList;
        this.operationDates = new HashMap<>();
        theaterName = "Calgary theater";
        ticketPrice = 15.;
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
        this.operationDates.put(showDate.getDate(), showDate);
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
}
