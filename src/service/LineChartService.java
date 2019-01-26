package service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mySQLConnect.LineChartData;

/**
 * Servlet implementation class LineChartService
 */
@WebServlet("/LineChartService")
public class LineChartService extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		LineChartData lChart = new LineChartData();
		String lineDropdata = lChart.getDropoutData();
		
		PrintWriter out = response.getWriter();
		out.println(lineDropdata);
	}

}
