package Controller;

import Model.Movie;
import Model.Theater;

import java.util.List;

public class MovieController {

    private Theater theater;

    //Default controller, using single instance of Theater
//    public MovieController(){
//        setTheater(Theater.getInstance());
//    }

    //Search for a movie
    public String searchMovieName(String movieName){
        if (theater.searchMovie(movieName)){
            return "Movie " + movieName + " is available.";
        }
        return "Movie " + movieName + "is not available";
    }

    //Search the movie list
    public String searchMovieList(){
        List<Movie> movieList = theater.getMovieList();
        return movieList.toString();
    }

    //Search show times
    public List<String> searchMovieShowtimes(){
        return theater.getShowtimes();
    }

    //Search the seats
    public String searchTheaterSeats(int showroomNumber){
        return theater.getShowroomSeating(showroomNumber).getSeatList();
    }

    //Getters and Setters
    public Theater getTheater() {
        return theater;
    }

    public void setTheater(Theater theater) {
        this.theater = theater;
    }
}
