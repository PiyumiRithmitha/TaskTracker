<%@ page import="app.classes.User" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String email = request.getParameter("email");
    String password = request.getParameter("password");

    if (email != null && password != null) {
        User user = new User();
        user = user.login(email, password);

        if (user != null && user.getRole() != null) {
            session.setAttribute("userEmail", email);
            session.setAttribute("user_id", user.getUserId());
            session.setAttribute("user_name", user.getFirstName());
            
            if (user.getRole().equalsIgnoreCase("admin")) {
                response.sendRedirect("dashboard_admin.jsp");
            } else {
                response.sendRedirect("dashboard_user.jsp");
            }
        } else {
            response.sendRedirect("index.jsp?id=101&message=Invalid+email+or+password.");
        }
    } else {
        response.sendRedirect("index.jsp?id=101&message=Email+and+password+are+required.");
    }
%>
