package com.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/HrPageServlet")
public class HrPageServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		//String loginId = request.getParameter("loginId");
		HttpSession session = request.getSession();
		String loginId = (String)session.getAttribute("loginId");
		out.print("<body bgcolor=yellow>");
		out.print("<h1><h3>"+"hi: " + loginId +"</h3><center>Welcome to the Hr page</center></h1>");
		out.print("<h3><center><a href='EmployeeById.html'> Display Employee By Id </a></center></h3>");
		out.print("<h3><center><a href='AllEmployeeServlet'>Display All the Employee</a><center><h3>");
		out.print("</body>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
