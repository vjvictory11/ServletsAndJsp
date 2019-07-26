package com.db.employeeManagementSystem.controller;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.db.employeeManagementSystem.bean.Login;
import com.db.employeeManagementSystem.service.LoginService;
import com.db.employeeManagementSystem.service.LoginServiceImpl;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		System.out.println(userName);
		System.out.println(password);
		
		RequestDispatcher dispatcher = null;
		LoginService loginService = new LoginServiceImpl();
		Login login  = new Login(userName, password);
		if(loginService.authenticate(login)){
//			response.sendRedirect("adminHome.html");
			dispatcher = request.getRequestDispatcher("adminHome.html");
			dispatcher.forward(request,response);
		}
		else
		{
			response.sendRedirect("form.html");
		}
	}

}
