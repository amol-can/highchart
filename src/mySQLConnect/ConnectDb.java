package mySQLConnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDb {
	
	public Connection dbConnection() throws ClassNotFoundException {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn =
					DriverManager.getConnection("jdbc:mysql://localhost:3306/skala?" +
							"user=root&password=password");
			System.out.println("Database connection Successuful");

		} catch (SQLException ex) {
			// handle any errors
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
		return conn;		
	}
	
}





