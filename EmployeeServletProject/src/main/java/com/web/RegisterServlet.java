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


@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		int empId = Integer.parseInt(request.getParameter("empId"));
		String empName = request.getParameter("empName");
		double salary = Double.parseDouble(request.getParameter("salary"));
		String loginId = request.getParameter("loginId");
		String password = request.getParameter("password");
		
		Employee employee = new Employee();
		employee.setId(empId);
		employee.setName(empName);
		employee.setSalary(salary);
		employee.setLoginId(loginId);
		employee.setPassword(password);
		
		EmployeeDao employeeDao = new EmployeeDao();
		int x = employeeDao.register(employee);
		if(x > 0) {
		out.print("<body bgcolor=green>");
		out.print("<h1><center>Registration Success...........</center></h1>");
		RequestDispatcher rd = request.getRequestDispatcher("/Logging.html");
		rd.include(request, response);
		out.print("</body>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
