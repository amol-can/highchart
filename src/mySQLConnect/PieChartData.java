package mySQLConnect;

import java.sql.Connection;
import java.sql.ResultSet;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.mysql.jdbc.Statement;

public class PieChartData {
	
	public String getDropoutData() {
		//TODO: get connection object of DB
		ConnectDb cDb =new ConnectDb();
		
		JSONArray jArray = new JSONArray();
		try {
			Connection conn = cDb.dbConnection();	

			Statement stmt =(Statement) conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT SUM(Drop_Count) as drpCount,(SUM(Drop_Count) / SUM(Enroll_Count)  * 100) as per ,"
					+ " Age FROM `dropout_dashboard` GROUP by Age ORDER BY per DESC");

			while(rs.next()) {
				JSONObject jObj = new JSONObject();
				jObj.put("age", rs.getString("Age"));
				jObj.put("dropout", rs.getInt("drpCount"));
				jObj.put("dropPer", rs.getInt("per"));
				jArray.add(jObj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Age pie chart data from DB: "+jArray.toJSONString());
		return jArray.toJSONString();
	}
}
