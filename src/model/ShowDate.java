package model;

import java.util.HashMap;

/**
 * A class that
 */
public class ShowDate {
    // Stores movie to a show time
    private HashMap<String, ShowTime> dateMovieSchedule;
    private String date;

    public ShowDate(String date){
        this.date = date;
        this.dateMovieSchedule = new HashMap<>();
    }

    public ShowDate(HashMap<String, ShowTime> dateMovieSchedule, String date) {
        this.dateMovieSchedule = dateMovieSchedule;
        this.date = date;
    }

    public void addShow(String movieName, ShowTime showTime){
        dateMovieSchedule.put(movieName, showTime);
    }

    public ShowTime getShowTimeByMovie(String movieName){
        return dateMovieSchedule.get(movieName);
    }

    public String getDate() {
        return date;
    }

    @Override
    public String toString() {
        return date;
    }
}
