<%@ page import="com.adi.voting.entity.Candidate" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Candidate Details</title>
    <style>
        /* General Styles */
	body {
	    font-family: 'Poppins', sans-serif;
	    background: linear-gradient(135deg, #f3f3f3, #e8e8e8);
	    text-align: center;
	    padding: 30px;
	}
	
	/* Table Styling */
	table {
	    width: 50%;
	    margin: auto;
	    border-collapse: collapse;
	    background: white;
	    box-shadow: 0px 5px 15px rgba(0, 0, 0, 0.2);
	    border-radius: 10px;
	    overflow: hidden;
	    animation: fadeIn 1s ease-in-out;
	}
	
	th {
	    background-color: #007bff;
	    color: white;
	    padding: 12px;
	    font-size: 1.2rem;
	    text-transform: uppercase;
	}
	
	td {
	    padding: 10px;
	    border-bottom: 1px solid #ddd;
	}
	
	/* Row Hover Effect */
	tr:hover {
	    background-color: rgba(0, 123, 255, 0.1);
	    transition: 0.3s ease-in-out;
	}
	
	/* Vote Button */
	button {
	    padding: 12px;
	    font-size: 1rem;
	    font-weight: bold;
	    background: linear-gradient(135deg, #007bff, #0056b3);
	    color: white;
	    border: none;
	    border-radius: 5px;
	    cursor: pointer;
	    box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.2);
	    transition: all 0.3s ease-in-out;
	}
	
	button:hover {
	    background: linear-gradient(135deg, #0056b3, #003d80);
	    transform: scale(1.05);
	}
	
	/* Animations */
	@keyframes fadeIn {
	    0% { opacity: 0; transform: translateY(-20px); }
	    100% { opacity: 1; transform: translateY(0); }
	}

    </style>
</head>
<body>

    <h2>Candidate Information</h2>

    <%
        Candidate candidate = (Candidate) request.getAttribute("candidateInfo");
        if (candidate != null) {
    %>

    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Party</th>
                <th>Votes</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td><%= candidate.getCandidateId() %></td>
                <td><%= candidate.getName() %></td>
                <td><%= candidate.getPartyName() %></td>
                <td id="voteCount"><%= candidate.getVotes() %></td>
            </tr>
        </tbody>
    </table>

    <form action="logout" method="post">
        <input type="hidden" name="candidateId" value="<%= candidate.getCandidateId() %>">
        <button type="submit">Vote for <%= candidate.getName() %></button>
    </form>

    <%
        } else {
    %>
        <p>No candidate found for the given ID.</p>
    <%
        }
    %>

</body>
</html>
