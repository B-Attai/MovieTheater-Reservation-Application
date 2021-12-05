package dataBase;

import Model.*;

import java.util.ArrayList;

public class DataBase {

    private ArrayList<Movie> movies;
    private Theater theater;
    private ArrayList<User> users;

    public DataBase(){
        this.movies = loadFromMovieDB();
        this.theater = new Theater(movies, loadFromShowroomDB());
        this.users = loadUserDB();
    }

    //Temporary loading from DB
    public static ArrayList<Movie> loadFromMovieDB() {

        ArrayList<Movie> testMovieDB = new ArrayList<Movie>();

        testMovieDB.add(new Movie("John Wick 3"));
        testMovieDB.add(new Movie("Home Alone"));
        testMovieDB.add(new Movie("James Bond"));
        return testMovieDB;
    }

    public static ArrayList<Showroom> loadFromShowroomDB(){
        ArrayList<Showroom> testShowroomDB = new ArrayList<Showroom>();

        testShowroomDB.add(new Showroom(1, loadFromSeatDB()));
        testShowroomDB.add(new Showroom( 2, loadFromSeatDB()));
        testShowroomDB.add(new Showroom(3, loadFromSeatDB()));
        return testShowroomDB;
    }

    //Temporary seat database
    public static ArrayList<Seat> loadFromSeatDB(){
        ArrayList<Seat> testSeatDB = new ArrayList<Seat>();

        testSeatDB.add(new Seat(1, 0, 0));
        testSeatDB.add(new Seat(2, 0, 1));
        testSeatDB.add(new Seat(3, 0, 2));
        testSeatDB.add(new Seat(4, 0, 3));
        testSeatDB.add(new Seat(5, 1, 0));
        testSeatDB.add(new Seat(6, 1, 1));
        testSeatDB.add(new Seat(7, 1, 2));
        testSeatDB.add(new Seat(8, 1, 3));
        testSeatDB.add(new Seat(9, 2, 0));
        testSeatDB.add(new Seat(10, 2, 1));
        testSeatDB.add(new Seat(11, 2, 2));
        testSeatDB.add(new Seat(12, 2, 3));
        testSeatDB.add(new Seat(13, 3, 0));
        testSeatDB.add(new Seat(14, 3, 1));
        testSeatDB.add(new Seat(15, 3, 2));
        testSeatDB.add(new Seat(16, 3, 3));
        return testSeatDB;
    }

    public static ArrayList<User> loadUserDB(){
        ArrayList<User> users = new ArrayList<User>();

//        users.
        return users;
    }
}
