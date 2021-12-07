package com.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmployeeDao;
import model.Employee;


@WebServlet("/EmployeeById")
public class EmployeeById extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		int empId = Integer.parseInt(request.getParameter("empId"));

		EmployeeDao employeeDao = new EmployeeDao();
		Employee employee = employeeDao.getEmployee(empId);
		if(employee != null) {
			RequestDispatcher rd = request.getRequestDispatcher("/HrPageServlet");
			rd.include(request, response);
			out.print("<table border=3 align=center>");
			out.print("<tr><th>ID</th><th>Name</th><td>Salary</th><th>LoginId</th><th>Password</th></tr>");
			out.print("<tr><td>"+ employee.getId() +"</td><td>"+employee.getName()+"</td><td>"+employee.getSalary()+"</td><td>"+ employee.getLoginId()+"</td><td>"+employee.getPassword() +"</td></tr>" );
			out.print("</table>");
		}

		else {

			out.print("<body bgcolor=red>");
			out.print("<h1><center>Wrong credential try it again</center></h1>");
			RequestDispatcher rd = request.getRequestDispatcher("/Logging.html");
			rd.include(request, response);
			out.print("</body>");

		}


	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
