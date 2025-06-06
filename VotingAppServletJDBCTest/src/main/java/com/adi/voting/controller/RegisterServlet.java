package com.adi.voting.controller;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import static com.adi.voting.utils.DBUtils.openConnection;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.adi.voting.dao.UserDAOImpl;
import com.adi.voting.pojo.UserRequest;


@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		try(PrintWriter printWriter = response.getWriter()){
			
			String firstName = request.getParameter("firstName");
	        String lastName = request.getParameter("lastName");
	        String email = request.getParameter("email");
	        String password = request.getParameter("password");
	        String userRole = request.getParameter("userRole");
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date dob = sdf.parse(request.getParameter("dob"));
            
            boolean userRegistered = WelcomeServlet.userDAO.registerUser(new UserRequest(firstName,lastName,
            		email,password,dob,userRole));
            
            if(userRegistered) {
				printWriter.print("<h5> Register Successfully , " + "You can do <a href='login.html'>Login</a></h5>");
            	// response.sendRedirect("login");
            }else {
    			printWriter.print("<h5> User Alreaddy Exsits , " + "Please <a href='login.html'>Login</a></h5>");
            }
  	
		} catch (Exception e) {
			e.printStackTrace();
		} 
			
	}

}
