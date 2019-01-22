package mySQLConnect;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

public class getData {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		ConnectDb cDb =new ConnectDb();
		Connection conn = cDb.dbConnection();
		
		/**
		 * Get Resultset
		 */
		Statement stmt =(Statement) conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT SUM(Drop_Count) as dper, COUNT(Drop_Count) "
				+ "as sper, Course from dropout_dashboard GROUP BY Course "
				+ "order by (( SUM(Drop_Count) / COUNT(Drop_Count))* 100) DESC");
		while(rs.next()) {
			System.out.println("=================================");
			System.out.println("Dropout Count: "+rs.getString(1));
			System.out.println("Servive Count: "+rs.getString(2));
			System.out.println("Branch: "+rs.getString(3));
		}

	}

}


