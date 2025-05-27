<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.adi.library.entity.Book" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Get Book Details</title>
    <style>
        body {
            font-family: "Poppins", sans-serif;
            background: linear-gradient(to right, #6a11cb, #2575fc);
            text-align: center;
            padding: 50px;
            color: white;
        }

        h1 {
            font-size: 32px;
            text-shadow: 2px 2px 4px rgba(0,0,0,0.3);
        }

        .book-details {
            background: white;
            color: black;
            padding: 25px;
            border-radius: 12px;
            box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.3);
            display: inline-block;
            margin-top: 20px;
            transition: transform 0.3s ease-in-out;
        }

        .book-details:hover {
            transform: scale(1.05);
        }

        p {
            font-size: 18px;
            margin: 10px 0;
        }

        .no-book {
            font-size: 20px;
            color: #ffd700;
        }
    </style>
</head>
<body>

    <h1>Book Information</h1>
    <% 
        Object bookObj = request.getAttribute("book");
        if (bookObj != null) { 
            Book book = (Book) bookObj;
    %>
        <div class="book-details">
            <h2>Book Details</h2>
            <p><strong>ID:</strong> <%= book.getId() %></p>
            <p><strong>Name:</strong> <%= book.getName() %></p>
            <p><strong>Author:</strong> <%= book.getAuthor() %></p>
            <p><strong>Stock:</strong> <%= book.getStock() %></p>
            <p><strong>Price:</strong> ₹<%= book.getPrice() %></p>
        </div>
    <% 
        } else if (request.getParameter("id") != null) { 
    %>
        <p class="no-book">No book found with the provided ID.</p>
    <% } %>

</body>
</html>
