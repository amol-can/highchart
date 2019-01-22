package mySQLConnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDb {
	
	public static Connection dbConnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("DB driver loaded");
			conn =
					DriverManager.getConnection("jdbc:mysql://localhost:3306/skala?" +
							"user=root&password=password");
		} catch (SQLException ex) {
			// TODO: handle any sqlException errors
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
		catch (ClassNotFoundException e) {
			// TODO: handle class not found exception
			System.out.println("ClassNotFound Exception: "+ e.getMessage());
		}
		if (conn != null) {
			System.out.println("Connection made to DB!");
		}
		return conn;		
	}
	
}





