package mySQLConnect;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.mysql.jdbc.Statement;

public class getData {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		JsonObject jObj = new JsonObject();
		ArrayList<String> arrL = new ArrayList<>();
		
		
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
			
			arrL.add(rs.getString(1));
			arrL.add(rs.getString(2));
			arrL.add(rs.getString(3));	
			
		}
		System.out.println(arrL.size());

	}

}


