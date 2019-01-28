package mySQLConnect;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


public class LineChartData {

	public String getDropoutData() {
		//TODO: get connection object of DB
		ConnectDb cDb =new ConnectDb();
		
		JSONArray jArray = new JSONArray();
		try {
			Connection conn = cDb.dbConnection();	

			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT COUNT(*) AS total,SUM(Drop_Count) AS dropout, "
					+ "(COUNT(*) - SUM(Drop_Count)) as servive, batch from dropout_dashboard "
					+ "GROUP BY batch  ORDER BY batch");

			while(rs.next()) {
				JSONObject jObj = new JSONObject();
				jObj.put("total", rs.getInt("total"));
				jObj.put("dropout", rs.getInt("dropout"));
				jObj.put("servive", rs.getInt("servive"));
				jObj.put("batch", rs.getString("batch"));
				jArray.add(jObj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Line chart data from DB: "+jArray.toJSONString());
		return jArray.toJSONString();
	}
}
