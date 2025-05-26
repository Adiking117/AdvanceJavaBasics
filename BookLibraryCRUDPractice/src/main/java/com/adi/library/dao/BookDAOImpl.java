package com.adi.library.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.adi.library.entity.Book;
import com.adi.library.pojos.BookRequest;
import com.adi.library.utils.SQLQuerys;
import static com.adi.library.utils.DBUtils.*;

public class BookDAOImpl implements BookDAO{

	private Connection connection;
	private PreparedStatement createPreparedStatement,readPreparedStatement,
	deletePreparedStatement,updatePreparedStatement;
	
	public BookDAOImpl() throws SQLException {
		connection = getConnection();
		createPreparedStatement = connection.prepareStatement(SQLQuerys.getCreateBookQueryString());
		readPreparedStatement = connection.prepareStatement(SQLQuerys.getReadBookQueryString());
		updatePreparedStatement = connection.prepareStatement(SQLQuerys.getUpdateBookQueryString());
		deletePreparedStatement = connection.prepareStatement(SQLQuerys.getDeleteBookQueryString());
	}
	
	@Override
	public boolean createBook(BookRequest book) throws SQLException {
		createPreparedStatement.setString(1,book.getName());
		createPreparedStatement.setString(2,book.getAuthor());
		createPreparedStatement.setInt(3,book.getStock());
		createPreparedStatement.setDouble(4,book.getPrice());
		
		int bookCreated = createPreparedStatement.executeUpdate();
		
		return bookCreated == 1;
		
	}

	@Override
	public Book readBook(Long id) throws SQLException {
		readPreparedStatement.setLong(1,id);
		
		try(ResultSet bookResultSet = readPreparedStatement.executeQuery()){
			if(bookResultSet.next()) {
				return new Book(
						bookResultSet.getLong(1),
						bookResultSet.getString(2),
						bookResultSet.getString(3),
						bookResultSet.getInt(4),
						bookResultSet.getDouble(5)
					);
			}
		}
		return null;
	}

	@Override
	public boolean updateBook(BookRequest book) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteBook(Long id) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public void cleanUp() throws SQLException {
		if (createPreparedStatement != null) {
			createPreparedStatement.close();
			createPreparedStatement = null;
		}
		if (readPreparedStatement != null) {
			readPreparedStatement.close();
			readPreparedStatement = null;
		}
		if (updatePreparedStatement != null) {
			updatePreparedStatement.close();
			updatePreparedStatement = null;
		}
		if (deletePreparedStatement != null) {
			deletePreparedStatement.close();
			deletePreparedStatement = null;
		}
		// closeConnection();
	}

}
