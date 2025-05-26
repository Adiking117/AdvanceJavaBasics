package com.adi.library.dao;

import java.sql.SQLException;

import com.adi.library.entity.Book;
import com.adi.library.pojos.BookRequest;

public interface BookDAO {
	boolean createBook(BookRequest book) throws SQLException;
	Book readBook(Long id) throws SQLException;
	boolean updateBook(BookRequest book);
	boolean deleteBook(Long id);
}
