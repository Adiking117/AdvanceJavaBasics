package com.adi.voting.controller;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import static com.adi.voting.utils.DBUtils.closeConnection;
import static com.adi.voting.utils.DBUtils.openConnection;

import java.io.IOException;
import java.sql.SQLException;

import com.adi.voting.dao.CandidateDAOImpl;
import com.adi.voting.dao.UserDAOImpl;

// @WebServlet(value = "/welcome",loadOnStartup = 1)
public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static UserDAOImpl userDAO;
	static CandidateDAOImpl candidateDAO;
	
	

	public WelcomeServlet() {
		System.out.println("Welcome Constructor "+ getServletConfig());
	}


	public void init(/*ServletConfig config*/) throws ServletException {
		try {
			ServletConfig config = getServletConfig();
			System.out.println("Welcome Init "+ config);
			
			openConnection(
					config.getInitParameter("db_url"),
					config.getInitParameter("user_name"),
					config.getInitParameter("password")
				);
			
			userDAO = new UserDAOImpl();
			candidateDAO = new CandidateDAOImpl();
			System.out.println("Database Connected and DAO instances Created");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace(); // JAVA Compiler
			throw new ServletException("Servlet initialization failed",e);	// Web Container
		}
		
	}

	public void destroy() {
		try {
			userDAO.cleanUp();
			candidateDAO.cleanUp();
			closeConnection();
			System.out.println("Servlet Lifecycle ends"
					+ " and Database Connection closed and Destroyed");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
