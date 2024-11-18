<%@page import="app.classes.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String email = request.getParameter("email");
    User user = new User();

    if (email != null) {
        boolean result = user.deleteUser(email);
        if (result) {
            response.sendRedirect("dashboard_admin.jsp?id=102&message=User deleted successfully");
        } else {
            response.sendRedirect("dashboard_admin.jsp?id=101&message=Failed to delete user");
        }
    } else {
        response.sendRedirect("dashboard_admin.jsp?id=101&message=Invalid request");
    }
%>

