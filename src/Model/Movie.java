package Model;

public class Movie {

    private String movieInfo;

    //Test Constructor
    public Movie(String movieName) {
        setMovieInfo(movieName);
    }


    public String getMovieInfo() {
        return movieInfo;
    }

    public void setMovieInfo(String movieInfo) {
        this.movieInfo = movieInfo;
    }

    @Override
    public String toString() {
        return movieInfo;

    }
}
