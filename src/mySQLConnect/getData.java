package mySQLConnect;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class getData {

	public static void main(String[] args) {
		getData data = new getData();
		List<String> s1 = data.getDropoutDetail();
		System.out.println(s1.toString());
	}

	public List<String> getDropoutDetail(){
		List<String> dropout = new ArrayList<>();
		
		Connection conn = ConnectDb.dbConnection();

		// TODO: Get Resultset
		try {
			Statement stmt = conn.createStatement();
			String sql = "SELECT SUM(Drop_Count) as dropCount, COUNT(Drop_Count) as serviveCount,"
					+ " Course from dropout_dashboard GROUP BY Course "
					+ "order by (( SUM(Drop_Count) / COUNT(Drop_Count))* 100) DESC";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				/*System.out.println("=================================");
				System.out.println("Dropout Count: "+rs.getString(1));
				System.out.println("Servive Count: "+rs.getString(2));
				System.out.println("Branch: "+rs.getString(3));*/
				String course = rs.getString("Course");
				String dropCount = rs.getString("dropCount");
				String serviveCount = rs.getString("serviveCount");
				dropout.add(course);
				dropout.add(dropCount);
				dropout.add(serviveCount);
				
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dropout;

	}
}


