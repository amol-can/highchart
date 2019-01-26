package service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mySQLConnect.GetData;

public class getJson extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("Inside servlet");
		PrintWriter out = response.getWriter();
		GetData gData = new GetData();
		String dropData = gData.getDropoutData();
		out.println(dropData);
		//out.print("{ \"xAxis\":{ \"categories\":[\"Africa\", \"America\", \"Asia\",\"Europe\", \"Oceania\" ] }}");		
	}
	
}
