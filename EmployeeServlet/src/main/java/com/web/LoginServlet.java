package com.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("Text/html");;
		PrintWriter out = response.getWriter();
		String loginId = request.getParameter("loginId");
		String password = request.getParameter("password");
		System.out.println("Data received  " + loginId);
		out.print("<html>");
		if(loginId.equalsIgnoreCase("HR") && password.equalsIgnoreCase("HR")) {
		out.print("Wellooooooooooooooo");
//			RequestDispatcher rd = request.getRequestDispatcher("HrHomePage");
//			rd.forward(request, response);
			
		}else{
			out.print("<body bgcolor=yellow text=red>");
			out.print("<h1><center>wrong Credential</center><h1>");
			RequestDispatcher rd = request.getRequestDispatcher("EmpPractice.html");
			rd.include(request, response);
			out.print("</body>");
			
		}
		
		out.print("</html");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
