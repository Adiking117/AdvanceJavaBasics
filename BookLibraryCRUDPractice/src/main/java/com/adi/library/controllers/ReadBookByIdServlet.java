package com.adi.library.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

import com.adi.library.entity.Book;

/**
 * Servlet implementation class ReadBookByIdServlet
 */
@WebServlet("/read")
public class ReadBookByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long id = null;
		try {
			id = Long.parseLong(request.getParameter("bookId"));
			Book bookToRead = WelcomeServlet.bookDAO.readBook(id);
			request.setAttribute("book", bookToRead);
	        request.getRequestDispatcher("/getBook.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
