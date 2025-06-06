package com.adi.voting.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import com.adi.voting.dao.CandidateDAOImpl;
import com.adi.voting.entity.User;

/**
 * Servlet implementation class GetAllCandidates
 */
@WebServlet("/AllCandidates")
public class GetAllCandidates extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try(PrintWriter printWriter = response.getWriter()){
			HttpSession httpSession = request.getSession();
			
			System.out.println("session id getAllCandidates "+httpSession.getId());
			System.out.println("session is new getAllCandidates "+httpSession.isNew());
			
			// User user = (User) httpSession.getAttribute("userInfo");
			CandidateDAOImpl candidateDAO = (CandidateDAOImpl) httpSession.getAttribute("candidateDAO");
			
			request.setAttribute("allCandidatesList", candidateDAO.getAllCandidates());
			request.getRequestDispatcher("/getAllCandidates.jsp").forward(request, response);
			
			// printWriter.write("All Candidates List "+candidateDAO.getAllCandidates());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 

}
