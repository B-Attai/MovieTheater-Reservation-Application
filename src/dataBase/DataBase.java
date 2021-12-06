package dataBase;

import Model.*;

import java.util.ArrayList;

public class DataBase {

    private final ArrayList<Movie> movies;
    private final ArrayList<User> users;
    private final ArrayList<Ticket> tickets;

    public DataBase(){
        this.movies = loadFromMovieDB();
        setupTheater();
        this.users = loadUserDB();
        this.tickets = loadTicketDB();
    }

    //Temporary loading from DB
    private static ArrayList<Movie> loadFromMovieDB() {

        ArrayList<Movie> testMovieDB = new ArrayList<Movie>();

        testMovieDB.add(new Movie("John Wick 3"));
        testMovieDB.add(new Movie("Home Alone"));
        testMovieDB.add(new Movie("James Bond"));
        return testMovieDB;
    }

    private static ArrayList<Showroom> loadFromShowroomDB(){
        ArrayList<Showroom> testShowroomDB = new ArrayList<Showroom>();

        testShowroomDB.add(new Showroom(1, loadFromSeatDB()));
        testShowroomDB.add(new Showroom( 2, loadFromSeatDB()));
        testShowroomDB.add(new Showroom(3, loadFromSeatDB()));
        return testShowroomDB;
    }

    //Temporary seat database
    private static ArrayList<Seat> loadFromSeatDB(){
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

    private static ArrayList<User> loadUserDB(){
        ArrayList<User> users = new ArrayList<User>();

        users.add(new RegisteredUser("Amir", "123", "123", "123"));
        users.add(new RegisteredUser("1", "1", "123", "123"));
        users.add(new User("1", "1"));
        return users;
    }

    private ArrayList<Ticket> loadTicketDB(){
        Payment payment = Payment.getInstance();

        ArrayList<Ticket> tickets = new ArrayList<>();

        tickets.add(payment.generateTicket(movies.get(2), users.get(0), 1, 1, "12-12-2021", 12));
        tickets.add(payment.generateTicket(movies.get(2), users.get(0), 1, 3, "12-12-2021", 12));
        tickets.add(payment.generateTicket(movies.get(2), users.get(1), 1, 2, "12-12-2021", 12));
        tickets.add(payment.generateTicket(movies.get(2), users.get(1), 1, 2, "07-12-2021", 12));
        tickets.add(payment.generateTicket(movies.get(2), users.get(2), 1, 4, "12-12-2021", 12));

        return tickets;
    }

    private void setupTheater(){
        System.out.println("setupTheater");
        TheaterShowRooms tshr1 = new TheaterShowRooms(12, loadFromShowroomDB());
        TheaterShowRooms tshr2 = new TheaterShowRooms(12, loadFromShowroomDB());

        ShowTime sh1 = new ShowTime("12-12-2021");
        ShowTime sh2 = new ShowTime("07-12-2021");
        sh1.addTimeSlot(tshr1);
        sh2.addTimeSlot(tshr2);

        ShowDate shd1 = new ShowDate("12-12-2021");
        shd1.addShow("James Bond", sh1);

        ShowDate shd2 = new ShowDate("07-12-2021");
        shd2.addShow("James Bond", sh2);

        Theater.getInstance().addShowDate(shd1);
        Theater.getInstance().addShowDate(shd2);
        Theater.getInstance().setMovieList(movies);
    }

    public ArrayList<Movie> getMovies() {
        return movies;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public ArrayList<Ticket> getTickets() {
        return tickets;
    }
}