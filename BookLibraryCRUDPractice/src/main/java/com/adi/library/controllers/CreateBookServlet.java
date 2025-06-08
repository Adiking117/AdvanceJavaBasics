package com.adi.library.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import com.adi.library.pojos.BookRequest;

/**
 * Servlet implementation class CreateBookServlet
 */
@WebServlet("/add")
public class CreateBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bookName = request.getParameter("name");
		String bookAuthor = request.getParameter("author");
		int bookStock = Integer.parseInt(request.getParameter("stock"));
		double bookPrice = Double.parseDouble(request.getParameter("price"));
		
		try(PrintWriter printWriter = response.getWriter()){
			boolean bookCreated = WelcomeServlet.bookDAO.createBook(
					new BookRequest(bookName,bookAuthor,bookStock,bookPrice));
			if(bookCreated) {
				printWriter.print("<h3>Book Created Successfully</h3>");
			}
			
		} catch (SQLException e) {
			// printWriter.print("<h3>Book Creation failed</h3>");
			e.printStackTrace();
		}
		
		
	}

}
