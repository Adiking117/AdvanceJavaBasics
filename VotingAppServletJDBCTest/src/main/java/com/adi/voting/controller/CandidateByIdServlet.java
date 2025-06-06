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

/**
 * Servlet implementation class CandidateByIdServlet
 */
@WebServlet("/CandidateById")
public class CandidateByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try(PrintWriter printWriter = response.getWriter()){
			int candidateId = Integer.parseInt(request.getParameter("candidateId"));
			HttpSession httpSession = request.getSession();
			
			System.out.println("session id getByIdCandidates "+httpSession.getId());
			System.out.println("session is new getByIdCandidates "+httpSession.isNew());
			
			// User user = (User) httpSession.getAttribute("userInfo");
			CandidateDAOImpl candidateDAO = (CandidateDAOImpl) httpSession.getAttribute("candidateDAO");
			request.setAttribute("candidateInfo", candidateDAO.getCandidateById(candidateId));
			request.getRequestDispatcher("/getByIdCandidate.jsp").forward(request, response);
			
			
			// printWriter.write("Candidate fetched "+ candidateDAO.getCandidateById(candidateId));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
