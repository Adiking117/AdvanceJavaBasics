<%@ page import="java.util.List" %>
<%@ page import="com.adi.voting.entity.Candidate" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>All Candidates</title>
    <style>
	        /* General Styles */
	body {
	    font-family: 'Poppins', sans-serif;
	    background: linear-gradient(135deg, #f3f3f3, #e8e8e8);
	    text-align: center;
	    margin: 20px;
	}
	
	/* Table Styling */
	table {
	    width: 80%;
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
	    padding: 8px 12px;
	    cursor: pointer;
	    border: none;
	    font-size: 1rem;
	    font-weight: bold;
	    background: linear-gradient(135deg, #007bff, #0056b3);
	    color: white;
	    border-radius: 5px;
	    transition: all 0.3s ease-in-out;
	    box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.2);
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

    <h2>All Candidates</h2>

    <%
        List<Candidate> candidatesList = (List<Candidate>) request.getAttribute("allCandidatesList");
        if (candidatesList != null && !candidatesList.isEmpty()) {
    %>

    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Party</th>
                <th>Votes</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <% for (Candidate candidate : candidatesList) { %>
                <tr>
                    <td><%= candidate.getCandidateId() %></td>
                    <td><%= candidate.getName() %></td>
                    <td><%= candidate.getPartyName() %></td>
                    <td><%= candidate.getVotes() %></td>
                    <td>
                        <form action="logout" method="post">
                            <input type="hidden" name="candidateId" value="<%= candidate.getCandidateId() %>">
                            <button type="submit">Vote</button>
                        </form>
                    </td>
                </tr>
            <% } %>
        </tbody>
    </table>

    <%
        } else {
    %>
        <p>No candidates found.</p>
    <%
        }
    %>

</body>
</html>
