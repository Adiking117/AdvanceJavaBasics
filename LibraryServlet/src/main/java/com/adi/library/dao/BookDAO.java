package com.adi.library.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.adi.library.entity.Book;
import com.adi.library.util.DBConnection;

public class BookDAO {
	public void insertBook(Book book) {
		try (Connection conn = DBConnection.getConnection()) {
			String sql = "INSERT INTO books (title, author) VALUES (?, ?)";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, book.getTitle());
			stmt.setString(2, book.getAuthor());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
