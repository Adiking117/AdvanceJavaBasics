<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Book</title>
</head>
<body>
    <h2>Add a New Book</h2>
    <form action="AddBookServlet" method="post">
        <label for="title">Book Title:</label>
        <input type="text" id="title" name="title" required><br><br>

        <label for="author">Author Name:</label>
        <input type="text" id="author" name="author" required><br><br>

        <input type="submit" value="Add Book">
    </form>
</body>
</html>

