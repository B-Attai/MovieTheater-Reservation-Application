package model;

public class Movie {

    private String movieName;
    private String movieInfo;

    //Test Constructor
    public Movie(String movieName) {
        setMovieName(movieName);
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
}
