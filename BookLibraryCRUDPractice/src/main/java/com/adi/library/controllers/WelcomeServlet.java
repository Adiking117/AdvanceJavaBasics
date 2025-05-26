package com.adi.library.controllers;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import static com.adi.library.utils.DBUtils.*;

import java.io.IOException;
import java.sql.SQLException;

import com.adi.library.dao.BookDAO;
import com.adi.library.dao.BookDAOImpl;


/**
 * Servlet implementation class WelcomeServlet
 */
@WebServlet(value = "/welcome",loadOnStartup = 1)
public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static BookDAOImpl bookDAO;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		try {
			openConnection();
			bookDAO = new BookDAOImpl();
			System.out.println("Servlet initialiazation Started , DAO instance created");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ServletException("Servlet initialization failed",e);
		}
		
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		try {
			bookDAO.cleanUp();
			closeConnection();
			System.out.println("Servlet Lifecycle ends"
					+ " and Database Connection closed and Destroyed");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect(req.getContextPath() + "/welcome.html");
    }

}
