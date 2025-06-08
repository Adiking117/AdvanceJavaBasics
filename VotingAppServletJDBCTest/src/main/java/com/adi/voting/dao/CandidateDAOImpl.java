package com.adi.voting.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.adi.voting.entity.Candidate;
import static com.adi.voting.utils.DBUtils.*;
import static com.adi.voting.sqlquerys.SQLQuerys.*;


public class CandidateDAOImpl implements CandidateDAO {
	
	private Connection connection;
	private PreparedStatement allCandidatesPreparedStatement,getByIdCandidatePreparedStatement,incrementVotePreparedStatement;
	
	

	public CandidateDAOImpl() throws SQLException {
		connection = getConnection();
		allCandidatesPreparedStatement = connection.prepareStatement(getGetAllCandidatesQuery());
		getByIdCandidatePreparedStatement = connection.prepareStatement(getGetCandidatesByIdQuery());
		incrementVotePreparedStatement = connection.prepareStatement(getIncrementCandidateVotes());
	}

	@Override
	public List<Candidate> getAllCandidates() throws SQLException {
		List<Candidate> allCandidatesList = new ArrayList<>();
		try(ResultSet resultSet = allCandidatesPreparedStatement.executeQuery()){
			while(resultSet.next()) {
				allCandidatesList.add(new Candidate
						(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getInt(4)));
			}
		}
		return allCandidatesList;
	}

	@Override
	public String incrementCandidateVotes(int candidateId) throws SQLException {
		incrementVotePreparedStatement.setInt(1, candidateId);
		int votesUpdated = incrementVotePreparedStatement.executeUpdate();
		if(votesUpdated == 1) {
			return "Votes for Candidate updated Successfully";
		}
		return null;
	}

	@Override
	public Candidate getCandidateById(int candidateId) throws SQLException {
		getByIdCandidatePreparedStatement.setInt(1, candidateId);
		try(ResultSet resultSet = getByIdCandidatePreparedStatement.executeQuery()){
			if(resultSet.next()) {
				return new Candidate(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getInt(4));
			}
		}
		return null;
	}
	
	public void cleanUp() throws SQLException {
		if (allCandidatesPreparedStatement != null) {
			allCandidatesPreparedStatement.close();
			allCandidatesPreparedStatement = null;
		}
		if (getByIdCandidatePreparedStatement != null) {
			getByIdCandidatePreparedStatement.close();
			getByIdCandidatePreparedStatement = null;
		}
		if (incrementVotePreparedStatement != null) {
			incrementVotePreparedStatement.close();
			incrementVotePreparedStatement = null;
		}
		// closeConnection();
	}

}
