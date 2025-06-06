<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Candidates Dashboard</title>
    <style>
	        /* General styles */
	body {
	    font-family: 'Poppins', sans-serif;
	    margin: 20px;
	    position: relative;
	    background: linear-gradient(135deg, #f3f3f3, #e8e8e8);
	}
	
	/* Logout Button */
	.logout {
	    position: absolute;
	    top: 10px;
	    right: 10px;
	}
	.logout a {
	    text-decoration: none;
	    color: white;
	    background-color: #d9534f;
	    padding: 10px 18px;
	    border-radius: 5px;
	    box-shadow: 2px 2px 5px rgba(0, 0, 0, 0.2);
	    transition: all 0.3s ease-in-out;
	}
	.logout a:hover {
	    background-color: #c9302c;
	    transform: scale(1.05);
	}
	
	/* Header */
	.header {
	    text-align: center;
	    margin-bottom: 50px;
	    animation: fadeIn 1s ease-in-out;
	}
	h1 {
	    color: #333;
	    font-size: 2.5rem;
	    text-transform: uppercase;
	    letter-spacing: 2px;
	    text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.2);
	}
	
	/* Form Containers */
	.form-container {
	    margin: 30px auto;
	    padding: 25px;
	    border-radius: 10px;
	    width: 350px;
	    background: white;
	    box-shadow: 0px 5px 15px rgba(0, 0, 0, 0.1);
	    transition: all 0.3s ease-in-out;
	    animation: slideUp 1s ease-out;
	}
	.form-container:hover {
	    transform: translateY(-5px);
	    box-shadow: 0px 8px 20px rgba(0, 0, 0, 0.2);
	}
	
	h2 {
	    color: #444;
	    font-size: 1.8rem;
	    margin-bottom: 15px;
	}
	
	/* Form Inputs */
	input[type="text"] {
	    width: 100%;
	    padding: 10px;
	    border: 2px solid #ccc;
	    border-radius: 5px;
	    transition: all 0.3s ease;
	}
	input[type="text"]:focus {
	    border-color: #007bff;
	    box-shadow: 0px 0px 8px rgba(0, 123, 255, 0.3);
	}
	
	/* Buttons */
	button {
	    width: 100%;
	    padding: 12px;
	    background: linear-gradient(135deg, #007bff, #0056b3);
	    color: white;
	    font-size: 1rem;
	    font-weight: bold;
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
	
	@keyframes slideUp {
	    0% { opacity: 0; transform: translateY(20px); }
	    100% { opacity: 1; transform: translateY(0); }
	}

    </style>
</head>
<body>
    <!-- Logout option positioned in the top right -->
  <div class="logout">
    <a href="<%= request.getContextPath() %>/logout">Logout</a>
  </div>
    
    <div class="header">
        <h1>Candidates Dashboard</h1>
    </div>
    
    <!-- Form to search a candidate by ID -->
    <div class="form-container">
        <h2>Search Candidate by ID</h2>
        <form action="CandidateById" method="get">
            <!-- Hidden field to indicate the action -->
            <input type="hidden" name="action" value="getById" />
            <label for="candidateId">Candidate ID:</label>
            <input type="text" id="candidateId" name="candidateId" required />
            <br/><br/>
            <button type="submit">Fetch Candidate</button>
        </form>
    </div>
    
    <!-- Form to fetch all candidates -->
    <div class="form-container">
        <h2>Show All Candidates</h2>
        <form action="AllCandidates" method="get">
            <!-- Hidden field to indicate the action -->
            <input type="hidden" name="action" value="getAll" />
            <button type="submit">Fetch All Candidates</button>
        </form>
    </div>
</body>
</html>
