package com.adi.voting.test;

import java.sql.SQLException;
import java.util.Scanner;

import com.adi.voting.dao.UserDAO;
import com.adi.voting.dao.UserDAOImpl;
import com.adi.voting.entity.User;
import com.adi.voting.pojo.UserRequest;

public class VotingTest {
    private static Scanner sc = new Scanner(System.in);
    private static UserDAO userDAO;

    public static void main(String[] args) {
        try {
            userDAO = new UserDAOImpl();
            boolean exit = false;
            while (!exit) {
                System.out.println("\n=== Voting System ===");
                System.out.println("1. Register");
                System.out.println("2. Login");
                System.out.println("3. Exit");
                System.out.print("Select an option: ");
                int choice = sc.nextInt();
                sc.nextLine();  // Consume newline
                
                switch (choice) {
                    case 1:
                        registerUser();
                        break;
                    case 2:
                        loginUser();
                        break;
                    case 3:
                        exit = true;
                        System.out.println("Exiting the system. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                ((UserDAOImpl) userDAO).cleanUp();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private static void registerUser() {
        try {
            System.out.println("\n=== Register ===");
            System.out.print("First Name: ");
            String firstName = sc.nextLine();
            System.out.print("Last Name: ");
            String lastName = sc.nextLine();
            System.out.print("Email: ");
            String email = sc.nextLine();
            System.out.print("Password: ");
            String password = sc.nextLine();
            System.out.print("Date of Birth (yyyy-mm-dd): ");
            String dobStr = sc.nextLine();
            System.out.print("Status (true/false): ");
            boolean status = sc.nextBoolean();
            sc.nextLine();  // Consume newline
            System.out.print("User Role: ");
            String userRole = sc.nextLine();

            UserRequest user = new UserRequest();
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setEmail(email);
            user.setPassword(password);
            user.setDob(java.sql.Date.valueOf(dobStr));
            user.setStatus(status);
            user.setUserRole(userRole);

            if (userDAO.registerUser(user)) {
                System.out.println("User registered successfully!");
            } else {
                System.out.println("Registration failed. Please try again.");
            }
        } catch (SQLException e) {
            System.out.println("Error during registration: " + e.getMessage());
        }
    }

    private static void loginUser() {
        try {
            System.out.println("\n=== Login ===");
            System.out.print("Email: ");
            String email = sc.nextLine();
            System.out.print("Password: ");
            String password = sc.nextLine();

            User user = userDAO.loginUser(email, password);
            if (user != null) {
                System.out.println("Login successful! Welcome, " + user.getFirstName() + " " + user.getLastName());
            } else {
                System.out.println("Invalid credentials. Please try again.");
            }
        } catch (SQLException e) {
            System.out.println("Error during login: " + e.getMessage());
        }
    }
}
