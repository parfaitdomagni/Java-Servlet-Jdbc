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
import javax.servlet.http.HttpSession;

import dao.EmployeeDao;
import model.Employee;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("Text/html");
		PrintWriter out = response.getWriter();
		String loginId = request.getParameter("loginId");
		String password = request.getParameter("password");
		System.out.println("Connection establish........");
		HttpSession session = request.getSession();
		session.setAttribute("loginId", loginId);
		session.setAttribute("password",password);
		
		out.print("<html>");
		if(loginId.equalsIgnoreCase("HR") && password.equalsIgnoreCase("HR")) {
			RequestDispatcher rd = request.getRequestDispatcher("/HrPageServlet");
			rd.forward(request, response);
		}
		else {
			
			EmployeeDao employeeDao = new EmployeeDao();
			Employee employee = employeeDao.getEmployee(loginId, password);
			if(employee != null) {
				out.print("<body bgcolor=blue>");
				out.print("<h1><center>Welcome to Employee Page</center></h1>");
				RequestDispatcher rd = request.getRequestDispatcher("/EmployeePageServlet");
				rd.forward(request, response);
				out.print("</body>");
			}else {
				out.print("<body bgcolor=red>");
				out.print("<h1><center>Wrong credential try it again</center></h1>");
				RequestDispatcher rd = request.getRequestDispatcher("/Logging.html");
				rd.include(request, response);
				out.print("</body>");
			}
			
		}
		out.print("</html>");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
