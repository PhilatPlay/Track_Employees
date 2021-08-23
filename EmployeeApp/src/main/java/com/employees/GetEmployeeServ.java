package com.employees;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ListEmployeeServ")
public class GetEmployeeServ extends HttpServlet{
	List<Employee> employees = new ArrayList<>();
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html");
		EmployeeDAO dao;
		try {
			dao = EmployeeDAOFactory.getEmployeeDao();
			employees = dao.getEmployees(employees);
			request.setAttribute("employee_list", employees);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try(PrintWriter out = response.getWriter()){
			out.println("<!DOCTYPE.html>");
			out.println("<HTML>");
			out.println("<Head>");
			out.println("<title>Damn Employees</title>");
			out.println("</Head>");
			out.println("<body>");
			
			for(Employee employee : employees) {
			out.println("<table border=1 width=50% height=50%>");  
            out.println("<tr><th>Name</th><th>Email</th><th>Gender</th><th>Country</th></tr>");  
              
                String n = employee.toString();  
                String e = employee.toString();
                String g = employee.toString();  
                String c = employee.toString();
                int id = employee.getId();
                   
                out.println("<tr><td>" + n + "</td><td>" + e + "</td><td>" + g + "</td></tr>" + c + "</td></tr>");
			}
			out.println("</body>");
			out.println("<html>");
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/test.html");
			dispatcher.forward(request, response);
		}
	}
}
	

//		
					

	
	
		
