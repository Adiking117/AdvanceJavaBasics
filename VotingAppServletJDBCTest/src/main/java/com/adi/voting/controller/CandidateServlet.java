package com.adi.voting.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import com.adi.voting.exception.UserNotAuthenticatedException;

/**
 * Servlet implementation class AdminDashborad
 */
@WebServlet("/candidates")
public class CandidateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		try(PrintWriter printWriter = response.getWriter()){
			
			Cookie[] cookies = request.getCookies();
			if(cookies == null) {
				printWriter.print("<h5>No Cookies , session tracking failed , "
			    		+ "Can't Continue !!!!!</h5>");
				throw new UserNotAuthenticatedException("User Not Authenticated");
			}
			// Cookie c1=cookies[0];
					
			String userCookieString = null;
			
			for(Cookie cookie : cookies) {
				if(cookie.getName().equals("userDetails")) {
					userCookieString = URLDecoder.decode(cookie.getValue(), "utf-8");
					printWriter.print("<h5> User Details from the cookie"
					+userCookieString+"</h5>");
					break;
				}
			}
			
			if(userCookieString == null) {
				printWriter.print("<h5>No Cookies , session tracking failed , "
			    		+ "Can't Continue !!!!!</h5>");
				throw new UserNotAuthenticatedException("User Not Authenticated");
			}
			
			printWriter.print("<h5> Thank You for voting "+ "Please <a href='logout.html'>Logout</a></h5>"
					+"</h5>");
		
			// response.sendRedirect(request.getContextPath() + "/candidates.jsp");
		} catch (UserNotAuthenticatedException e) {
			e.printStackTrace();
		}
		
	}

}
