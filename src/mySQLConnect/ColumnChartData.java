package mySQLConnect;

import java.sql.Connection;
import java.sql.ResultSet;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.mysql.jdbc.Statement;

public class ColumnChartData {
	
	public String getPerformanceData() {
		//TODO: get connection object of DB
		ConnectDb cDb =new ConnectDb();
		
		JSONArray jArray = new JSONArray();
		try {
			Connection conn = cDb.dbConnection();	

			Statement stmt =(Statement) conn.createStatement();
			ResultSet rs = stmt.executeQuery("select AVG(final_score) as performance, center_name from inst_performance "
					+ "WHERE center_name IS not null GROUP by center_name order by performance DESC");

			while(rs.next()) {
				JSONObject jObj = new JSONObject();
				jObj.put("performance", rs.getInt("performance"));
				jObj.put("institute", rs.getString("center_name"));
				jArray.add(jObj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Column chart data from DB: "+jArray.toJSONString());
		return jArray.toJSONString();
	}


}
