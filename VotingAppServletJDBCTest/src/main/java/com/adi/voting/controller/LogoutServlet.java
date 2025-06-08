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
import com.adi.voting.dao.UserDAOImpl;
import com.adi.voting.entity.User;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try(PrintWriter printWriter = response.getWriter()){
			printWriter.print("Logged out Success...");
			HttpSession httpSession = request.getSession();
			
			System.out.println("session id logout "+httpSession.getId());
			System.out.println("session is new logout "+httpSession.isNew());
			
			httpSession.invalidate();
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		int userId = Integer.parseInt(req.getParameter("id"));
		int candidateId = Integer.parseInt(req.getParameter("candidateId"));
		try(PrintWriter printWriter = resp.getWriter()){
			printWriter.print("Logged out Success...");
			HttpSession httpSession = req.getSession();
			
			System.out.println("session id logout "+httpSession.getId());
			System.out.println("session is new logout "+httpSession.isNew());
			
			CandidateDAOImpl candidateDAO = (CandidateDAOImpl) httpSession.getAttribute("candidateDAO");
			UserDAOImpl userDAO = (UserDAOImpl) httpSession.getAttribute("userDAO");
			// int userId = (int)(User)httpSession.getAttribute("userInfo").getUserId();
			
			User user = (User)httpSession.getAttribute("userInfo");
			String updateVoteString = candidateDAO.incrementCandidateVotes(candidateId);
			userDAO.updateVotingStatus(user.getUserId());
			
			httpSession.invalidate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
