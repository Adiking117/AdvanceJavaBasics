package com.adi.voting.dao;

import java.sql.SQLException;

import com.adi.voting.entity.User;
import com.adi.voting.pojo.UserRequest;

public interface UserDAO {
	User loginUser(String userEmail,String userPassword) throws SQLException;
	boolean registerUser(UserRequest user) throws SQLException;
}
