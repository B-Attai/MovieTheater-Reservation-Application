package model;

import view.Menu_UI;

public class Movie {

    private String movieName;
    private String movieInfo;
    private String announcementDate;

    //Test Constructor
    public Movie(String movieName, String announcementDate) {

        setMovieName(movieName);
        setAnnouncementDate(announcementDate); //ADDED 2021-12-06
    }


    public String getMovieInfo() {
        return movieInfo;
    }

    public void setMovieInfo(String movieInfo) {
        this.movieInfo = movieInfo;
    }

    public String getMovieName(){
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    @Override
    public String toString() {
        return movieName;

    }

    public String getAnnouncementDate() {
        return announcementDate;
    }

    public void setAnnouncementDate(String announcementDate) {
        this.announcementDate = announcementDate;
    }
}
