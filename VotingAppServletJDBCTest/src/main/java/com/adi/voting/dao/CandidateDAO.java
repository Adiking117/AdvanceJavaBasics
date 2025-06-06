package com.adi.voting.dao;

import java.sql.SQLException;
import java.util.List;

import com.adi.voting.entity.Candidate;

public interface CandidateDAO {
	List<Candidate> getAllCandidates() throws SQLException;
	Candidate getCandidateById(int candidateId) throws SQLException;
	String incrementCandidateVotes(int candidateId) throws SQLException;
}
