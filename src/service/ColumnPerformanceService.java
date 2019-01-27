package service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mySQLConnect.ColumnChartData;

/**
 * Servlet implementation class ColumnPerformanceService
 */
@WebServlet("/ColumnPerformanceService")
public class ColumnPerformanceService extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ColumnChartData cData = new ColumnChartData();
		String performanceData = cData.getPerformanceData();
		PrintWriter out = response.getWriter();
		out.print(performanceData);
	}

}
