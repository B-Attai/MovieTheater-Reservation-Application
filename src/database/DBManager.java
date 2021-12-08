package database;

import java.sql.*;

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

	public ResultSet selectAll(String tableName) { // Generic "SELECT * TABLE" to avoid hard_coding

		// StringBuffer movie = new StringBuffer();

		try {
			String query = "SELECT * FROM " + tableName;
			statement = connection.prepareStatement(query);
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
	public String searchAllMovie() {

		StringBuffer movie = new StringBuffer();

		try {
			Statement myStmt = connection.createStatement();
			resultset = myStmt.executeQuery("SELECT * FROM MOVIES");

			while (resultset.next()) {

				movie.append(resultset.getString("movieName"));
				movie.append('\n');
			}

			myStmt.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return movie.toString();

	}
	 //Delete a particular movie
	public void deleteMovie(String name) {

		try {

			String query = "DELETE FROM MOVIE WHERE Mov_Name = ?";
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

	public static void main(String[] Args) {

		DBManager database = new DBManager();

//		database.selectAll("registered_user");
//		//database.selectMovies(1);
//		database.searchAllMovie();

		database.deleteMovie("Iron Man");
		database.removeRegisteredUser("Ally Bur");

	}

}
