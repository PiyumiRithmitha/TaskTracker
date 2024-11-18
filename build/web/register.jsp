<%@page import="app.classes.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String firstName = request.getParameter("first_name");
    String lastName = request.getParameter("last_name");
    String email = request.getParameter("email");
    String role = request.getParameter("role");
    String password = request.getParameter("password");
    String confirmPassword = request.getParameter("Cpassword");

    String errorMessage = null;

    if (firstName == null || lastName == null || email == null || role == null || password == null || confirmPassword == null) {
        errorMessage = "All fields are required.";
    } else if (!password.equals(confirmPassword)) {
        errorMessage = "Passwords do not match.";
    } else if (!email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
        errorMessage = "Invalid email format.";
    } else if (role.equalsIgnoreCase("admin")) {
        errorMessage = "Invalid role selection.";
    } else {
        User user = new User();
        boolean result = user.register(firstName, lastName, email, role, password);

        if (!result) {
            errorMessage = "Email already registered or registration failed. Please try again.";
        }
    }

    if (errorMessage != null) {
        response.sendRedirect("index.jsp?id=101&message=" + java.net.URLEncoder.encode(errorMessage, "UTF-8"));
    } else {
        response.sendRedirect("index.jsp?id=102&message=" + java.net.URLEncoder.encode("Registration successful!", "UTF-8"));
    }
%>
