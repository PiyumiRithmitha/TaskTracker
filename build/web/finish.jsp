<%-- 
    Document   : finish
    Created on : Aug 8, 2024, 9:55:37 PM
    Author     : sheha
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>




<%

    String p_id = request.getParameter("p_id");

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
        String sql = "UPDATE startproject SET status = 'FINISH' WHERE projectId=?";
        pstmt = conn.prepareStatement(sql);

        pstmt.setString(1, p_id);
        int a = pstmt.executeUpdate();
        if (a > 0) {
            response.sendRedirect("loadEmail.jsp");
        } else {
            response.sendRedirect("dashboard_user.jsp");
        }

    } catch (Exception e) {
        out.println(e);
    }


%>

