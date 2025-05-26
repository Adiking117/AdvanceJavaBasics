<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Get Book Details</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }
        form {
            margin-bottom: 20px;
        }
        label {
            display: block;
            margin-bottom: 8px;
        }
        input[type="number"] {
            padding: 8px;
            width: 200px;
        }
        button {
            padding: 8px 16px;
            margin-top: 8px;
        }
        .book-details {
            border: 1px solid #ccc;
            padding: 15px;
            margin-top: 15px;
            max-width: 400px;
        }
    </style>
</head>
<body>
    <h1>Retrieve a Book by ID</h1>

    <!-- Form to capture the Book ID -->
    <form action="read" method="get">
        <label for="bookId">Book ID:</label>
        <input type="number" id="bookId" name="id" required>
        <button type="submit">Get Book</button>
    </form>

<!-- 
    <%-- If a "book" attribute exists, display the details --%>
    <% 
        Object bookObj = request.getAttribute("book");
        if (bookObj != null) { 
            // Assuming there is a Book bean with proper getters
            Book book = (Book) bookObj; 
    %>
        <div class="book-details">
            <h2>Book Details</h2>
            <p><strong>ID:</strong> <%= book.getId() %></p>
            <p><strong>Name:</strong> <%= book.getName() %></p>
            <p><strong>Author:</strong> <%= book.getAuthor() %></p>
            <p><strong>Stock:</strong> <%= book.getStock() %></p>
            <p><strong>Price:</strong> <%= book.getPrice() %></p>
        </div>
    <% 
        } else if (request.getParameter("id") != null) { 
    %>
        <p>No book found with the provided ID.</p>
    <% } %>
    
-->
</body>
</html>
