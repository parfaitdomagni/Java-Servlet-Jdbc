package com.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmployeeDao;
import model.Employee;

@WebServlet("/AllEmployeeServlet")
public class AllEmployeeServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		EmployeeDao employeeDao = new EmployeeDao();
		List<Employee> empList = employeeDao.getAllEmployee();
		if(empList != null) {
			RequestDispatcher rd = request.getRequestDispatcher("/HrPageServlet");
			rd.include(request, response);
			out.print("<table border=3 align=center>");
			out.print("<tr><th>ID</th><th>Name</th><td>Salary</th><th>LoginId</th><th>Password</th></tr>");
			for(Employee employee:empList) {
			out.print("<tr><td>"+ employee.getId() +"</td><td>"+employee.getName()+"</td><td>"+employee.getSalary()+"</td><td>"+ employee.getLoginId()+"</td><td>"+employee.getPassword() +"</td></tr>" );
			}
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
