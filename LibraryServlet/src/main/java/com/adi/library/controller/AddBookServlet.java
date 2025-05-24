package com.adi.library.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.adi.library.dao.BookDAO;
import com.adi.library.entity.Book;

/**
 * Servlet implementation class AddBookServlet
 */
@WebServlet("/AddBookServlet")
public class AddBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // response.setContentType("text/html")
		response.sendRedirect("addBook.jsp");
	}

 
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
        String author = request.getParameter("author");

        Book book = new Book();
        book.setTitle(title);
        book.setAuthor(author);

        BookDAO dao = new BookDAO();
        dao.insertBook(book);
        
        System.out.println("Book added success");

	}

}
