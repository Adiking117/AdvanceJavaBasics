package com.adi.voting.controller;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.sql.SQLException;

import com.adi.voting.dao.UserDAO;
import com.adi.voting.dao.UserDAOImpl;
import com.adi.voting.entity.User;
import com.adi.voting.exception.UserNotFoundException;

import static com.adi.voting.utils.DBUtils.*;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
//	private UserDAOImpl userDAO;
//	
//	public void init(ServletConfig config) throws ServletException {
//		try {
//			userDAO = new UserDAOImpl();
//			System.out.println("DAO instance created");
//		} catch (ClassNotFoundException | SQLException e) {
//			e.printStackTrace(); // JAVA Compiler
//			throw new ServletException("Servlet initialization failed",e);	// Web Container
//		}
//	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		try(PrintWriter printWriter = response.getWriter()){
			
			String emailString = request.getParameter("em");
			String passwordString = request.getParameter("pass");
			
			User user = WelcomeServlet.userDAO.loginUser(emailString, passwordString);
			
			if(user == null) {
				printWriter.print("<h5> Invalid Login , " + "Please <a href='login.html'>Retry</a></h5>");
				throw new UserNotFoundException("User Not Found");
			}
			
			String encodedUserString = URLEncoder.encode(user.toString(),"utf-8");
			Cookie userCookie = new Cookie("userDetails", encodedUserString);
			response.addCookie(userCookie);
			
			// Tomcat uses default Cookie processor thats why encoding user details
			
			if(user.getUserRole().equals("admin")) {
	            response.sendRedirect("admin");
	        } else {
	            if(user.isStatus()) {
	                response.sendRedirect("logout");
	            } else {
	                response.sendRedirect("candidates");
	            }
	        }
			
			
		} catch (Exception e) {
			throw new ServletException("Login failed ", e);
		}
	}
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		resp.setContentType("text/html");
//		resp.sendRedirect(req.getContextPath() + "/login.html");
//	}

}
