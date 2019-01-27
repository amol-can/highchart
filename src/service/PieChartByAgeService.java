package service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mySQLConnect.PieChartData;

/**
 * Servlet implementation class PieChartByAgeService
 */
@WebServlet("/PieChartByAgeService")
public class PieChartByAgeService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PieChartData pieData = new PieChartData();
		String dropData = pieData.getDropoutData();
		
		PrintWriter out = response.getWriter();
		out.print(dropData);
	}

}
