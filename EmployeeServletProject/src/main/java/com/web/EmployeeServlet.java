package com.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("Text/html");
		PrintWriter out = response.getWriter();
		String loginId = request.getParameter("loginId");
		String password = request.getParameter("password");
		System.out.println("Connection establish........");
		out.print("<html>");
		if(loginId.equalsIgnoreCase("HR") && password.equalsIgnoreCase("HR")) {
			RequestDispatcher rd = request.getRequestDispatcher("/HrPageServlet");
			rd.forward(request, response);
		}
		else {
			out.print("<body bgcolor=red>");
			out.print("<h1><center>Wrong credential try it again</center></h1>");
			RequestDispatcher rd = request.getRequestDispatcher("/Logging.html");
			rd.include(request, response);
			out.print("</body>");
			
			
		}
		out.print("</html>");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
