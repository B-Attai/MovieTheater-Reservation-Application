package database;

import model.Movie;
import model.RegisteredUser;
import model.Seat;
import model.User;

import java.sql.*;
import java.util.ArrayList;

public class DBManager implements Credentials {

	private Connection connection;
	private ResultSet resultset;
	private PreparedStatement statement;

	public DBManager() { // initializing database
		initializeConnection();
		System.out.println("Connected to database" + DB_URL);
		//System.out.println("\n");
	}

	public void initializeConnection() { // connection to database
		try {
			Driver driver = new com.mysql.cj.jdbc.Driver();
			DriverManager.registerDriver(driver);
			connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
		} catch (SQLException e) {
			System.out.println("Problem");
			e.printStackTrace();
		}
	}

	public void close() { // closing connection
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


    // Specific
	public ResultSet selectMovies(int theatreID) {// Theater selection
		try {
			String query = "SELECT * FROM MOVIE WHERE TheatreID = ?";
			statement = connection.prepareStatement(query);
			statement.setInt(1, theatreID);
			resultset = statement.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			while (resultset.next()) {
				String row = "";
				for (int i = 1; i <= resultset.getMetaData().getColumnCount(); i++) {
					row += resultset.getString(i) + ", ";
				}
				System.out.println(row);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return resultset;
	}

	//Search
	public ArrayList<Movie> loadAllMovies() {

		ArrayList<Movie> testMovieDB = new ArrayList<Movie>();
		try {
			Statement myStmt = connection.createStatement();
			resultset = myStmt.executeQuery("SELECT * FROM MOVIES");

			while (resultset.next()) {

				testMovieDB.add(new Movie(resultset.getString("movieName"),
						resultset.getString("announcementDate")));
			}

			myStmt.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return testMovieDB;

	}

	public ArrayList<User> loadAllUsers(){
		ArrayList<User> testUserDB = new ArrayList<User>();
		Statement myStmt = null;
		try {
			myStmt = connection.createStatement();
			resultset = myStmt.executeQuery("SELECT * FROM USERS");
			while (resultset.next()) {

				testUserDB.add(new RegisteredUser(resultset.getString("userName"),
						resultset.getString("password"), resultset.getBoolean("hasNotPaidFee")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return testUserDB;
	}

	public ArrayList<Seat> loadSeats(int roomNumber, int time, String day){
		ArrayList<Seat> testSeatDB = new ArrayList<>();
		try {
			String query ="SELECT seatNumber, seatState FROM THEATER where roomNumber=? AND time=? AND day=?";
			PreparedStatement myStmt = connection.prepareStatement(query);
			myStmt.setInt(1, roomNumber);
			myStmt.setInt(2, time);
			myStmt.setString(3, day);
			resultset = myStmt.executeQuery();
			while (resultset.next()) {

				testSeatDB.add(new Seat(resultset.getInt("seatNumber"),
						resultset.getInt("seatState")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return testSeatDB;
	}

	public void removeRegisteredUser(String name) {

		try {

			String query = "DELETE FROM REGISTERED_USER WHERE userName = ?";
			PreparedStatement myStmt = connection.prepareStatement(query);

			myStmt.setString(1, name);

			int rowCount = myStmt.executeUpdate();
			System.out.println("Rows affected: " + rowCount);

			myStmt.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
