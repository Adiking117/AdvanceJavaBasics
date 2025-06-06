package com.adi.voting.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import com.adi.voting.entity.User;
import com.adi.voting.exception.UserNotAuthenticatedException;

@WebServlet("/auth")
public class AuthServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		try(PrintWriter printWriter = response.getWriter()){
			
//			Cookie[] cookies = request.getCookies();
//			if(cookies == null) {
//				printWriter.print("<h5>No Cookies , session tracking failed , "
//			    		+ "Can't Continue !!!!!</h5>");
//				throw new UserNotAuthenticatedException("User Not Authenticated");
//			}
//			// Cookie c1=cookies[0];
//					
//			String userCookieString = null;
//			
//			for(Cookie cookie : cookies) {
//				if(cookie.getName().equals("userDetails")) {
//					userCookieString = URLDecoder.decode(cookie.getValue(), "utf-8");
//					printWriter.print("<h5> User Details from the cookie"
//					+userCookieString+"</h5>");
//					break;
//				}
//			}
//						
//			// response.sendRedirect(request.getContextPath() + "/candidates.jsp");
//			
//			if(userCookieString == null) {
//				printWriter.print("<h5>No Cookies , session tracking failed , "
//			    		+ "Can't Continue !!!!!</h5>");
//				throw new UserNotAuthenticatedException("User Not Authenticated");
//			}
			
			HttpSession httpSession = request.getSession();
			
			System.out.println("session id auth "+httpSession.getId());
			System.out.println("session is new auth "+httpSession.isNew());
			
			User currentUser = (User) httpSession.getAttribute("userInfo");
			if(currentUser!=null) {
				printWriter.print("<h5> You have logged In Successfully"
						+ " "+ "You can <a href='candidates.jsp'>Vote</a> Now </h5>"
						+"</h5>");
			}else {
				printWriter.print("<h5>No Cookies , session tracking failed , "
			    		+ "Can't Continue !!!!!</h5>");
				throw new UserNotAuthenticatedException("User Not Authenticated");
			}
			
			
		
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}

}
