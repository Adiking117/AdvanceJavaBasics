package com.adi.library.utils;

public class SQLQuerys {
	private static String createBookQueryString = 
		    "INSERT INTO books (name, author, stock, price) VALUES (?, ?, ?, ?)";

		private static String readBookQueryString = 
		    "SELECT id, name, author, stock, price FROM books WHERE id = ?";

		private static String updateBookQueryString = 
		    "UPDATE books SET name = ?, author = ?, stock = ?, price = ? WHERE id = ?";

		private static String deleteBookQueryString = 
		    "DELETE FROM books WHERE id = ?";

		public static String getCreateBookQueryString() {
			return createBookQueryString;
		}

		public static String getReadBookQueryString() {
			return readBookQueryString;
		}

		public static String getUpdateBookQueryString() {
			return updateBookQueryString;
		}

		public static String getDeleteBookQueryString() {
			return deleteBookQueryString;
		}
		
		

}
