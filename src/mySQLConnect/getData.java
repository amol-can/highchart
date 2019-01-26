package mySQLConnect;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.mysql.jdbc.Statement;

import bean.DropoutData;

public class GetData {

	public String getDropoutData() {
		//TODO: get connection object of DB
		ConnectDb cDb =new ConnectDb();
		
		JSONArray jArray = new JSONArray();
		try {
			Connection conn = cDb.dbConnection();	

			Statement stmt =(Statement) conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT SUM(Drop_Count) as dper, COUNT(Drop_Count) "
					+ "as sper, Course from dropout_dashboard GROUP BY Course "
					+ "order by (( SUM(Drop_Count) / COUNT(Drop_Count))* 100) DESC");

			while(rs.next()) {
				/*System.out.println("=================================");
				System.out.println("Dropout Count: "+rs.getString(1));
				System.out.println("Servive Count: "+rs.getString(2));
				System.out.println("Branch: "+rs.getString(3));*/

				JSONObject jObj = new JSONObject();
				jObj.put("course", rs.getString("Course"));
				jObj.put("servive", rs.getInt("sper"));
				jObj.put("drop", rs.getInt("dper"));
				jArray.add(jObj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("column chart data from DB: "+jArray.toJSONString());
		return jArray.toJSONString();
	}
}


