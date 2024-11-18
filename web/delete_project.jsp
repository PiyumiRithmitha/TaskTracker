<%-- 
    Document   : delete_project
    Created on : Aug 7, 2024, 1:47:09 AM
    Author     : sheha
--%>

<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>


<%

    int p_id = Integer.parseInt(request.getParameter("p_id"));

// Database connection settings
    String dbURL = "jdbc:mysql://localhost:3306/task_tracker";
    String dbUser = "task";
    String dbPassword = "task";

    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    try {
        // Connect to the database
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection(dbURL, dbUser, dbPassword);

        // Prepare the SQL query to retrieve all property details
        String sql = "DELETE FROM project WHERE project_id =?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, p_id);

        int a = pstmt.executeUpdate();
        if (a > 0) {
            out.println("sucessfull database delete");
            response.sendRedirect("dashboard_admin.jsp");
        } else {
            out.println("unsucessfull database update");
        }

    } catch (Exception e) {
        e.printStackTrace();
    }


%>

